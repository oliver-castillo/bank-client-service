package com.bank.clientservice.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BusinessClientRequest {
    private String companyName;
    private String ruc;
    private String email;
    private String phone;
    private String address;
}
