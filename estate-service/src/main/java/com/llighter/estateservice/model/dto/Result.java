package com.llighter.estateservice.model.dto;

public record Result<T>(
        String code,
        T data
) {

    public static <T> Result<T> success() {
        return new Result<>(Result.S000, null);
    }

    public static <T> Result<T> failure(String code, T data) {
        return new Result<>(code, data);
    }

    public static final String S000 = "S000";
    public static final String E001 = "E001";
    public static final String E002 = "E002";
    public static final String E003 = "E003";

}
