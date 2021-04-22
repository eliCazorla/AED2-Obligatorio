package Dominio;

public class NodoAbbUsuario {
    private String cedula;
    private String nombre;
    private NodoAbbUsuario izq;
    private NodoAbbUsuario der;
    
    public NodoAbbUsuario(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.izq = null;
        this.der = null;
    } 

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public NodoAbbUsuario getIzq() {
        return izq;
    }

    public NodoAbbUsuario getDer() {
        return der;
    }

    public void setIzq(NodoAbbUsuario izq) {
        this.izq = izq;
    }

    public void setDer(NodoAbbUsuario der) {
        this.der = der;
    }
    
    
    
}
