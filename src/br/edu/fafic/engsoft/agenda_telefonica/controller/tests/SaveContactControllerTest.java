package br.edu.fafic.engsoft.agenda_telefonica.controller.tests;

import br.edu.fafic.engsoft.agenda_telefonica.controller.SaveContactController;
import br.edu.fafic.engsoft.agenda_telefonica.model.Contact;
import br.edu.fafic.engsoft.agenda_telefonica.service.SaveContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SaveContactControllerTest {

    private SaveContactController saveContactController;
    private SaveContactService saveContactService;
    private List<Contact> contacts;

    @BeforeEach
    void setUp() {
        contacts = new ArrayList<>();
        saveContactService = new SaveContactService();
        saveContactController = new SaveContactController(saveContactService, contacts);
    }

    @Test
    void testHandleSaveContact_ValidContact() {
        saveContactController.handleSaveContact("Nicollas", "123456789");
        assertEquals(1, contacts.size());
        assertEquals("Nicollas", contacts.get(0).getName());
        assertEquals("123456789", contacts.get(0).getNumber());
    }

    @Test
    void testHandleSaveContact_InvalidName() {
        saveContactController.handleSaveContact("", "123456789");
        assertEquals(0, contacts.size());
    }

    @Test
    void testHandleSaveContact_InvalidNumber() {
        saveContactController.handleSaveContact("Nicollas", "12345");
        assertEquals(0, contacts.size());
    }
}