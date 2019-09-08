package com.wxy.pojo.dto;

import com.wxy.page.PageQuery;
import io.swagger.annotations.ApiModelProperty;

public class BookQueryDto extends PageQuery {

    @ApiModelProperty("${item.note}")
    private String book_id;

    @ApiModelProperty("${item.note}")
    private String book_name;

    @ApiModelProperty("${item.note}")
    private String kind_name;

    public String getKind_name() {
        return kind_name;
    }

    public void setKind_name(String kind_name) {
        this.kind_name = kind_name;
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
}
