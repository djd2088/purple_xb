package com.rui.xb.purple.base;

import java.util.Observable;

/**
 * Created by Rui on 2018/7/10.
 */

public class BaseResponseEntity {

    private int code;
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
    }
}
