package com.shushang.huagongproject.Bean;

import java.util.List;

public class Image {

    /**
     * success : true
     * code : 0
     * message : OK
     * data : ["upload/201901/20190128_162625_51230094d3a144e0b7e05a40e531fa11.jpg"]
     */

    private boolean success;
    private int code;
    private String message;
    private List<String> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

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

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
