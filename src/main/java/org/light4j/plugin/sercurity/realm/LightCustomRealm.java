package org.light4j.plugin.sercurity.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.light4j.plugin.sercurity.SecurityConstant;
import org.light4j.plugin.sercurity.SmartSecurity;
import org.light4j.plugin.sercurity.password.Md5CredentialsMatcher;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by weimiantong on 18/10/21.
 */
public class LightCustomRealm extends AuthorizingRealm {
    private final SmartSecurity smartSecurity;

    public LightCustomRealm(SmartSecurity smartSecurity) {
        this.smartSecurity = smartSecurity;
        super.setName(SecurityConstant.REALMS_CUSTOM);
        super.setCredentialsMatcher(new Md5CredentialsMatcher());
    }

    @Override
    public AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        if (token == null) {
            throw new AuthenticationException("parameter token is null");
        }

        String username = ((UsernamePasswordToken) token).getUsername();
        String password = smartSecurity.getPassword(username);

        //将用户名与密码放入AuthenticationInfo 对象, 便于后续的认证操作
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo();
        authenticationInfo.setPrincipals(new SimplePrincipalCollection(username, super.getName()));
        authenticationInfo.setCredentials(password);
        return authenticationInfo;
    }

    @Override
    public AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (principals == null) {
            throw new AuthorizationException("parameter principals is null");
        }
        //获取已认证用户的用户名
        String username = (String) super.getAvailablePrincipal(principals);

        Set<String> roleNameSet = smartSecurity.getRoleNameSet(username);

        Set<String> permissionNameSet = new HashSet<String>();
        if (roleNameSet != null && roleNameSet.size() > 0) {
            for (String roleName : roleNameSet) {
                Set<String> currentPermissionNameSet = smartSecurity.getPermissionNameSet(roleName);
                permissionNameSet.addAll(currentPermissionNameSet);
            }
        }
        // 将角色名集合与权限名集合放入authorizationInfo, 便于后续的授权操作
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roleNameSet);
        authorizationInfo.setStringPermissions(permissionNameSet);
        return authorizationInfo;
    }
}
