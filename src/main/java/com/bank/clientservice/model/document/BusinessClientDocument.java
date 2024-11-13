package com.bank.clientservice.model.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@Document(collection = "business_clients")
public class BusinessClientDocument extends Client {
    private String companyName;

    @Indexed(unique = true)
    private String ruc;

    private Set<SignatoryDocument> signatories;
}
