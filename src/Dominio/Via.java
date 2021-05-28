package Dominio;

public class Via {
    private int longitud;
    private int tiempo;
    private boolean existe;
    private int id;
    
    public Via() {
        this.longitud = 0;
        this.tiempo = 0;
        this.existe = false;
    }

    public Via(int longitud, int tiempo) {
        this.longitud = longitud;
        this.tiempo = tiempo;
        this.existe = true;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public boolean getExiste() {
        return existe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
}
