package Vista;

public class Mensaje {
    Teclado teclado;
    
    public Mensaje(){
        this.teclado= new Teclado();
    }
    public void msj_cadena(String msj){
        System.out.print(msj);
    }
    public void msj_entero(int msj){
        System.out.print(msj);
    }
    public void opcionEntero(){
        int opcion=0;
        System.out.println("Escribe un numero entero:");
    }

    public void menu(){
        System.out.println("|--------------INVENTARIO--------------|");
        System.out.println("| 1.Mostrar todos los articulos        |");
        System.out.println("| 2.Agregar articulo                   |");
        System.out.println("| 3.Eliminar articulo                  |");
        System.out.println("| 4.Mostrar articulo                   |");
        System.out.println("| 5.Modificar articulo                 |");
        System.out.println("| 6.Registrar venta                    |");
        System.out.println("| 7.Salir                              |");
        System.out.println("|--------------------------------------|\n");
    }
    
    public void menu_modificarArti(){
        System.out.print("|::::::::::::::::::::::::::::|\n");
        System.out.print("|           <MENU>           |\n");
        System.out.print("|1. Modificar clave          |\n");
        System.out.print("|2. Modificar nombre         |\n");
        System.out.print("|3. Modificar descripcion    |\n");
        System.out.print("|4. Modificar unidad         |\n");
        System.out.print("|5. Modificar cantidad       |\n");
        System.out.print("|6. Modificar precio unitario|\n");
        System.out.print("|7. Salir                    |\n");
        System.out.print("|::::::::::::::::::::::::::::|\n\n");
    }

    public void menu_registrarVenta(){
        System.out.print("|::::::::::::::::::::::::::::|\n");
        System.out.print("|        <REGISTRAR>         |\n");
        System.out.print("|                            |\n");
        System.out.print("|1. Registrar venta          |\n");
        System.out.print("|2. Regresar                    |\n");
        System.out.print("|::::::::::::::::::::::::::::|\n\n");
    }
    
    public void agregar_mensaje(){
        System.out.println("Ingresando un producto...");
    }
    public void mostrarTodos_mensaje(){
        System.out.println("Productos:\n");
    }
    public void mostrarProducto_mensaje(){
        System.out.println("INFO del producto:\n");
    }
    
    public void modificar_mensaje(){
        System.out.println("Escriba la clave del producto a modificar: ");
    }
    public void modificarClave_mensaje(){
        System.out.println("Escriba la nueva clave del producto: ");
    }
    public void modificarNombre_mensaje(){
        System.out.println("Escriba el nuevo nombre del producto: ");
    }
    public void modificarDescrip_mensaje(){
        System.out.println("Escriba la nueva descripcion del producto: ");
    }
    public void modificarUnidad_mensaje(){
        System.out.println("Escriba la nueva unidad a la que se va a vender el producto: ");
    }
    public void modificarCantidad_mensaje(){
        System.out.println("Escriba la nueva cantidad del producto en almacen: ");
    }
    public void modificarPrecioUni_mensaje(){
        System.out.println("Escriba el nuevo precio por unidad del producto: ");
    }
    public void eliminar_mensaje(){
        System.out.println("Eliminando un producto...");
    }
    public void registrarVenta_mensaje(int opc){
        if(opc == 1){
            System.out.print("clave del producto: ");
        }
        if(opc == 2){
            System.out.print("Cantidad vendida: ");
        }
    }
    
    public void leerClave(){
        System.out.print("Introduzca la clave del articulo: \n");
    }
    public void leerNombre(){
        System.out.print("Introduzca el nombre del articulo: \n");
    }
    public void leerDescripcion(){
        System.out.print("Introduzca la descripcion del articulo: \n");
    }
    public void leerUnidad(){
        System.out.print("Introduzca la unidad (kg,gr,L,etc): \n");
    }
    public void leerCantidad(){
        System.out.println("Introduzca la cantidad: \n");
    }
    public void leerPrecioUni(){
        System.out.print("Introduzca el precio: \n");
    }
    public void resultadoOperacion(boolean resultado, String operacion){
        if(resultado){
            System.out.println("\n Resultado exitoso al "+ operacion + "\n");
        }else{
            System.out.println("\n Resultado Fallido al "+ operacion + "\n");
        }
    }
}