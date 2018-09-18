/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.logica;

import controlador.logica.interfaces.IGestion;
import controlador.PersonasConstantes;
import controlador.persistencia.GestionArchivo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import modelo.Acudiente;
import modelo.Curso;
import modelo.Departamento;
import modelo.Deuda;
import modelo.Direccion;
import modelo.Directivo;
import modelo.Docente;
import modelo.EPS;
import modelo.Estudiante;
import modelo.Fecha;
import modelo.Persona;
import modelo.PersonalServicio;
import modelo.Ruta;
import modelo.Trabajador;

/**
 * <p><code>GestionPersonas</code> es una clase engargada de guardar los 
 * datos de una clase en específico. Funciona solamente para subclases que hereden
 * de la clase<code>Persona</code>.</p><br>
 * Contiene todos los metodos de control de todas las subclases de personas.
 * @author Carlos Andres Garnica Salazar
 * @param <T> Cualquier clase que sea hija de <code>Persona</code>
 * @see Persona
 * @since 1.0
 */
public class GestionPersonas<T> implements IGestion<T>, PersonasConstantes{
    /**
     * <p><code>personas</code> es un objeto de la clase <code>ArrayList</code> 
     * que ayuda a almacenar todas las instancias que sean hijas de la clase 
     * <code>personas</code> y las guarda en memoria</p>
     * @see ArrayList
     * @see Personas
     * @since 1.0
     */
    private ArrayList<T> personas;
    /**
     * Objeto que ayuda a guardar temporalmente los <code>acudientes</code> que
     * se eligirán para un estudiante es específico.
     * @see Acudiente
     * @see Estudiante
     * @since 1.0
     */
    private ArrayList<Acudiente> acudientesTemp;
    /**
     * <p><code>gestionArchivo</code> es un objeto que ayuda al control de lectura
     *  y escritura del archivo, así como la creación, eliminación, actualización 
     * del archivo de control.</p>
     */
    private final GestionArchivo<T> gestionArchivo;
    
    /**
     * <p>Constructor utilizado por defecto. instancia los objetos de los arraylist
     *  e inicializa el archivo de persistencia para su uso.</p>
     */
    public GestionPersonas() {
        this.personas = new ArrayList<>();
        this.acudientesTemp = new ArrayList<>();
        gestionArchivo = new GestionArchivo<>("personas.bin");
        this.cargarDatos();
    }
    
    /**
     * <p><code>agregarEstudiante</code> es um método estático que se utiliza 
     * para la creación de un estudiante dado unos parmaémtros de entrada pedidas
     * en la función.</p>
     * <br>Estos datos son datos personales del estudiante.
     * @param codigo El codigo del estudiante a registrar
     * @param dia El dia que el estudiante cumple anios
     * @param mes El mes en el que el estudiante cumple anios
     * @param anio El anio en el que el estudiante nació
     * @param barrio Perteneciente a la clase {@link modelo.Direccion}, guarda la
     * el barrio donde reside el estudiante
     * @param localidad Perteneciente a la clase {@link modelo.Direccion}, guarda
     * la localidad, provincia donde reside el estudiante
     * @param dir Perteneciente a la clase {@link modelo.Direccion}, guarda la 
     * dirección física de dodne reside el estudiante. Es la dirección de su casa
     * o casa de los tutores.
     * @param rh Tipo de sangre del estudiante
     * @param estadoInscripcion Por defecto, al registrarse es matriculado. Sin 
     * embargo, el directivo puede cambiar el estadod el estudiante dependiendo
     * de las necesidades o circustancias
     * @param eps Es la entidad de prestación de servicios. Dependiendo del país 
     * donde se utilice el sistema puede variar. Aún así el/los directivos/as 
     * tienen la capacidad de indicar la EPS, registrar una o más.
     * @param documento Es el documento del estudiante. 
     * @param tipo_documento Cada documento tiene un tipo, este tipo depende de 
     * la edad del estudiante. Esto varía por cada país. Para estudiantes mayores
     * de edad, en algunos paises se nombra Cedula de Ciudadanía, en otras DNI.
     * @param primer_nombre El primer nombre del estudiante
     * @param segundo_nombre El segundo nombre del estudiante
     * @param primer_apellido El primer apellido del estudiante
     * @param segundo_apellido El segundo apellido del estudiante
     * @param edad La edad del estudiante.
     * @param genero El género del estudiante. (Masculino-femenino). No confundir 
     * con orientación sexual.
     * @param telefono El teléfono del estudiante. Puede ser teléfono fijo de casa,
     *  o teléfono celular.
     * @param acudientes Lista de los acudientes o tutores que tendrá el estudiante
     * @param curso El curso al que el estudiante será matriculado
     * @param usuario EL usuario que tendrá el estudiante
     * @param clave La clave que tendrá el estudiante dentro del sistema
     * @return Una nueva instancia de Estudiante
     * @see Estudiante
     * @see Persona
     * @since 1.0
     */
    public static Estudiante agregarEstudiante(int codigo, int dia, int mes, int anio, String barrio, String localidad, String dir, String rh, String estadoInscripcion, EPS eps, long documento, String tipo_documento, String primer_nombre, String segundo_nombre, String primer_apellido, String segundo_apellido, int edad, char genero, long telefono, Acudiente[] acudientes, Curso curso, String usuario, String clave){
        //Se captura la fecha de inscripción para guardarla
        Calendar calendar = new GregorianCalendar();
        int diaInscripcion = calendar.get(Calendar.DATE);
        int mesInscripcion = calendar.get(Calendar.MONTH) + 1;
        int anioInscripcion = calendar.get(Calendar.YEAR);
        //Se fabrica la fecha de nacimiento
        Fecha fechaNam = new Fecha(dia,mes,anio);
        //Se crea la dirección para el estudiante
        Direccion direccion = new Direccion(barrio, localidad, dir);
        //Se crea la fechad e inscripción para asu guardado
        Fecha fechaInscripcion = new Fecha(diaInscripcion, mesInscripcion, anioInscripcion);
        //Se instancia el objeto de la clase estudiante
        return new Estudiante(codigo, fechaNam, direccion, rh, fechaInscripcion, estadoInscripcion, eps, documento, tipo_documento, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, edad, genero, telefono, acudientes, curso, usuario, clave);
    }
    /**
     * Método para crear una nueva instancia de la clase Docente mediante los 
     * parámetros de entada de la función
     * @param numeroContrato El numero de contrato que tendrá el docente
     * @param salario El salario que devengará el docente
     * @param departamento El departamento donde pertenecerá el docente
     * @param documento Es el documento del docente. 
     * @param tipo_documento Cada documento tiene un tipo, este tipo depende de 
     * la edad del docente. Esto varía por cada país. Para mayores de edad, en 
     * algunos paises se nombra Cedula de Ciudadanía, en otras DNI.
     * @param primer_nombre El primer nombre del docente
     * @param segundo_nombre El segundo nombre del docente
     * @param primer_apellido El primer apellido del docente
     * @param segundo_apellido El segundo apellido del docente
     * @param edad La edad del docente.
     * @param genero El género del docente. (Masculino-femenino). No confundir 
     * con orientación sexual.
     * @param telefono El teléfono del docente. Puede ser teléfono fijo de casa,
     *  o teléfono celular.
     * @param usuario EL usuario que tendrá el docente
     * @param clave La clave que tendrá el docente dentro del sistema
     * @return Una nueva instancia de docente
     * @see Docente
     * @see Persona
     * @since 1.0
     */
    public static Docente agregarDocente(int numeroContrato, double salario, 
            Departamento departamento, long documento, String tipo_documento, 
            String primer_nombre, String segundo_nombre, String primer_apellido, 
            String segundo_apellido, int edad, char genero, long telefono, 
            String usuario, String clave){
        
        return new Docente(numeroContrato, salario, departamento, documento, 
                tipo_documento, primer_nombre, segundo_nombre, primer_apellido, 
                segundo_apellido, edad, genero, telefono, usuario, clave);
    }
    /**
     * <code>agregarPersona</code> es un método estático que sirve para crear 
     * una persona directamente de la clase <code>Persona</code>. Utilizar por
     * fuerza necesaria
     * @param documento Es el documento de la persona. 
     * @param tipo_documento Cada documento tiene un tipo, este tipo depende de 
     * la edad de la persona. Esto varía por cada país. Para mayores de edad, en 
     * algunos paises se nombra Cedula de Ciudadanía, en otras DNI.
     * @param primer_nombre El primer nombre de la persona
     * @param segundo_nombre El segundo nombre de la persona
     * @param primer_apellido El primer apellido de la persona
     * @param segundo_apellido El segundo apellido de la persona
     * @param edad La edad del docente.
     * @param genero El género de la persona. (Masculino-femenino). No confundir 
     * con orientación sexual.
     * @param telefono El teléfono de la persona. Puede ser teléfono fijo de casa,
     *  o teléfono celular.
     * @param usuario EL usuario que tendrá la persona dentro del sistema
     * @param clave La clave que tendrá la persona dentro del sistema
     * @return Una nueva instancia de la clase Persona
     * @see Persona
     * @since 1.0
     */
    public static Persona agregarPersona(long documento, String tipo_documento, 
            String primer_nombre, String segundo_nombre, String primer_apellido, 
            String segundo_apellido, int edad, char genero, long telefono, 
            String usuario, String clave){
        
        return new Persona(documento, tipo_documento, primer_nombre, 
                segundo_nombre, primer_apellido, segundo_apellido, edad, genero, 
                telefono, usuario, clave);
    }
    
    /**
     * Método para crear una nueva instancia de la clase Trabajador mediante los 
     * parámetros de entada de la función
     * @param salario El salario que devengará el trabajador
     * @param departamento El departamento donde pertenecerá el trabajador
     * @param documento Es el documento del trabajador. 
     * @param tipo_documento Cada documento tiene un tipo, este tipo depende de 
     * la edad del trabajador. Esto varía por cada país. Para mayores de edad, en 
     * algunos paises se nombra Cedula de Ciudadanía, en otras DNI.
     * @param primer_nombre El primer nombre del trabajador
     * @param segundo_nombre El segundo nombre del trabajador
     * @param primer_apellido El primer apellido del trabajador
     * @param segundo_apellido El segundo apellido del trabajdor
     * @param edad La edad del trabajador.
     * @param genero El género del trabajador. (Masculino-femenino). No confundir 
     * con orientación sexual.
     * @param telefono El teléfono del trabajador. Puede ser teléfono fijo de casa,
     *  o teléfono celular.
     * @param usuario EL usuario que tendrá el trabajdor
     * @param clave La clave que tendrá el trabajador dentro del sistema
     * @return Una nueva instancia de trabajador
     * @see Trabajdor
     * @see Persona
     * @since 1.0
     */
    public static Trabajador agregarTrabajador(double salario, 
            Departamento departamento, long documento, String tipo_documento, 
            String primer_nombre, String segundo_nombre, String primer_apellido, 
            String segundo_apellido, int edad, char genero, long telefono, 
            String usuario, String clave){
        
        return new Trabajador(salario, departamento, documento, tipo_documento, 
                primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, 
                edad, genero, telefono, usuario, clave);
    }
    
    /**
     * Método para crear una nueva instancia de la clase Trabajador mediante los 
     * parámetros de entada de la función
     * @param salario El salario que devengará el trabajador
     * @param cargo El cargo que tendrá el trbajador.
     * @param departamento El departamento donde pertenecerá el trabajador
     * @param documento Es el documento del trabajador. 
     * @param tipo_documento Cada documento tiene un tipo, este tipo depende de 
     * la edad del trabajador. Esto varía por cada país. Para mayores de edad, en 
     * algunos paises se nombra Cedula de Ciudadanía, en otras DNI.
     * @param primer_nombre El primer nombre del trabajador
     * @param segundo_nombre El segundo nombre del trabajador
     * @param primer_apellido El primer apellido del trabajador
     * @param segundo_apellido El segundo apellido del trabajdor
     * @param edad La edad del trabajador.
     * @param genero El género del trabajador. (Masculino-femenino). No confundir 
     * con orientación sexual.
     * @param telefono El teléfono del trabajador. Puede ser teléfono fijo de casa,
     *  o teléfono celular.
     * @param usuario EL usuario que tendrá el trabajdor
     * @param clave La clave que tendrá el trabajador dentro del sistema
     * @return Una nueva instancia de trabajador
     * @see Trabajdor
     * @see Persona
     * @since 1.0
     */
    public static Trabajador agregarTrabajador(double salario, String cargo, 
            Departamento departamento, long documento, String tipo_documento, 
            String primer_nombre, String segundo_nombre, String primer_apellido, 
            String segundo_apellido, int edad, char genero, long telefono, 
            String usuario, String clave){
        
        return new Trabajador(salario, cargo, departamento, documento, 
                tipo_documento, primer_nombre, segundo_nombre, primer_apellido, 
                segundo_apellido, edad, genero, telefono, usuario, clave);
    }
    
    /**
     * Método para crear una nueva instancia de la clase {@link modelo.PersonalServicio} 
     * mediante los parámetros de entada de la función
     * @param numeroContrato EL numero de contrato que tendrá la persona que 
     * accederá a ser personal de servicio
     * @param salario El salario que devengará el trabajador
     * @param departamento El departamento donde pertenecerá el trabajador
     * @param cargo EL cargo que tendrá la persona que hace parte de personal 
     * de servicio
     * @param documento Es el documento del personal de servicio. 
     * @param tipo_documento Cada documento tiene un tipo, este tipo depende de 
     * la edad del personal de servicio. Esto varía por cada país. Para mayores de edad, en 
     * algunos paises se nombra Cedula de Ciudadanía, en otras DNI.
     * @param primer_nombre El primer nombre del personal de servicio
     * @param segundo_nombre El segundo nombre del personal de servicio
     * @param primer_apellido El primer apellido del personal de servicio
     * @param segundo_apellido El segundo apellido del personal de servicio
     * @param edad La edad del personal de servicio.
     * @param genero El género del personal de servicio. (Masculino-femenino). No confundir 
     * con orientación sexual.
     * @param telefono El teléfono del personal de servicio. Puede ser teléfono fijo de casa,
     *  o teléfono celular.
     * @param usuario EL usuario que tendrá el personal de servicio
     * @param clave La clave que tendrá el personal de servicio dentro del sistema
     * @return Una nueva instancia de la clase <code>PersonalServicio</code>
     * @see PersonalServicio
     * @see Persona
     * @since 1.0
     */
    public static PersonalServicio agregarPersonalServicio(int numeroContrato, double salario, 
            String cargo, Departamento departamento, long documento, 
            String tipo_documento, String primer_nombre, String segundo_nombre, 
            String primer_apellido, String segundo_apellido, int edad, char genero, 
            long telefono, String usuario, String clave){
        
       return new PersonalServicio(numeroContrato, salario, cargo, departamento, documento, 
               tipo_documento, primer_nombre, segundo_nombre, primer_apellido, 
               segundo_apellido, edad, genero, telefono, usuario, clave);
    }
        /**
     * Método para crear una nueva instancia de la clase Acudiente mediante los 
     * parámetros de entada de la función
     * @param idAcudiente El id del acudiente, será un identificador para cada 
     * acudiente existente en el sistema
     * @param Parentesco El parentezco es el rasgo familiar que tiene el acudiente
     * con un estudiante. Existen varios ejemplos, como Padre, Madre, Hermano/a,
     *  Tutor, entre otros.
     * @param documento Es el documento del acudiente. 
     * @param tipo_documento Cada documento tiene un tipo, este tipo depende de 
     * la edad del acudiente. Esto varía por cada país. Para mayores de edad, en 
     * algunos paises se nombra Cedula de Ciudadanía, en otras DNI.
     * @param primer_nombre El primer nombre del acudiente
     * @param segundo_nombre El segundo nombre del acudiente
     * @param primer_apellido El primer apellido del acudiente
     * @param segundo_apellido El segundo apellido del acudiente
     * @param edad La edad del acudiente.
     * @param genero El género del acudiente. (Masculino-femenino). No confundir 
     * con orientación sexual.
     * @param telefono El teléfono del acudiente. Puede ser teléfono fijo de casa,
     *  o teléfono celular.
     * @param usuario EL usuario que tendrá el acudiente
     * @param clave La clave que tendrá el acudiente dentro del sistema
     * @return Una nueva instancia de la clase {@link modelo.Acudiente}
     * @see Acudiente
     * @see Persona
     * @since 1.0
     */
    public static Acudiente agregarAcudiente(int idAcudiente, String Parentesco, 
            long documento, String tipo_documento, String primer_nombre, 
            String segundo_nombre, String primer_apellido, String segundo_apellido, 
            int edad, char genero, long telefono, String usuario, String clave){
        
        return new Acudiente(idAcudiente, Parentesco, documento, 
                tipo_documento, primer_nombre, segundo_nombre, primer_apellido, 
                segundo_apellido, edad, genero, telefono, usuario, clave);
    }
        /**
     * Método para crear una nueva instancia de la clase Directivo mediante los 
     * parámetros de entada de la función
     * @param numeroContrato El número de contrato que tendrá
     * @param salario El salario que devengará el trabajador
     * @param departamento El departamento donde pertenecerá el trabajador
     * @param cargo El cargo que tedrá el directivo
     * @param documento Es el documento del acudiente. 
     * @param tipo_documento Cada documento tiene un tipo, este tipo depende de 
     * la edad del acudiente. Esto varía por cada país. Para mayores de edad, en 
     * algunos paises se nombra Cedula de Ciudadanía, en otras DNI.
     * @param primer_nombre El primer nombre del acudiente
     * @param segundo_nombre El segundo nombre del acudiente
     * @param primer_apellido El primer apellido del acudiente
     * @param segundo_apellido El segundo apellido del acudiente
     * @param edad La edad del acudiente.
     * @param genero El género del acudiente. (Masculino-femenino). No confundir 
     * con orientación sexual.
     * @param telefono El teléfono del acudiente. Puede ser teléfono fijo de casa,
     *  o teléfono celular.
     * @param usuario EL usuario que tendrá el acudiente
     * @param clave La clave que tendrá el acudiente dentro del sistema
     * @return Una nueva instancia de acudiente
     * @see Directivo
     * @see Persona
     * @since 1.0
     */
    public static Directivo agregarDirectivo(int numeroContrato, double salario, 
            String cargo, Departamento departamento, long documento, 
            String tipo_documento, String primer_nombre, String segundo_nombre, 
            String primer_apellido, String segundo_apellido, int edad, char genero, 
            long telefono, String usuario, String clave){
        
        return new Directivo(numeroContrato, salario, cargo, departamento, 
                documento, tipo_documento, primer_nombre, segundo_nombre, 
                primer_apellido, segundo_apellido, edad, genero, telefono, usuario, 
                clave);
    }
    /** 
     * El método <code>agregar</code> cumple la función de agregar cualquier 
     * objeto que venga de la clase padre <code>Persona</code>. Para ello verifica
     * que el objeto persona sea instancia de alguna de clases hijas de 
     * <code>Persona</code>
     * @param persona Objeto instaciado que pertenezca a una clase que sea hija
     * de la clase padre {@link modelo.Persona}
     * @return Verdadero si se agregó a la lista y al archivo, o falso en caso de
     * que uno de los 2 haya fallado.
     * @see ArrayList
     * @see Persona
     * @since 1.0
     */
    @Override
    public boolean agregar(T persona) {
        /*
        Parte para impresión y verificación de datos. Sirver simplemente para
        ver que los datos imrpesos por consola sean los mismo que los datos 
        ingresados mediante el formulario de la aplicación.
        */
        //persona es instancia de Estudiante?
        if(persona instanceof Estudiante){
            System.out.println((((Persona)persona).toString()) + " " + ((Estudiante)persona).toString());
            Estudiante e = (Estudiante)persona;
            for(int i = 0 ; i < e.getAcudientes().length; i++){
                System.out.println(e.getAcudientes()[i]);
            }
            
        } else if (persona instanceof Docente) {//persona es instancia de Docente?
            System.out.println((((Persona)persona).toString()) + " " + (((Trabajador)persona).toString()) + " " + ((Docente)persona).toString());
        }else if (persona instanceof Acudiente) {//persona es instancia de Acudiente?
            System.out.println(((Persona)persona).toString() + " " + ((Acudiente)persona).toString());
        }else if (persona instanceof Directivo) {//persona es instancia de Directivo?
            System.out.println(((Persona)persona).toString() + " " + ((Directivo)persona).toString());
        }else if (persona instanceof PersonalServicio) {//persona es instancia de PersonalServicio?
            System.out.println(((Persona)persona).toString() + " " + ((PersonalServicio)persona).toString());
        }
        /*
        Guarda el objeto en la lista (Memoria) y posteriormente en el archivo.
        */
        return this.personas.add(persona) && this.gestionArchivo.ingresarDato(persona);
    }

    /**
     * Método que sirve para buscar una persona dentro de la lista por su
     * documento. Devuelve falsao si no encontró nada
     * @param documento El documento de la persona a buscar
     * @return Verdadero si la persona está en la lista (Registrada), o falso si
     * no se encontró nada
     */
    @Override
    public boolean buscar(long documento) {
        for(int i = 0 ; i < this.personas.size(); i++){
            Persona p = (Persona)this.personas.get(i);
            if (p.getDocumento() == documento) return true;
        }
        return false;
    }
    
    /**
     * <p>Método que es parecido a {@link GestionPersonas(buscar)}, la diferencia es
     * que si encuentra alguna persona, devuelve la posición en la lista en donde
     * se encuentra.</p>
     * Se puede utilizar este método también como reemplazo de 
     * {@link GestionPersonas(buscar)}.
     * @param documento El documento de la persona a buscar
     * @return Un entero, el cual si se encuentra el objeto, retorna la posición
     * en donde está guardado en la lista, de lo contrario retorna -1.
     */
    @Override
    public int buscarObjeto(long documento) {
        for(int i = 0 ; i < this.personas.size(); i++){
            Persona p = (Persona)this.personas.get(i);
            if (p.getDocumento() == documento) return i;
        }
        return -1;
    }
    
    /**
     * <p><code>modificar</code> es un método para modificar un objeto guardado en
     * memoria. El funcionamiento es que reemplaza un objeto x por uno y con nuevos
     * valores modificados</p>.
     * @param obj Objeto modificado perteneciente a la clase persona o clases 
     * hijas.
     * @param documento Identificación para encontrar el objeto a modificar
     * @return Verdadero si se encontró y s emodificó correctamente el objeto,
     * falso si no se encontró el objeto en la lista
     */
    @Override
    public boolean modificar(T obj, long documento) {
        int index  = this.buscarObjeto(documento);
        if(index != -1){
            this.personas.remove(index);
            this.personas.add(index, (T)obj);
            return true;
        }
        return false;
    }

    /**
     * Método que se encarga de borrar un objeto de la clase persona o clases
     * hijas de la lista.
     * @param tipoPersona Es un entero que está definido en 
     * {@link controlador.PersonasConstantes}
     * @param id Identificador del objeto, puede ser un id de un objeto, como el
     * codigo del estudiante, el ID del acudiente, entre otros. Se elige 
     * dependiendo de la instancia de donde es el objeto.
     * @return Verdadero si se ha eliminado el objeto, falso si no se encontró o
     * no se pudo eliminar
     * @see Persona
     * @see PersonasConstantes
     * @since 1.0
     */
    @Override
    public boolean borrar(int tipoPersona, int id) {
        switch(tipoPersona){
            case 1: return borrarEstudiante(id);
            case 2: return borrarDocente(id);
            case 3: return borrarDirectivo(id);
            case 4: return borrarAcudiente(id);
            case 5: return borrarPersonalServicio(id);
        }
        return false;
    }

    @Override
    public T borrar(long documento) {
        int index = this.buscarObjeto(documento);
        if(index != -1){
            return (T)this.personas.remove(index);
        }
        return null;
    }

    public int obtenerCantidad(int tipoClase) {
        switch(tipoClase){
            case 1: return cantidadEstudiante();
            case 2: return cantidadDocente();
            case 3: return cantidadDirectivo();
            case 4: return cantidadAcudiente();
            case 5: return cantidadPersonalServicio();
        }
        return -1;
    }

    private int cantidadEstudiante() {
        int cant = 0;
        for(int i = 0 ; i < this.personas.size(); i++){
            Persona p = (Persona)this.personas.get(i);
            if (p instanceof Estudiante){
                cant++;
            }
        }
        return cant;
    }

    private int cantidadDocente() {
        int cant = 0;
        for (int i = 0; i < this.personas.size(); i++) {
            Persona p = (Persona)this.personas.get(i);
            if (p instanceof Docente) {
                cant++;
            }
        }
        return cant;
    }

    private int cantidadDirectivo() {
        int cant = 0;
        for(int i = 0 ; i < this.personas.size(); i++){
            Persona p = (Persona)this.personas.get(i);
            if (p instanceof Directivo){
                cant++;
            }
        }
        return cant;
    }

    private int cantidadAcudiente() {
        int cant = 0;
        for (int i = 0; i < this.personas.size(); i++) {
            Persona p = (Persona)this.personas.get(i);
            if (p instanceof Acudiente) {
                cant++;
            }
        }
        return cant;
    }

    private int cantidadPersonalServicio() {
        int cant = 0;
        for (int i = 0; i < this.personas.size(); i++) {
            Persona p = (Persona)this.personas.get(i);
            if (p instanceof PersonalServicio) {
                cant++;
            }
        }
        return cant;
    }

    private boolean borrarEstudiante(int id) {
        for (int i = 0; i < this.personas.size(); i++) {
            Persona p = (Persona)this.personas.get(i);
            if (p instanceof Estudiante) {
                Estudiante e = (Estudiante) p;
                if (e.getCodigo() == id) {
                    e = (Estudiante) this.personas.remove(i);
                    if (e != null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean borrarDocente(int id) {
        for (int i = 0; i < this.personas.size(); i++) {
            Persona p = (Persona)this.personas.get(i);
            if (p instanceof Docente) {
                Docente doc = (Docente) p;
                if (doc.getNumeroContrato() == id) {
                    doc = (Docente) this.personas.remove(i);
                    if (doc != null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean borrarDirectivo(int id) {
        for (int i = 0; i < this.personas.size(); i++) {
            Persona p = (Persona)this.personas.get(i);
            if (p instanceof Directivo) {
                Directivo d = (Directivo) p;
                if (d.getNumeroContrato() == id) {
                    d = (Directivo) this.personas.remove(i);
                    if (d != null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean borrarAcudiente(int id) {
        for (int i = 0; i < this.personas.size(); i++) {
            Persona p = (Persona)this.personas.get(i);
            if (p instanceof Acudiente) {
                Acudiente acudiente = (Acudiente) p;
                if (acudiente.getIdAcudiente() == id) {
                    acudiente = (Acudiente) this.personas.remove(i);
                    if (acudiente != null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean borrarPersonalServicio(int id) {
        for (int i = 0; i < this.personas.size(); i++) {
            Persona p = (Persona)this.personas.get(i);
            if (p instanceof PersonalServicio) {
                PersonalServicio ps = (PersonalServicio) p;
                if (ps.getNumeroContrato() == id) {
                    ps = (PersonalServicio) this.personas.remove(i);
                    if (ps != null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public int obtenerCantidad() {
        return this.personas.size();
    }

    public String[] obtenerCodigosEstudiantes() {
        ArrayList<String> estTemp = new ArrayList<>();
        for(int i = 0 ; i < this.obtenerCantidad(); i++){
            Persona p = (Persona)this.personas.get(i);
            
            if(p instanceof Estudiante){
                Estudiante e = (Estudiante)p;
                estTemp.add(e.getCodigo() + "");
            }
        }
        
        String[] codigos = new String[estTemp.size()];
        for(int i = 0 ; i < codigos.length; i++){
            codigos[i] = estTemp.get(i);
        }
        
        return codigos;
    }
    
    public String[][] obtenerCodigosEstudiantes(int columnas){
        ArrayList<ArrayList<String>> matriz = new ArrayList<>();
        int filas = 0;
        for(int i = 0 ; i < columnas; i++){
            matriz.add(new ArrayList<>());
        }
        
        for(int i = 0; i < this.obtenerCantidad(); i++){
            Persona p = (Persona)this.personas.get(i);
            if (p instanceof Estudiante){
                Estudiante e = (Estudiante)p;
                int codigo = e.getCodigo();
                String nombres = e.getPrimerNombre() + " " + e.getSegundoNombre();
                String apellidos = e.getPrimerApellido() + " " + e.getSegundoApellido();
                matriz.get(0).add(codigo + "");
                matriz.get(1).add(e.getTipoDocumento());
                matriz.get(2).add(e.getDocumento() + ""); 
                matriz.get(3).add(nombres);
                matriz.get(4).add(apellidos);
                matriz.get(5).add(e.getCurso().getNumCurso() + "");
                matriz.get(6).add(e.getEdad() + "");
                String genero = e.getGenero() == 'M' ? "Masculino" : "Femenino";
                matriz.get(7).add(genero);
                matriz.get(8).add(e.getTelefono() + "");
                matriz.get(9).add(e.getEstadoInscripcion());
                String placa = e.getRuta() != null ? e.getRuta().getPlaca() : "No Inscrito";
                matriz.get(10).add(placa);
                
                filas++;
            }
        }
        String estudiantes[][] = new String[filas][columnas];
        
        for(int i = 0; i < matriz.size(); i++){
            for(int j = 0; j < matriz.get(i).size(); j++){
                estudiantes[j][i] = matriz.get(i).get(j);
            }
        }
        return estudiantes;
    }
    
    public String[][] obtenerAcudientes(int columnas){
        ArrayList<ArrayList<String>> matriz = new ArrayList<>();
        int filas = 0;
        for(int i = 0 ; i < columnas; i++){
            matriz.add(new ArrayList<>());
        }
        
        for(int i = 0; i < this.obtenerCantidad(); i++){
            Persona p = (Persona)this.personas.get(i);
            if (p instanceof Acudiente){
                Acudiente a = (Acudiente)p;
                String nombres = a.getPrimerNombre() + " " + a.getSegundoNombre();
                String apellidos = a.getPrimerApellido() + " " + a.getSegundoApellido();
                
                matriz.get(0).add(a.getIdAcudiente() + "");
                matriz.get(1).add(a.getTipoDocumento());
                matriz.get(2).add(a.getDocumento() + ""); 
                matriz.get(3).add(nombres);
                matriz.get(4).add(apellidos);
                matriz.get(5).add(a.getParentesco());
                matriz.get(6).add(a.getEdad() + "");
                String genero = a.getGenero() == 'M' ? "Masculino" : "Femenino";
                matriz.get(7).add(genero);
                matriz.get(8).add(a.getTelefono() + "");
                
                filas++;
            }
        }
        String estudiantes[][] = new String[filas][columnas];
        
        for(int i = 0; i < matriz.size(); i++){
            for(int j = 0; j < matriz.get(i).size(); j++){
                estudiantes[j][i] = matriz.get(i).get(j);
            }
        }
        return estudiantes;
    }
    
    public String[][] obtenerDocentes(int columnas){
        ArrayList<ArrayList<String>> matriz = new ArrayList<>();
        int filas = 0;
        for(int i = 0 ; i < columnas; i++){
            matriz.add(new ArrayList<>());
        }
        
        for(int i = 0; i < this.obtenerCantidad(); i++){
            Persona p = (Persona)this.personas.get(i);
            if (p instanceof Docente){
                Docente d = (Docente)p;
                String nombres = d.getPrimerNombre() + " " + d.getSegundoNombre();
                String apellidos = d.getPrimerApellido() + " " + d.getSegundoApellido();
                
                matriz.get(0).add(d.getNumeroContrato() + "");
                matriz.get(1).add(d.getTipoDocumento());
                matriz.get(2).add(d.getDocumento() + ""); 
                matriz.get(3).add(nombres);
                matriz.get(4).add(apellidos);
                matriz.get(5).add(d.getEdad() + "");
                String genero = d.getGenero() == 'M' ? "Masculino" : "Femenino";
                matriz.get(6).add(genero);
                matriz.get(7).add(d.getTelefono() + "");
                
                filas++;
            }
        }
        String estudiantes[][] = new String[filas][columnas];
        
        for(int i = 0; i < matriz.size(); i++){
            for(int j = 0; j < matriz.get(i).size(); j++){
                estudiantes[j][i] = matriz.get(i).get(j);
            }
        }
        return estudiantes;
    }
    
    public String[][] obtenerDirectivos(int columnas){
        ArrayList<ArrayList<String>> matriz = new ArrayList<>();
        int filas = 0;
        for(int i = 0 ; i < columnas; i++){
            matriz.add(new ArrayList<>());
        }
        
        for(int i = 0; i < this.obtenerCantidad(); i++){
            Persona p = (Persona)this.personas.get(i);
            if (p instanceof Directivo){
                Directivo d = (Directivo)p;
                String nombres = d.getPrimerNombre() + " " + d.getSegundoNombre();
                String apellidos = d.getPrimerApellido() + " " + d.getSegundoApellido();
                
                matriz.get(0).add(d.getNumeroContrato() + "");
                matriz.get(1).add(d.getTipoDocumento());
                matriz.get(2).add(d.getDocumento() + ""); 
                matriz.get(3).add(nombres);
                matriz.get(4).add(apellidos);
                matriz.get(5).add(d.getEdad() + "");
                String genero = d.getGenero() == 'M' ? "Masculino" : "Femenino";
                matriz.get(6).add(genero);
                matriz.get(7).add(d.getTelefono() + "");
                
                filas++;
            }
        }
        String estudiantes[][] = new String[filas][columnas];
        
        for(int i = 0; i < matriz.size(); i++){
            for(int j = 0; j < matriz.get(i).size(); j++){
                estudiantes[j][i] = matriz.get(i).get(j);
            }
        }
        return estudiantes;
    }
    
    public String[][] obtenerPersonalServicio(int columnas) {
        ArrayList<ArrayList<String>> matriz = new ArrayList<>();
        int filas = 0;
        for (int i = 0; i < columnas; i++) {
            matriz.add(new ArrayList<>());
        }

        for (int i = 0; i < this.obtenerCantidad(); i++) {
            Persona p = (Persona) this.personas.get(i);
            if (p instanceof PersonalServicio) {
                PersonalServicio d = (PersonalServicio) p;
                String nombres = d.getPrimerNombre() + " " + d.getSegundoNombre();
                String apellidos = d.getPrimerApellido() + " " + d.getSegundoApellido();

                matriz.get(0).add(d.getNumeroContrato() + "");
                matriz.get(1).add(d.getTipoDocumento());
                matriz.get(2).add(d.getDocumento() + "");
                matriz.get(3).add(nombres);
                matriz.get(4).add(apellidos);
                matriz.get(5).add(d.getEdad() + "");
                String genero = d.getGenero() == 'M' ? "Masculino" : "Femenino";
                matriz.get(6).add(genero);
                matriz.get(7).add(d.getTelefono() + "");

                filas++;
            }
        }
        String estudiantes[][] = new String[filas][columnas];

        for (int i = 0; i < matriz.size(); i++) {
            for (int j = 0; j < matriz.get(i).size(); j++) {
                estudiantes[j][i] = matriz.get(i).get(j);
            }
        }
        return estudiantes;
    }

    public String[] obtenerInformacionEstudiante(int codigo) {
        String[] estudiante = new String[11];
        for(int i = 0 ; i < this.obtenerCantidad(); i++){
            Persona p = (Persona)this.personas.get(i);
            if (p instanceof Estudiante){
                Estudiante e = (Estudiante)p;
                if(e.getCodigo() == codigo){
                    estudiante[0] = "Documento: " + e.getDocumento() + "";
                    estudiante[1] = "Nombres: " + e.getPrimerNombre() +" " + e.getSegundoNombre();
                    estudiante[2] = "Apellidos: " + e.getPrimerApellido() + " " + e.getSegundoApellido();
                    estudiante[3] = "Género: " + e.getGenero() + "";
                    estudiante[4] = "RH: " + e.getRh();
                    estudiante[5] = "Fecha de Nacimiento: " + e.getFechaNam().getString(Fecha.FORMATO_FECHA_DIAG);
                    estudiante[6] = "Fecha de Inscripción: " + e.getFechaInscripcion().getString(Fecha.FORMATO_FECHA_DIAG);
                    estudiante[7] = "Estado: " + e.getEstadoInscripcion();
                    estudiante[8] = "EPS: " + e.getEps().getNombreEPS();
                    estudiante[9] = "Promedio: " + e.getPromedio() + "";
                    estudiante[10] = "Curso:" + e.getCurso().getNumCurso();
                }
            }
        }
        return estudiante;
    }

    @Override
    public T obtener(long documento) {
        for(int i = 0 ; i < this.obtenerCantidad(); i++){
            Persona p = (Persona)this.personas.get(i);
            if(p.getDocumento() == documento){
                return (T) p;
            }
        }
        return null;
    }

    public String[] obtenerDocentes() {
        ArrayList<String> docTemp = new ArrayList<>();
        for(int i = 0 ; i < this.obtenerCantidad(); i++){
            Persona p = (Persona)this.personas.get(i);
            if(p instanceof Docente){
                Docente d = (Docente)p;
                String nombres = p.getPrimerNombre() + " " + p.getSegundoNombre();
                String apellidos = p.getPrimerApellido() + " " + p.getSegundoApellido();
                docTemp.add(d.getNumeroContrato() + "-" + nombres + " " + apellidos);
            }
        }
        
        String[] docentes = new String[docTemp.size()];
        for(int i = 0 ; i < docentes.length; i++){
            docentes[i] = docTemp.get(i);
        }
        return docentes;
    }
    
    public String[] obtenerDocentesPorDocumento() {
        ArrayList<String> docTemp = new ArrayList<>();
        for(int i = 0 ; i < this.obtenerCantidad(); i++){
            Persona p = (Persona)this.personas.get(i);
            if(p instanceof Docente){
                String nombres = p.getPrimerNombre() + " " + p.getSegundoNombre();
                String apellidos = p.getPrimerApellido() + " " + p.getSegundoApellido();
                docTemp.add(p.getDocumento() + "-" + nombres + " " + apellidos);
            }
        }
        
        String[] docentes = new String[docTemp.size()];
        for(int i = 0 ; i < docentes.length; i++){
            docentes[i] = docTemp.get(i);
        }
        return docentes;
    }
    
    public String[] obtenerDirectivos() {
        ArrayList<String> direcTemp = new ArrayList<>();
        for(int i = 0 ; i < this.obtenerCantidad(); i++){
            Persona p = (Persona)this.personas.get(i);
            if(p instanceof Directivo){
                Directivo d = (Directivo)p;
                String nombres = p.getPrimerNombre() + " " + p.getSegundoNombre();
                String apellidos = p.getPrimerApellido() + " " + p.getSegundoApellido();
                direcTemp.add(d.getNumeroContrato() + "-" + nombres + " " + apellidos);
            }
        }
        
        String[] directivos = new String[direcTemp.size()];
        for(int i = 0 ; i < directivos.length; i++){
            directivos[i] = direcTemp.get(i);
        }
        return directivos;
    }
    
    public String[] obtenerDirectivosPorDocumento() {
        ArrayList<String> direcTemp = new ArrayList<>();
        for(int i = 0 ; i < this.obtenerCantidad(); i++){
            Persona p = (Persona)this.personas.get(i);
            if(p instanceof Directivo){
                String nombres = p.getPrimerNombre() + " " + p.getSegundoNombre();
                String apellidos = p.getPrimerApellido() + " " + p.getSegundoApellido();
                direcTemp.add(p.getDocumento() + "-" + nombres + " " + apellidos);
            }
        }
        
        String[] directivos = new String[direcTemp.size()];
        for(int i = 0 ; i < directivos.length; i++){
            directivos[i] = direcTemp.get(i);
        }
        return directivos;
    }

    public void agregarAcudienteTemp(long documento) {
        Acudiente acudiente = (Acudiente)this.obtener(documento);
        this.acudientesTemp.add(acudiente);
    }

    public String[] obtenerAcudientesTemp() {
        String[] acuTemp = new String[this.acudientesTemp.size()];
        
        for(int i = 0; i < acuTemp.length; i++){
            Acudiente a = this.acudientesTemp.get(i);
            String nombres = a.getPrimerNombre() + " " + a.getSegundoNombre();
            String apellidos = a.getPrimerApellido() + " " + a.getSegundoApellido();
            acuTemp[i] = a.getDocumento() + "-" + nombres + " " + apellidos;
        }
        return acuTemp;
    }

    public boolean quitarAcudienteTemp(long acudiente) {
        for(int i = 0 ; i < this.acudientesTemp.size(); i++){
            Acudiente a = this.acudientesTemp.get(i);
            
            if(a.getDocumento() == acudiente){
                a = this.acudientesTemp.remove(i);
                return a != null;
            }
        }
        return false;
    }

    public int obtenerCantAcudientesTemp() {
        return this.acudientesTemp.size();
    }
    
    public void borrarAcudienteTemp(){
        this.acudientesTemp.clear();
        if(this.acudientesTemp != null){
            acudientesTemp = null;
            acudientesTemp = new ArrayList<>();
        }
    }

    public Acudiente[] obtenerAcudientesTemporales() {
        Acudiente[] acudientes = new Acudiente[this.acudientesTemp.size()];
        
        for(int i = 0 ; i < acudientes.length; i++){
            acudientes[i] = this.acudientesTemp.get(i);
        }
        
        return acudientes;
    }

    public String[] obtenerAcudientes() {
        ArrayList<String> acuTemp = new ArrayList<>();
        for(int i = 0 ; i < this.obtenerCantidad(); i++){
            Persona p = (Persona)this.personas.get(i);
            if (p instanceof Acudiente){
                Acudiente a = (Acudiente)p;
                String nombres = p.getPrimerNombre() + " " + p.getSegundoNombre();
                String apellidos = p.getPrimerApellido() + " " + p.getSegundoApellido();
                acuTemp.add(a.getIdAcudiente() + "-" + nombres + " " + apellidos);
            }
        }
        
        String[] acudientes = new String[acuTemp.size()];
        
        for(int i = 0 ; i < acudientes.length; i++){
            acudientes[i] = acuTemp.get(i);
        }
        
        return acudientes;
    }

    public String[] obtenerAcudientesPorDocumento() {
        ArrayList<String> acuTemp = new ArrayList<>();
        for (int i = 0; i < this.obtenerCantidad(); i++) {
            Persona p = (Persona) this.personas.get(i);
            if (p instanceof Acudiente) {
                String nombres = p.getPrimerNombre() + " " + p.getSegundoNombre();
                String apellidos = p.getPrimerApellido() + " " + p.getSegundoApellido();
                acuTemp.add(p.getDocumento() + "-" + nombres + " " + apellidos);
            }
        }

        String[] acudientes = new String[acuTemp.size()];

        for (int i = 0; i < acudientes.length; i++) {
            acudientes[i] = acuTemp.get(i);
        }

        return acudientes;
    }

    public boolean existeTrabajadorPorContrato(int numero_contrato) {
        for(int i = 0 ; i < this.obtenerCantidad(); i++){
            Persona p = (Persona)this.personas.get(i);
            if(p instanceof Docente){
                Docente doc = (Docente)p;
                if(doc.getNumeroContrato() == numero_contrato){
                    return true;
                }
            }else if (p instanceof Directivo){
                Directivo dir = (Directivo)p;
                if(dir.getNumeroContrato() == numero_contrato){
                    return true;
                }
            }else if (p instanceof PersonalServicio){
                PersonalServicio per = (PersonalServicio)p;
                if(per.getNumeroContrato() == numero_contrato){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean existeEstudiantePorCodigo(int codigo) {
        for(int i = 0 ; i < this.obtenerCantidad(); i++){
            Persona p = (Persona)this.personas.get(i);
            if(p instanceof Estudiante && (((Estudiante)p).getCodigo()) == codigo){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean buscar(Object id) {
        String value = String.valueOf(id);
        long documento = Long.parseLong(value);
        for(int i = 0 ; i < this.obtenerCantidad(); i++){
            Persona p = (Persona)this.personas.get(i);
            if(p.getDocumento() == documento){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean modificar(T obj, Object id) {
        String value = String.valueOf(id);
        long documento = Long.parseLong(value);
        int index = this.buscarObjeto(documento);
        if (index != -1) {
            this.personas.add(index, (T)obj);
            return true;
        }
        return false;
    }

    public String[] obtenerEstudiantePorCurso(int curso) {
        ArrayList<String> estTemp = new ArrayList<>();
        
        for(int i = 0 ; i < this.obtenerCantidad(); i++){
            Persona p = (Persona)this.personas.get(i);
            
            if(p instanceof Estudiante){
                Estudiante e = (Estudiante)p;
                if(e.getCurso().getNumCurso() == curso){
                    String nombres = e.getPrimerNombre() + " " + e.getSegundoNombre();
                    String apellidos = e.getPrimerApellido() + " " + e.getSegundoApellido();
                    estTemp.add(e.getDocumento() + "-" + nombres + " " + apellidos);
                }
            }
        }
        
        String estudiantes[] = new String[estTemp.size()];
        
        for(int i = 0; i < estudiantes.length; i++){
            estudiantes[i] = estTemp.get(i);
        }
        
        return estudiantes;
    }

    public boolean agregarEstudianteARuta(long documento[], Ruta ruta) {
        boolean modificar = false;
        for(int i = 0; i < this.obtenerCantidad(); i++){
            for(int j = 0 ; j < documento.length; j++){
                Persona p = (Persona)this.personas.get(i);
                
                if(p instanceof Estudiante){
                    Estudiante e = (Estudiante)p;
                    if(e.getDocumento() == documento[j]){
                        e.setRuta(ruta);
                        System.out.println(((Estudiante)this.personas.get(i)).getRuta().getPlaca());
                        modificar = this.gestionArchivo.modificarDato((T)e, GestionArchivo.PERSONA);
                    }
                }
            }
        }
        return modificar;
    }

    private void cargarDatos() {
        this.personas = this.gestionArchivo.obtenerTodosLosElementos();
    }

    public int obtenerCantidadDeudas() {
        int cant = 0;
        for(int i = 0 ; i < this.obtenerCantidad(); i++){
            Persona p = (Persona)this.personas.get(i);
            if(p instanceof Estudiante){
                Estudiante e = (Estudiante)p;
                if(e.getDeudas()!= null)cant+=e.getDeudas().size();
            }
        }
        return cant;
    }

    public boolean asignarDeudaAEstudiante(Deuda d, int codigo) {
        Estudiante e = null;
        for(int i = 0 ; i < this.obtenerCantidad(); i++){
            Persona p = (Persona)this.personas.get(i);
            if(p instanceof Estudiante){
                Estudiante es = (Estudiante)p;
                if(es.getCodigo() == codigo) e = es;
            }
        }
        
        if(e != null){
            if(e.getDeudas() == null){
                e.setDeudas(new ArrayList<>());
            }
            boolean x = e.getDeudas().add(d);
            return x && this.gestionArchivo.modificarDato((T)e, GestionArchivo.PERSONA);
        }
        return false;
    }

    public String[][] obtenerDeudasDeEstudiantes(int columnas) {
        int filas = this.obtenerCantidadDeudas();
        String[][] deudas = new String[filas][columnas];
        //Contador para los elementos (filas) actuales agregados a la matriz
        int contadorActual = 0;
        for (int i = 0; i < this.obtenerCantidad(); i++) {
            Persona p = (Persona) this.personas.get(i);
            if (p instanceof Estudiante) {
                Estudiante e = (Estudiante) p;
                if (e.getDeudas() != null) {
                    for (int j = 0; j < e.getDeudas().size(); j++) {
                        deudas[contadorActual][0] = e.getDeudas().get(j).getIdDeuda() + "";
                        deudas[contadorActual][1] = e.getDeudas().get(j).getValor() + "";
                        deudas[contadorActual][2] = e.getDeudas().get(j).getDescripcion();
                        deudas[contadorActual][3] = e.getCodigo() + "";
                        contadorActual++;
                    }
                }
            }
        }
        return deudas;
    }

    public String[][] obtenerPersonasRegistradas(int columnas) {
        String[][] personas = new String[this.obtenerCantidad()][columnas];
        for(int i = 0 ; i < this.obtenerCantidad(); i++){
            Persona p = (Persona)this.personas.get(i);
            String nombres = p.getPrimerNombre() + " " + p.getSegundoNombre();
            String apellidos = p.getPrimerApellido() + " " + p.getSegundoApellido();
            personas[i][0] = p.getDocumento() + "";
            personas[i][1] = p.getTipoDocumento();
            personas[i][2] = nombres;
            personas[i][3] = apellidos;
            personas[i][4] = p.getEdad() + "";
            personas[i][5] = new StringBuilder().append("").append(p.getGenero()).toString();
            personas[i][6] = p.getTelefono() + "";
            String tipoPersona = "";
            if(p instanceof Estudiante){
                tipoPersona = "Estudiante";
            }else if (p instanceof Docente){
                tipoPersona = "Docente";
            }else if(p instanceof PersonalServicio){
                tipoPersona = "Personal de Servicio";
            }else if(p instanceof Acudiente){
                tipoPersona = "Acudiente";
            }else if(p instanceof Directivo){
                tipoPersona = "Directivo";
            }
            personas[i][7] = tipoPersona;
        }
        return personas;
    }

    public boolean eliminarRutasDeEstudiantes(String placa) {
        boolean est = false;
        
        for(int i = 0 ; i < this.obtenerCantidad(); i++){
            Persona p = (Persona)this.personas.get(i);
            if(p instanceof Estudiante){
                Estudiante e = (Estudiante)p;
                if(e.getRuta() != null){
                    if(e.getRuta().getPlaca().equals(placa)){
                        e.setRuta(null);
                        est = this.gestionArchivo.modificarDato((T) e, GestionArchivo.PERSONA);
                    }
                }
            }
        }
        return est;
    }
}
