package Dominio;

public class Estacion {
    private String nombre;
    private double coordX;
    private double coordY;
    private int codigo; //posicion en el vector;
    private boolean existe;

    public Estacion(String nombre, double coordX, double coordY, int codigo) {
        this.nombre = nombre;
        this.coordX = coordX;
        this.coordY = coordY;
        this.codigo = codigo;
        this.existe = false;
    }

    public Estacion() {
        this.nombre = null;
        this.coordX = 0;
        this.coordY = 0;
        this.codigo = 0;
        this.existe = false;
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

    public boolean getExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }
    
    

    boolean existeEstacionXCoordenadas(Double coordX, Double coordY) {
        return this.getCoordX() == coordX && this.getCoordY() == coordY;
    }
    
    
    
}
