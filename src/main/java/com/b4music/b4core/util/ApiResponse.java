package com.b4music.b4core.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponse <T> {
    public boolean success;
    public String message;
    public T data;

    public ApiResponse (boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    static <T> ResponseEntity<ApiResponse<T>> ok (String message, T data) {
        return ResponseEntity.ok(new ApiResponse<T>(true, message, data));
    }

    static <T> ResponseEntity<ApiResponse<T>> notFound (String message, T data) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, message, data));
    }

    static <T> ResponseEntity<ApiResponse<T>> badRequest (String message, T data) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(false, message, data));
    }
}
