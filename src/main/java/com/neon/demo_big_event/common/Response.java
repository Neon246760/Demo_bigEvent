package com.neon.demo_big_event.common;

import java.time.LocalDateTime;

public class Response<T> {
    private LocalDateTime timestamp;
    private int code;  // 业务逻辑码，0为正确，-1为错误
    private String message;
    private T data;

    // 无参构造函数 - 初始化timestamp
    public Response() {
        this.timestamp = LocalDateTime.now();
    }

    // 有参构造函数 - 初始化timestamp
    public Response(int code, String message, T data) {
        this.timestamp = LocalDateTime.now(); // 添加这行
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 静态方法
    public static <T> Response<T> success() {
        return new Response<T>(0, "操作成功", null);
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(0, "操作成功", data);
    }

    public static <T> Response<T> error(String message) {
        return new Response<>(-1, message, null);
    }

    // Getter和Setter方法
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "timestamp=" + timestamp +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}