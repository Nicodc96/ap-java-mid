package colecciones;

import java.util.List;
import java.util.stream.Collectors;

public class Aplanacion {
    public static List<String> listToUpperCase(List<String> list){
        return list.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    public static String listJoin(List<String> list) {
        return listJoin(list, 0);
    }
    public static String listJoin(List<String> list, int quantity){
        return list.stream().filter((s) -> s.length() > quantity).collect(Collectors.joining(","));
    }
}
