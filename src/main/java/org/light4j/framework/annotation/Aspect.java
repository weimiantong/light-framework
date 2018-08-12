package org.light4j.framework.annotation;

import java.lang.annotation.*;

/**
 * 切面注解
 *
 * @author weimiantong
 * @date 18/7/15
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {

    /**
     * 注解
     */
    Class<? extends Annotation> value();
}
