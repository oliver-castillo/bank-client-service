package com.bank.clientservice.model.dto.request;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

/*
 * Cliente Personal (PersonalClientRequest)          1
 * Cliente Empresarial (BusinessClientRequest)       2
 * Cliente Personal VIP (PersonalClientRequest)      3
 * Cliente Empresarial PYME (BusinessClientRequest)  4
 * */

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "typeId",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PersonalClientRequest.class, name = "1"),
        @JsonSubTypes.Type(value = BusinessClientRequest.class, name = "2"),
        @JsonSubTypes.Type(value = PersonalClientRequest.class, name = "3"),
        @JsonSubTypes.Type(value = BusinessClientRequest.class, name = "4")
})
@Getter
@Setter
public abstract class ClientRequest {
    @Range(min = 1, max = 4)
    @NotNull
    private Integer typeId;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String phone;
    @NotBlank
    private String address;
}
