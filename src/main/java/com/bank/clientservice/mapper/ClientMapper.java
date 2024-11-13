package com.bank.clientservice.mapper;

import com.bank.clientservice.model.document.BusinessClientDocument;
import com.bank.clientservice.model.document.PersonalClientDocument;
import com.bank.clientservice.model.dto.request.BusinessClientRequest;
import com.bank.clientservice.model.dto.request.PersonalClientRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClientMapper {
    PersonalClientDocument toDocument(PersonalClientRequest request);

    BusinessClientDocument toDocument(BusinessClientRequest request);
}
