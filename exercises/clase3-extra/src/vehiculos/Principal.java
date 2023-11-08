package vehiculos;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

	static List<Vehiculo> vehiculos = new ArrayList<>();
	
	public static void cargarVehiculos() {
		vehiculos.add(new Vehiculo("1111AAA", Marca.RENAULT, 10000));
		vehiculos.add(new Vehiculo("2222BBB", Marca.FIAT, 20000));
		vehiculos.add(new Vehiculo("3333CCC", Marca.FORD, 30000));
		vehiculos.add(new Vehiculo("4444DDD", Marca.VOLKSWAGEN, 100000));
		vehiculos.add(new Vehiculo("5555EEE", Marca.FIAT, 200000));
		vehiculos.add(new Vehiculo("6666FFF", Marca.FORD, 300000));
		vehiculos.add(new Vehiculo("7777GGG", Marca.CITROEN, 0));
	}
	
	public static void main(String[] args) {
		cargarVehiculos();
		//System.out.println(showAllKm(vehiculos)); // 1
		//System.out.println(getAllByMarca(vehiculos, Marca.FIAT)); // 2
		//System.out.println(existAnyModel(vehiculos, Marca.FIAT)); // 3
		//System.out.println(getAllSortedByKm(vehiculos)); // 4
		//System.out.println(getAllExistingModels(vehiculos)); // 5
		//System.out.println(mapToModel(vehiculos)); // 6
		//System.out.println(getSumAllKm(vehiculos)); // 7
		//System.out.println(getVehicleWithLessKm(vehiculos)); // 8
		//System.out.println(getVehicleWithMaxKm(vehiculos)); // 9
	}

	// dada una lista de vehiculos retornar una lista con los km de c/ vehiculo
	public static List<Integer> showAllKm(List<Vehiculo> vehicleList){
		return vehicleList.stream()
				.map(Vehiculo::getKilometros)
				.collect(Collectors.toList());
	}

	//dada una lista de vehiculos y una marca, retornar una lista de aquellos
	//vehiculos que sean de esa marca
	public static List<Vehiculo> getAllByMarca(List<Vehiculo> vehicleList, Marca marcaParam){
		return vehicleList.stream()
				.filter((v) -> v.getMarca().equals(marcaParam))
				.collect(Collectors.toList());
	}

	//dado una lista de vehiculos y una marca, retorna si hay en la lista algun
	//vehiculo de esa marca
	public static boolean existAnyModel(List<Vehiculo> vehicleList, Marca marcaParam){
		return vehicleList.stream()
				.anyMatch((v) -> v.getMarca().equals(marcaParam));
	}

	//dada una lista de vehiculos devolver una lista de vehiculos ordena por km
	public static List<Vehiculo> getAllSortedByKm(List<Vehiculo> vehicleList){
		return vehicleList.stream()
				.sorted((v1, v2) -> Integer.compare(v1.getKilometros(), v2.getKilometros()))
				.collect(Collectors.toList());
	}

	//dada una lista de vehiculos retornar una lista de las distintas marcas
	//presentes, sin repetir
	public static List<Marca> getAllExistingModels(List<Vehiculo> vehicleList){
		return vehicleList.stream()
				.map(Vehiculo::getMarca)
				.distinct().collect(Collectors.toList());
	}

	//dada una lista de vehiculos retornar una Map cuya clave sea la marca y el
	//valor sea una coleccion de vehiculos de esa marca
	public static Map<Marca, List<Vehiculo>> mapToModel(List<Vehiculo> vehicleList){
		return vehicleList.stream()
				.collect(Collectors.groupingBy(Vehiculo::getMarca));
	}

	//dada una lista de vehiculos retornar la suma de km entre todos ellos
	public static Integer getSumAllKm(List<Vehiculo> vehicleList){
		return vehicleList.stream()
				.mapToInt(Vehiculo::getKilometros)
				.sum();
	}
	//dada una coleccion de vehiculos retorna aquel con menor cant de km
	public static Vehiculo getVehicleWithLessKm(List<Vehiculo> vehicleList){
		return vehicleList.stream()
				.min((v1, v2) -> Integer.compare(v1.getKilometros(), v2.getKilometros()))
				.orElseThrow(NoSuchElementException::new);
	}
	//dada una coleccion de vehiculos retorna aquel con mayor cant de km
	public static Vehiculo getVehicleWithMaxKm(List<Vehiculo> vehicleList){
		return vehicleList.stream()
				.max((v1, v2) -> Integer.compare(v1.getKilometros(), v2.getKilometros()))
				.orElseThrow(NoSuchElementException::new);
	}
}
