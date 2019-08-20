package com.wxy.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    @Column(length = 32)
    private String user_id;
    @Column(length = 32)
    private String user_name;
    @Column(length = 32)
    private String user_addr;
    @Column(length = 32)
    private String user_account;
    @Column(length = 32,nullable = false)
    private String user_pass;
    @Column(length = 11)
    private String user_phone;

    public Users() {
    }

    public Users(String user_id, String user_name, String user_addr, String user_account, String user_pass, String user_phone) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_addr = user_addr;
        this.user_account = user_account;
        this.user_pass = user_pass;
        this.user_phone = user_phone;
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
