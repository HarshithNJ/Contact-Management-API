package org.contact.contact.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.contact.contact.dto.contact;
import org.contact.contact.repository.contactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class contactService {

    @Autowired
    contactRepository repository;

    public ResponseEntity<Object> addContact(contact contact) {
        if(repository.existsByName(contact.getName())){

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Name Already Exists");

            // if(contact.getPhoneNumber()> 10000000000L){

            //     Map<String, Object> map1 = new HashMap<String, Object>();
            //     map1.put("error", "Length of phone number must not exceed 10 digits");
   
            //     return new ResponseEntity<Object>(map1, HttpStatus.BAD_REQUEST);
            // }

            return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
        }else{
            repository.save(contact);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Data Saved Successfully");
            map.put("Data", contact);

            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> getAllContacts() {
        List<contact> contacts = repository.findAll();

        if(contacts.isEmpty()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No Data Found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Data Found");
            map.put("Data", contacts);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }
    
}
