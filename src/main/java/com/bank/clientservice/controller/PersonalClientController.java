package com.bank.clientservice.controller;

import com.bank.clientservice.model.dto.request.PersonalClientRequest;
import com.bank.clientservice.model.dto.response.OperationResponse;
import com.bank.clientservice.model.dto.response.PersonalClientResponse;
import com.bank.clientservice.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "personal")
public class PersonalClientController {
    private final ClientService<PersonalClientRequest, PersonalClientResponse> clientService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<PersonalClientResponse> findAll() {
        return clientService.findAll();
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<PersonalClientResponse> findById(@PathVariable String id) {
        return clientService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<OperationResponse> save(@RequestBody PersonalClientRequest request) {
        return clientService.save(request);
    }

    @PutMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<OperationResponse> update(@PathVariable String id, @RequestBody PersonalClientRequest request) {
        return clientService.update(id, request);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<OperationResponse> deleteById(@PathVariable String id) {
        return clientService.delete(id);
    }
}
