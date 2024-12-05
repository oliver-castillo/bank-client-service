package com.bank.clientservice.service;

import com.bank.clientservice.model.dto.request.ClientRequest;
import com.bank.clientservice.model.dto.response.ClientResponse;
import com.bank.clientservice.model.dto.response.OperationResponse;
import com.bank.clientservice.model.enums.ClientType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {
    Mono<OperationResponse> save(ClientRequest request);

    Flux<ClientResponse> findAllByType(ClientType type);

    Mono<ClientResponse> findById(String id);

    Mono<OperationResponse> update(String id, ClientRequest request);

    Mono<OperationResponse> delete(String id);
}
