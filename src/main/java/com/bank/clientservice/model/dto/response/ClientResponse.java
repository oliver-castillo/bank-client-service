package com.bank.clientservice.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class ClientResponse {
    private String id;
    private String email;
    private String phone;
    private String address;

    private String companyName;
    private String ruc;

    private String name;
    private String paternalSurname;
    private String maternalSurname;
    private String dni;
}
