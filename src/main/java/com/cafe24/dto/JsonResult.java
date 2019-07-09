package com.cafe24.dto;

public class JsonResult {
    private String result;
    private String message;
    private Object data;

    public static JsonResult fail(String message) {
        return new JsonResult("success", message, null);
    }
    public static JsonResult success(Object data) {
        return new JsonResult("success", null, data);
    }

    private JsonResult(String result, String message, Object data ) {
        this.result = result;
        this.message = message;
        this.data= data;
    }

    public String getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
