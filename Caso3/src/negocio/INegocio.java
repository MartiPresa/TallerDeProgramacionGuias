package negocio;

import exceptions.LegajoInvalidoException;

public interface INegocio {

    void pedirCertificado(int legajo) throws LegajoInvalidoException;
    String traerApellidoyNombre();
    String traerEstado(String materia);
    String traerNota(String materia);
    String traerCondicion();
}
