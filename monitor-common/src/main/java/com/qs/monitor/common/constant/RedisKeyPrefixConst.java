package com.qs.monitor.common.constant;

/**
 * <pre>
 * @Describe Redis Key 存储的前缀常量文件
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/1/16       create this file
 * </pre>
 */
public interface RedisKeyPrefixConst {

    /**
     * 用户登录信息
     */
    String USER_REDIS_LOGIN_INFO = "user:redis:login:info";

    /**
     * redis布隆过滤器key
     */
    String PRODUCT_REDIS_BLOOM_FILTER = "product:redis:bloom:filter";

}

