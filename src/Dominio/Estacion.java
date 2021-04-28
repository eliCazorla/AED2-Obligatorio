package Dominio;

public class Estacion {
    private String nombre;
    private double coordX;
    private double coordY;
    private int codigo; //posicion en el vector;

    public Estacion(String nombre, double coordX, double coordY) {
        this.nombre = nombre;
        this.coordX = coordX;
        this.coordY = coordY;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCoordX() {
        return coordX;
    }

    public void setCoordX(double coordX) {
        this.coordX = coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public void setCoordY(double coordY) {
        this.coordY = coordY;
    }
    
    
}
