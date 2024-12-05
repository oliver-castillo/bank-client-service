package com.bank.clientservice.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonalClientRequest extends ClientRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String paternalSurname;
    @NotBlank
    private String maternalSurname;
    @NotBlank
    @Size(min = 8, max = 8)
    private String dni;
}
