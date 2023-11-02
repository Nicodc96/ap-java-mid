package main;
import ValidadorMaterias.*;

public class Main {
    public static void main(String[] args) {
        // Instancio algunas materias
        Materia programacion_1 = new Materia(1, ListaMaterias.PROGRAMACION_I);
        Materia programacion_2 = new Materia(2, ListaMaterias.PROGRAMACION_II);
        Materia programacion_3 = new Materia(3, ListaMaterias.PROGRAMACION_III);
        Materia laboratorio_1 = new Materia(4, ListaMaterias.LABORATORIO_I);
        Materia laboratorio_2 = new Materia(5, ListaMaterias.LABORATORIO_II);
        Materia laboratorio_3 = new Materia(6, ListaMaterias.LABORATORIO_III);
        Materia laboratorio_4 = new Materia(7, ListaMaterias.LABORATORIO_IV);
        Materia bases_de_datos = new Materia(8, ListaMaterias.BASES_DE_DATOS);
        Materia metodologia_computacion = new Materia(9, ListaMaterias.METODOLOGIA_DE_COMPUTACION);
        Materia matematica_1 = new Materia(10, ListaMaterias.MATEMATICA_I);
        Materia matematica_2 = new Materia(11, ListaMaterias.MATEMATICA_II);
        Materia estadistica = new Materia(12, ListaMaterias.ESTADISTICA);
        Materia inv_operativa = new Materia(13, ListaMaterias.INVESTIGACION_OPERATIVA);

        // Asocio las materias con sus respectivas correlativas
        programacion_2.setCorrelativa(programacion_1);
        programacion_2.setCorrelativa(laboratorio_1);

        laboratorio_2.setCorrelativa(programacion_1);
        laboratorio_2.setCorrelativa(laboratorio_1);

        programacion_3.setCorrelativa(programacion_1);
        programacion_3.setCorrelativa(programacion_2);
        programacion_3.setCorrelativa(laboratorio_1);
        programacion_3.setCorrelativa(laboratorio_2);

        laboratorio_3.setCorrelativa(programacion_1);
        laboratorio_3.setCorrelativa(programacion_2);
        laboratorio_3.setCorrelativa(laboratorio_1);
        laboratorio_3.setCorrelativa(laboratorio_2);

        laboratorio_4.setCorrelativa(programacion_1);
        laboratorio_4.setCorrelativa(programacion_2);
        laboratorio_4.setCorrelativa(programacion_3);
        laboratorio_4.setCorrelativa(laboratorio_1);
        laboratorio_4.setCorrelativa(laboratorio_2);
        laboratorio_4.setCorrelativa(laboratorio_3);

        bases_de_datos.setCorrelativa(programacion_1);
        bases_de_datos.setCorrelativa(programacion_2);
        bases_de_datos.setCorrelativa(programacion_3);
        bases_de_datos.setCorrelativa(laboratorio_1);
        bases_de_datos.setCorrelativa(laboratorio_2);
        bases_de_datos.setCorrelativa(laboratorio_3);

        metodologia_computacion.setCorrelativa(programacion_1);
        metodologia_computacion.setCorrelativa(programacion_2);
        metodologia_computacion.setCorrelativa(programacion_3);
        metodologia_computacion.setCorrelativa(laboratorio_1);
        metodologia_computacion.setCorrelativa(laboratorio_2);
        metodologia_computacion.setCorrelativa(laboratorio_3);
        metodologia_computacion.setCorrelativa(matematica_1);
        metodologia_computacion.setCorrelativa(matematica_2);
        metodologia_computacion.setCorrelativa(estadistica);
        metodologia_computacion.setCorrelativa(inv_operativa);

        matematica_2.setCorrelativa(matematica_1);

        estadistica.setCorrelativa(matematica_1);
        estadistica.setCorrelativa(matematica_2);

        inv_operativa.setCorrelativa(matematica_1);
        inv_operativa.setCorrelativa(matematica_2);
        inv_operativa.setCorrelativa(estadistica);

        /*
        *   En este ejemplo voy a hacer que el alumno haya aprobado:
        *   - Programacion I, II y III
        *   - Laboratorio I y II
        *   - Matematica I y II
        * */

        programacion_1.setAprobada(true);
        programacion_2.setAprobada(true);
        programacion_3.setAprobada(true);
        laboratorio_1.setAprobada(true);
        laboratorio_2.setAprobada(true);
        matematica_1.setAprobada(true);
        matematica_2.setAprobada(true);

        // Nota: Las materias que no utilicé el método setAprobada() están no aprobadas por defecto

        // Alumno de ejemplo
        Alumno alumnoNicolas = new Alumno(1, "Nicolás", "39468894");

        // Asocio las materias aprobadas al alumno
        alumnoNicolas.agregarMateriaAprobada(programacion_1);
        alumnoNicolas.agregarMateriaAprobada(programacion_2);
        alumnoNicolas.agregarMateriaAprobada(programacion_3);
        alumnoNicolas.agregarMateriaAprobada(laboratorio_1);
        alumnoNicolas.agregarMateriaAprobada(laboratorio_2);
        alumnoNicolas.agregarMateriaAprobada(matematica_1);
        alumnoNicolas.agregarMateriaAprobada(matematica_2);

        // Muestro la lista de materias aprobadas del alumno
        System.out.println("Lista de materias aprobadas del Alumno " + alumnoNicolas.getNombre() + ":");
        for (Materia mat: alumnoNicolas.getListaMaterias()){
            System.out.println(mat.getNombre());
        }

        /* Verifico si puede cursar, sólo puede cursar si la materia no la ha aprobado ya
         * y si tiene todas sus correlativas aprobadas */

        // Intento registrarme a una materia que NO puedo inscribirme

        Inscripcion inscripcionAMetodologia = new Inscripcion(metodologia_computacion, alumnoNicolas);

        System.out.println("\n¿Puede el alumno " + alumnoNicolas.getNombre() +
                " cursar " + metodologia_computacion.getNombre() + "?: "
                + inscripcionAMetodologia.puedeCursar());

        // Me registro a una materia que SI puede inscribirse (no tiene correlativas desaprobadas)

        Inscripcion inscripcionALaboratorio3 = new Inscripcion(laboratorio_3, alumnoNicolas);

        System.out.println("\n¿Puede el alumno " + alumnoNicolas.getNombre() +
                " cursar " + laboratorio_3.getNombre() + "?: "
                + inscripcionALaboratorio3.puedeCursar());

        // Intento registrarme a otra materia que NO puedo inscribirme

        Inscripcion inscripcionAOperativa = new Inscripcion(inv_operativa, alumnoNicolas);

        System.out.println("\n¿Puede el alumno " + alumnoNicolas.getNombre() +
                " cursar " + inv_operativa.getNombre() + "?: "
                + inscripcionAOperativa.puedeCursar());
    }
}