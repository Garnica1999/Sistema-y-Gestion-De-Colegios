/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.logica;

import controlador.persistencia.GestionArchivo;
import java.util.ArrayList;
import modelo.Direccion;
import modelo.EPS;

/**
 *
 * @author Carlos
 */
public class GestionEpsSalud {
    private ArrayList<EPS> eps;
    private GestionArchivo<EPS> gestionArchivo;
    public GestionEpsSalud() {
        this.eps = new ArrayList<>();
        this.gestionArchivo = new GestionArchivo<>("eps.bin");
        this.cargarDatos();
    }
    
    public boolean agregarEPS(String nombreEPS, long telefono, Direccion direccionEPS){
        EPS eps = new EPS(nombreEPS, telefono, direccionEPS);
        return this.eps.add(eps) && this.gestionArchivo.ingresarDato(eps);
        
    }
    
    public String[] obtenerTodoEPS(){
        
        String[] eps = new String[this.eps.size()];
        
        for(int i = 0 ; i < eps.length; i++){
            eps[i] = this.eps.get(i).getNombreEPS();
        }
        return eps;
    }

    public boolean existeEps(String nombreEps) {
        for(int i = 0 ; i < this.obtenerCantidad(); i++){
            if(this.eps.get(i).getNombreEPS().equals(nombreEps)){
                return true;
            }
        }
        return false;
    }

    public int obtenerCantidad() {
        return this.eps.size();
    }

    public EPS obtener(String nombre) {
        for(int i = 0 ; i < this.obtenerCantidad(); i++){
            if(this.eps.get(i).getNombreEPS().equals(nombre)){
                return this.eps.get(i);
            }
        }
        
        return null;
    }

    public String[][] obtenerTodoEPS(int columnCount) {
        String[][] eps = new String[this.eps.size()][columnCount];
        for(int i = 0 ; i < this.eps.size(); i++){
            EPS e = this.eps.get(i);
            eps[i][0] = e.getNombreEPS();
            eps[i][1] = e.getTelefono() + "";
            eps[i][2] = e.getDireccionEPS().getDireccion();
            eps[i][3] = e.getDireccionEPS().getBarrio();
            eps[i][4] = e.getDireccionEPS().getLocalidad();
        }
        
        return eps;
    }

    private void cargarDatos() {
        this.eps = this.gestionArchivo.obtenerTodosLosElementos();
    }
}
