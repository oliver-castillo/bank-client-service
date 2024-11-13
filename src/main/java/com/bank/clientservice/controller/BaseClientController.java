package com.bank.clientservice.controller;

import com.bank.clientservice.model.dto.response.OperationResponse;
import com.bank.clientservice.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public abstract class BaseClientController<R> {
    private final ClientService<R> clientService;

    @PostMapping("/save")
    public Mono<ResponseEntity<OperationResponse>> saveClient(@RequestBody R request) {
        return clientService.save(request)
                .map(response -> new ResponseEntity<>(response, HttpStatus.CREATED));
    }
}
