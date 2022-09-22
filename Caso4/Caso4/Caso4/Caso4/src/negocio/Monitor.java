package negocio;

import excepciones.CalculoImposibleException;
import excepciones.ParametroException;
import modelo.Calcular;
import vista.IVista;
import vista.Ventana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Monitor implements ActionListener {

    private Calcular modelo;
    private IVista ventana;

    private String error;
    public Monitor(IVista ventana){
        this.ventana = ventana;
        this.error = "No hay errores.";
    }

    public void calcular(int op1, int op2, String Operacion)
    {
        try {
            this.modelo.calcular(op1,op2,Operacion);
        } catch (ParametroException e) {
            this.error = e.getMessage();
        } catch (CalculoImposibleException e) {
            this.error = e.getMessage();
        }
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */

    @Override
    public void actionPerformed(ActionEvent e) {

        Ventana ventana = (Ventana) this.ventana;
        System.out.println("ActionPerformed");
        switch (e.getActionCommand()) {
            case "Calcular" -> this.calcular(Integer.valueOf(ventana.getTextFieldOp2().getText()),Integer.valueOf(ventana.getTextFieldOp2().getText()),ventana.getTextFieldOperacion().getText());
            case "mostrarEstado"-> JOptionPane.showMessageDialog(null,this.error);
            case "mostrarResultado" ->JOptionPane.showMessageDialog(null,"El resultado es: "+this.modelo.traerResultado());
        }
    }



}
