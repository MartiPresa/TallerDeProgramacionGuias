package negocio;

import exceptions.LegajoInvalidoException;
import modelo.Certificado;

public class Negocio implements INegocio{

    private Certificado certificado;

    @Override
    public void pedirCertificado(int legajo) throws LegajoInvalidoException {
        this.certificado.pedirCertificado(legajo);
    }

    @Override
    public String traerApellidoyNombre() {
        String aux = null;
        try {
            aux = this.certificado.traerApellidoyNombre();
        } catch (LegajoInvalidoException e) {
            System.out.println(e.getMessage());
        }
        return aux;
    }

    @Override
    public String traerEstado(String materia) {
        String aux = null;
        try {
            aux = this.certificado.traerEstado(materia);
        } catch (LegajoInvalidoException e) {
            System.out.println(e.getMessage());
        }
        return aux;
    }

    @Override
    public String traerNota(String materia) {
        String aux = null;

        try {
            aux = this.certificado.traerNota(materia);
        } catch (LegajoInvalidoException e) {
            throw new RuntimeException(e);
        }
        return aux;

    }

    @Override
    public String traerCondicion() {
        String aux = null;

        try {
            aux = this.certificado.traerCondicion();
        } catch (LegajoInvalidoException e) {
            throw new RuntimeException(e);
        }
        return aux;
    }
}
