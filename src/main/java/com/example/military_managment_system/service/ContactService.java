package com.example.military_managment_system.service;



import com.example.military_managment_system.model.Contact;

import java.util.List;

public interface ContactService {
    public Contact saveVontact(Contact contact);
        public List<Contact> GetAllContact();
        public void deleteContact(String email);
}
