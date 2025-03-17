package br.edu.fafic.engsoft.agenda_telefonica.service.tests;
import br.edu.fafic.engsoft.agenda_telefonica.model.Contact;
import br.edu.fafic.engsoft.agenda_telefonica.service.DeleteContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeleteContactServiceTest {

    private DeleteContactService deleteContactService;
    private List<Contact> contacts;

    @BeforeEach
    void setUp() {
        deleteContactService = new DeleteContactService();
        contacts = new ArrayList<>();
        contacts.add(new Contact("Alice", "123456789"));
        contacts.add(new Contact("Bob", "987654321"));
        contacts.add(new Contact("Charlie", "555555555"));
    }

    @Test
    void testDeleteContactByNumber_Success() {
        deleteContactService.deleteContactByNumber("123456789", contacts);
        assertEquals(2, contacts.size());
        assertFalse(contacts.stream().anyMatch(c -> c.getNumber().equals("123456789")));
    }

    @Test
    void testDeleteContactByNumber_NotFound() {
        deleteContactService.deleteContactByNumber("000000000", contacts);
        assertEquals(3, contacts.size());
    }

    @Test
    void testDeleteContactByName_Success() {
        deleteContactService.deleteContactByName("Bob", contacts);
        assertEquals(2, contacts.size());
        assertFalse(contacts.stream().anyMatch(c -> c.getName().equals("Bob")));
    }

    @Test
    void testDeleteContactByName_NotFound() {
        deleteContactService.deleteContactByName("Daniel", contacts);
        assertEquals(3, contacts.size());
    }

    @Test
    void testDeleteContactByNumber_EmptyList() {
        List<Contact> emptyList = new ArrayList<>();
        deleteContactService.deleteContactByNumber("123456789", emptyList);
        assertTrue(emptyList.isEmpty());
    }

    @Test
    void testDeleteContactByName_EmptyList() {
        List<Contact> emptyList = new ArrayList<>();
        deleteContactService.deleteContactByName("Alice", emptyList);
        assertTrue(emptyList.isEmpty());
    }
}
