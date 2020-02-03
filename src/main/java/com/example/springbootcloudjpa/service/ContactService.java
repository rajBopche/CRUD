package com.example.springbootcloudjpa.service;

import com.example.springbootcloudjpa.model.Contact;
import com.example.springbootcloudjpa.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
