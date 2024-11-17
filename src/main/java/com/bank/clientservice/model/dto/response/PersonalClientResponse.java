package com.bank.clientservice.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PersonalClientResponse extends ClientResponse {
    private String name;
    private String paternalSurname;
    private String maternalSurname;
    private String dni;
}
