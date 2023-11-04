package transformador;
import java.util.*;

public class Transformador {
    public static List<String> aMayusculas(List<String> listaDeStrings, IConverter converter) {
        try {
            List<String> newConvertedArray = new ArrayList<>(listaDeStrings);
            newConvertedArray.replaceAll(converter::convert);
            return newConvertedArray;
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e);
            return new ArrayList<>();
        }
    }

    public static List<Integer> sumador(List<Integer> lista, IOperador operator){
        try{
            List<Integer> newConvertedArray = new ArrayList<>(lista);
            newConvertedArray.replaceAll((num) -> operator.operar(num, 3));
            return newConvertedArray;
        }   catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e);
            return new ArrayList<>();
        }
    }

    public static String mostrarValoresArray(List<?> lista, IConverter converter){
        try{
            StringBuilder sB = new StringBuilder();
            lista.forEach((s) -> {
                sB.append(converter.convert(s.toString()));
            });
            return sB.toString();
        }catch (Exception e){
            return "Ha ocurrido un error: " + e;
        }
    }
}
