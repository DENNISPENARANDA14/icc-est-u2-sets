package controllers;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sets {
    public Sets(){

    }
    public Set<String> construirHashSet(){
        Set<String> palabra = new HashSet<>();
        palabra.add("Laptop");
        palabra.add("Manzana");
        palabra.add("Pera");
        palabra.add("Celular");
        palabra.add("Laptop");
        palabra.add("Celular");
        System.out.println(palabra.size());
        return palabra;
    }

    public Set<String> construirLinkedHashSet(){
        Set<String> palabra = new LinkedHashSet<>();
        palabra.add("Laptop");
        palabra.add("Manzana");
        palabra.add("Pera");
        palabra.add("Celular");
        palabra.add("Laptop");
        palabra.add("Celular");
        System.out.println(palabra.size());
        return palabra;
        
    }
    public Set<String> construirTreeSet(){
        Set<String> palabra = new TreeSet<>();
        palabra.add("Laptop");
        palabra.add("Manzana");
        palabra.add("Pera");
        palabra.add("Celular");
        palabra.add("Laptop");
        palabra.add("Celular");
        System.out.println(palabra.size());
        return palabra;
    }
    public Set<String> construirTreeSetConComparador(){
        // Implementacion del comparator, para comparacion especifica
        Comparator<String> comparador = new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                //primero comparamos por la longitud
                int result = Integer.compare(s1.length(), s2.length()); 
                //si son iguales comparo alfabeticamente
                if (result==0) {
                    result=s1.compareTo(s2);                    
                }
                return result;
            }
        };

        Set<String> palabra = new TreeSet<>(comparador);
        palabra.add("Laptop");
        palabra.add("Manzana");
        palabra.add("Pera");
        palabra.add("Celular");
        palabra.add("Laptop");
        palabra.add("Celular");
        palabra.add("Celulas");
        System.out.println(palabra.size());
        return palabra;
    }

    public Set<String> construirTreeSetConComparadorDescendente(){
        // Implementacion del comparator, para comparacion especifica
        Comparator<String> comparadorInvertido = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            int result = Integer.compare(s2.length(), s1.length());
            if (result == 0) {
                result = s2.compareTo(s1);
            }
            return result;
        }
    };

    Set<String> miTreeSetComparatorInvertido = new TreeSet<>(comparadorInvertido);

    miTreeSetComparatorInvertido.add("Laptop");
    miTreeSetComparatorInvertido.add("Manzana");
    miTreeSetComparatorInvertido.add("Pera");
    miTreeSetComparatorInvertido.add("Celular");
    miTreeSetComparatorInvertido.add("Laptop");
    miTreeSetComparatorInvertido.add("Celular");
    miTreeSetComparatorInvertido.add("Celulas");

        return miTreeSetComparatorInvertido;
    }
}
