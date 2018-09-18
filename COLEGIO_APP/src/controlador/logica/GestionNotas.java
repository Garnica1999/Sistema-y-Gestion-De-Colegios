/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.logica;

import java.util.ArrayList;
import modelo.Docente;
import modelo.Estudiante;
import modelo.MateriaBase;
import modelo.Nota;
import modelo.Periodo;

/**
 *
 * @author Carlos
 */
public class GestionNotas {

    private ArrayList<Nota> notas;
    
    public GestionNotas() {
        this.notas = new ArrayList<>();
    }
    
    /*public Nota agregarNota(long idNota, Estudiante estudiante, Docente docenteCalificador, MateriaBase idMateria, Periodo idPeriodo, double nota){
        Nota n = new Nota(idNota, estudiante, docenteCalificador, idMateria, idPeriodo, nota);
        this.notas.add(n);
        return n;
    }*/
    
    
}
