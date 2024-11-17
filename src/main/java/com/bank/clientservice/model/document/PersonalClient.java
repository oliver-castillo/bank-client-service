package com.bank.clientservice.model.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Getter
@Setter
@Document(collection = "personal_clients")
public class PersonalClient extends Client {
    private String name;

    private String paternalSurname;

    private String maternalSurname;

    @Indexed(unique = true)
    private String dni;
}
