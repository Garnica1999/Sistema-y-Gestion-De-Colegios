/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.persistencia;

import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public interface IObtenerEvent<T> {
    public T accionObjeto(Object ident, ArrayList<T> objs, int index);
}
