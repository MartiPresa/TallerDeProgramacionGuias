package modelo;

public interface ICertificado {

    void pedirCertificado(int legajo);
    String traerApellidoyNombre();
    String traerEstado(String materia);
    String traerNota(String materia);
    String traerCondicion();
}
