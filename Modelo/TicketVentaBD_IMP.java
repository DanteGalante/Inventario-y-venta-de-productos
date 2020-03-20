package Modelo;

import Controlador.ConexionBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TicketVentaBD_IMP implements TicketVentaBD{
    ConexionBD conexBD = new ConexionBD("localhost",3306,"Almacen","root","JLDI02092102");
    
    @Override
    public boolean create(TicketVenta ticketVenta) {
        boolean operacionExitosa = false;
        try{
            conexBD.update("INSERT INTO registrarVenta VALUES (NULL,"
                    +ticketVenta.getPrecioTotal()+","
                    +ticketVenta.getFolio_venta()+","
                    +ticketVenta.getClave_producto()+")"
            );
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return operacionExitosa;
    }

    @Override
    public List<TicketVenta> readAll() {
        List<TicketVenta> listaTicketVenta = new ArrayList<TicketVenta>();
        Statement stm = null;
        ResultSet rs = null;
        try{
            rs = stm.executeQuery("SELECT * FROM registrarVenta");
            while(rs.next()){
                listaTicketVenta.add(new TicketVenta(
                        rs.getInt("folioVenta"),
                        rs.getDouble("precioTotal"),
                        rs.getInt("folio_Venta"),
                        rs.getString("clave_Producto")
                ));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return listaTicketVenta;
    }

    @Override
    public TicketVenta read(int folioTkVenta) {
        ResultSet rs = null;
        Statement stm = null;
        TicketVenta tkVenta = null;
        
        try{
            rs = stm.executeQuery("SELECT * FROM registrarVenta WHERE Clave = '"+folioTkVenta+"'");
            tkVenta = new TicketVenta(rs.getInt("folioVenta"),rs.getDouble("precioTotal"),rs.getInt("folio_Venta"),rs.getString("clave_Producto"));
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return tkVenta;
    }

    @Override
    public boolean update(int folioActual, int folio, int opc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(int folioActual, double precioTotal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(int folioActual, String claveProducto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Articulo articulo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String clave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
