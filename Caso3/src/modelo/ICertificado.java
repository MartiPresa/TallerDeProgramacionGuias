package modelo;

import exceptions.LegajoInvalidoException;

public interface ICertificado {

    void pedirCertificado(int legajo) throws LegajoInvalidoException;
    String traerApellidoyNombre() throws LegajoInvalidoException;
    String traerEstado(String materia) throws LegajoInvalidoException;
    String traerNota(String materia) throws LegajoInvalidoException;
    String traerCondicion() throws LegajoInvalidoException;
}
