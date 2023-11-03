package ValidadorMaterias;
import java.util.*;

public class Materia {
    private int id;
    private ListaMaterias nombre;
    private final List<Materia> correlativas;
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

    /**
     * Agrego una materia correlativa a la instancia actual
     * @param materia materia a agregar
     * @return *true* si la materia no está ya incluida, de lo contrario *false*
     */
    public Boolean setCorrelativa(Materia materia){
        if (!Materia.estaIncluida(materia, this.correlativas)){
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

    /**
     * Verifica si el nombre de una materia se encuentra en una lista
     * @param m materia a comparar
     * @param listaMateriasAprobadas lista a comparar
     * @return *true* si encuentra una coincidencia de nombres, de lo contrario *false*
     */
    public static Boolean estaIncluida(Materia m, List<Materia> listaMateriasAprobadas){
        for (Materia mat : listaMateriasAprobadas){
            if (m.getNombre().equals(mat.getNombre())){
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica si todas las materias en la lista de correlativas de la instancia
     * actual tienen su atributo 'aprobada' en *true*
     * @return *true* si se cumple la condición, de lo contrario *false*
     */
    public boolean verificarCorrelativas(){
        boolean todasAprobadas = true;
        for (Materia mat : this.getCorrelativas()){
            if (!mat.getAprobada()){
                todasAprobadas = false;
                break;
            }
        }
        return todasAprobadas;
    }
}
