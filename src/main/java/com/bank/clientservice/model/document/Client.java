package com.bank.clientservice.model.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class Client {
    @Id
    private String id;

    @Indexed(unique = true)
    private String email;

    private String phone;

    private String address;

    private LocalDateTime creationDate = LocalDateTime.now();

    private LocalDateTime updateDate = null;

    private boolean isDeleted = false;
}
