package modelo;

import java.util.ArrayList;

public class Alumno {

    private int legajo;     //numero entero de 4 cifras
    private String nombre;
    private String apellido;
    private Materia historia;
    private Materia matematica;
    private Materia literatura;
    private Materia fisica;
    //private ArrayList<Materia> materias = new ArrayList<Materia>();


    public int getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Materia getHistoria() {
        return historia;
    }

    public Materia getMatematica() {
        return matematica;
    }

    public Materia getLiteratura() {
        return literatura;
    }

    public Materia getFisica() {
        return fisica;
    }
}
