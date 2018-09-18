/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.logica;

import controlador.persistencia.GestionArchivo;
import java.util.ArrayList;
import modelo.Area;
import modelo.Docente;

/**
 *
 * @author Carlos
 */
public class GestionArea {
    private ArrayList<Area> areas;
    private final GestionArchivo<Area> gestionArchivo;
    public GestionArea() {
        this.areas = new ArrayList<>();
        this.gestionArchivo = new GestionArchivo<>("areas.bin");
        this.cargarDatos();
    }
    
    public boolean agregar(String nombreArea, Docente docenteEncargado){
        Area a = new Area(nombreArea, docenteEncargado);
        return this.areas.add(a) && this.gestionArchivo.ingresarDato(a);
    }
    
    public String[] obtenerTodasLasAreas(){
        String[] areas = new String[this.areas.size()];
        
        for(int i = 0; i < this.areas.size(); i++){
            areas[i] = this.areas.get(i).getNombreArea();
        }
        
        return areas;
    }
    
    public int obtenerCantidadAreas(){
        return this.areas.size();
    }
    
    public boolean buscarArea(String nombreArea){
        for(int i = 0 ; i < this.obtenerCantidadAreas(); i++){
            Area a = this.areas.get(i);
            
            if(a.getNombreArea().equals(areas)){
                return true;
            }
        }
        return false;
    }

    public Area obtenerArea(String nombreArea) {
        for(int i = 0 ; i < this.obtenerCantidadAreas(); i++){
            Area a = this.areas.get(i);
            if(a.getNombreArea().equals(nombreArea)){
                return a;
            }
        }
        return null;
    }

    private void cargarDatos() {
        this.areas = this.gestionArchivo.obtenerTodosLosElementos();
    }
    
    
}
