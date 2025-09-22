package com.neon.demo_big_event.common;

import java.time.LocalDateTime;

public class Response<T> {
    private LocalDateTime timestamp;
    private int code;  // 业务逻辑码，0为正确，-1为错误
    private String message;
    private T data;

    public Response() {
        this.timestamp = LocalDateTime.now();
    }

    public Response<T> success(T data) {
        Response<T> response = new Response<>();
        response.setCode(0);
        response.setMessage("操作成功！");
        response.setData(data);

        return response;
    }

    public Response<T> error(String message) {
        Response<T> response = new Response<>();
        response.setCode(-1);
        response.setMessage(message);
        return response;
    }

    public LocalDateTime getTimestamp() { return this.timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    public int getCode() { return this.code; }
    public void setCode(int code) { this.code = code; }
    public String getMessage() { return this.message; }
    public void setMessage(String message) { this.message = message;}
    public T getData() { return this.data; }
    public void setData(T data) { this.data = data; }
}