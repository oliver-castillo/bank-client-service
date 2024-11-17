package com.bank.clientservice.service;

import com.bank.clientservice.model.dto.request.ClientRequest;
import com.bank.clientservice.model.dto.response.ClientResponse;
import com.bank.clientservice.model.dto.response.OperationResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService<T extends ClientRequest, R extends ClientResponse> {
    Mono<OperationResponse> save(T request);

    Flux<R> findAll();

    Mono<R> findById(String id);

    Mono<OperationResponse> update(String id, T request);

    Mono<OperationResponse> delete(String id);
}
