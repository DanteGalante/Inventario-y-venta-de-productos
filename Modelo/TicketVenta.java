package Modelo;
/**
 * Clave: TicketVenta
 * Descripcion: Clase que muestra la relacion entre un articulo vendido y su venta
 * @author Dan Javier
 * @version 16/03/2020
 */

public class TicketVenta {
    private double precioTotal;
    private int folio_venta;
    private String clave_producto;
    /**
     * Metodo contructor parametrizado
     * @param folio folio que identifica al conjunto de ventas
     * @param precioTotal precio total de la venta
     * @param folio_venta folio de la venta que se registra
     * @param clave_producto  folio del articulo vendido
     */
    public TicketVenta(int folio, double precioTotal, int folio_venta, String clave_producto) {
        this.precioTotal = precioTotal;
        this.folio_venta = folio_venta;
        this.clave_producto = clave_producto;
    }
    /**
     * Constructor sin parametros
     */
    public TicketVenta() {
    }

    public TicketVenta(double precioTotal, int folio_venta, String clave_producto) {
        this.precioTotal = precioTotal;
        this.folio_venta = folio_venta;
        this.clave_producto = clave_producto;
    }
    /**
     * Metodo que retorna el precio total de la venta, el precio de venta tiene una ganancia del 30%
     * @return precio total de venta
     */
    public double getPrecioTotal() {
        return precioTotal;
    }
    /**
     * Metodo que asigna un valor al precio total de la venta
     * @param precioTotal 
     */
    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
    /**
     * Metodo que retorna el folio de la venta de un articulo
     * @return folio de la venta del articulo
     */
    public int getFolio_venta() {
        return folio_venta;
    }
    /**
     * Metodo que asigna un valor al folio de la vena de un articulo
     * @param folio_venta 
     */
    public void setFolio_venta(int folio_venta) {
        this.folio_venta = folio_venta;
    }

    public String getClave_producto() {
        return clave_producto;
    }

    public void setClave_producto(String clave_producto) {
        this.clave_producto = clave_producto;
    }
}
