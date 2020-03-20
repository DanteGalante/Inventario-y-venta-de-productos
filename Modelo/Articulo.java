 package Modelo;
/**
* Clave: Articulo                                                                                        
* @author  Dan Javier
* @version  13/03/2020
* Descripción: Clase Articulo que guarda temporalmente la informacion del articulo obtenida de la base de datos
*/
public class Articulo {
    String clave;
    String nombre;
    String descripcion;
    String unidad;
    int cantidad;
    double precioUni;
    /**
     * Metodo constructor parametrizado
     * @param clave clave del articulo, su identificador en el sistema
     * @param nombre nombre del articulo, su identificador para clientes
     * @param descripcion descripcion breve sobre el producto
     * @param unidad en que unidad se esta vendiendo (kg,gr,l,unidad...)
     * @param cantidad cantidad del articulo en el almacen
     * @param precionUni precio por unidad
     */

    public Articulo(String clave, String nombre, String descripcion, String unidad, int cantidad, double precionUni) {
        this.clave = clave;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidad = unidad;
        this.cantidad = cantidad;
        this.precioUni = precionUni;
    }
    /** 
     * Metodo constructor sin parametros
     */
    public Articulo(){
        clave = "";
        nombre = "";
        descripcion = "";
        unidad = "";
        cantidad = 0;
        precioUni = 0.0;
    }
    /**
     * retorna la clave del articulo 
     * @return 
     */
    public String getClave() {
        return clave;
    }
    /**
     * establece un valor para el atributo clave
     * @param clave 
     */
    public void setClave(String clave) {
        this.clave = clave;
    }
    /**
     * retorna el nombre del articulo 
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * establece un valor para el atributo nombre
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * retorna la descripcion del articulo 
     * @return 
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * establece un valor para el atributo descripcion
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * retorna la unidad en la que se vende el articulo 
     * @return 
     */
    public String getUnidad() {
        return unidad;
    }
    /**
     * establece un valor para el atributo unidad
     * @param unidad 
     */
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
    /**
     * retorna la cantidad del articulo en almacen 
     * @return 
     */
    public int getCantidad() {
        return cantidad;
    }
    /**
     * establece un valor para el atributo cantidad
     * @param cantidad 
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    /**
     * retorna el precio por unidad del articulo
     * @return 
     */
    public double getPrecioUni() {
        return precioUni;
    }
    /**
     * establece un valor para el atributo precioUni
     * @param precionUni 
     */
    public void setPrecioUni(double precionUni) {
        this.precioUni = precionUni;
    }
    
}
