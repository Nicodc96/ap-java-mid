package ValidadorMaterias;
import java.util.*;

public class Alumno {
    private int legajo;
    private String nombre;
    private String DNI;
    private List<Materia> listaMateriasAprobadas;

    public int getLegajo(){
        return this.legajo;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getDNI(){
        return this.DNI;
    }

    public List<Materia> getListaMaterias(){
        return this.listaMateriasAprobadas;
    }

    public boolean agregarMateriaAprobada(Materia materia){
        if (!this.listaMateriasAprobadas.contains(materia)){
            return this.listaMateriasAprobadas.add(materia);
        } else return false;
    }

    public Alumno(){
        this.listaMateriasAprobadas = new ArrayList<Materia>();
    }
    public Alumno(int legajo, String nombre, String dni){
        this();
        this.legajo = legajo;
        this.nombre = nombre;
        this.DNI = dni;
    }
}
