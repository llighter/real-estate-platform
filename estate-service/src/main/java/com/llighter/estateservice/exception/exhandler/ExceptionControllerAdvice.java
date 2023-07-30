package com.llighter.estateservice.exception.exhandler;

import com.llighter.estateservice.exception.NoDataFoundException;
import com.llighter.estateservice.model.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Result<String>> handleNoClassDefFoundError(NoDataFoundException e) {
        log.error("[exceptionHandle] ex", e);
        return ResponseEntity.ok().body(Result.failure(Result.E001, e.getMessage()));
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Result<String>> handleIllegalStateError(IllegalStateException e) {
        log.error("[exceptionHandle] ex", e);
        return ResponseEntity.ok().body(Result.failure(Result.E002, e.getMessage()));
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Result<String>> handleNullPointerError(NullPointerException e) {
        log.error("[exceptionHandle] ex", e);
        return ResponseEntity.ok().body(Result.failure(Result.E003, e.getMessage()));
    }
}
