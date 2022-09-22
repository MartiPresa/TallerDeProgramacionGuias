package prueba;

import negocio.Monitor;
import vista.IVista;
import vista.Ventana;

import javax.swing.*;

public class main {
    public static void main(String[] args) {

        System.out.println("Main xd");
        Ventana ventana = new Ventana();
        Monitor monitor = new Monitor(ventana);
        ventana.setActionListener(monitor);


    }
}
