package com.bank.clientservice.repository;

import com.bank.clientservice.model.document.BusinessClientDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessClientRepository extends ReactiveMongoRepository<BusinessClientDocument, String> {
}
