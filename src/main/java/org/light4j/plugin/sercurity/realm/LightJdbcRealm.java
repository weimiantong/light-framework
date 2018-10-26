package org.light4j.plugin.sercurity.realm;

import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.light4j.framework.helper.DatabaseHelper;
import org.light4j.plugin.sercurity.SecurityConfig;
import org.light4j.plugin.sercurity.password.Md5CredentialsMatcher;

/**
 * Created by weimiantong on 18/10/21.
 */
public class LightJdbcRealm extends JdbcRealm{
    public LightJdbcRealm() {
        super.setDataSource(DatabaseHelper.getDataSource());
        super.setAuthenticationQuery(SecurityConfig.getJdbcAuthcQuery());
        super.setUserRolesQuery(SecurityConfig.getJdbcRolesQuery());
        super.setPermissionsQuery(SecurityConfig.getJdbcPermissionsQuery());
        super.setPermissionsLookupEnabled(true);
        super.setCredentialsMatcher(new Md5CredentialsMatcher());
    }
}
