package vista;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ventana extends JFrame implements IVista {

    private JPanel PanelPrincipal;
    private JButton calcularButton;
    private JTextField textFieldOp1;
    private JTextField textFieldOp2;
    private JTextField textFieldOperacion;
    private JButton mostrarEstadoButton;
    private JButton mostrarResultadoButton;
    private ActionListener actionListener;
    public Ventana() {

//        textFieldOp1.addKeyListener(this);
//        textFieldOp2.addKeyListener(this);
//        textFieldOperacion.addKeyListener(this);

        this.setTitle("Calculadora");
        this.setContentPane(this.PanelPrincipal);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calcularButton.setActionCommand("Calcular");
        mostrarEstadoButton.setActionCommand("mostrarEstado");
        mostrarResultadoButton.setActionCommand("mostrarResultado");
        calcularButton.addActionListener(this.actionListener);
        mostrarEstadoButton.addActionListener(this.actionListener);
        mostrarResultadoButton.addActionListener(this.actionListener);
        this.setVisible(true);
    }

    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }

    public JButton getCalcularButton() {
        return calcularButton;
    }

    public JTextField getTextFieldOp1() {
        return textFieldOp1;
    }

    public JTextField getTextFieldOp2() {
        return textFieldOp2;
    }

    public JTextField getTextFieldOperacion() {
        return textFieldOperacion;
    }

    public JButton getMostrarEstadoButton() {
        return mostrarEstadoButton;
    }

    public JButton getMostrarResultadoButton() {
        return mostrarResultadoButton;
    }

    public ActionListener getActionListener() {
        return actionListener;
    }

    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     *
     * @param e the event to be processed
     */

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key pressed event.
     *
     * @param e the event to be processed
     */

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

//    public static void main(String[] args) {
//        JFrame frame = new JFrame("ventana");
//        frame.setContentPane(new Ventana().PanelPrincipal);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//    }

    @Override
    public void calcular(int op1, int op2, String Operacion) {

    }

    @Override
    public void mostrarEstado(String mensaje) {

    }

    @Override
    public void mostrarResultado() {

    }

    @Override
    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }
}
