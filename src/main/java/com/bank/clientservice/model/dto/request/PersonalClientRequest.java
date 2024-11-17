package com.bank.clientservice.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PersonalClientRequest extends ClientRequest {
    private String name;
    private String paternalSurname;
    private String maternalSurname;
    private String dni;
}
