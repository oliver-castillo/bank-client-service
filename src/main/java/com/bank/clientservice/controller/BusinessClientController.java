package com.bank.clientservice.controller;

import com.bank.clientservice.model.dto.request.BusinessClientRequest;
import com.bank.clientservice.service.ClientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clients/business")
public class BusinessClientController extends BaseClientController<BusinessClientRequest> {
    public BusinessClientController(ClientService<BusinessClientRequest> clientService) {
        super(clientService);
    }
}
