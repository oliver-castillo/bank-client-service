package com.bank.clientservice.service.implementation;

import com.bank.clientservice.mapper.ClientMapper;
import com.bank.clientservice.model.dto.request.PersonalClientRequest;
import com.bank.clientservice.model.dto.response.OperationResponse;
import com.bank.clientservice.repository.PersonalClientRepository;
import com.bank.clientservice.service.ClientService;
import com.bank.clientservice.util.Messages;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service("personalClientService")
public class PersonalClientService implements ClientService<PersonalClientRequest> {
    private final PersonalClientRepository repository;
    private final ClientMapper mapper;

    @Override
    public Mono<OperationResponse> save(PersonalClientRequest request) {
        return repository.save(mapper.toDocument(request))
                .doOnSuccess(savedDocument -> log.info("Saved document: {}", savedDocument.getId()))
                .doOnError(error -> log.error("Error saving document: {}", error.getMessage()))
                .doOnTerminate(() -> log.info("Saving personal client operation terminated"))
                .map(savedDocument -> new OperationResponse(
                        Messages.CREATED_SUCCESSFULLY,
                        HttpStatus.CREATED
                ));
    }
}
