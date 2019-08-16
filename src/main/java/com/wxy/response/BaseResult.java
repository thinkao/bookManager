package com.wxy.response;

import java.io.Serializable;

/**
 * @author: wusq
 * @date: 2018/10/30
 */
public class BaseResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code = 200;

    private String message;

    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
        this.code = HttpStatus.OK.value;
        this.message= HttpStatus.OK.reasonPhrase();
    }

    public BaseResult(HttpStatus httpStatus) {
       this.code = httpStatus.value;
       this.message= httpStatus.reasonPhrase();
    }

    public BaseResult(HttpStatus httpStatus, Object data) {
        this.code = httpStatus.value;
        this.message= httpStatus.reasonPhrase();
        this.data = data;
    }

    public void recordError(HttpStatus httpStatus){
        this.code = httpStatus.value;
        this.message= httpStatus.reasonPhrase();
    }

    public void recordError(String error){
        this.code = 500;
        this.message= error;
    }

    public void recordError(HttpStatus httpStatus,String error){
        this.code = httpStatus.value;
        this.message= error;
    }

    public BaseResult() {
    }
}
