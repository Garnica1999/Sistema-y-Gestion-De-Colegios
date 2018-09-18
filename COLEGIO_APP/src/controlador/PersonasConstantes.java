/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 * <p>Interfaz para asingnación de las contantes para los tipos de personas que
 * existen en la aplicación. Si se desea obtener o ingresar un tipo específico 
 * de persona, se utilziará esta interfaz. Se recomienda hacer implements a la
 * clase a utilizar.</p>
 * @author Carlos
 * @see Persona
 */
public interface PersonasConstantes {
    /**
     * Personas que son Estudiantes
     */
    public static int ESTUDIANTE = 1;
    /**
     * Personas que son Docentes
     */
    public static int DOCENTE = 2;
    /**
     * Personas que son directivos
     */
    public static int DIRECTIVO = 3;
    /**
     * Personas que son Acudientes
     */
    public static int ACUDIENTE = 4;
    /**
     * Personas que hacen parte al grupo de Personal de Servicio
     */
    public static int PERSONAL_SERVICIO = 5;
    /**
     * Constante de reconocimiento general
     */
    public static int PERSONA = 6;
}
