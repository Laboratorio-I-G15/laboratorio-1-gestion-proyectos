/*
Clase modelo Miembro para el proyecto de gestion - Laboratorio 1.
 */
package models;

/**
 *
 * @author leo_t
 */
public class Miembro {
    private int idMiembro;
    private long dni;
    private String apellido;
    private String nombre;
    private boolean estado;
    
    /**
     * Constructor vacio para utilizar metodos get y set
     */
    public Miembro() {
    }
    /**
     * Constructor parametrizado con todos los atributos
     * @param idMiembro
     * @param dni
     * @param apellido
     * @param nombre
     * @param estado 
     */
    public Miembro(int idMiembro, long dni, String apellido, String nombre, boolean estado) {
        this.idMiembro = idMiembro;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.estado = estado;
    }
/**
 * Contructor parametrizado pero sin el idMiembro
 * @param dni
 * @param apellido
 * @param nombre
 * @param estado 
 */
    public Miembro(long dni, String apellido, String nombre, boolean estado) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.estado = estado;
    }

    /** 
    * Meotodos getter & setter para el acceso 
    * a los atributos del objeto usando encapsulamiento.
    */
    public int getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(int idMiembro) {
        this.idMiembro = idMiembro;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
    return "Miembro = " + idMiembro + 
        "\n, dni=" + dni + 
        "\n, apellido=" + apellido + 
        "\n, nombre=" + nombre + 
        "\n, estado=" + estado;
    }
}
