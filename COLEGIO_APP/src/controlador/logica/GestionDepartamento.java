/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.logica;

import controlador.persistencia.GestionArchivo;
import java.util.ArrayList;
import modelo.Departamento;
import modelo.Persona;

/**
 *
 * @author Carlos
 */
public class GestionDepartamento {
    private ArrayList<Departamento> departamentos;
    private GestionArchivo<Departamento> gestionArchivo;
    
    public GestionDepartamento() {
        this.departamentos = new ArrayList<>();
        this.gestionArchivo =  new GestionArchivo<>("departamentos.bin");
        this.cargarDatos();
    }
    
    public boolean agregar(String nombreDpto, String descripcion, Persona encargado){
        Departamento d = new Departamento(nombreDpto, descripcion, encargado);
        return this.departamentos.add(d) && this.gestionArchivo.ingresarDato(d);
    }

    public String[] cargarDepartamentos() {
        String[] departamentos = new String[this.departamentos.size()];
        for(int i = 0 ; i < this.departamentos.size(); i++){
            departamentos[i] = this.departamentos.get(i).getNombreDpto();
        }
        return departamentos;
    }
    
    public int obtenerCantidadDepartamentos(){
        return this.departamentos.size();
    }

    public boolean buscarDepartamento(String departamento) {
        for(int i = 0 ; i < this.obtenerCantidadDepartamentos(); i++){
            if(this.departamentos.get(i).getNombreDpto().equals(departamento)){
                return true;
            }
        }
        return false;
    }
    
    public Departamento obtenerDepartamento(String nombre){
        for(int i = 0 ; i < this.obtenerCantidadDepartamentos(); i++){
            if(this.departamentos.get(i).getNombreDpto().equals(nombre)){
                return this.departamentos.get(i);
            }
        }
        return null;
    }

    private void cargarDatos() {
        this.departamentos = this.gestionArchivo.obtenerTodosLosElementos();
        //this.obtenerPrueba(0);
    }

    private void obtenerPrueba(int i) {
        System.out.println(this.gestionArchivo.obtenerDatoDelArchivo(this.departamentos.get(i).getNombreDpto(), GestionArchivo.DEPARTAMENTO).getNombreDpto());
    }

    public String[][] obtenerDepartamentos(int col) {
        String[][] departamentos = new String[this.obtenerCantidadDepartamentos()][col];
        
        for(int i = 0 ; i < this.obtenerCantidadDepartamentos(); i++){
            Departamento d = this.departamentos.get(i);
            departamentos[i][0] = d.getNombreDpto();
            if(d.getEncargado() != null){
                String nombres = d.getEncargado().getPrimerNombre() + " " + d.getEncargado().getSegundoNombre();
                String apellidos = d.getEncargado().getPrimerApellido() + " " + d.getEncargado().getSegundoApellido();
                departamentos[i][1] = nombres + " " + apellidos;
            } else {
                departamentos[i][1] = "No asignado";
            }
            
            departamentos[i][2] = d.getDescripcion();
        }
        
        return departamentos;
    }
}
