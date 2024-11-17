package com.bank.clientservice.service.implementation;

import com.bank.clientservice.mapper.ClientMapper;
import com.bank.clientservice.model.document.BaseDocument;
import com.bank.clientservice.model.document.PersonalClient;
import com.bank.clientservice.model.dto.request.PersonalClientRequest;
import com.bank.clientservice.model.dto.response.OperationResponse;
import com.bank.clientservice.model.dto.response.PersonalClientResponse;
import com.bank.clientservice.repository.PersonalClientRepository;
import com.bank.clientservice.service.ClientService;
import com.bank.clientservice.util.Messages;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service
public class PersonalClientService implements ClientService<PersonalClientRequest, PersonalClientResponse> {
    private final ClientMapper mapper;
    private final PersonalClientRepository repository;

    @Override
    public Mono<OperationResponse> save(PersonalClientRequest request) {
        return repository.save(mapper.toDocument(request))
                .map(businessClient -> {
                    log.info("Personal client with ID {} was saved successfully", businessClient.getId());
                    return new OperationResponse(Messages.CREATED_SUCCESSFULLY, HttpStatus.CREATED);
                });
    }

    @Override
    public Flux<PersonalClientResponse> findAll() {
        return repository.findAll()
                .filter(BaseDocument::isEnabled)
                .map(mapper::toResponse);
    }

    @Override
    public Mono<PersonalClientResponse> findById(String id) {
        return repository.findById(id).map(mapper::toResponse);
    }

    @Override
    public Mono<OperationResponse> update(String id, PersonalClientRequest request) {
        PersonalClient document = mapper.toDocument(request);
        document.setId(id);

        return repository.existsById(id)
                .flatMap(exists -> {
                    if (Boolean.TRUE.equals(exists)) {
                        return repository.save(document)
                                .map(savedDocument -> new OperationResponse(Messages.UPDATED_SUCCESSFULLY, HttpStatus.ACCEPTED));
                    } else {
                        return Mono.just(new OperationResponse(Messages.NOT_FOUND, HttpStatus.NOT_FOUND));
                    }
                })
                .doOnSuccess(response -> log.info("Update personal client operation completed with status: {}", response.getStatus()))
                .doOnError(error -> log.error("An error occurred during update personal client operation", error));
    }

    @Override
    public Mono<OperationResponse> delete(String id) {
        return repository.deleteById(id)
                .then(Mono.fromCallable(() -> new OperationResponse(Messages.DELETED_SUCCESSFULLY, HttpStatus.ACCEPTED)))
                .doOnSuccess(response -> log.info("Delete personal client operation completed with status: {}", response.getStatus()));
    }
}
