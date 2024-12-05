package com.bank.clientservice.model.document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonalClient extends Client {
    private String name;

    private String paternalSurname;

    private String maternalSurname;

    private String dni;

    public PersonalClient(Integer typeId) {
        super(typeId);
    }
}
