package modelo;

import exceptions.LegajoInvalidoException;

import java.util.HashMap;

public class Certificado implements ICertificado {

    private int legajo;  //numero entero de 4 cifras
    private String nombre;
    private String apellido;

    private HashMap<String,Materia> materias = new HashMap<>();
//    private Materia historia;
//    private Materia matematica;
//    private Materia literatura;
//    private Materia fisica;

    private String condicion;

    public Certificado(int legajo, String nombre, String apellido, Materia historia,Materia matematica,Materia literatura, Materia fisica) {

        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.materias.put(historia.getNombre(),historia);
        this.materias.put(matematica.getNombre(), matematica);
        this.materias.put(literatura.getNombre(),literatura);
        this.materias.put(fisica.getNombre(),fisica);

        this.verificaCondicion();
    }

    public void verificaCondicion(){
    int aux = 0;

        if(this.materias.get("historia").getEstado() == "A cursar")
            aux++;
        if(this.materias.get("matematica").getEstado() == "A cursar")
            aux++;
        if(this.materias.get("literatura").getEstado() == "A cursar")
            aux++;
        if(this.materias.get("fisica").getEstado() == "A cursar")
            aux++;
        if(aux >= 2)
            this.condicion = "Regular";
        else
            this.condicion = "Irregular";
    }
    @Override
    public void pedirCertificado(int legajo) throws LegajoInvalidoException {

        if(Escuela.getInstance().getAlumnos().containsKey(this.legajo) == false)
            throw new LegajoInvalidoException("El legajo "+this.legajo+" no se encuentra en la base de alumnos",this.legajo);
        else{
            Alumno alumno = Escuela.getInstance().getAlumnos().get(legajo);
            this.legajo = alumno.getLegajo();
            this.nombre = alumno.getNombre();
            this.apellido = alumno.getApellido();

            this.materias.clear();
            this.materias.put(alumno.getHistoria().getNombre(),alumno.getHistoria());
            this.materias.put(alumno.getMatematica().getNombre(),alumno.getMatematica());
            this.materias.put(alumno.getLiteratura().getNombre(),alumno.getLiteratura());
            this.materias.put(alumno.getFisica().getNombre(),alumno.getFisica());

            this.verificaCondicion();
        }
    }

    @Override
    public String traerApellidoyNombre() throws LegajoInvalidoException {

//        if(Escuela.getInstance().getAlumnos().containsKey(this.legajo) == true)
//            return this.apellido+this.nombre;
//        else
//            throw new LegajoInvalidoException("El legajo",this.legajo);

        if(Escuela.getInstance().getAlumnos().containsKey(this.legajo) == false)
            throw new LegajoInvalidoException("El legajo "+this.legajo+" no se encuentra en la base de alumnos",this.legajo);
        else
            return this.apellido+this.nombre;
    }

    @Override
    public String traerEstado(String materia) throws LegajoInvalidoException {

        if(Escuela.getInstance().getAlumnos().containsKey(this.legajo) == false)
            throw new LegajoInvalidoException("El legajo "+this.legajo+" no se encuentra en la base de alumnos",this.legajo);
        else
            return this.materias.get(materia).getEstado();
    }

    @Override
    public String traerNota(String materia) throws LegajoInvalidoException {

        if(Escuela.getInstance().getAlumnos().containsKey(this.legajo) == false)
            throw new LegajoInvalidoException("El legajo "+this.legajo+" no se encuentra en la base de alumnos",this.legajo);
        else
            return this.materias.get(materia).getNota();
    }

    @Override
    public String traerCondicion() throws LegajoInvalidoException {

        if(Escuela.getInstance().getAlumnos().containsKey(this.legajo) == false)
            throw new LegajoInvalidoException("El legajo "+this.legajo+" no se encuentra en la base de alumnos",this.legajo);
        else
            return this.condicion;
    }
}
