package Vista;

import modelo.Certificado;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements IVista {
    private JTextField textField1;
    private JButton pedirCertificadoButton;
    private JButton mostrarEstadoButton;
    private JButton mostrarCertificadoButton;
    private JPanel panelPrincipal;

    //private ActionListener actionListener;

    public Ventana(ActionListener actionListener){
        //this.actionListener = actionListener;

        this.setTitle("Calculadora");
        this.setContentPane(this.panelPrincipal);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pedirCertificadoButton.setActionCommand("Pedir Certificado");
        this.mostrarEstadoButton.setActionCommand("Mostrar Estado");
        this.mostrarCertificadoButton.setActionCommand("Mostrar Certificado");

//        this.pedirCertificadoButton.addActionListener(this.actionListener);
//        this.mostrarEstadoButton.addActionListener(this.actionListener);
//        this.mostrarCertificadoButton.addActionListener(this.actionListener);

        this.pedirCertificadoButton.addActionListener(actionListener);
        this.mostrarEstadoButton.addActionListener(actionListener);
        this.mostrarCertificadoButton.addActionListener(actionListener);

        this.setVisible(true);
    }



    @Override
    public int pedirCertificado() {
        return Integer.getInteger(this.textField1.getText());
    }

    @Override
    public void mostrarEstado(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    @Override
    public void mostrarCertificado() {
        Certificado.pedirCertificado(Integer.getInteger(this.textField1.getText()));
    }


    public JTextField getTextField1() {
        return textField1;
    }

    public JButton getPedirCertificadoButton() {
        return pedirCertificadoButton;
    }

    public JButton getMostrarEstadoButton() {
        return mostrarEstadoButton;
    }

    public JButton getMostrarCertificadoButton() {
        return mostrarCertificadoButton;
    }

//    public void setActionListener(ActionListener actionListener) {
//        this.actionListener = actionListener;
//    }
}
