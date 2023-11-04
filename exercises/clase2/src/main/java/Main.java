import transformador.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
        System.out.println("Ejercicio de clase N°2: Interfaces funcionales y Expresiones lambda.\n");

        /*
            Implemento una funcionalidad para mi interfaz, invoco al método de
            String que convierte una cadena de caracteres en mayúsculas

            Declaré 2 maneras de hacerlas, aunque la segunda es la mejor opción
         */
        IConverter convertToUpperCase = (s) -> s.toUpperCase();
        IConverter convertToUpperCase2 = String::toUpperCase;

        // Declaro una lista de Strings a transformar
        List<String> lista = Arrays.asList("esta", "sera", "mi lista", "a transformar");

        /*
            Utilizo el método estático de mi clase invocando a mi lista e interfaz
            y lo guardo en una nueva lista.
         */
        List<String> listaConvertida = Transformador.aMayusculas(lista, convertToUpperCase);

        /*
            Muestro ambos arrays con sus respectivos valores utilizando una nueva
            implementación de mi interfaz
         */
        IConverter richTextToShow = (value) -> "- " + value + "\n";

        System.out.println("Array original: ");
        System.out.println(Transformador.mostrarValoresArray(lista, richTextToShow));

        System.out.println("Array transformada: ");
        System.out.println(Transformador.mostrarValoresArray(listaConvertida, richTextToShow));

        System.out.println("\nEjercicio adicional clase 2:\n");

        // Implemento la funcionalidad de mi interfaz
        IOperador suma = Integer::sum;
        IOperador suma2 = (a, b) -> a + b;

        // Declaro una lista de numeros al azar
        List<Integer> listaNumerica = Arrays.asList(10, 22, 70, 41, 22);

        // Declaro una nueva lista pero habiéndo sumado +3 a cada valor del array original
        List<Integer> listaNumericaSumada = Transformador.sumador(listaNumerica, suma);

        // Muestro ambas listas
        System.out.println("Array numérica original: ");
        System.out.println(Transformador.mostrarValoresArray(listaNumerica, richTextToShow));

        System.out.println("Array numérica sumada:");
        System.out.println(Transformador.mostrarValoresArray(listaNumericaSumada, richTextToShow));
    }
}
