import java.util.Set;

import controllers.Sets;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Sets sets = new Sets();
        System.out.println("HASHSET");
        runHashSet(sets);
        System.out.println("LINKEDHASHSET");
        runLikedHashSet(sets);
        System.out.println("TREESET");
        runTreeSet(sets);
        System.out.println("TREESET CON COMPARADOR");
        runTreeSetConComparador(sets);
        System.out.println("TREESET CON COMPARADOR DESCENDENTE");
        runTreeSetConComparadorDescendente(sets);
    }
    public static void runHashSet(Sets sets){
        Set<String> palabra= sets.construirHashSet();
        for (String p : palabra) {
            System.out.println(p);
        }
    }
    public static void runLikedHashSet(Sets sets){
        Set<String> palabra= sets.construirLinkedHashSet();
        for (String p : palabra) {
            System.out.println(p);
        }
    }
    public static void runTreeSet(Sets sets){
        Set<String> palabra= sets.construirTreeSet();
        for (String p : palabra) {
            System.out.println(p);
        }
    }
    public static void runTreeSetConComparador(Sets sets){
        Set<String> palabra= sets.construirTreeSetConComparador();
        for (String p : palabra) {
            System.out.println(p);
        }
    }
    public static void runTreeSetConComparadorDescendente(Sets sets){
        Set<String> palabra= sets.construirTreeSetConComparador();
        for (String p : palabra) {
            System.out.println(p);
        }
    }
}
