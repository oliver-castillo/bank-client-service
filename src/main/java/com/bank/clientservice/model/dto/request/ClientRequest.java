package com.bank.clientservice.model.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ClientRequest {
    private String email;
    private String phone;
    private String address;
}
