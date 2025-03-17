package br.edu.fafic.engsoft.agenda_telefonica.service.tests;
import br.edu.fafic.engsoft.agenda_telefonica.model.Contact;
import br.edu.fafic.engsoft.agenda_telefonica.service.ListContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListContactServiceTest {

    private ListContactService listContactService;
    private List<Contact> contacts;

    @BeforeEach
    void setUp() {
        listContactService = new ListContactService();
        contacts = new ArrayList<>();
        contacts.add(new Contact("Alice", "123456789"));
        contacts.add(new Contact("Bob", "987654321"));
        contacts.add(new Contact("Charlie", "555555555"));
    }

    @Test
    void testShowContactByName_Found() {
        Contact contact = listContactService.showContactByName("Alice", contacts);
        assertNotNull(contact);
        assertEquals("Alice", contact.getName());
    }

    @Test
    void testShowContactByName_NotFound() {
        Contact contact = listContactService.showContactByName("Daniel", contacts);
        assertNull(contact);
    }

    @Test
    void testShowContactByNumber_Found() {
        Contact contact = listContactService.showContactByNumber("987654321", contacts);
        assertNotNull(contact);
        assertEquals("987654321", contact.getNumber());
    }

    @Test
    void testShowContactByNumber_NotFound() {
        Contact contact = listContactService.showContactByNumber("000000000", contacts);
        assertNull(contact);
    }

    @Test
    void testTotalOfContacts() {
        assertEquals(3, listContactService.totalOfContacts(contacts));
    }

    @Test
    void testTotalOfContacts_EmptyList() {
        List<Contact> emptyList = new ArrayList<>();
        assertEquals(0, listContactService.totalOfContacts(emptyList));
    }
}
