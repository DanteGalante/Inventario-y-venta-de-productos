package Modelo;

import Controlador.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * Clave: ArticuloBDImplementado
 * Descripcion: implementa los metodos de la interfaz InterfazArticuloBD
 * @author Pale Parra
 * @version 16/03/2020
 */
public class ArticuloBD_IMP implements ArticuloBD{
    ConexionBD conexBD = new ConexionBD("localhost",3306,"Almacen","root","JLDI02092102");
    
    @Override
    public boolean create(Articulo articulo) {
        boolean creado = false;
        String sql = "INSERT INTO Productos values ("
                +"'"
                +articulo.getClave()+
                "','"
                +articulo.getNombre()+
                "','"
                +articulo.getDescripcion()+
                "','"
                +articulo.getUnidad()+
                "',"
                +articulo.getCantidad()+
                ","
                +articulo.getPrecioUni()+")";
        
        
        System.out.println(sql);
        
        
        try{
            conexBD.update(sql);
            creado = true;
        } catch (SQLException ex) {
            System.out.println("\nError al crear un nuevo articulo en el almacen\n");
            ex.printStackTrace();
        }
        return creado;
    }

    @Override
    public List<Articulo> readAll() {
        Statement stm = null;
        ResultSet rs = null;
        List<Articulo> listaArticulos = new ArrayList<Articulo>();
        String sql = "SELECT * FROM Productos";
        try{
            Connection conn = conexBD.getConn();
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
                listaArticulos.add(
                    new Articulo(
                        rs.getString("clave")
                        ,rs.getString("nombre")
                        ,rs.getString("descripcion")
                        ,rs.getString("unidad")
                        ,rs.getInt("cantidad")
                        ,rs.getDouble("precioUni")
                    )
                );
            }
            stm.close();
            rs.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listaArticulos;
    }

    @Override
    public Articulo read(String clave) {
        Articulo arti = null;
        Statement stm = null;
        ResultSet rs = null;
        
        
        System.out.println("FUERON CREADAS LAS VARIABLES INICIALES\n");
        
        
        try{
            stm = conexBD.query("SELECT * FROM Productos WHERE clave = '"+clave+"'");
            rs = stm.getResultSet();
            
            System.out.println("EL RESULT SET SE LE ASIGNO UN VALOR");
                    
            arti = new Articulo(
                        rs.getString(1)
                        ,rs.getString(2)
                        ,rs.getString(3)
                        ,rs.getString(4)
                        ,rs.getInt(5)
                        ,rs.getDouble("6")
                    );
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return arti;
    }

@Override
    public boolean update(String claveArticulo, String contenido, int opc) {
        boolean operacionExitosa = false;
        try{
            switch(opc){
                case 1: //En caso de que se quiera modificar la clave
                    conexBD.update("UPDATE Productos SET Clave = '"+contenido+"' WHERE Clave = '"+claveArticulo+"'");
                    operacionExitosa = true;
                break;
                case 2: //En caso de que se quiera modificar el nombre
                    conexBD.update("UPDATE Productos SET Nombre = '"+contenido+"' WHERE Clave = '"+claveArticulo+"'");
                    operacionExitosa = true;
                break;
                case 3: //En caso de que se quiera modificar la descripción
                    conexBD.update("UPDATE Productos SET Descripcion = '"+contenido+"' WHERE Clave = '"+claveArticulo+"'");
                    operacionExitosa = true;
                break;
                case 4: //En caso de que se quiera modificar la unidad
                    conexBD.update("UPDATE Productos SET Unidad = '"+contenido+"' WHERE Clave = '"+claveArticulo+"'");
                    operacionExitosa = true;
                break;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return operacionExitosa;
    }

    @Override
    public boolean update(String claveArticulo, int cantidad) {
        boolean operacionExitosa = false;
        try{
            conexBD.update("UPDATE Productos SET cantidad = "+cantidad+" WHERE Clave = '"+claveArticulo+"'");
            operacionExitosa = true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return operacionExitosa;
    }

    @Override
    public boolean update(String claveArticulo, double precio) {
        boolean operacionExitosa = false;
        try{
            conexBD.update("UPDATE Productos SET PrecioUni = "+precio+" WHERE Clave = '"+claveArticulo+"'");
            operacionExitosa = true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return operacionExitosa;
    }

    @Override
    public boolean delete(Articulo articulo) {
        String sql = "DELETE * FROM Productos WHERE clave = '"+articulo.getClave()+"'";
        boolean borrado = false;
        try{
            conexBD.update(sql);
            borrado = true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return borrado;
    }

    @Override
    public boolean delete(String clave) {
        String sql = "DELETE FROM Productos WHERE clave = '"+clave+"'";
        boolean borrado = false;
        try{
            conexBD.update(sql);
            borrado = true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return borrado;
    }

}
