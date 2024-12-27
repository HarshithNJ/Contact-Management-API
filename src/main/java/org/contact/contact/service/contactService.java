package org.contact.contact.service;

import org.contact.contact.repository.contactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class contactService {

    @Autowired
    contactRepository repository;
    
}
