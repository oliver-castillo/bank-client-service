package com.bank.clientservice.repository;

import com.bank.clientservice.model.document.PersonalClientDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalClientRepository extends ReactiveMongoRepository<PersonalClientDocument, String> {
}
