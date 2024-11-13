package com.bank.clientservice.model.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;

@Getter
@Setter
public class SignatoryDocument {
    @Id
    private String id;

    private String name;

    private String paternalSurname;

    private String maternalSurname;

    @Indexed(unique = true)
    private String dni;

    private LocalDateTime creationDate = LocalDateTime.now();

    private LocalDateTime updateDate = null;

    private boolean isEnabled = true;
    
    private boolean isDeleted = false;
}
