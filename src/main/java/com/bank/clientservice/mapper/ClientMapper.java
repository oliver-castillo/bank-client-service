package com.bank.clientservice.mapper;

import com.bank.clientservice.model.document.BusinessClient;
import com.bank.clientservice.model.document.Client;
import com.bank.clientservice.model.document.PersonalClient;
import com.bank.clientservice.model.dto.request.BusinessClientRequest;
import com.bank.clientservice.model.dto.request.ClientRequest;
import com.bank.clientservice.model.dto.request.PersonalClientRequest;
import com.bank.clientservice.model.dto.response.ClientResponse;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClientMapper {
    PersonalClient toDocument(PersonalClientRequest request);

    BusinessClient toDocument(BusinessClientRequest request);

    ClientResponse toResponse(BusinessClient document);

    ClientResponse toResponse(PersonalClient document);

    default ClientResponse toResponse(Client document) {
        if (document instanceof PersonalClient personalClient) {
            return toResponse(personalClient);
        }
        if (document instanceof BusinessClient businessClient) {
            return toResponse(businessClient);
        }
        return null;
    }

    default Client toDocument(ClientRequest request) {
        if (request instanceof PersonalClientRequest personalClientRequest) {
            return toDocument(personalClientRequest);
        } else if (request instanceof BusinessClientRequest businessClientRequest) {
            return toDocument(businessClientRequest);
        }
        return null;
    }

    default void updateClient(@MappingTarget Client document, ClientRequest request) {
        if (request instanceof PersonalClientRequest personalClientRequest) {
            updateClient((PersonalClient) document, personalClientRequest);
        } else if (request instanceof BusinessClientRequest businessClientRequest) {
            updateClient((BusinessClient) document, businessClientRequest);
        }
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateClient(@MappingTarget PersonalClient document, PersonalClientRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateClient(@MappingTarget BusinessClient document, BusinessClientRequest request);


}
