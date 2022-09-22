package org.negocio;

import org.excepciones.CapacidadExcedidaException;
import org.excepciones.MesaAbiertaException;
import org.excepciones.MesaInexistenteException;
import org.excepciones.MesaOcupadaException;
import org.modelo.BeerHouse;
import org.vista.IVista;
import org.vista.Ventana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que implementa la capa de negocio, se relaciona con la interfase
 * y la capa de modelo.<br>
 * Implementa patron Singleton.<br>
 */
public class negocio implements ActionListener {
    private static negocio instance = null;
    private IVista ventana;
    private BeerHouse beerHouse;

    private negocio()
    {
    }

    public static negocio getInstance() {
        if (negocio.instance == null)
            negocio.instance = new negocio();
        return negocio.instance;
    }

    public void setVentana(IVista ventana) {
        this.ventana = ventana;
    }

    public void setBeerHouse(BeerHouse beerHouse) {
        this.beerHouse = beerHouse;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Abrir" -> this.abrirLocal(this.ventana.abrirLocal());
            case "Cerrar" -> this.cerrarMesa(this.ventana.cerrarMesa());
            case "Ocupar" -> this.ocuparMesa(this.ventana.ocuparMesa());
        }
    }

    /**
     * Ocupa un mesa validando previamente de que se trate de un numero posible.<br>
     *
     * @param nroMesa nro de mesa recibido de la ventena sin validacion.<br>
     */
    private void ocuparMesa(int nroMesa) {
        if (nroMesa <= 0)
            JOptionPane.showMessageDialog(null, "Ingrese un numero de mesa positivo.");
        else {
            try {
                this.beerHouse.ocuparMesa(nroMesa);
                JOptionPane.showMessageDialog(null, "Mesa " + nroMesa + " ocupada!");
            } catch (MesaOcupadaException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (MesaInexistenteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        this.ventana.resetTextFieldOcupar();
    }

    /**
     * Cierra un mesa validando previamente de que se trate de un numero posible.<br>
     *
     * @param nroMesa nro de mesa recibido de la ventena sin validacion.<br>
     */
    private void cerrarMesa(int nroMesa) {
        if (nroMesa <= 0)
            JOptionPane.showMessageDialog(null, "Ingrese un numero de mesa positivo.");
        else {
            try {
                double total = this.beerHouse.cerrarMesa(nroMesa);
                JOptionPane.showMessageDialog(null, "Mesa " + nroMesa + " cerrada!\n Total = " + total);
            } catch (MesaInexistenteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (MesaAbiertaException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        this.ventana.resetTextFieldCerrar();
    }

    /**
     * Abre el local previamente validando que se trate de un numero posible.<br>
     *
     * @param cantMesas cantidad de mesas recibido de la ventena sin validacion.<br>
     */
    private void abrirLocal(int cantMesas) {
        if (cantMesas <= 0) {
            JOptionPane.showMessageDialog(null, "Ingrese una cantidad de mesas positiva.");
        } else {
            try {
                this.beerHouse.abrirLocal(cantMesas);
                JOptionPane.showMessageDialog(null, "Local abierto con " + cantMesas + " mesas!");
            } catch (CapacidadExcedidaException e) {
                JOptionPane.showMessageDialog(null, "Capacidad del local excedida!\n Limite = " + e.getCapacidad());
            }
        }
        this.ventana.resetTextFieldAbrir();
    }
}
