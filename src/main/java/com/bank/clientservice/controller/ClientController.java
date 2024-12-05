package com.bank.clientservice.controller;

import com.bank.clientservice.model.dto.request.ClientRequest;
import com.bank.clientservice.model.dto.response.ClientResponse;
import com.bank.clientservice.model.dto.response.OperationResponse;
import com.bank.clientservice.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
public class ClientController {
    private final ClientService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<OperationResponse> save(@RequestBody @Valid ClientRequest request) {
        return service.save(request);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<OperationResponse> update(@PathVariable String id,
                                          @RequestBody @Valid ClientRequest request) {
        return service.update(id, request);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ClientResponse> findById(@PathVariable String id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<OperationResponse> deleteById(@PathVariable String id) {
        return service.delete(id);
    }

}
