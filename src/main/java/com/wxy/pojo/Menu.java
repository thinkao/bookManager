package com.wxy.pojo;

import java.util.Date;

public class Menu {
    private String menu_id;
    private String menu_name;
    private String menu_parent;
    private String menu_url;
    private Date create_date;

    public String getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(String menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getMenu_parent() {
        return menu_parent;
    }

    public void setMenu_parent(String menu_parent) {
        this.menu_parent = menu_parent;
    }

    public String getMenu_url() {
        return menu_url;
    }

    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }
}
