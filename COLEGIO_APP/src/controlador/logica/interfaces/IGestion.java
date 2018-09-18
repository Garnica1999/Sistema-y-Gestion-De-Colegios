/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.logica.interfaces;

/**
 *
 * @author Carlos
 */
public interface IGestion<T>{
    
    public abstract boolean agregar(T obj);
    public abstract boolean buscar(long id);
    public abstract boolean buscar(Object id);
    public abstract int buscarObjeto(long id);
    public abstract boolean modificar(T obj, long id);
    public abstract boolean modificar(T obj, Object id);
    public abstract boolean borrar(int tipoPersona, int id);
    public abstract T borrar(long documento);
    public abstract int obtenerCantidad();
    public abstract T obtener(long documento);
}
