package org.light4j.test.security;

import org.light4j.framework.util.CodecUtil;
import org.light4j.plugin.sercurity.SmartSecurity;

import java.util.HashSet;
import java.util.Set;

/**
 * 应用安全控制
 *
 * @author huangyong
 * @since 1.0.0
 */
public class AppSecurity implements SmartSecurity {

    @Override
    public String getPassword(String username) {
        String sql = "SELECT password FROM user WHERE username = ?";
//        return DatabaseHelper.query(sql, username); // TODO: 18/10/27
        return CodecUtil.md5(username); // TODO: 18/10/27 just for test without DB
    }

    @Override
    public Set<String> getRoleNameSet(String username) {
        String sql = "SELECT r.role_name FROM user u, user_role ur, role r WHERE u.id = ur.user_id AND r.id = ur.role_id AND u.username = ?";
//        return DatabaseHelper.querySet(sql, username);
        Set<String> roleNames = new HashSet<String>(); // TODO: 18/10/27 just for test without DB
        roleNames.add("User");
        return roleNames;
    }

    @Override
    public Set<String> getPermissionNameSet(String roleName) {
        String sql = "SELECT p.permission_name FROM role r, role_permission rp, permission p WHERE r.id = rp.role_id AND p.id = rp.permission_id AND r.role_name = ?";
//        return DatabaseHelper.querySet(sql, roleName);
        Set<String> permissionNames = new HashSet<String>();// TODO: 18/10/27 just for test without DB
        permissionNames.add("customer");
        return permissionNames;
    }
}
