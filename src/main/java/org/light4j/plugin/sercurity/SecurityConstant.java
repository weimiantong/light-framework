package org.light4j.plugin.sercurity;

/**
 * 常量接口
 *
 * @author weimiantong
 * @since 1.0.0
 */
public interface SecurityConstant {

    String REALMS = "light.plugin.security.realms";
    String REALMS_JDBC = "jdbc";
    String REALMS_CUSTOM = "custom";

    String SMART_SECURITY = "light.plugin.security.custom.class";

    String JDBC_AUTHC_QUERY = "light.plugin.security.jdbc.authc_query";
    String JDBC_ROLES_QUERY = "light.plugin.security.jdbc.roles_query";
    String JDBC_PERMISSIONS_QUERY = "light.plugin.security.jdbc.permissions_query";

    String CACHE = "light.plugin.security.cache";
}
