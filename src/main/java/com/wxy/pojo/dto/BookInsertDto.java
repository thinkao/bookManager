package com.wxy.pojo.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

@Api("书籍管理")
public class BookInsertDto {

    @ApiModelProperty("${item.note}")
    private String book_id;
    @ApiModelProperty("${item.note}")
    private String book_name;
    @ApiModelProperty("${item.note}")
    private String book_editor;
    @ApiModelProperty("${item.note}")
    private double book_price;
    @ApiModelProperty("${item.note}")
    private String kind_name;
    @ApiModelProperty("${item.note}")
    private int book_num;
    @ApiModelProperty("${item.note}")
    private String pub_name;
    @ApiModelProperty("${item.note}")
    private String picture;
    @ApiModelProperty("${item.note}")
    private String picture_name;

    public String getKind_name() {
        return kind_name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPicture_name() {
        return picture_name;
    }

    public void setPicture_name(String picture_name) {
        this.picture_name = picture_name;
    }

    public void setKind_name(String kind_name) {
        this.kind_name = kind_name;
    }

    public String getPub_name() {
        return pub_name;
    }

    public void setPub_name(String pub_name) {
        this.pub_name = pub_name;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_editor() {
        return book_editor;
    }

    public void setBook_editor(String book_editor) {
        this.book_editor = book_editor;
    }

    public double getBook_price() {
        return book_price;
    }

    public void setBook_price(double book_price) {
        this.book_price = book_price;
    }

    public int getBook_num() {
        return book_num;
    }

    public void setBook_num(int book_num) {
        this.book_num = book_num;
    }

}
