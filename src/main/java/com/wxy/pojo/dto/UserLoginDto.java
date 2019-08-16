package com.wxy.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * wxy
 */
@ApiModel("用户登录参数")
public class UserLoginDto {

    @ApiModelProperty("用户名-非空")
    @NotBlank(message = "用户名不能为空")
    private String user_account;

    @ApiModelProperty("密码-非空")
    @NotBlank(message = "密码不能为空")
    private String user_pass;

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }
}
