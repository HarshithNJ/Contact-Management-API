package org.contact.contact.controller;

import java.util.List;

import org.contact.contact.dto.contact;
import org.contact.contact.service.contactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class contactController {

    @Autowired
    contactService service;


    //To Save a record
    @PostMapping("/contacts")
    public ResponseEntity<Object> addContact(@RequestBody contact contact){
        return service.addContact(contact);
    }
    

    //To get all records
    @GetMapping("/contacts")
    public ResponseEntity<Object> getAllContacts(){
        return service.getAllContacts();
    }

    @GetMapping("/contacts/{name}")
    public ResponseEntity<Object> getDataByName(@PathVariable String name){
        return service.getDataByName(name);
    }

    @GetMapping("/contacts/mobile/{phoneNumber}")
    public ResponseEntity<Object> getDataByPhoneNumber(@PathVariable long phoneNumber){
        return service.getDataByPhoneNumber(phoneNumber);
    }
    
}
