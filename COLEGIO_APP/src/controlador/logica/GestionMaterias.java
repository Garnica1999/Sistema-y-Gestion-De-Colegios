/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.logica;

import controlador.persistencia.GestionArchivo;
import java.util.ArrayList;
import modelo.Area;
import modelo.Curso;
import modelo.Docente;
import modelo.Materia;
import modelo.MateriaBase;

/**
 *
 * @author Carlos
 */
public class GestionMaterias {
    private ArrayList<MateriaBase> materiasBase;
    private ArrayList<Materia> materias;
    private ArrayList<Materia> materiasTemp;
    private final GestionArchivo<Materia> gestionArchivoMaterias;
    private final GestionArchivo<MateriaBase> gestionArchivoMateriasBase;
    public GestionMaterias() {
        this.materias = new ArrayList<>();
        this.materiasBase = new ArrayList<>();
        this.materiasTemp = new ArrayList<>();
        this.gestionArchivoMaterias = new GestionArchivo<>("materias.bin");
        this.gestionArchivoMateriasBase = new GestionArchivo<>("materias_base.bin");
        this.cargarDatos();
    }
    
    public boolean agregarMateriaBase(String nombreMateria, String descripcion, Area nombreArea){
        MateriaBase m = new MateriaBase(nombreMateria, descripcion, nombreArea);
        return this.materiasBase.add(m) && this.gestionArchivoMateriasBase.ingresarDato(m);
    }
    
    public boolean agregarMateria(Docente docente, String nombreMateria, String descripcion, Area nombreArea){
        Materia m = new Materia(docente, nombreMateria, descripcion, nombreArea);
        return this.materias.add(m) && this.gestionArchivoMaterias.ingresarDato(m);
    }
    
    public MateriaBase obtenerMateriaBase(String nombre){
        for(int i = 0 ; i < this.materiasBase.size(); i++){
           if(this.materiasBase.get(i).getNombreMateria().equals(nombre)){
               return this.materiasBase.get(i);
           } 
        }
        return null;
    }
    
    public Materia[] obtenerMaterias(String[] nombres, Docente docente){
        Materia[] materias = new Materia[nombres.length];
        int contador = 0;
        for(int i = 0 ; i < this.materiasBase.size(); i++){
            MateriaBase matBase = this.materiasBase.get(i);
            for(int j = 0 ; j < nombres.length; j++){
                if(matBase.getNombreMateria().equals(nombres[j])){
                    materias[contador] = (Materia)matBase;
                    materias[contador].setDocente(docente);
                    contador++;
                }
            }
        }
        return materias;
    }
    

    public Materia agregarDocenteAMateria(MateriaBase m, Docente docente) {
        return new Materia(docente, m.getNombreMateria(), m.getDescripcion(), m.getArea());
    }

    public boolean agregarMateriaTemporal(Materia materia) {
        boolean x = this.materiasTemp.add(materia);
        //this.imprimirMateriasTemp();
        return x;
    }

    public Materia[] obtenerMateriasAAgregar() {
        Materia[] materias = new Materia[this.materiasTemp.size()];
        for(int i = 0 ; i < this.materiasTemp.size(); i++){
            materias[i] = this.materiasTemp.get(i);
        }
        return materias;
    }

    public String[] obtenerMateriasBase() {
        String[] matBase = new String[this.materiasBase.size()];
        
        for(int i = 0 ; i < matBase.length; i++){
            matBase[i] = this.materiasBase.get(i).getNombreMateria();
        }
        
        return matBase;
    }

    public void limpiarMateriasTemp() {
        this.materiasTemp.clear();
        materiasTemp = new ArrayList<>();
    }

    public String[] obtenerMateriasTemp() {
        String[] materias = new String[this.materiasTemp.size()];
        
        for(int i = 0 ; i < materias.length; i++){
            Materia m = this.materiasTemp.get(i);
            materias[i] = m.getNombreMateria() + "-" + m.getDocente().getDocumento();
        }
        
        return materias;
    }

    public String[] cargarMateriasPorArea(String area) {
        ArrayList<String> materiasTemp = new ArrayList<>();
        
        for(int i = 0 ; i < this.materiasBase.size(); i++){
            MateriaBase m = this.materiasBase.get(i);
            if(m.getArea().getNombreArea().equals(area)){
                materiasTemp.add(m.getNombreMateria());
            }
        }
        
        String[] materias = new String[materiasTemp.size()];
        
        for(int i = 0 ; i < materias.length; i++){
            materias[i] = materiasTemp.get(i);
        }
        
        return materias;
    }

    public boolean eliminarMateriaTemporal(String materia) {
        for(int i = 0 ; i < this.materiasTemp.size(); i++){
            Materia m = this.materiasTemp.get(i);
            
            if(m.getNombreMateria().equals(materia)){
                m = this.materiasTemp.remove(i);
                return m != null;
            }
        }
        return false;
    }

    public boolean buscarMateriaTemp(String nombreMateria) {
        for(int i = 0 ; i < this.materiasTemp.size(); i++){
            if(this.materiasTemp.get(i).getNombreMateria().equals(nombreMateria)){
                return true;
            }
        }
        return false;
    }

    public String[][] cargarMateriasPorArea(String area, int col) {
        String[][] materias = new String[this.materiasBase.size()][col];
        
        for(int i = 0, contador = 0 ; i < this.materiasBase.size(); i++){
            MateriaBase m = this.materiasBase.get(i);
            if(m.getArea().getNombreArea().equals(area)){
                materias[contador][0] = m.getNombreMateria();
                materias[contador][1] = m.getDescripcion();
                materias[contador][2] = m.getArea().getNombreArea();
                contador++;
            }
        }
        return materias;
    }
    
    public int obtenerCantidadMateriasBase(){
        return this.materiasBase.size();
    }
    
    public int obtenerCantidadMaterias(){
        return this.materias.size();
    }

    private void cargarDatos() {
        this.materias = this.gestionArchivoMaterias.obtenerTodosLosElementos();
        this.materiasBase = this.gestionArchivoMateriasBase.obtenerTodosLosElementos();
    }

    private void imprimirMateriasTemp() {
        for(Materia m : materiasTemp){
            System.out.println(m.getNombreMateria());
        }
    }
    
}
