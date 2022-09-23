package modelo;

import java.util.HashMap;

public class Escuela {

    private static Escuela instance = null;
    //coleccion alumnos
    private HashMap<Integer,Alumno> alumnos = new HashMap<>();


    public static Escuela getInstance(){
        if( Escuela.instance == null)
            Escuela.instance = new Escuela();
        return Escuela.instance;
    }

    public void agregaAlumno(Alumno alumno){
        this.alumnos.put(alumno.getLegajo(),alumno);
    }

    public void sacaAlumno(Alumno alumno){
        this.alumnos.remove(alumno.getLegajo());
    }

    public void sacaAlumno(int legajo){
        this.alumnos.remove(legajo);
    }

    public HashMap<Integer, Alumno> getAlumnos() {
        return alumnos;
    }
}
