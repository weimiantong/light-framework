package org.light4j.plugin.sercurity;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.CachingSecurityManager;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.light4j.plugin.sercurity.realm.LightCustomRealm;
import org.light4j.plugin.sercurity.realm.LightJdbcRealm;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author weimiantong
 * @date 18/10/21
 */
public class LightSecurityFilter extends ShiroFilter{
    @Override
    public void init() throws Exception {
        super.init();
        WebSecurityManager webSecurityManager = super.getSecurityManager();
        //可以同时支持多个Realm, 并按照先后顺序逗号分隔开
        setRealms(webSecurityManager);
        setCache(webSecurityManager);
    }

    private void setRealms(WebSecurityManager webSecurityManager) {
        //读取 light.plugin.security.realms 配置项
        String securityRealms = SecurityConfig.getRealms();
        if (securityRealms != null) {
            String[] securityRealmArray = securityRealms.split(",");
            if (securityRealmArray.length > 0) {
                Set<Realm> realms = new LinkedHashSet<Realm>();
                for (String securityRealm : securityRealmArray) {
                    if (securityRealm.equalsIgnoreCase(SecurityConstant.REALMS_JDBC)) {
                        addJdbcRealm(realms);
                    } else if (securityRealm.equalsIgnoreCase(SecurityConstant.REALMS_CUSTOM)) {
                        addCustomRealm(realms);
                    }
                }
                RealmSecurityManager realmSecurityManager = (RealmSecurityManager) webSecurityManager;
                realmSecurityManager.setRealms(realms);
            }
        }
    }

    private void addJdbcRealm(Set<Realm> realms) {
        LightJdbcRealm lightJdbcRealm = new LightJdbcRealm();
        realms.add(lightJdbcRealm);
    }

    private void addCustomRealm(Set<Realm> realms) {
        SmartSecurity smartSecurity = SecurityConfig.getSmartSecurity();
        LightCustomRealm lightCustomRealm = new LightCustomRealm(smartSecurity);
        realms.add(lightCustomRealm);
    }


    public void setCache(WebSecurityManager webSecurityManager) {
        if (SecurityConfig.isCache()) {
            CachingSecurityManager cachingSecurityManager = (CachingSecurityManager) webSecurityManager;
            CacheManager cacheManager = new MemoryConstrainedCacheManager();
            cachingSecurityManager.setCacheManager(cacheManager);
        }
    }
}
