package com.bank.clientservice.model.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ClientResponse {
    private String id;
    private String email;
    private String phone;
    private String address;
}
