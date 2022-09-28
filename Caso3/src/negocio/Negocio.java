package negocio;

import Vista.IVista;
import exceptions.LegajoInvalidoException;
import modelo.Certificado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Negocio implements INegocio, ActionListener {

    private Certificado certificado;
    private IVista ventana;

    private String error;
    @Override
    public void pedirCertificado(int legajo) throws LegajoInvalidoException {
        this.certificado.pedirCertificado(legajo);
        this.error = "No hubo errores";
    }

    @Override
    public String traerApellidoyNombre() {
        String aux = null;
        try {
            aux = this.certificado.traerApellidoyNombre();
        } catch (LegajoInvalidoException e) {
            System.out.println(e.getMessage());
            this.error = e.getMessage();
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
            this.error = e.getMessage();
        }
        return aux;
    }

    @Override
    public String traerNota(String materia) {
        String aux = null;

        try {
            aux = this.certificado.traerNota(materia);
        } catch (LegajoInvalidoException e) {
            //throw new RuntimeException(e);
            this.error = e.getMessage();
        }
        return aux;

    }

    @Override
    public String traerCondicion() {
        String aux = null;

        try {
            aux = this.certificado.traerCondicion();
        } catch (LegajoInvalidoException e) {
            //throw new RuntimeException(e);
            this.error = e.getMessage();
        }
        return aux;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "Pedir Certificado" -> {
                try {
                    this.pedirCertificado(this.ventana.pedirCertificado());
                } catch (LegajoInvalidoException ex) {
                    throw new RuntimeException(ex);
                }
            }
            case "Mostrar Estado" -> this.ventana.mostrarEstado(this.error);
            case "Mostrar Certificado" -> this.ventana.mostrarCertificado();
        }
    }
}
