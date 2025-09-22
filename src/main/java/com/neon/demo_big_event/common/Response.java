package com.neon.demo_big_event.common;

import java.time.LocalDateTime;

public record Response<T>(
    LocalDateTime timestamp,
    int code,  // 业务逻辑码，0为正确，-1为错误
    String message,
    T data
) {}