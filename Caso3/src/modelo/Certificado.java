package modelo;

public class Certificado implements ICertificado {

    private int legajo;  //numero entero de 4 cifras
    private String nombre;
    private String apellido;

    private Materia historia;
    private Materia matematica;
    private Materia literatura;
    private Materia fisica;

    private String condicion;


    @Override
    public void pedirCertificado(int legajo) {

    }

    @Override
    public String traerApellidoyNombre() {
        return null;
    }

    @Override
    public String traerEstado(String materia) {
        return null;
    }

    @Override
    public String traerNota(String materia) {
        return null;
    }

    @Override
    public String traerCondicion() {
        return null;
    }
}
