package org.contact.contact.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    public ResponseEntity<Object> getDataByName(String name) {
        Optional<contact> op = repository.findByName(name);
        if(op.isPresent()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Data Found");
            map.put("Data", op.get());

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No Data Found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> getDataByPhoneNumber(long phoneNumber) {
        Optional<contact> op =repository.findByPhoneNumber(phoneNumber);
        if(op.isPresent()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Data Found");
            map.put("Data", op.get());

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No Data Found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<Object> getDataByAddress(String address) {
        List<contact> contacts = repository.findByAddress(address);

        if (contacts.isEmpty()) {
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("error", "No Data Found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("success", "Data Found");
            map.put("Data", contacts);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }

    public ResponseEntity<Object> deleteContact(int id) {
        Optional<contact> op = repository.findById(id);

        if(op.isPresent()){
            repository.deleteById(id);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Data Deleted Successfully");
            map.put("Data", op.get());

            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No Data Found with the id: " + id);

            return new ResponseEntity<Object>(map, HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<Object> updateContact(int id, contact contact) {
        if(repository.findById(id).isPresent()){
            contact contacts = repository.findById(id).get();

            if(contact.getName() != null)
                contacts.setName(contact.getName());

            if(contact.getEmail() != null)
                contacts.setEmail(contact.getEmail());

            if(contact.getPhoneNumber() != 0)
                contacts.setPhoneNumber(contact.getPhoneNumber());

            if(contact.getAddress() != null)
                contacts.setAddress(contact.getAddress());

            repository.save(contacts);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Data Updated Successfully");
            map.put("Data", contacts);

            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No Data Found with the id: " + id);

            return new ResponseEntity<Object>(map, HttpStatus.NO_CONTENT);
        }
    }
    
    
}
