package com.bank.clientservice.service;

import com.bank.clientservice.model.dto.response.OperationResponse;
import reactor.core.publisher.Mono;

public interface ClientService<R> {
    Mono<OperationResponse> save(R request);
}
