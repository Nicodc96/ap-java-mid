package ValidadorMaterias;

public class Inscripcion {
    private Materia materia;
    private Alumno alumno;
    private final boolean estadoAprobacion;
    private final boolean puedeCursar;

    public Inscripcion(Materia materia, Alumno alumno){
        super();
        this.materia = materia;
        this.alumno = alumno;
        this.estadoAprobacion = this.materia.getAprobada();
        this.puedeCursar = !Materia.estaIncluida(this.materia, this.alumno.getListaMaterias()) && this.materia.verificarCorrelativas();
    }

    public Boolean aprobada(){
        return this.estadoAprobacion;
    }

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
