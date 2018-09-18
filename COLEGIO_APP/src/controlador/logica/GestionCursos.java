/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.logica;

import controlador.persistencia.GestionArchivo;
import java.util.ArrayList;
import modelo.Curso;
import modelo.Docente;
import modelo.Materia;

/**
 *
 * @author Carlos
 */
public class GestionCursos {
    private ArrayList<Curso> cursos;
    private final GestionArchivo<Curso> gestionArchivo;
    
    public GestionCursos(){
        cursos = new ArrayList<>();
        this.gestionArchivo = new GestionArchivo<>("cursos.bin");
        this.cargarDatos();
    }
    
    public boolean agregar(int numCurso, int capacidadMaxima, int grado, Docente directorCurso, Materia[] materias){
        Curso c = new Curso(numCurso, capacidadMaxima, grado, directorCurso, materias);
        return this.cursos.add(c) && this.gestionArchivo.ingresarDato(c);
        
    }
    
    public Curso buscar(int numCurso){
        for(int i = 0 ; i < this.obtenerCantidadCursos(); i++){
            Curso c = this.cursos.get(i);
            if(c.getNumCurso() == numCurso){
                return c;
            }
        }
        return null;
    }
    
    public int obtenerCantidadCursos(){
        return this.cursos.size();
    }

    public String[] obtenerCursos() {
        String[] cursos = new String[this.cursos.size()];
        for(int i = 0 ; i < cursos.length; i++){
            cursos[i] = this.cursos.get(i).getNumCurso() + "";
        }
        return cursos;
    }

    public Object[][] obtenerCursos(int columnas) {
        Object[][] datos = new String[this.obtenerCantidadCursos()][columnas]; 
        for(int i = 0 ; i < this.obtenerCantidadCursos(); i++){
            Curso c = this.cursos.get(i);
            
            datos[i][0] = c.getNumCurso() + "";
            datos[i][1] = c.getGrado() + "";
            
            String nombres = c.getDirectorCurso().getPrimerNombre() + " " + c.getDirectorCurso().getSegundoNombre();
            String apellidos = c.getDirectorCurso().getSegundoNombre() + " " + c.getDirectorCurso().getSegundoApellido();
            
            datos[i][2] = nombres + " " + apellidos;
            datos[i][3] = c.getCapacidadMaxima() + "";
            datos[i][4] = "Ver Materias";
        }
        return datos;
    }

    private void cargarDatos() {
        this.cursos = this.gestionArchivo.obtenerTodosLosElementos();
    }

    public String obtenerMateriasPorCurso(int curso) {
        String materias = "";
        for(int i = 0 ; i < this.obtenerCantidadCursos(); i++){
            Curso c = this.cursos.get(i);
            if(c.getNumCurso() == curso){
                for(int j = 0 ; j < c.getMaterias().length; j++){
                    Materia m[] = c.getMaterias();
                    String nomMateria = m[j].getNombreMateria();
                    String nombresDoc = m[j].getDocente().getPrimerNombre() + " " + m[j].getDocente().getSegundoNombre();
                    String apellidosDoc = m[j].getDocente().getPrimerApellido() + " " + m[j].getDocente().getSegundoApellido();
                    String docente = nombresDoc + " " + apellidosDoc;
                    materias = materias + nomMateria + "-" + docente + "\n";
                }
                break;
            }
            
        }
        return materias;
    }
}
