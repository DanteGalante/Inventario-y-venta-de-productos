package Modelo;
import java.util.List;

public interface TicketVentaBD {
    public boolean create(TicketVenta ticketVenta);
    public List<TicketVenta> readAll();
    public TicketVenta read(int folioTkVenta);
    public boolean update(int folioActual, int folio, int opc); //Modifica el folio del ticket de venta o el folio de la venta
    public boolean update(int folioActual, double precioTotal); //Modifica el precio total refleado en el ticket de venta
    public boolean update(int folioActual, String claveProducto); //Modifica la clave del producto relacionado con la venta
    public boolean delete(Articulo articulo);
    public boolean delete(String clave);
}
