package com.bank.clientservice.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BusinessClientRequest extends ClientRequest {
    @NotBlank
    private String companyName;
    @NotBlank
    private String ruc;
}
