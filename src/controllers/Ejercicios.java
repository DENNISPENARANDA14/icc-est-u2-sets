package controllers;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicios {
    public Ejercicios(){
        //System.out.println(tieneDuplicados(new int[] {1, 2, 3, 4, 5}));
        //System.out.println(tieneDuplicados(new int[] {1, 2, 3, 4, 5, 4, 3, 2, 45}));
        
        //System.out.println(esISograma("murcielago")+" murcielago" );
        //System.out.println(esISograma("cualquiera ")+" cualquiera");
        String texto = """
            La inteligencia artificial (IA) está transformando el mundo a una velocidad sin precedentes. Desde asistentes virtuales que responden preguntas hasta vehículos autónomos que recorren las ciudades, la IA está presente en casi todos los aspectos de nuestra vida diaria. Sin embargo, este avance también plantea desafíos éticos, sociales y económicos que deben ser cuidadosamente analizados. ¿Estamos preparados para delegar decisiones importantes a sistemas que no poseen conciencia ni empatía?
                    Por otro lado, la IA puede ser una herramienta poderosa en sectores como la salud, la educación y el medio ambiente. Con algoritmos bien entrenados, es posible detectar enfermedades de forma temprana, personalizar la enseñanza o monitorear los ecosistemas en tiempo real. No obstante, es fundamental garantizar que su implementación sea inclusiva, justa y transparente.
                    En resumen, el desarrollo responsable de la inteligencia artificial no solo debe centrarse en la innovación, sino también en el impacto que genera en la humanidad y en el planeta. El futuro no está escrito, pero lo que decidamos hoy tendrá consecuencias duraderas.""";
        String texto1 = "¡Hola! La programación en Java es muy divertida, sobre todo cuando se entienden los conceptos.";
        String texto2 = "Java es divertido. Aprender programación puede ser un reto, pero también muy gratificante.";
        //System.out.println("hay "+ contarPalabrasUnicas(texto) + " unicas");

        analyzeTexts(texto1, texto2);

    }
    public boolean tieneDuplicados(int[] numeros){
        // 1. Crea un nuevo HashSet vacío.
        // Usamos Integer porque HashSet solo puede almacenar objetos, no tipos primitivos directamente.
        Set<Integer> elementosUnicos = new HashSet<>();

        // 2. Itera sobre cada elemento del arreglo.
        for (int elemento : numeros) {
            // 3. Intenta añadir el elemento al Set.
            // El método add() de HashSet retorna 'false' si el elemento ya existe.
            if (!elementosUnicos.add(elemento)) {
                // Si add() retorna false, significa que el elemento ya estaba en el Set,
                // por lo tanto, hemos encontrado un duplicado.
                return true; // Se encontró un duplicado.
            }
        }

        // 4. Si el bucle termina, significa que todos los elementos se añadieron exitosamente
        // al Set, lo que implica que no hay duplicados en el arreglo.
        return false;
    }

    public boolean esISograma(String palabra){
        if (palabra == null || palabra.isEmpty()) {
            return true; // Un string vacío o nulo se puede considerar un isograma
        }

        // 1. Crea un nuevo HashSet para almacenar las letras vistas.
        Set<Character> letrasVistas = new HashSet<>();

        // 2. Normaliza la palabra: convierte a minúsculas y elimina espacios/otros caracteres
        // para considerar solo las letras alfabéticas.
        String palabraNormalizada = palabra.toLowerCase();

        // 3. Itera sobre cada caracter de la palabra normalizada.
        for (char letra : palabraNormalizada.toCharArray()) {
            // Ignoramos caracteres que no son letras (ej. espacios, números, puntuación).
            // Si solo esperas letras, esta comprobación es opcional.
            if (!Character.isLetter(letra)) {
                continue; // Pasa al siguiente caracter si no es una letra
            }

            // 4. Intenta añadir la letra al Set.
            // Si add() retorna 'false', significa que la letra ya estaba, por lo tanto, es un duplicado.
            if (!letrasVistas.add(letra)) {
                return false; // Se encontró una letra duplicada, no es un isograma.
            }
        }

        // 5. Si el bucle termina, significa que todas las letras son únicas.
        return true; // Es un isograma.
    }

    
    public int contarPalabrasUnicas(String frase){
        if (frase == null || frase.trim().isEmpty()) {
            return 0; // Si el texto es nulo o vacío (solo espacios), no hay palabras únicas.
        }

        // 1. Crea un nuevo HashSet para almacenar las palabras únicas.
        Set<String> palabrasUnicas = new HashSet<>();

        // 2. Normaliza el texto: convierte a minúsculas para tratar "Palabra" y "palabra" como iguales.
        String textoNormalizado = frase.toLowerCase();

        // 3. Define un patrón para encontrar palabras.
        // "\\b" representa un límite de palabra.
        // "\\p{L}+" busca una o más letras de cualquier idioma Unicode.
        // Esto ayudará a extraer palabras ignorando puntuación, números, etc.
        Pattern patron = Pattern.compile("\\b\\p{L}+\\b");
        Matcher matcher = patron.matcher(textoNormalizado);

        // 4. Itera a través de las coincidencias (palabras) encontradas por el patrón.
        while (matcher.find()) {
            String palabra = matcher.group(); // Obtiene la palabra encontrada

            // 5. Añade la palabra al Set. HashSet se encarga automáticamente de los duplicados.
            palabrasUnicas.add(palabra);
        }

        // 6. El tamaño del Set es el número total de palabras únicas.
        return palabrasUnicas.size();
    }


    public Set<String> getUniqueWords(String texto) {
        Set<String> uniqueWords = new HashSet<>();
        if (texto == null || texto.trim().isEmpty()) {
            return uniqueWords;
        }

        // Normalizamos el texto a minúsculas.
        String normalizedText = texto.toLowerCase();

        // Dividimos el texto por uno o más espacios en blanco.
        // Esto crea un array de "tokens" que pueden incluir puntuación pegada a las palabras.
        String[] words = normalizedText.split("\\s+"); // \\s+ coincide con uno o más espacios en blanco

        for (String word : words) {
            // Limpiamos cada "palabra" para remover caracteres no alfabéticos al principio y al final.
            // Por ejemplo, "gato." se convierte en "gato".
            // [^\\p{L}] significa "cualquier cosa que NO sea una letra Unicode".
            String cleanedWord = word.replaceAll("[^\\p{L}]", ""); // Reemplaza todo lo que no sea letra con vacío.

            // Aseguramos que la palabra no esté vacía después de la limpieza (ej. si era solo puntuación o espacios)
            if (!cleanedWord.isEmpty()) {
                uniqueWords.add(cleanedWord);
            }
        }
        return uniqueWords;
    }

    public void analyzeTexts(String text1, String text2) {

        // Obtenemos las palabras únicas de cada texto
        Set<String> uniqueWords1 = getUniqueWords(text1);
        Set<String> uniqueWords2 = getUniqueWords(text2);

        System.out.println("\n Palabras Únicas");
        System.out.println("Palabras únicas del Texto 1 (" + uniqueWords1.size() + "): ");
        System.out.println("Palabras únicas del Texto 2 (" + uniqueWords2.size() + "): ");

        // Calculamos las palabras en común (intersección de los Sets)
        // Creamos una copia de uniqueWords1 para no modificar el Set original al calcular la intersección.
        Set<String> commonWords = new HashSet<>(uniqueWords1);
        commonWords.retainAll(uniqueWords2); // retainAll deja solo los elementos presentes en ambos sets.

        System.out.println("\n Palabrasen comun");
        System.out.println("Palabras en común (" + commonWords.size() + "): " + commonWords);

        // Calculamos el porcentaje de coincidencia léxica
        double lexicalMatchPercentage = 0.0;
        int minUniqueWords = Math.min(uniqueWords1.size(), uniqueWords2.size());

        if (minUniqueWords > 0) { // Evitamos división por cero si uno de los textos no tiene palabras.
            lexicalMatchPercentage = ((double) commonWords.size() / minUniqueWords) * 100;
        }

        System.out.println("\n Coincidencia Léxica");
        System.out.printf("Porcentaje de coincidencia léxica: %.2f%%\n", lexicalMatchPercentage);

        // Mostramos las palabras que son únicas para cada texto (diferencia de sets)
        // Necesitamos crear copias para no alterar los sets originales uniqueWords1 y uniqueWords2
        // al usar removeAll.
        Set<String> wordsOnlyInText1 = new HashSet<>(uniqueWords1);
        wordsOnlyInText1.removeAll(commonWords);

        Set<String> wordsOnlyInText2 = new HashSet<>(uniqueWords2);
        wordsOnlyInText2.removeAll(commonWords);

        System.out.println("\n--- Vocabulario Exclusivo ---");
        System.out.println("Palabras que solo aparecen en Texto 1: " + wordsOnlyInText1);
        System.out.println("Palabras que solo aparecen en Texto 2: " + wordsOnlyInText2);
        System.out.println("--- Fin del Análisis ---");
    }

}
