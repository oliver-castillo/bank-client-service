package com.bank.clientservice.repository;

import com.bank.clientservice.model.document.Client;
import com.bank.clientservice.model.enums.ClientType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ClientRepository extends ReactiveMongoRepository<Client, String> {
    Flux<Client> findAllByType(ClientType type);
}
