package com.bank.clientservice.model.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;

@Getter
@Setter
public abstract class Client extends BaseDocument {
    @Indexed(unique = true)
    private String email;

    private String phone;

    private String address;
}
