package com.xlw.oa.dto;

/**
 * @author 熊立伟
 * @version 1.0
 * @date 2020/2/20 14:33
 */
public class Result {
    private Boolean success;
    private String message;
    private Object data;

    public Result(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Result(Boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
