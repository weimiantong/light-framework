package org.light4j.framework;

import org.light4j.framework.helper.*;
import org.light4j.framework.util.ClassUtil;

/**
 * 加载相应的 Helper 类
 *
 * @author weimiantong
 * @date 18/7/15
 */
public final class HelperLoader {

    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                AopHelper.class,
                IocHelper.class,
                DatabaseHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName());
        }
    }
}
