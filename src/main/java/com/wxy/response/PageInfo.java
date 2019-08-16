package com.wxy.response;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kemi on 2016/3/12.
 */
@ApiModel
public class PageInfo<T> implements Serializable {

    private static final long serialVersionUID = 1244437270503922868L;

    /**
     * 总记录数
     */
    @ApiModelProperty(value = "总记录条数")
    private long total;
    /**
     * 每页数据
     */
    @ApiModelProperty(value = "每页数据列表")
    private List<T> rows;
    
    @ApiModelProperty(value = "查询条件")
    private Map<String, Object> parameter;

    /**
     * 每页数据条数
     */
    private int limit;
    /**
     * 当前页面
     */
    private int current;

    /**
     * 排序字段
     */
    private String  orderColumn;

    /**
     * 排序次序，升序还是降序
     */
    private String orderSort;

    private int offset;

    public PageInfo() {
        if (parameter==null) {
            parameter = new HashMap<String, Object>();
        }
    }


    public void init() {
        if (current < 1) {
            current = 1;
        }
        if (limit < 1) {
            limit = 10;
        }
        this.limit = limit;
        this.current = current;
        this.offset = (current - 1) * limit;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Map<String, Object> getParameter() {
        return parameter;
    }

    public void setParameter(Map<String, Object> parameter) {
        this.parameter = parameter;
    }

    public void putParameter(String key,Object value){
        this.parameter.put(key,value);
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public String getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
    }

    public String getOrderSort() {
        return orderSort;
    }

    public void setOrderSort(String orderSort) {
        this.orderSort = orderSort;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

}
