package br.edu.fafic.engsoft.agenda_telefonica.controller;

import br.edu.fafic.engsoft.agenda_telefonica.model.Contact;
import br.edu.fafic.engsoft.agenda_telefonica.service.ListContactService;

import java.util.List;

public class ListContactController {
    private List<Contact> listOfContacts;
    private ListContactService listContactService;

    public ListContactController(ListContactService listContactService, List<Contact> listOfContacts) {
        this.listContactService = listContactService;
        this.listOfContacts = listOfContacts;
    }

    public void handleShowContact(String contact, String token) {
        switch (token.toLowerCase()) {
            case "nome":
                System.out.println(listContactService.showContactByName(contact, listOfContacts));
                break;
            case "numero":
                System.out.println(listContactService.showContactByNumber(contact, listOfContacts));
                break;
            default:
                System.out.println("Token inválido.");
                break;
        }
    }

    public void handleShowAllContacts() {
        listContactService.showAllContacts(listOfContacts);
    }

    public void handleShowTotalOfContacts() {
        System.out.println("Total de contatos: " + listContactService.totalOfContacts(listOfContacts));
    }
}