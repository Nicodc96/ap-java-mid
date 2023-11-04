package ValidadorMaterias;

public class Inscripcion {
    private final Materia materia;
    private final boolean puedeCursar;

    public Inscripcion(Materia materia, Alumno alumno){
        super();
        this.materia = materia;
        this.puedeCursar = !Materia.estaIncluida(this.materia, alumno.getListaMaterias()) && this.materia.verificarCorrelativas();
    }

    /**
     * Verifica si se ha aprobado la inscripción a la materia
     * @return *true* Si se cumple las condiciones, de lo contrario *false*
     */
    public boolean aprobada(){
        return this.puedeCursar;
    }

    /**
     * Devuelve un mensaje customizado respondiendo si un objeto Alumno puede o no
     * cursar la Materia solicitada y responde con 'Puede' o 'No puede'. En el caso de
     * no poder, enumera las Materias a regularizar antes de poder inscribirse.
     * @return Un string con el mensaje correspondiente
     */
    public String puedeCursar(){
        StringBuilder sB = new StringBuilder();
        sB.append(this.aprobada() ? "Puede Cursar" : "No puede cursar");
        if (!this.aprobada()){
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
