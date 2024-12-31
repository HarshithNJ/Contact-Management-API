package org.contact.contact.controller;


import org.contact.contact.dto.contact;
import org.contact.contact.service.contactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@Tag(name = "Contact Controller", description = "A Controller to store contact information")
public class contactController {

    @Autowired
    contactService service;


    //To Save a record
    @Operation(summary = "Add a new contact" , description = "Add a new contact")
    @ApiResponse(responseCode = "200", description = "Successfully added")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @PostMapping("/contacts")
    public ResponseEntity<Object> addContact(@RequestBody contact contact){
        return service.addContact(contact);
    }
    

    //To get all records
    @Operation(summary = "Get all contacts" , description = "Get all contacts")
    @ApiResponse(responseCode = "302", description = "Successfully fetched")
    @ApiResponse(responseCode = "404", description = "No data found")
    @GetMapping("/contacts")
    public ResponseEntity<Object> getAllContacts(){
        return service.getAllContacts();
    }

    @Operation(summary = "Get a contact by name" , description = "Get a contact by name")
    @ApiResponse(responseCode = "302", description = "Successfully fetched")
    @ApiResponse(responseCode = "404", description = "No data found")
    @GetMapping("/contacts/{name}")
    public ResponseEntity<Object> getDataByName(@PathVariable String name){
        return service.getDataByName(name);
    }

    @Operation(summary = "Get a contact by phone number" , description = "Get a contact by phone number")
    @ApiResponse(responseCode = "302", description = "Successfully fetched")
    @ApiResponse(responseCode = "404", description = "No data found")
    @GetMapping("/contacts/mobile/{phoneNumber}")
    public ResponseEntity<Object> getDataByPhoneNumber(@PathVariable long phoneNumber){
        return service.getDataByPhoneNumber(phoneNumber);
    }

    @Operation(summary = "Get a contact by address" , description = "Get a contact by address")
    @ApiResponse(responseCode = "302", description = "Successfully fetched")
    @ApiResponse(responseCode = "404", description = "No data found")
    @GetMapping("/contacts/find/address/{address}")
    public ResponseEntity<Object> getDataByAddress(@PathVariable String address){
        return service.getDataByAddress(address);
    }


    //To delete a record
    @Operation(summary = "Delete a contact" , description = "Delete a contact")
    @ApiResponse(responseCode = "200", description = "Successfully deleted")
    @ApiResponse(responseCode = "204", description = "No data found")
    @DeleteMapping("/contacts/{id}")
    public ResponseEntity<Object> deleteContact(@PathVariable int id){
        return service.deleteContact(id);
    }
    

    //To update a record
    @Operation(summary = "Update a contact" , description = "Update a contact")
    @ApiResponse(responseCode = "200", description = "Successfully updated")
    @ApiResponse(responseCode = "204", description = "No data found")
    @PatchMapping("/contacts/{id}")
    public ResponseEntity<Object> updateContact(@PathVariable int id, @RequestBody contact contact){
        return service.updateContact(id, contact);
    }
}
