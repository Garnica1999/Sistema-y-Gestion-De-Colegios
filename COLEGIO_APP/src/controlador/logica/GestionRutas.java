/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.logica;

import controlador.logica.interfaces.IGestion;
import controlador.persistencia.GestionArchivo;
import java.util.ArrayList;
import modelo.Fecha;
import modelo.Ruta;

/**
 *
 * @author Carlos
 */
public class GestionRutas implements IGestion<Ruta>{
    private ArrayList<Ruta> rutas;
    public static final int RUTA = 1;
    private GestionArchivo<Ruta> gestionArchivo;
    public GestionRutas(){
        this.rutas = new ArrayList<>();
        this.gestionArchivo = new GestionArchivo<>("rutas.bin");
        this.cargarDatos();
    }
    
    public static Ruta crearRuta(int idRuta, String placa, String localidad, int capacidad){
        return new Ruta(idRuta, placa, localidad, capacidad);
    }
    
    public static Ruta crearRuta(int idRuta, String placa, String localidad, int capacidad, int dia, int mes, int anio){
        Fecha fecha_ultimo_mantenimiento = new Fecha(dia, mes, anio);
        return new Ruta(idRuta, placa, localidad, capacidad, fecha_ultimo_mantenimiento);
    }

    @Override
    public boolean agregar(Ruta obj) {
        return this.rutas.add(obj) && this.gestionArchivo.ingresarDato(obj);
    }

    @Override
    public boolean buscar(long id) {
        int idRuta = (int)id;
        for(int i = 0; i < this.obtenerCantidad(); i++){
            Ruta r = this.rutas.get(i);
            if(r.getIdRuta() == idRuta){
                return true;
            }
        } 
        return false;
    }

    @Override
    public boolean buscar(Object id) {
        String placa = String.valueOf(id);
        for(int i = 0 ; i < this.obtenerCantidad(); i++){
            Ruta r = this.rutas.get(i);
            if(r.getPlaca().equals(placa)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int buscarObjeto(long id) {
        int idRuta = (int) id;
        for (int i = 0; i < this.obtenerCantidad(); i++) {
            Ruta r = this.rutas.get(i);
            if (r.getIdRuta() == idRuta) {
                return i;
            }
        }
        return -1;
    }
    
    public int buscarObjeto(Object id) {
        String placa = String.valueOf(id);
        for (int i = 0; i < this.obtenerCantidad(); i++) {
            Ruta r = this.rutas.get(i);
            if (r.getPlaca().equals(placa)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean modificar(Ruta obj, long id) {
        
        int index  = this.buscarObjeto(id);
        if(index != -1){
            this.rutas.add(index, obj);
            return true;
        }
        return false;
   }

    @Override
    public boolean modificar(Ruta obj, Object id) { 
        int index  = this.buscarObjeto(id);
        if(index != -1){
            this.rutas.add(index, obj);
            return true;
        }
        return false;
    }

    @Override
    public boolean borrar(int tipo, int id) {
        if(tipo == this.RUTA){
            return borrarRuta(id);
        }
        return false;
    }

    @Override
    public Ruta borrar(long id) {
        for(int i = 0; i < this.obtenerCantidad(); i++){
            Ruta r = this.rutas.get(i);
            if(r.getIdRuta() == id){
                return this.rutas.remove(i);
            }
        }
        return null;
    }
    
    public Ruta borrar(String placa) {
        for(int i = 0; i < this.obtenerCantidad(); i++){
            Ruta r = this.rutas.get(i);
            if(r.getPlaca().equals(placa)){
                return this.rutas.remove(i);
            }
        }
        return null;
    }

    @Override
    public int obtenerCantidad() {
        return this.rutas.size();
    }

    @Override
    public Ruta obtener(long id) {
        for(int i = 0; i < this.obtenerCantidad(); i++){
            Ruta r = this.rutas.get(i);
            
            if(r.getIdRuta() == (int)id){
                return r;
            }
        }
        return null;
    }
    
    public Ruta obtener(String placa){
        for(int i = 0; i < this.obtenerCantidad(); i++){
            Ruta r = this.rutas.get(i);
            
            if(r.getPlaca().equals(placa)){
                return r;
            }
        }
        return null;
    }

    private boolean borrarRuta(int id) {
        for(int i = 0 ; i < this.obtenerCantidad(); i++){
            Ruta r = this.rutas.get(i);
            if(r.getIdRuta() == id) return true;
        }
        return false;
    }

    public String[] obtenerTodasLasRutas() {
        ArrayList<String> rutasTemp = new ArrayList<>();
        for(int i = 0; i < this.obtenerCantidad(); i++){
            Ruta r = this.rutas.get(i);
            rutasTemp.add(r.getPlaca());
        } 
        
        String rutas[] = new String[rutasTemp.size()];
        for(int i = 0 ; i < rutas.length; i++){
            rutas[i] = rutasTemp.get(i);
        }
        return rutas;
    }

    public String[][] obtenerTodasLasRutas(int columnas) {
        String[][] data = new String[this.rutas.size()][columnas];
        for(int i = 0 ; i < this.obtenerCantidad(); i++){
            Ruta r = this.rutas.get(i);
            data[i][0] = r.getPlaca();
            data[i][1] = r.getIdRuta() + "";
            data[i][2] = r.getLocalidad();
            data[i][3] = r.getCapacidad() + "";
            if(r.getFecha_ultimo_mantenimiento() != null)
                data[i][4] = r.getFecha_ultimo_mantenimiento().getString(Fecha.FORMATO_FECHA_LIN);
            else
                data[i][4] = "Sin mantenimiento";
        }
        
        return data;
    }

    private void cargarDatos() {
        this.rutas = this.gestionArchivo.obtenerTodosLosElementos();
    }

    public boolean eliminarRuta(String placa) {
        boolean eliruta = false;
        for(int i = 0 ; i < this.obtenerCantidad(); i++){
            Ruta r = this.rutas.get(i);
            if(r.getPlaca().equals(placa)){
                this.rutas.remove(i);
                eliruta = this.gestionArchivo.eliminarDato(placa, GestionArchivo.RUTA) != null;
            }
        }
        
        return eliruta;
    }
    
    
}
