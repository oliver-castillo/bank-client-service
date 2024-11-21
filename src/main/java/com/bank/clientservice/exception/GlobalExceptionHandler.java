package com.bank.clientservice.exception;

import com.bank.clientservice.model.dto.response.OperationResponse;
import com.bank.clientservice.util.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DuplicateKeyException.class)
    public Mono<ResponseEntity<OperationResponse>> handleDuplicateKeyException(DuplicateKeyException e) {
        log.error("Duplicate key exception occurred", e);
        return Mono.just(new ResponseEntity<>(new OperationResponse(
                Message.DUPLICATE_KEY,
                HttpStatus.CONFLICT), HttpStatus.CONFLICT));
    }

    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<OperationResponse>> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return Mono.just(new ResponseEntity<>(new OperationResponse(
                Message.INTERNAL_SERVER_ERROR,
                HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR));
    }
}
