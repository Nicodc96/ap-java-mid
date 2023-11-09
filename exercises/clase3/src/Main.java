import java.util.Arrays;
import java.util.List;

import colecciones.*;

public class Main {
    public static void main (String[] args){
        System.out.println("Ejercicio de clase N°3:\n");

        System.out.println("--- Ejercicio 1 ---");
        System.out.println("Declaro una lista de strings a convertir:");
        List<String> listaDeStrings = Arrays.asList("clase", "numero", "tres", "java", "intermedio");

        System.out.println(listaDeStrings);

        System.out.println("\nInvoco a mi método que convierte una lista de strings a otra en mayúsculas y muestro:");
        System.out.println(Aplanacion.listToUpperCase(listaDeStrings));

        System.out.println("\n--- Ejercicio 2 ---");
        System.out.println("Declaro una nueva lista de strings para aplicar mi método: ");
        List<String> listaDeStrings2 = Arrays.asList("segundo", "ejercicio", "de", "clase", "tres");

        System.out.println(listaDeStrings2);

        System.out.println("\nInvoco a mi método que concatena una lista de strings según la cantidad de caracteres y separados por coma");
        System.out.println("En primer lugar llamaré a todas esas strings que contengan más de 5 caracteres:");
        System.out.println(Aplanacion.listJoin(listaDeStrings2, 5));

        System.out.println("\nAhora los que tengan más de 7:");
        System.out.println(Aplanacion.listJoin(listaDeStrings2, 7));

        System.out.println("\nFinalmente los que tengan más de 3:");
        System.out.println(Aplanacion.listJoin(listaDeStrings2, 3));
    }
}
