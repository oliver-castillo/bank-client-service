package com.bank.clientservice.controller;

import com.bank.clientservice.model.dto.request.PersonalClientRequest;
import com.bank.clientservice.service.ClientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clients/personal")
public class PersonalClientController extends BaseClientController<PersonalClientRequest> {
    public PersonalClientController(ClientService<PersonalClientRequest> personalClientService) {
        super(personalClientService);
    }
}
