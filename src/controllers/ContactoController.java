package controllers;
import models.*;
import utils.ContactoComparator;
import utils.ContactoComparatorTelefono;
import utils.contactoComparatorHash;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class ContactoController {
    public ContactoController(){
        runTreeContacto();
        runTreeContactoTelefono();
        runCompareHash();
    }

    public void runTreeContacto(){
        ContactoComparator cCom = new ContactoComparator();
        Set<Contacto> agenda =new TreeSet<>(cCom);
        //Agregamos algunos contactos
        agenda.add(new Contacto("Pedro", "Lopez", "222222222"));
        agenda.add(new Contacto("Luis", "Perez", "111111111"));
        agenda.add(new Contacto("Ana", "Perez", "987654321"));
        agenda.add(new Contacto("Pedro", "Lopez", "123456789"));
        agenda.add(new Contacto("Pedro", "Lopez", "222222222"));
        agenda.add(new Contacto("Pedro", "Gonzales", "222222222"));
        agenda.add(new Contacto("Pablo", "Lopez", "222222222"));
        System.out.println("Agenda ordenada por Apellido y Nombre");
        for (Contacto contacto : agenda) {
            System.out.println(contacto);
        }
    }
    public void runTreeContactoTelefono(){
        Set<Contacto> agenda =new TreeSet<>(new ContactoComparatorTelefono());
        //Agregamos algunos contactos
        agenda.add(new Contacto("Pedro", "Lopez", "222222222"));
        agenda.add(new Contacto("Luis", "Perez", "111111111"));
        agenda.add(new Contacto("Ana", "Perez", "987654321"));
        agenda.add(new Contacto("Pedro", "Lopez", "123456789"));
        agenda.add(new Contacto("Pedro", "Lopez", "222222222"));
        agenda.add(new Contacto("Pedro", "Gonzales", "222222222"));
        agenda.add(new Contacto("Pablo", "Lopez", "222222222"));
        System.out.println("Agenda ordenada por Apellido, Nombre y telefono");
        for (Contacto contacto : agenda) {
            System.out.println(contacto);
        }
    }

    public void runCompareHash(){

        Set<Contacto> agenda =new TreeSet<>(new contactoComparatorHash());
        //Agregamos algunos contactos
        agenda.add(new Contacto("Pedro", "Lopez", "222222222"));
        agenda.add(new Contacto("Luis", "Perez", "111111111"));
        agenda.add(new Contacto("Ana", "Perez", "987654321"));
        agenda.add(new Contacto("Pedro", "Lopez", "123456789"));
        agenda.add(new Contacto("Pedro", "Lopez", "222222222"));
        agenda.add(new Contacto("Pedro", "Gonzales", "222222222"));
        agenda.add(new Contacto("Pablo", "Lopez", "222222222"));
        System.out.println("Agenda ordenada por hash code");
        for (Contacto contacto : agenda) {
            System.out.println(contacto);
        }
    }

    
}
