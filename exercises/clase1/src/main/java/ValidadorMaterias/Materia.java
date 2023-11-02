package ValidadorMaterias;
import java.util.*;

public class Materia {
    private int id;
    private ListaMaterias nombre;
    private List<Materia> correlativas;
    private Boolean aprobada = false;

    public int getId(){
        return this.id;
    }

    public String getNombre(){
        return this.nombre.toString();
    }

    public List<Materia> getCorrelativas(){
        return this.correlativas;
    }

    public Boolean getAprobada(){
        return this.aprobada;
    }

    public void setAprobada(Boolean value){
        this.aprobada = value;
    }

    public Boolean setCorrelativa(Materia materia){
        if (!this.correlativas.contains(materia)){
            return this.correlativas.add(materia);
        } else return false;
    }

    public Materia(){
        this.correlativas = new ArrayList<Materia>();
    }

    public Materia(int id, ListaMaterias nombreMateria){
        this();
        this.id = id;
        this.nombre = nombreMateria;
    }

    public static Boolean estaIncluida(Materia m, List<Materia> listaMateriasAprobadas){
        for (Materia mat : listaMateriasAprobadas){
            if (m.getNombre().equals(mat.getNombre())){
                return true;
            }
        }
        return false;
    }

    public boolean verificarCorrelativas(){
        boolean todasAprobadas = false;
        if (this.getCorrelativas() != null){
            todasAprobadas = true;
            for (Materia mat : this.getCorrelativas()){
                if (!mat.getAprobada()){
                    todasAprobadas = false;
                    break;
                }
            }
        }
        return todasAprobadas;
    }
}
