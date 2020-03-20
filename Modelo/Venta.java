package Modelo;

public class Venta {
    
    //folio = null
    private int diaVenta;
    private int mesVenta;
    private int añoVenta;
    private String horaVenta;
    private int cantidad;

    public Venta(int diaVenta, int mesVenta, int añoVenta, String horaVenta, int cantidad) {
        this.diaVenta = diaVenta;
        this.mesVenta = mesVenta;
        this.añoVenta = añoVenta;
        this.horaVenta = horaVenta;
        this.cantidad = cantidad;
    }
    
    public Venta(int cantidad) {
        this.diaVenta = 0;
        this.mesVenta = 0;
        this.añoVenta = 0;
        this.horaVenta = "";
        this.cantidad = cantidad;
    }

    public int getDiaVenta() {
        return diaVenta;
    }

    public void setDiaVenta(int diaVenta) {
        this.diaVenta = diaVenta;
    }

    public int getMesVenta() {
        return mesVenta;
    }

    public void setMesVenta(int mesVenta) {
        this.mesVenta = mesVenta;
    }

    public int getAñoVenta() {
        return añoVenta;
    }

    public void setAñoVenta(int añoVenta) {
        this.añoVenta = añoVenta;
    }

    public String getHoraVenta() {
        return horaVenta;
    }

    public void setHoraVenta(String horaVenta) {
        this.horaVenta = horaVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
}
