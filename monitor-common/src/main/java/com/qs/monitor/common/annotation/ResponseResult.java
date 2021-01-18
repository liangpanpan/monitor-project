package com.qs.monitor.common.annotation;

/**
 * <pre>
 * @Describe 返回结果进行封装的注解
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/1/17       create this file
 * </pre>
 */

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ResponseResult {
}
