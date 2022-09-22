package vista;

import java.awt.event.ActionListener;

public interface IVista {
    void calcular(int op1, int op2, String Operacion);
    void mostrarEstado(String mensaje);
    void mostrarResultado();
    void setActionListener(ActionListener actionListener);
}
