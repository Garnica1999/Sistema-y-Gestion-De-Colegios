/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.logica;

import controlador.logica.interfaces.IGestion;
import java.util.ArrayList;
import modelo.Actividad;
import modelo.Estudiante;

/**
 *
 * @author Carlos
 */
public class GestionActividades implements IGestion<Actividad>{
    private ArrayList<Actividad> actividades;

    public GestionActividades() {
        this.actividades = new ArrayList<>();
    }

    @Override
    public boolean agregar(Actividad obj) {
        return this.actividades.add(obj);
    }

    @Override
    public boolean buscar(long id) {
        for(Actividad a : actividades){
            if(a.getNota().getIdNota() == id){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean buscar(Object id) {
        for (Actividad a : actividades) {
            if (a.getNombreActividad().equals((String)id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int buscarObjeto(long id) {
        for (Actividad a : actividades) {
            if (a.getNota().getIdNota() == id) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public boolean modificar(Actividad obj, long id) {
        for(int i = 0 ; i < this.actividades.size(); i++){
            Actividad a = this.actividades.get(i);
            if(a.getNota().getIdNota() == id){
                this.actividades.remove(i);
                this.actividades.add(i,obj);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean modificar(Actividad obj, Object id) {
        for (int i = 0; i < this.actividades.size(); i++) {
            Actividad a = this.actividades.get(i);
            if (a.getNombreActividad().equals((String)id)) {
                this.actividades.remove(i);
                this.actividades.add(i, obj);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean borrar(int tipoPersona, int idTemp) {
        long id = Long.parseLong(String.valueOf(idTemp));
        return borrar(id) != null;
    }

    @Override
    public Actividad borrar(long id) {
        for (int i = 0 ; i < this.actividades.size(); i++) {
            Actividad a = this.actividades.get(i);
            if (a.getNota().getIdNota() == id) {
                return this.actividades.remove(i);
                
            }
        }
        return null;
    }

    @Override
    public int obtenerCantidad() {
        return this.actividades.size();
    }

    @Override
    public Actividad obtener(long id) {
        for(Actividad a : actividades){
            if(a.getNota().getIdNota() == id){
                return a;
            }
        }
        return null;
    }

    public Actividad obtener(Object id){
        for(Actividad a : actividades){
            if(a.getNombreActividad().equals((String)id)){
                return a;
            }
        }
        return null;
    }

    public String[][] obtenerTareasEstudiante(int columnas, String usuario) {
        /*for(Actividad a : actividades){
            if(a.getNota().getEstudiante().getUsuario().equals(usuario)){
                
            }
        }*/
        return null;
    }
}
