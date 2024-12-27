package org.contact.contact.controller;

import org.contact.contact.service.contactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class contactController {

    @Autowired
    contactService service;
    
}
