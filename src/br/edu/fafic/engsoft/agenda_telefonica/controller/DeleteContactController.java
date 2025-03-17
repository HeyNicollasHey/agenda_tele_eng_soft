package br.edu.fafic.engsoft.agenda_telefonica.controller;

import br.edu.fafic.engsoft.agenda_telefonica.model.Contact;
import br.edu.fafic.engsoft.agenda_telefonica.service.DeleteContactService;

import java.util.List;

public class DeleteContactController {
    private List<Contact> listOfContacts;
    private DeleteContactService deleteContactService;

    public DeleteContactController(List<Contact> listOfContacts) {
        this.listOfContacts = listOfContacts;
    }

    public void handleDeleteContact(String contact, String token){
        switch (token.toLowerCase()){
            case "nome":
                deleteContactService.deleteContactByName(contact, listOfContacts);
                break;
            case "numero":
                deleteContactService.deleteContactByNumber(contact, listOfContacts);
                break;
            default:
                break;
        }
    }
}


