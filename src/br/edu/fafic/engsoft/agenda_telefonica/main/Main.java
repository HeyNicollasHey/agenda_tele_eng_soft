package br.edu.fafic.engsoft.agenda_telefonica.main;

import br.edu.fafic.engsoft.agenda_telefonica.controller.DeleteContactController;
import br.edu.fafic.engsoft.agenda_telefonica.controller.ListContactController;
import br.edu.fafic.engsoft.agenda_telefonica.controller.SaveContactController;
import br.edu.fafic.engsoft.agenda_telefonica.model.Contact;
import br.edu.fafic.engsoft.agenda_telefonica.service.ListContactService;
import br.edu.fafic.engsoft.agenda_telefonica.service.SaveContactService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Contact> listOfContacts = new ArrayList<>();
        ListContactService listContactService = new ListContactService();
        SaveContactService saveContactService = new SaveContactService();

        SaveContactController saveContactController = new SaveContactController(saveContactService, listOfContacts);
        ListContactController listContactController = new ListContactController(listContactService, listOfContacts);
        DeleteContactController deleteContactController = new DeleteContactController(listOfContacts);

        saveContactController.handleSaveContact("Erlon", "999909409");
        saveContactController.handleSaveContact("Lucas", "999909410");
        saveContactController.handleSaveContact("Davina", "999909411");
        saveContactController.handleSaveContact("Valesca", "999909412");
        saveContactController.handleSaveContact("Mony", "999909413");
        saveContactController.handleSaveContact("Yuri", "999909414");

        listContactController.handleShowAllContacts();

        listContactController.handleShowTotalOfContacts();

        listContactController.handleShowContact("Erlon", "nome");
        listContactController.handleShowContact("999909410", "numero");

        deleteContactController.handleDeleteContact("Mony", "nome");

        listContactController.handleShowTotalOfContacts();

        deleteContactController.handleDeleteContact("999909412", "numero");
        listContactController.handleShowTotalOfContacts();

        listContactController.handleShowAllContacts();
    }
}
