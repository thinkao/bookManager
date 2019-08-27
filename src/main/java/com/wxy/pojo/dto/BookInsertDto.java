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
    private int book_num;
    @ApiModelProperty("${item.note}")
    private String pub_id;

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

    public String getPub_id() {
        return pub_id;
    }

    public void setPub_id(String pub_id) {
        this.pub_id = pub_id;
    }
}
