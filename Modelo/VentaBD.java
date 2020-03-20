package Modelo;

import java.util.List;

public interface VentaBD {
    public boolean create(Venta venta);
    public boolean create(int cantidad);
    public List<Venta> readAll();
    public Articulo read();    
    public boolean update(String claveArticulo, int cantidad); //Modifica la cantidad de productos vendidos
    public boolean delete(String folio);
}
