package com.bank.clientservice.service.implementation;

import com.bank.clientservice.exception.NotFoundException;
import com.bank.clientservice.mapper.ClientMapper;
import com.bank.clientservice.model.document.BusinessClient;
import com.bank.clientservice.model.document.PersonalClient;
import com.bank.clientservice.model.dto.request.BusinessClientRequest;
import com.bank.clientservice.model.dto.request.ClientRequest;
import com.bank.clientservice.model.dto.request.PersonalClientRequest;
import com.bank.clientservice.model.dto.response.ClientResponse;
import com.bank.clientservice.model.dto.response.OperationResponse;
import com.bank.clientservice.model.enums.ClientType;
import com.bank.clientservice.repository.ClientRepository;
import com.bank.clientservice.service.ClientService;
import com.bank.clientservice.util.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service
public class DefaultClientService implements ClientService {
    private final ClientRepository repository;
    private final ClientMapper mapper;

    @Override
    public Mono<OperationResponse> save(ClientRequest request) {
        return validateRequest(request)
                .flatMap(valid -> repository.save(mapper.toDocument(request)))
                .map(client ->
                        new OperationResponse(
                                ResponseMessage.CREATED_SUCCESSFULLY,
                                HttpStatus.CREATED));
    }

    @Override
    public Flux<ClientResponse> findAllByType(ClientType type) {
        return repository.findAllByType(type).map(mapper::toResponse);
    }

    @Override
    public Mono<ClientResponse> findById(String id) {
        return repository.findById(id).map(mapper::toResponse);
    }

    @Override
    public Mono<OperationResponse> update(String id, ClientRequest request) {
        return validateRequest(request)
                .flatMap(valid -> repository.findById(id))
                .switchIfEmpty(Mono.error(new NotFoundException("Cliente no encontrado")))
                .map(client -> {
                    mapper.updateClient(client, request);
                    return repository.save(client);
                })
                .map(client -> new OperationResponse(ResponseMessage.UPDATED_SUCCESSFULLY, HttpStatus.OK));
    }

    @Override
    public Mono<OperationResponse> delete(String id) {
        return repository.deleteById(id)
                .then(Mono.fromCallable(() ->
                        new OperationResponse(ResponseMessage.DELETED_SUCCESSFULLY,
                                HttpStatus.OK)));
    }

    private Mono<Boolean> validateRequest(ClientRequest request) {
        if (request instanceof PersonalClientRequest personalClientRequest) {
            return repository.findAll()
                    .ofType(PersonalClient.class)
                    .filter(client -> client.getDni().equals(personalClientRequest.getDni()))
                    .map(client -> false)
                    .switchIfEmpty(Mono.just(true)).single()
                    .flatMap(valid -> {
                        if (Boolean.FALSE.equals(valid)) {
                            return Mono.error(new DuplicateKeyException("El DNI ya esta registrado"));
                        }
                        return Mono.just(true);
                    });
        }
        if (request instanceof BusinessClientRequest businessClientRequest) {
            return repository.findAll()
                    .ofType(BusinessClient.class)
                    .filter(client -> client.getRuc().equals(businessClientRequest.getRuc()))
                    .map(client -> false)
                    .switchIfEmpty(Mono.just(true)).single()
                    .flatMap(valid -> {
                        if (Boolean.FALSE.equals(valid)) {
                            return Mono.error(new DuplicateKeyException("El RUC ya esta registrado"));
                        }
                        return Mono.just(true);
                    });
        }
        return Mono.just(false);
    }
}
