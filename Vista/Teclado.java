package Vista;

import java.util.Scanner;

public class Teclado {
    public int leerEntero(){
        int entero = 0;
        Scanner sc = new Scanner(System.in);
        try{
            entero = sc.nextInt();
        }catch(Exception e){
            System.out.println("Error al leer el dato");
        }
        return entero;
    }
    public String leerCadena(){
        String cadena = "";
        Scanner sc = new Scanner(System.in);
        try{
            cadena = sc.nextLine();
        }catch(Exception e){
            System.out.println("Error al leer el dato");
        }
        return cadena;
    }

    public double leerDouble() {
        double decimal = 0.0;
        Scanner sc = new Scanner(System.in);
        try{
            decimal = sc.nextDouble();
        }catch(Exception e){
            System.out.println("Error al leer el dato");
        }
        return decimal;
    }
}
