package Modelo;
/**
 * Clave: InterfazArticuloBD
 * Descripcion: Interfaz que muestra todos los metodos que seran implementados, metodos que sirven para interactuar con la base de datos
 * @Autor Dan Javier
 * @Version 16/03/2020
 */
import java.util.List;

public interface ArticuloBD {
    /**
     * Crea un articulo nuevo en la base de datos
     * @param articulo objeto "Articulo" que sera agregado a la base de datos
     * @return valor booleano que indica si el articulo fue guardado en la base de datos correctamente
     */
    public boolean create(Articulo articulo);
    /**
     * Retorna una lista con todos los articulos que se encuentran registrados en la base de datos
     * @return lista de todos los articulos en base de datos
     */
    public List<Articulo> readAll();
    /**
     * Retorna un articulo de la base de datos tomando la clave como identificador a buscar
     * @param clave clave del Articulo que sirve para buscar el articulo deseado en la base de datos
     * @return objeto Articulo buscado
     */
    public Articulo read(String clave);
    /**
     * Modifica la clave, el nombre, la descripcion o la unidad del articulo en la base de datos
     * @param claveArticulo clave del articulo para buscarlo en la base de datos
     * @param contenido valor nuevo de cualquiera de los atributos con tipo String en Articulo (clave,nombre,descripcion,unidad)
     * @param opc valor numerico para indicar que atributo se quiere modificar
     * @return valor booleano que indica si el articulo fue modificado en la base de datos correctamente
     */
    public boolean update(String claveArticulo, String contenido, int opc); 
    /**
     * Modifica la cantidad con la que cuenta un articulo en la base de datos
     * @param claveArticulo clave del articulo para buscarlo en la base de datos
     * @param cantidad nuevo valor para la cantidad de un articulo en la base de datos
     * @return valor booleano que indica si el articulo fue modificado en la base de datos correctamente
     */
    public boolean update(String claveArticulo, int cantidad);
    /**
     * Modifica el precio del articulo en la base de datos
     * @param claveArticulo clave del articulo para buscarlo en la base de datos
     * @param precio nuevo valor para el precio de un articulo en la base de datos
     * @return valor booleano que indica si el articulo fue modificado en la base de datos correctamente
     */
    public boolean update(String claveArticulo, double precio);
    /**
     * Borra un articulo en la base de datos
     * @param articulo Objeto articulo que se desea borrar en la base de datos
     * @return valor booleano que indica si el articulo fue eliminado correctamente de la base de datos
     */
    public boolean delete(Articulo articulo);
    /**
     * Borra un articulo en la base de datos tomando en cuenta una clave de articulo
     * @param clave valor que indica la clave del articulo que se desea borrar en la base de datos
     * @return valor booleano que indica si el articulo fue eliminado correctamente de la base de datos
     */
    public boolean delete(String clave);
}
