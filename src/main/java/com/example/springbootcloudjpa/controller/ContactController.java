package com.example.springbootcloudjpa.controller;

import com.example.springbootcloudjpa.model.Contact;
import com.example.springbootcloudjpa.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/contacts"})
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping(value = "/savecontact")
    public Contact create(@RequestBody Contact contact) {
        return contactService.saveContact(contact);
    }

    @PostMapping(value = "/saveallcontact")
    public List<Contact> create(@RequestBody List<Contact> contact) {
        return contactService.saveContact(contact);
    }

    @GetMapping(value = "/getallcontacts")
    public List<Contact> findAll() {
        return contactService.getAllContact();
    }

    @GetMapping(value = "/getcontactbyid/{id}")
    public Optional<Contact> findContactById(@PathVariable("id") long id) {
        return contactService.getContactById(id);
    }

    @DeleteMapping(value = "/deletecontactbyid/{id}")
    public ResponseEntity<?> deleteContactById(@PathVariable("id") long id) {
        return contactService.deleteContactById(id);
    }

    @DeleteMapping(value = "/deleteallcontactbyid")
    public ResponseEntity<?> deleteAllContacts() {
        return contactService.deleteAllContacts();
    }

    @PutMapping(value = "/updatecontactbyid/{id}")
    public ResponseEntity<?> updateContact(@PathVariable("id") long id, @RequestBody Contact contact) {
        return contactService.updateContactById(id, contact);
    }
}
