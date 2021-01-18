package com.qs.monitor.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <pre>
 * @Describe
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/1/18       create this file
 * </pre>
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Authorization {
    boolean needAuth() default true;
}