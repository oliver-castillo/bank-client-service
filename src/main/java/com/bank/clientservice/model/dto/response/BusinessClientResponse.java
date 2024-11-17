package com.bank.clientservice.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BusinessClientResponse extends ClientResponse {
    private String companyName;
    private String ruc;
}
