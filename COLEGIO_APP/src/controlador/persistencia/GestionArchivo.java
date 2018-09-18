/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Actividad;
import modelo.ActividadExtra;
import modelo.Area;
import modelo.Colegio;
import modelo.Curso;
import modelo.Departamento;
import modelo.Deuda;
import modelo.EPS;
import modelo.Materia;
import modelo.MateriaBase;
import modelo.Menu;
import modelo.Nota;
import modelo.Periodo;
import modelo.Persona;
import modelo.Restaurante;
import modelo.Ruta;

/**
 *
 * @author Carlos
 * @param <T>
 */
public class GestionArchivo<T> implements IObjetosConstantes{
    private String nombreArchivo;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private FileInputStream fis;
    private FileOutputStream fos;
    private File archivo;
    
    public GestionArchivo(String archivo){
        this.nombreArchivo = archivo;
        
        this.archivo = new File(archivo);
        this.crearArchivo();
    }

    private boolean crearArchivo() {
        try {
            if (!this.archivo.exists()) {
                return archivo.createNewFile();
            }
            return false;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean existenciaArchivo(){
        return this.archivo.exists();
    }

    public boolean eliminarArchivo() {
        if (this.archivo.exists()) {
            return this.archivo.delete();
        }
        return false;
    }

    public boolean ingresarDato(T obj){
        try{
            fos = new FileOutputStream(archivo, true);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();
            fos.close();
            return true;
        }catch(IOException ex){
            System.out.println(ex.getMessage());
            Logger.getLogger(GestionArchivo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void limpiarArchivo(){
        eliminarArchivo();
        crearArchivo();
    }

    public ArrayList<T> obtenerTodosLosElementos(){
        try {
            ArrayList<T> objetos = new ArrayList<>();
            boolean bufferAbierto = false;
            T obj;
            fis = new FileInputStream(archivo);
            while(fis.available() > 0){
                ois = new ObjectInputStream(fis);
                obj = (T)ois.readObject();
                if(obj != null){
                    objetos.add(obj);
                }
                bufferAbierto = true;
            }
            if(bufferAbierto){
                ois.close();
            }
            fis.close();
            return objetos;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionArchivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(GestionArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }
    
    /*public T obtenerDatoDelArchivo(long documento){
        ArrayList<T> objetos = obtenerTodosLosElementos();
        for(int i = 0 ; i < objetos.size(); i++){
            if(documento == ((Persona)objetos.get(i)).getDocumento()){
                return objetos.get(i);
                
            }
        }
        return null;
    }*/
    
    public T obtenerDatoDelArchivo(Object id, int tipoObjeto) {
        ArrayList<T> objetos = obtenerTodosLosElementos();
        IObtenerEvent<T> event;
        T obj = null;
        int i = 0;
        for (i = 0; i < objetos.size(); i++) {
            switch (tipoObjeto) {
                case PERSONA:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        long documento = Long.parseLong(String.valueOf(ident));
                        System.out.println(documento + " " + ((Persona) objs.get(index)).getDocumento() );
                        if (documento == ((Persona) objs.get(index)).getDocumento()) {
                            return objs.get(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        return obj;
                    }
                    break;
                case ACTIVIDAD:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        if (String.valueOf(ident).equals(((Actividad) objs.get(index)).getNombreActividad())) {
                            return objs.get(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        return obj;
                    }
                    break;
                case ACTIVIDAD_EXTRA:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        int num = Integer.parseInt(String.valueOf(ident));
                        if (num == ((ActividadExtra) objs.get(index)).getNumActividad()) {
                            return objs.get(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        return obj;
                    }
                    break;
                case AREA:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        if (String.valueOf(ident).equals(((Area) objs.get(index)).getNombreArea())) {
                            return objs.get(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        return obj;
                    }
                    break;
                case COLEGIO:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        if (String.valueOf(ident).equals(((Colegio) objs.get(index)).getNombreColegio())) {
                            return objs.get(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    break;
                case CURSO:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        int num = Integer.parseInt(String.valueOf(ident));
                        if (num == ((Curso) objs.get(index)).getNumCurso()) {
                            return objs.get(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        return obj;
                    }
                    break;
                case DEPARTAMENTO:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        if (String.valueOf(ident).equals(((Departamento) objs.get(index)).getNombreDpto())) {
                            return objs.get(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        return obj;
                    }
                    break;
                case DEUDA:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        int num = Integer.parseInt(String.valueOf(ident));
                        if (num == ((Deuda) objs.get(index)).getIdDeuda()) {
                            return objs.get(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        return obj;
                    }
                    break;
                case EPS:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        if (String.valueOf(ident).equals(((EPS) objs.get(index)).getNombreEPS())) {
                            return objs.get(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        return obj;
                    }
                    break;
                case MATERIA:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        if (String.valueOf(ident).equals(((Materia) objs.get(index)).getNombreMateria())) {
                            return objs.get(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        return obj;
                    }
                    break;
                case MATERIA_BASE:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        if (String.valueOf(ident).equals(((MateriaBase) objs.get(index)).getNombreMateria())) {
                            return objs.get(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        return obj;
                    }
                    break;
                case MENU:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        int num = Integer.parseInt(String.valueOf(ident));
                        if (num ==((Menu) objs.get(index)).getIdMenu()) {
                            return objs.get(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        return obj;
                    }
                    break;
                case NOTA:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        long num = Long.parseLong(String.valueOf(ident));
                        if (num == ((Nota) objs.get(index)).getIdNota()) {
                            return objs.get(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        return obj;
                    }
                    break;
                case PERIODO:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        int num = Integer.parseInt(String.valueOf(ident));
                        if (num == ((Periodo) objs.get(index)).getIdPeriodo()) {
                            return objs.get(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        return obj;
                    }
                    break;
                case RESTAURANTE:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        if (String.valueOf(ident).equals(((Restaurante) objs.get(index)).getNombreRestaurante())) {
                            return objs.get(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        return obj;
                    }
                    break;
                case RUTA:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        if (String.valueOf(ident).equals(((Ruta) objs.get(index)).getPlaca())) {
                            return objs.get(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        return obj;
                    }
                    break;
            }
        }
        return obj;
    }
    
    public T eliminarDato(Object id, int tipoObjeto){
        ArrayList<T> objetos = this.obtenerTodosLosElementos();
        IObtenerEvent<T> event;
        T obj = null;
        ciclo : for (int i = 0; i < objetos.size(); i++) {
            switch (tipoObjeto) {
                case PERSONA:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        long documento = Long.parseLong(String.valueOf(ident));
                        if (documento == ((Persona) objs.get(index)).getDocumento()) {
                            return objs.remove(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        break ciclo;
                    }
                    break;
                case ACTIVIDAD:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        if (String.valueOf(ident).equals(((Actividad) objs.get(index)).getNombreActividad())) {
                            return objs.remove(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        break ciclo;
                    }
                    break;
                case ACTIVIDAD_EXTRA:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        int num = Integer.parseInt(String.valueOf(ident));
                        if (num == ((ActividadExtra) objs.get(index)).getNumActividad()) {
                            return objs.remove(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        break ciclo;
                    }
                    break;
                case AREA:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        if (String.valueOf(ident).equals(((Area) objs.get(index)).getNombreArea())) {
                            return objs.remove(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        break ciclo;
                    }
                    break;
                case COLEGIO:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        if (String.valueOf(ident).equals(((Colegio) objs.get(index)).getNombreColegio())) {
                            return objs.remove(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        break ciclo;
                    }
                    break;
                case CURSO:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        int num = Integer.parseInt(String.valueOf(ident));
                        if (num == ((Curso) objs.get(index)).getNumCurso()) {
                            return objs.remove(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        break ciclo;
                    }
                    break;
                case DEPARTAMENTO:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        if (String.valueOf(ident).equals(((Departamento) objs.get(index)).getNombreDpto())) {
                            return objs.remove(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        break ciclo;
                    }
                    break;
                case DEUDA:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        int num = Integer.parseInt(String.valueOf(ident));
                        if (num == ((Deuda) objs.get(index)).getIdDeuda()) {
                            return objs.remove(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        break ciclo;
                    }
                    break;
                case EPS:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        if (String.valueOf(ident).equals(((EPS) objs.get(index)).getNombreEPS())) {
                            return objs.remove(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        break ciclo;
                    }
                    break;
                case MATERIA:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        if (String.valueOf(ident).equals(((Materia) objs.get(index)).getNombreMateria())) {
                            return objs.remove(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        break ciclo;
                    }
                    break;
                case MATERIA_BASE:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        if (String.valueOf(ident).equals(((MateriaBase) objs.get(index)).getNombreMateria())) {
                            return objs.remove(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        break ciclo;
                    }
                    break;
                case MENU:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        int num = Integer.parseInt(String.valueOf(ident));
                        if (num ==((Menu) objs.get(index)).getIdMenu()) {
                            return objs.remove(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        break ciclo;
                    }
                    break;
                case NOTA:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        long num = Long.parseLong(String.valueOf(ident));
                        if (num == ((Nota) objs.get(index)).getIdNota()) {
                            return objs.remove(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        break ciclo;
                    }
                    break;
                case PERIODO:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        int num = Integer.parseInt(String.valueOf(ident));
                        if (num == ((Periodo) objs.get(index)).getIdPeriodo()) {
                            return objs.remove(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        break ciclo;
                    }
                    break;
                case RESTAURANTE:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        if (String.valueOf(ident).equals(((Restaurante) objs.get(index)).getNombreRestaurante())) {
                            return objs.remove(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        break ciclo;
                    }
                    break;
                case RUTA:
                    event = (Object ident, ArrayList<T> objs, int index) -> {
                        if (String.valueOf(ident).equals(((Ruta) objs.get(index)).getPlaca())) {
                            return objs.remove(index);
                        }
                        return null;
                    };
                    obj = event.accionObjeto(id, objetos, i);
                    if(obj != null){
                        break ciclo;
                    }
                    break;
            }
        }
        limpiarArchivo();
        
        for(int i = 0 ; i < objetos.size(); i++){
            ingresarDato(objetos.get(i));
        }
        return obj;
    }
    
    public boolean modificarDato(T obj, int tipoObjeto){
        Object id = null;
        switch(tipoObjeto){
            case PERSONA:
                id = ((Persona)obj).getDocumento();
                if(obtenerDatoDelArchivo(id, tipoObjeto) == null){
                    return false;
                }
                break;
            case ACTIVIDAD:
                id = ((Actividad)obj).getNombreActividad();
                if(obtenerDatoDelArchivo(id, tipoObjeto) == null){
                    return false;
                }
                break;
            case ACTIVIDAD_EXTRA:
                id = ((ActividadExtra)obj).getNumActividad();
                if(obtenerDatoDelArchivo(id, tipoObjeto) == null){
                    return false;
                }
                break;
            case AREA:
                id = ((Area)obj).getNombreArea();
                if(obtenerDatoDelArchivo(id, tipoObjeto) == null){
                    return false;
                }
                break;
            case COLEGIO:
                id = ((Colegio)obj).getNit();
                if(obtenerDatoDelArchivo(id, tipoObjeto) == null){
                    return false;
                }
                break;
            case CURSO:
                id = ((Curso)obj).getNumCurso();
                if(obtenerDatoDelArchivo(id, tipoObjeto) == null){
                    return false;
                }
                break;
            case DEPARTAMENTO:
                id = ((Departamento)obj).getNombreDpto();
                if(obtenerDatoDelArchivo(id, tipoObjeto) == null){
                    return false;
                }
                break;
            case DEUDA:
                id = ((Deuda)obj).getIdDeuda();
                if(obtenerDatoDelArchivo(id, tipoObjeto) == null){
                    return false;
                }
                break;
            case EPS:
                id = ((EPS)obj).getNombreEPS();
                if(obtenerDatoDelArchivo(id, tipoObjeto) == null){
                    return false;
                }
                break;
            case MATERIA:
                id = ((Materia)obj).getNombreMateria();
                if(obtenerDatoDelArchivo(id, tipoObjeto) == null){
                    return false;
                }
                break;
            case MATERIA_BASE:
                id = ((MateriaBase)obj).getNombreMateria();
                if(obtenerDatoDelArchivo(id, tipoObjeto) == null){
                    return false;
                }
                break;
            case MENU:
                id = ((Menu)obj).getIdMenu();
                if(obtenerDatoDelArchivo(id, tipoObjeto) == null){
                    return false;
                }
                break;
            case NOTA:
                id = ((Nota)obj).getIdNota();
                if(obtenerDatoDelArchivo(id, tipoObjeto) == null){
                    return false;
                }
                break;
            case PERIODO:
                id = ((Periodo)obj).getIdPeriodo();
                if(obtenerDatoDelArchivo(id, tipoObjeto) == null){
                    return false;
                }
                break;
            case RESTAURANTE:
                id = ((Restaurante)obj).getNombreRestaurante();
                if(obtenerDatoDelArchivo(id, tipoObjeto) == null){
                    return false;
                }
                break;
            case RUTA:
                id = ((Ruta)obj).getPlaca();
                if(obtenerDatoDelArchivo(id, tipoObjeto) == null){
                    return false;
                }
                break;
            default:
                return false;
        }
        eliminarDato(id, tipoObjeto);
        ingresarDato(obj);
        return true;
    }
}
