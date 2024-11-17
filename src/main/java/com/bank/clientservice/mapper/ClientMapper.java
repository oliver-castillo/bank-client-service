package com.bank.clientservice.mapper;

import com.bank.clientservice.model.document.BusinessClient;
import com.bank.clientservice.model.document.PersonalClient;
import com.bank.clientservice.model.dto.request.BusinessClientRequest;
import com.bank.clientservice.model.dto.request.PersonalClientRequest;
import com.bank.clientservice.model.dto.response.BusinessClientResponse;
import com.bank.clientservice.model.dto.response.PersonalClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClientMapper {
    PersonalClient toDocument(PersonalClientRequest request);

    BusinessClient toDocument(BusinessClientRequest request);

    BusinessClientResponse toResponse(BusinessClient document);

    PersonalClientResponse toResponse(PersonalClient document);
}
