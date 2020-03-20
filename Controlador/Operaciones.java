package Controlador;

import Vista.Mensaje;
import Vista.Teclado;
import Modelo.ArticuloBD_IMP;
import Modelo.Articulo;
import Modelo.TicketVenta;
import Modelo.TicketVentaBD_IMP;
import Modelo.Venta;
import Modelo.VentaBD_IMP;
import java.util.ArrayList;
import java.util.List;

public class Operaciones {
    private Mensaje msj;
    private Teclado tcl;
    private ArticuloBD_IMP artiIMP;
    private VentaBD_IMP ventaIMP;
    private TicketVentaBD_IMP ticketVentaIMP;
    
    public Operaciones(){
        msj = new Mensaje();
        artiIMP = new ArticuloBD_IMP();
        tcl = new Teclado();
    }
    
    public boolean agregarArticulo(String clave, String nombre, String descrip, String unidad, int cant, double precioUni){
        return artiIMP.create(new Articulo(clave,nombre,descrip,unidad,cant,precioUni));
    }
    
    public void mostrarTodoAlmacen(){
        List<Articulo> listaArticulos = new ArrayList<Articulo>();
        listaArticulos = artiIMP.readAll();
        for(int i=0;i<listaArticulos.size();i++){
            System.out.print("Clave: ");
            System.out.println(listaArticulos.get(i).getClave());
            System.out.print("Nombre: ");
            System.out.println( listaArticulos.get(i).getNombre());
            System.out.print("Precio: $");
            System.out.println(listaArticulos.get(i).getPrecioUni()+"\n--------------\n");
        }
    }
    
    public boolean eliminarArticulo(String clave){
        return artiIMP.delete(clave);
    }
    
    public void mostrarArticulo(String claveProducto){
        Articulo articu = artiIMP.read(claveProducto);
        
        
        System.out.println("ARTICULO RECIBIO ALGUN VALOR? ");
        if(articu==null){System.out.println("No");}else{System.out.println("Si");}
        
        
        System.out.print("\nClave: ");
        System.out.println(articu.getClave());
        System.out.print("Nombre: ");
        System.out.println(articu.getNombre());
        System.out.println("Descripcion: ");
        System.out.println(articu.getDescripcion());
        System.out.print("Unidad: ");
        System.out.println(articu.getUnidad());
        System.out.print("Cantidad: ");
        System.out.println(articu.getCantidad());
        System.out.print("Precio: $");
        System.out.println(articu.getPrecioUni());
    }

    public boolean modificarArticulo(){
        boolean modificado = false;
        String claveProducto = "";
        int opc = 0;
        String nuevaInfoCadTxt = ""; //Esta variable va a contener la nueva información del producto de tipo "String"
        int nuevaCantProducto = 0;
        double nuevoPrecioUnit = 0.0;
        
        while(opc!=7){
            msj.menu_modificarArti();
            msj.opcionEntero();
            opc = tcl.leerEntero();
            msj.modificar_mensaje();
            claveProducto = tcl.leerCadena();
            
            switch(opc){
                case 1: //Modifica la clave del producto
                    nuevaInfoCadTxt = "";
                    msj.modificarClave_mensaje();
                    nuevaInfoCadTxt = tcl.leerCadena();
                    
                    artiIMP.update(claveProducto,nuevaInfoCadTxt,opc);
                    modificado = true;
                break;
                case 2: //Modifica el nombre del producto
                    nuevaInfoCadTxt = "";
                    msj.modificarNombre_mensaje();
                    nuevaInfoCadTxt = tcl.leerCadena();
                    
                    artiIMP.update(claveProducto,nuevaInfoCadTxt,opc);
                    modificado = true;
                break;
                case 3: //Modifica la descripción del producto
                    nuevaInfoCadTxt = "";
                    msj.modificarDescrip_mensaje();
                    nuevaInfoCadTxt = tcl.leerCadena();
                    
                    artiIMP.update(claveProducto,nuevaInfoCadTxt,opc);
                    modificado = true;
                break;
                case 4: //Modifica en que unidad se vende el producto
                    nuevaInfoCadTxt = "";
                    msj.modificarUnidad_mensaje();
                    nuevaInfoCadTxt = tcl.leerCadena();
                    
                    artiIMP.update(claveProducto,nuevaInfoCadTxt,opc);
                    modificado = true;
                break;
                case 5: //Modifica la cantidad del producto en almacen
                    nuevaCantProducto = 0;
                    msj.modificarCantidad_mensaje();
                    nuevaCantProducto = tcl.leerEntero();
                    
                    artiIMP.update(claveProducto,nuevaCantProducto);
                    modificado = true;
                break;
                case 6: //Modifica el precio unitario al que se vende el producto
                    nuevoPrecioUnit = 0.0;
                    msj.modificarPrecioUni_mensaje();
                    nuevoPrecioUnit = tcl.leerDouble();
                    
                    artiIMP.update(claveProducto,nuevoPrecioUnit);
                    modificado = true;
                break;
                case 7: //Sale del menu de modificacion de informacion de productos
                break;
            }
        }
        
        return modificado;
    }
    
    public Venta registrarVenta(int diaVenta, int mesVenta, int añoVenta, String horaVenta, int cantidad){// EN PROGRESO...
        Venta venta = new Venta(diaVenta,mesVenta,añoVenta,horaVenta,cantidad);
        ventaIMP.create(venta);
        return venta;
    }
     public Venta registrarVenta(int cantidad){// EN PROGRESO...
        Venta venta = new Venta(cantidad);
        ventaIMP.create(venta);
        return venta;
    }
    
    public void crearTicketVenta(Venta venta, Articulo articulo){ // EN PROGRESO...
        double precioTotal = articulo.getPrecioUni() * venta.getCantidad();
        precioTotal = precioTotal * 1.30;
        //TicketVenta ticket = new TicketVenta(precioTotal,);
    }
    /*
    |--------------INVENTARIO--------------|
    | 1.Mostrar todos los articulos        |
    | 2.Agregar articulo                   |
    | 3.Eliminar articulo                  |
    | 4.Mostrar articulo                   |
    | 5.Modificar articulo                 |
    | 6.Registrar venta                    |
    | 7.Salir                              |
    |--------------------------------------|
    */
    public void iniciar(){
        int CLAVE_PRODUCTO_VENDIDO = 1;
        int CANTIDAD_PRODUCTO_VENDIDO = 2;
        
        int opc = 0;
        
        String clave="",nombre="",descrip="",unidad="";
        int cant=0;
        double precio=0.0;
        
        do{
            msj.menu();
            msj.opcionEntero();
            opc = tcl.leerEntero();
            switch(opc){
                case 1: //Mostrar todos los articulos
                    mostrarTodoAlmacen();
                break;
                case 2: //Agregar articulo
                    msj.agregar_mensaje();
                    
                    msj.leerClave();
                    clave = tcl.leerCadena();
                    
                    msj.leerNombre();
                    nombre = tcl.leerCadena();
                    
                    msj.leerDescripcion();
                    descrip = tcl.leerCadena();
                    
                    msj.leerUnidad();
                    unidad = tcl.leerCadena();
                    
                    msj.leerCantidad();
                    cant = tcl.leerEntero();
                    
                    msj.leerPrecioUni();
                    precio = tcl.leerDouble();
                    
                    agregarArticulo(clave,nombre,descrip,unidad,cant,precio);
                break;
                case 3: //Eliminar articulo
                    msj.eliminar_mensaje();
                    clave = tcl.leerCadena();
                    
                    artiIMP.delete(clave);
                break;
                case 4: //Mostrar articulo
                    msj.leerClave();
                    clave = tcl.leerCadena();
                    
                    msj.mostrarProducto_mensaje();
                    mostrarArticulo(clave);
                break;
                case 5: //Modificar articulo
                    modificarArticulo();
                break;
                case 6: //Registrar venta
                    int opcVenta = 0;
                    String claveProd = "";
                    double precioTotal;
                    int cantidadVendida = 0;
                    Articulo arti;
                    do{ 
                        msj.menu_registrarVenta();
                        msj.opcionEntero();
                        opcVenta = tcl.leerEntero();
                        
                        switch(opcVenta){
                            case 1:                                                            
                                while(opcVenta==1){
                                    msj.registrarVenta_mensaje(CLAVE_PRODUCTO_VENDIDO);
                                    claveProd = tcl.leerCadena();
                                    arti = artiIMP.read(claveProd);
                                    
                                    msj.registrarVenta_mensaje(CANTIDAD_PRODUCTO_VENDIDO);
                                    cantidadVendida = tcl.leerEntero();
                                    
                                    
                                    Venta venta = registrarVenta(cantidadVendida);
                                   // ticketVenta tk = new TicketVenta()
                                }
                                
                            break;
                            case 2:
                            break;
                        }
                    }while(opcVenta != 2);
                case 7: //Salir
                break;
                default:
                    System.out.println("No hay ninguna opcion "+opc);
            }
        }while(opc!=7);
    }
}
