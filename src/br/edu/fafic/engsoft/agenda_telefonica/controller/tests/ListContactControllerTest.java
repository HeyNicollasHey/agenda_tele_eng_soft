package br.edu.fafic.engsoft.agenda_telefonica.controller.tests;

import br.edu.fafic.engsoft.agenda_telefonica.controller.ListContactController;
import br.edu.fafic.engsoft.agenda_telefonica.model.Contact;
import br.edu.fafic.engsoft.agenda_telefonica.service.ListContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListContactControllerTest {
    private ListContactController listContactController;
    private ListContactService listContactService;
    private List<Contact> contacts;

    @BeforeEach
    void setUp() {
        contacts = new ArrayList<>();
        contacts.add(new Contact("Nicollas", "12345"));
        contacts.add(new Contact("Gustavo", "54321"));
        listContactService = new ListContactService();
        listContactController = new ListContactController(listContactService, contacts);
    }

    @Test
    void testHandleShowContact_ByName() {
        listContactController.handleShowContact("Nicollas", "nome");
        assertTrue(contacts.stream().anyMatch(contact -> contact.getName().equals("Nicollas")));
    }

    @Test
    void testHandleShowContact_ByNumber() {
        listContactController.handleShowContact("54321", "numero");
        assertTrue(contacts.stream().anyMatch(contact -> contact.getNumber().equals("54321")));
    }

    @Test
    void testHandleShowContact_InvalidToken() {
        listContactController.handleShowContact("Nicollas", "email");
        assertEquals(2, contacts.size());
    }
}