package utils;

import java.util.Comparator;

import models.Contacto;

public class ContactoComparator implements Comparator<Contacto>{
    @Override
    public int compare(Contacto c1, Contacto c2){
        //primero comparo por el apellido alfabeticcamente
        int resultComparationApellido = c1.getApellido().compareToIgnoreCase(c2.getApellido());
        if (resultComparationApellido !=0){
            return resultComparationApellido;
        }
        int resultComparationNombre = c1.getNombre().compareToIgnoreCase(c2.getNombre());
        return resultComparationNombre;
    }   
}