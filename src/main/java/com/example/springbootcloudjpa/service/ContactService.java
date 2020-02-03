package com.example.springbootcloudjpa.service;

import com.example.springbootcloudjpa.model.Contact;
import com.example.springbootcloudjpa.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;


    public Contact saveContact(Contact contact) {
        try {
            return contactRepository.save(contact);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Contact> saveContact(List<Contact> contact) {
        try {
            return contact.stream().map(record -> contactRepository.save(record)).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Contact> getAllContact() {
        try {
            return contactRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Optional<Contact> getContactById(long id) {
        try {
            return contactRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public ResponseEntity<?> deleteContactById(long id) {
        try {
            contactRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<?> deleteAllContacts() {
        try {
            contactRepository.deleteAll();
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<?> updateContactById(long id, Contact contact) {
        return contactRepository.findById(id)
                .map(record -> {
                    record.setName(contact.getName());
                    record.setEmail(contact.getEmail());
                    record.setPhone(contact.getPhone());
                    Contact updatedContact = contactRepository.save(record);
                    return ResponseEntity.ok().body(updatedContact);
                }).orElse(ResponseEntity.notFound().build());
    }
}
