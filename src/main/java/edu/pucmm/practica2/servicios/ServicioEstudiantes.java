package edu.pucmm.practica2.servicios;

import edu.pucmm.practica2.encapsulacion.Estudiante;

import java.util.ArrayList;

public class ServicioEstudiantes {
    private static ServicioEstudiantes servicioEstudiantes;
    private ArrayList<Estudiante> misEstudiantes = new ArrayList<Estudiante>();

    public static ServicioEstudiantes getInstance(){
        if(servicioEstudiantes == null){
            servicioEstudiantes = new ServicioEstudiantes();
        }
        return servicioEstudiantes;
    }

    public String crearEstudiante(String matricula, String nombre, String apellido, String telefono){
        Estudiante estudiante = new Estudiante(matricula, nombre, apellido, telefono);
        String result = "error";
        if(!buscarMatricula(matricula)){ // Si no existe la misma matricula
            misEstudiantes.add(estudiante);
            result = "success";
        }
        return result;
    }

    public Estudiante buscarEstudiante(String matricula){
        Estudiante miEstudiante = null;
        for (Estudiante estudiante: misEstudiantes) {
            if(estudiante.getMatricula().equalsIgnoreCase(matricula))
                miEstudiante = estudiante;
        }
        return miEstudiante;
    }

    public void modificarEstudiante(String matricula, String nombre, String apellido, String telefono){
        int index = 0, studentPosition = 0;
        for (Estudiante estudiante: misEstudiantes) {
            if(estudiante.getMatricula().equalsIgnoreCase(matricula))
                studentPosition = index;
            index++;
        }
        misEstudiantes.get(studentPosition).setNombre(nombre);
        misEstudiantes.get(studentPosition).setApellido(apellido);
        misEstudiantes.get(studentPosition).setTelefono(telefono);
    }

    private boolean buscarMatricula(String matricula){
        boolean found = false;
        for (Estudiante estudiante: misEstudiantes) {
            if(estudiante.getMatricula().equalsIgnoreCase(matricula))
                found = true;
        }
        return found;
    }

    public ArrayList<Estudiante> getMisEstudiantes() {
        return misEstudiantes;
    }

    public void setMisEstudiantes(ArrayList<Estudiante> misEstudiantes) {
        this.misEstudiantes = misEstudiantes;
    }
}
