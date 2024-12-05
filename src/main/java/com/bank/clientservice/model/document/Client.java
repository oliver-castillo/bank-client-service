package com.bank.clientservice.model.document;

import com.bank.clientservice.model.enums.ClientType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "clients")
public abstract class Client extends BaseDocument {
    private Integer typeId;

    private ClientType type;

    @Indexed(unique = true)
    private String email;

    private String phone;

    private String address;

    protected Client(Integer typeId) {
        this.typeId = typeId;
        this.type = ClientType.fromId(typeId);
    }
}
