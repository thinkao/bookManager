package com.wxy.pojo.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

@ApiModel("用户管理")
public class UserUpdateDto {

    @ApiModelProperty("${item.note}")
    @NotBlank(message = "${item.note}不能为空")
    private String user_id;

    @ApiModelProperty("${item.note}")
    //@NotBlank(message = "${item.note}不能为空")
    private String user_name;

    @ApiModelProperty("${item.note}")
    //@NotBlank(message = "${item.note}不能为空")
    private String user_addr;

    @ApiModelProperty("${item.note}")
    //@NotBlank(message = "${item.note}不能为空")
    private String user_account;

    @ApiModelProperty("${item.note}")
    //@NotBlank(message = "${item.note}不能为空")
    private String user_pass;

    @ApiModelProperty("${item.note}")
    //@NotBlank(message = "${item.note}不能为空")
    private String user_phone;

    @ApiModelProperty("${item.note}")
    //@NotBlank(message = "${item.note}不能为空")
    private String role_id;

    @ApiModelProperty("${item.note}")
    //@NotBlank(message = "${item.note}不能为空")
    private String role_name;

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_addr() {
        return user_addr;
    }

    public void setUser_addr(String user_addr) {
        this.user_addr = user_addr;
    }

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

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }
}
