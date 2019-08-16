package com.wxy.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;



@Component
@ConfigurationProperties("global-config")
public class GlobalConfig {

    public static final String TOKEN = "token";

    /**
     * 系统用户Token过期时间
     */
    private Integer userTokenTimeout;

    /**
     * 系统用户登录随机盐过期时间
     */
    private Integer userLoginSaltTimeout;

    /**
     * 默认密码
     */
    private String defaultPassword;

    public Integer getUserTokenTimeout() {
        return userTokenTimeout;
    }

    public void setUserTokenTimeout(Integer userTokenTimeout) {
        this.userTokenTimeout = userTokenTimeout;
    }

    public Integer getUserLoginSaltTimeout() {
        return userLoginSaltTimeout;
    }

    public void setUserLoginSaltTimeout(Integer userLoginSaltTimeout) {
        this.userLoginSaltTimeout = userLoginSaltTimeout;
    }

    public String getDefaultPassword() {
        return defaultPassword;
    }

    public void setDefaultPassword(String defaultPassword) {
        this.defaultPassword = defaultPassword;
    }
}
