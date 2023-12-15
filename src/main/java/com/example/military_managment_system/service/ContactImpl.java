package com.example.military_managment_system.service;

import com.example.military_managment_system.model.Contact;
import com.example.military_managment_system.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContactImpl implements ContactService {

    private final ContactRepository contactRepository;

    public ContactImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact saveVontact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> GetAllContact() {
        return contactRepository.findAll();
    }

    @Override
    public void deleteContact(String email) {
        contactRepository.deleteById(email);
    }
}
