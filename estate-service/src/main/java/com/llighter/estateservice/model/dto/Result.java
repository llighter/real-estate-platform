package com.llighter.estateservice.model.dto;

public record Result<T>(
        String code,
        T data
) {

    public static <T> Result<T> success() {
        return new Result<>("S000", null);
    }

    public static <T> Result<T> failure(String code, T data) {
        return new Result<>(code, data);
    }

}
