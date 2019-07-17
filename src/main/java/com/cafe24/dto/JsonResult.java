package com.cafe24.dto;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonResult that = (JsonResult) o;
        return Objects.equals(result, that.result) &&
                Objects.equals(message, that.message) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, message, data);
    }
}
