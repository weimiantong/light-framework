package org.light4j.framework;

/**
 * 提供相关配置项常量
 *
 * @author weimiantong
 * @date 18/7/14
 */
public interface ConfigConstant {
    String CONFIG_FILE = "light.properties";
    String JDBC_DRIVER = "light.framework.jdbc.driver";
    String JDBC_URL = "light.framework.jdbc.url";
    String JDBC_USERNAME = "light.framework.jdbc.username";
    String JDBC_PASSWORD = "light.framework.jdbc.password";
    String APP_BASE_PACKAGE = "light.framework.app.base_package";
    String APP_JSP_PATH = "light.framework.app.jsp_path";
    String APP_ASSET_PATH = "light.framework.app.asset_path";
    String APP_UPLOAD_LIMIT = "light.framework.app.upload_limit";
}
