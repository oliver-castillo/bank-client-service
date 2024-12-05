package com.bank.clientservice.model.document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessClient extends Client {
    private String companyName;
    
    private String ruc;

    public BusinessClient(Integer typeId) {
        super(typeId);
    }
}
