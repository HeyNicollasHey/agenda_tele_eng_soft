package br.edu.fafic.engsoft.agenda_telefonica.model.tests;

import br.edu.fafic.engsoft.agenda_telefonica.model.Contact;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    @Test
    void testContactCreation() {
        Contact contact = new Contact("Alice", "123456789");
        assertNotNull(contact);
        assertEquals("Alice", contact.getName());
        assertEquals("123456789", contact.getNumber());
    }

    @Test
    void testSetName() {
        Contact contact = new Contact("Alice", "123456789");
        contact.setName("Bob");
        assertEquals("Bob", contact.getName());
    }

    @Test
    void testSetNumber() {
        Contact contact = new Contact("Alice", "123456789");
        contact.setNumber("987654321");
        assertEquals("987654321", contact.getNumber());
    }

    @Test
    void testToString() {
        Contact contact = new Contact("Alice", "123456789");
        String expectedString = "Contato{nome='Alice', numero='123456789'}";
        assertEquals(expectedString, contact.toString());
    }
}
