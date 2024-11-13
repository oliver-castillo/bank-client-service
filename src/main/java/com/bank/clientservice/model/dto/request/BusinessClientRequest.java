package com.bank.clientservice.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public class BusinessClientRequest {
    private String companyName;
    private String ruc;
    private String email;
    private String phone;
    private String address;
    private Set<SignatoryRequest> signatories;

    @AllArgsConstructor
    @Getter
    @Setter
    public static class SignatoryRequest {
        private String name;
        private String paternalSurname;
        private String maternalSurname;
        private String dni;
    }
}
