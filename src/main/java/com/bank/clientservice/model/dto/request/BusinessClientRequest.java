package com.bank.clientservice.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BusinessClientRequest extends ClientRequest {
    private String companyName;
    private String ruc;
}
