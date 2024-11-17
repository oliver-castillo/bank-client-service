package com.bank.clientservice.controller;

import com.bank.clientservice.model.dto.request.BusinessClientRequest;
import com.bank.clientservice.model.dto.response.BusinessClientResponse;
import com.bank.clientservice.model.dto.response.OperationResponse;
import com.bank.clientservice.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "clients/business")
public class BusinessClientController {
    private final ClientService<BusinessClientRequest, BusinessClientResponse> clientService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<BusinessClientResponse> findAll() {
        return clientService.findAll();
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<BusinessClientResponse> findById(@PathVariable String id) {
        return clientService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<OperationResponse> save(@RequestBody BusinessClientRequest request) {
        return clientService.save(request);
    }

    @PutMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<OperationResponse> update(@PathVariable String id, @RequestBody BusinessClientRequest request) {
        return clientService.update(id, request);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<OperationResponse> deleteById(@PathVariable String id) {
        return clientService.delete(id);
    }
}
