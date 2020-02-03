package com.example.springbootcloudjpa.controller;

import com.example.springbootcloudjpa.model.Contact;
import com.example.springbootcloudjpa.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/contacts"})
public class ContactController {


    //private ContactRepository repository;
    @Autowired
    private ContactService contactService;


   /* ContactController(ContactRepository contactRepository) {
        this.repository = contactRepository;
    }

    @GetMapping
    public List findAll() {
        return repository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Contact> findById(@PathVariable("id") long id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Contact create(@RequestBody Contact contact) {

        return repository.save(contact);
    }

    @PutMapping(path = {"/id"})
    public ResponseEntity<Contact> update(@PathVariable("id") long id, @RequestBody Contact contact) {
        return repository.findById(id)
                .map(record -> {
                    record.setName(contact.getName());
                    record.setEmail(contact.getEmail());
                    record.setPhone(contact.getPhone());
                    Contact updatedContact = repository.save(record);
                    return ResponseEntity.ok().body(updatedContact);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = {"/id"})
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }*/

    @RequestMapping(value = "/savecontact", method = RequestMethod.POST)
    public Contact create(@RequestBody Contact contact) {
        return contactService.saveContact(contact);
    }

}
