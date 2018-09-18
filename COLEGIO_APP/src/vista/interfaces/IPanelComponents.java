/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.interfaces;

/**
 *
 * @author Carlos
 */
public interface IPanelComponents {
    abstract Object cargarDatosPrincipales();
    abstract boolean validar();
    abstract boolean buscar();
    abstract void registrar();
    abstract void agregarItemsAMenu();
    abstract void agregarPlaceHolder();
    abstract void agregarTextosDefecto();
    abstract void limpiar();
}
