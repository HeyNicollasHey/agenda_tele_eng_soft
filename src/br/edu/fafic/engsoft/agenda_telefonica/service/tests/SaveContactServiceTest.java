package br.edu.fafic.engsoft.agenda_telefonica.service.tests;

import br.edu.fafic.engsoft.agenda_telefonica.model.Contact;
import br.edu.fafic.engsoft.agenda_telefonica.service.SaveContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SaveContactServiceTest {

    private SaveContactService saveContactService;
    private List<Contact> contacts;

    @BeforeEach
    void setUp() {
        saveContactService = new SaveContactService();
        contacts = new ArrayList<>();
    }

    @Test
    void testSaveContact_Success() {
        saveContactService.saveContact("Alice", "123456789", contacts);
        assertEquals(1, contacts.size());
        assertEquals("Alice", contacts.get(0).getName());
        assertEquals("123456789", contacts.get(0).getNumber());
    }

    @Test
    void testSaveMultipleContacts() {
        saveContactService.saveContact("Alice", "123456789", contacts);
        saveContactService.saveContact("Bob", "987654321", contacts);
        assertEquals(2, contacts.size());
    }

    @Test
    void testSaveContact_EmptyList() {
        saveContactService.saveContact("Charlie", "555555555", contacts);
        assertFalse(contacts.isEmpty());
    }
}
