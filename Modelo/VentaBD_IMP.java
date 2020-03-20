package Modelo;

import Controlador.ConexionBD;
import java.sql.SQLException;
import java.util.List;

public class VentaBD_IMP implements VentaBD {
    ConexionBD conexBD = new ConexionBD("localhost",3306,"Almacen","root","JLDI02092102");
    
    @Override
    public boolean create(Venta venta) {
        boolean operacionExitosa = false;
        try{
            conexBD.update("INSERT INTO Venta VALUES ("
                    + "NULL, "
                    + venta.getAñoVenta()+", "
                    + venta.getMesVenta() +", "
                    + venta.getDiaVenta()+", "
                    + venta.getHoraVenta()+", "
                    + venta.getCantidad()+")"
            );
            operacionExitosa = true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return operacionExitosa;
    }
    
    @Override
    public boolean create(int cantidad) {
        boolean operacionExitosa = false;
        try{
            conexBD.update("INSERT INTO Venta VALUES ("
                    + "NULL, "
                    + "NOW(), "
                    + cantidad+")"
            );
            operacionExitosa = true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return operacionExitosa;
    }

    @Override
    public List<Venta> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Articulo read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(String claveArticulo, int cantidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String folio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
