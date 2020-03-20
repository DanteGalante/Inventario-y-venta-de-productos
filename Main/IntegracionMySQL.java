package Main;

import Controlador.Operaciones;

/*
import Controlador.ConexionBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
*/


public class IntegracionMySQL{
    public static void main(String[] args) {
    Operaciones opera = new Operaciones();
    opera.iniciar();
        
        /*
        try{
            conn = new ConexionBD("localhost",3306,"Almacen","root","JLDI02092102");
            
            while(opc!=6){
                menu();
                print("\nOPC:");
                opc = sc.nextInt();
                print("\n");
                switch(opc){
                    case 1: //MOSTRAR INVENTARIO <---
                       consulta = String.format("SELECT * FROM Productos;");
                       try{
                            rs = conn.query(consulta).getResultSet();
                       
                            if(rs!=null){
                                print("INVENTARIO:\n");
                                while(rs.next()){
                                    clave = (rs.getString("Clave")!=null)?
                                            rs.getString("Clave").toString()
                                            :
                                            null;
                                    nombre = (rs.getString("Nombre")!=null)?
                                            rs.getString("Nombre").toString()
                                            :
                                            null;
                                    print("clave: "+clave+"\n");
                                    print("nombre: "+nombre+"\n\n");
                                }
                            }else{
                                print("No hay inventario");
                            }
                       }catch(SQLException e){
                           e.printStackTrace();
                       }
                    break;
                    case 2: //DAR DE ALTA PRODUCTO <---
                       sc.nextLine();
                       print("Clave: \n");clave = sc.nextLine();
                       print("Nombre: \n");nombre = sc.nextLine();
                       print("Descripcion: \n");desc = sc.nextLine();
                       print("Unidad: \n");unit = sc.nextLine();
                       print("Cantidad: \n");cant = sc.nextInt();
                       print("Precio: \n");precio = sc.nextDouble();
                       
                       instruccion = String.format("INSERT INTO Productos VALUES ('"+clave+"','"+nombre+"','"+desc+"','"+unit+"',"+cant+","+precio+")");
                       conn.update(instruccion);
                    break;
                    case 3: // DAR DE BAJA PRODUCTO <---
                        sc.nextLine();
                        print("Clave: ");
                        clave = sc.nextLine();
                        instruccion = String.format("DELETE FROM Productos WHERE clave='"+clave+"';");
                        conn.update(instruccion);
                        /*
                        ResultSet rs = conn.query(consulta).getResultSet();
                        if (rs != null) {
                            while (rs.next()){
                                String placa = (rs.getString("placa")!=null)?
                                rs.getString("placa").toString():null;
                                String modelo = (rs.getString("modelo")!=null)?
                        
                        
                                rs.getString("modelo").toString():"";
                                System.out.println(placa+":"+modelo);
                            }
                        }
                        
                    break;
                    case 4:
                        sc.nextLine();
                        print("Clave: ");
                        clave = sc.nextLine();
                        instruccion = String.format("SELECT * FROM Productos WHERE Clave = '"+clave+"';");
                        rs = conn.query(instruccion).getResultSet();
                        try{
                            rs = conn.query(instruccion).getResultSet();
                       
                            if(rs!=null){
                                while(rs.next()){
                                    clave = (rs.getString("Clave")!=null)?
                                            rs.getString("Clave").toString()
                                            :
                                            null;
                                    nombre = (rs.getString("Nombre")!=null)?
                                            rs.getString("Nombre").toString()
                                            :
                                            null;
                                    desc = (rs.getString("descripcion")!=null)?
                                            rs.getString("descripcion").toString()
                                            :
                                            null;
                                    unit = (rs.getString("unidad")!=null)?
                                            rs.getString("unidad").toString()
                                            :
                                            null;
                                    cant = (rs.getInt("cantidad")!=0)?
                                            rs.getInt("cantidad")
                                            :
                                            0;
                                    precio = (rs.getDouble("precioUni")!=0)?
                                            rs.getDouble("precioUni")
                                            :
                                            0.0;
                                    print("clave: "+clave+"\n");
                                    print("nombre: "+nombre+"\n");
                                    print("descripcion: "+desc+"\n");
                                    print("unidad: "+unit+"\n");
                                    print("cantidad: "+cant+"\n");
                                    print("precio: "+precio+"\n\n");
                                }
                            }else{
                                print("No hay inventario");
                            }
                       }catch(SQLException e){
                           e.printStackTrace();
                       }
                    break;
                    case 5:
                        sc.nextLine();
                        print("Escriba la clave del producto que desea modificar\n");
                        print("Clave: ");
                        clave = sc.nextLine();
                        opc = 0;
                        while(opc!=7){
                            print("|::::::::::::::::::::::::::::|\n");
                            print("|           <MENU>           |\n");
                            print("|1. Modificar clave          |\n");
                            print("|2. Modificar nombre         |\n");
                            print("|3. Modificar descripcion    |\n");
                            print("|4. Modificar unidad         |\n");
                            print("|5. Modificar cantidad       |\n");
                            print("|6. Modificar precio unitario|\n");
                            print("|7. Salir                    |\n");
                            print("|::::::::::::::::::::::::::::|\n");
                            
                            print("\nOPC: ");opc = sc.nextInt();print("\n");
                            switch(opc){
                                case 1:
                                    sc.nextLine();
                                    print("Escriba la clave nueva:\n");
                                    nuevosDatos = sc.nextLine();
                                    instruccion = String.format("UPDATE Productos SET clave='"+nuevosDatos+"' WHERE Clave='"+clave+"';");
                                    conn.update(instruccion);
                                break;
                                case 2:
                                    sc.nextLine();
                                    print("Escriba el nuevo nombre:\n");
                                    nuevosDatos = sc.nextLine();
                                    instruccion = String.format("UPDATE Productos SET nombre='"+nuevosDatos+"' WHERE Clave='"+clave+"';");
                                    conn.update(instruccion);
                                break;
                                case 3:
                                    sc.nextLine();
                                    print("Escriba nueva descripción:\n");
                                    nuevosDatos = sc.nextLine();
                                    instruccion = String.format("UPDATE Productos SET descripcion='"+nuevosDatos+"' WHERE Clave='"+clave+"';");
                                    conn.update(instruccion);
                                break;
                                case 4:
                                    sc.nextLine();
                                    print("Escriba la nueva unidad\n");
                                    nuevosDatos = sc.nextLine();
                                    instruccion = String.format("UPDATE Productos SET unidad='"+nuevosDatos+"' WHERE Clave='"+clave+"';");
                                    conn.update(instruccion);
                                break;
                                case 5:
                                    sc.nextLine();
                                    print("Escriba la nueva cantidad\n");
                                    nuevoCant = sc.nextInt();
                                    instruccion = String.format("UPDATE Productos SET cantidad="+nuevoCant+" WHERE Clave='"+clave+"';");
                                    conn.update(instruccion);
                                break;
                                case 6:
                                    sc.nextLine();
                                    print("Escriba el nuevo precio unitario\n");
                                    nuevoPrecio = sc.nextDouble();
                                    instruccion = String.format("UPDATE Productos SET precioUni="+nuevoPrecio+" WHERE Clave='"+clave+"';");
                                    conn.update(instruccion);
                                break;
                            }
                        }
                    break;
                }
            }
            /*
            System.out.println("hola mundo");
            insertar = String.format("INSERT INTO Productos VALUES ('123','Fresas','Rojas','KG',4,100.0)");
            System.out.println(insertar);
            conn.update(insertar);
            String consulta = String.format("SELECT * FROM Almacen;");
            System.out.println(consulta);
            */
            
            /*ResultSet rs = conn.query(consulta).getResultSet();
            if (rs != null) {
                while (rs.next()){
                    String placa = (rs.getString("placa")!=null)?
                            rs.getString("placa").toString():null;
                    String modelo = (rs.getString("modelo")!=null)?
                            rs.getString("modelo").toString():"";
                    System.out.println(placa+":"+modelo);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
        */
    }
}
