package utils;

import java.util.Comparator;

import models.Contacto;

public class ContactoComparatorTelefono implements Comparator<Contacto>{
    @Override
    public int compare(Contacto c1, Contacto c2){
        int resultComparationApellido = c1.getApellido().compareToIgnoreCase(c2.getApellido());
        if (resultComparationApellido !=0){
            return resultComparationApellido;
        }
        int resultComparationNombre = c1.getNombre().compareToIgnoreCase(c2.getNombre());
        if(resultComparationNombre !=0){
            return resultComparationNombre;
        }
        return c2.getTelefono().compareToIgnoreCase(c1.getTelefono());
    }   
}