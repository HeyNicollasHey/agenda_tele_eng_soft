package br.edu.fafic.engsoft.agenda_telefonica.controller.tests;

import br.edu.fafic.engsoft.agenda_telefonica.controller.DeleteContactController;
import br.edu.fafic.engsoft.agenda_telefonica.model.Contact;
import br.edu.fafic.engsoft.agenda_telefonica.service.DeleteContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeleteContactControllerTest {

    private DeleteContactController deleteContactController;
    private DeleteContactService deleteContactService;
    private List<Contact> contacts;

    @BeforeEach
    void setUp() {
        contacts = new ArrayList<>();
        contacts.add(new Contact("Alice", "123456789"));
        contacts.add(new Contact("Bob", "987654321"));
        deleteContactController = new DeleteContactController(contacts);
    }

    @Test
    void testHandleDeleteContact_ByName() {
        deleteContactController.handleDeleteContact("Alice", "nome");
        assertFalse(contacts.stream().anyMatch(contact -> contact.getName().equals("Alice")));
    }

    @Test
    void testHandleDeleteContact_ByNumber() {
        deleteContactController.handleDeleteContact("987654321", "numero");
        assertFalse(contacts.stream().anyMatch(contact -> contact.getNumber().equals("987654321")));
    }

    @Test
    void testHandleDeleteContact_InvalidToken() {
        deleteContactController.handleDeleteContact("Alice", "email");
        assertEquals(2, contacts.size());
    }
}
