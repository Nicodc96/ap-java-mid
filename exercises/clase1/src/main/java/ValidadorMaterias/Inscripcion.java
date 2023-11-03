package ValidadorMaterias;

public class Inscripcion {
    private final Materia materia;
    private final boolean estadoAprobacion;
    private final boolean puedeCursar;

    public Inscripcion(Materia materia, Alumno alumno){
        super();
        this.materia = materia;
        this.estadoAprobacion = this.materia.getAprobada();
        this.puedeCursar = !Materia.estaIncluida(this.materia, alumno.getListaMaterias()) && this.materia.verificarCorrelativas();
    }

    /**
     * Verifica si la materia a inscribirse se ha aprobado o no
     * @return *true* Si la materia inscrita se ha aprobado, de lo contrario *false*
     */
    public Boolean aprobada(){
        return this.estadoAprobacion;
    }

    /**
     * Devuelve un mensaje customizado respondiendo si un objeto Alumno puede o no
     * cursar la Materia solicitada y responde con 'Puede' o 'No puede'. En el caso de
     * no poder, enumera las Materias a regularizar antes de poder inscribirse.
     * @return Un string con el mensaje correspondiente
     */
    public String puedeCursar(){
        StringBuilder sB = new StringBuilder();
        sB.append(this.puedeCursar ? "Puede Cursar" : "No puede cursar");
        if (!this.puedeCursar){
            sB.append("\nDebe regularizar: ");
            for(Materia mat : this.materia.getCorrelativas()){
                if (!mat.getAprobada()){
                    sB.append("\n- ").append(mat.getNombre());
                }
            }
        }
        return sB.toString();
    }
}
