package utils;

import java.util.Comparator;

import models.Contacto;

public class contactoComparatorHash implements Comparator<Contacto> {

    @Override
    public int compare(Contacto c1, Contacto c2) {
        // TODO Auto-generated method stub
        
        return Integer.compare(c1.hashCode(), c2.hashCode());
    }
    
}
