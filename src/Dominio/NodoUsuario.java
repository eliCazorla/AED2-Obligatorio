package Dominio;

public class NodoUsuario {
    private String cedula;
    private String nombre;
    private NodoUsuario sig;
    private NodoUsuario ant;
    
    public NodoUsuario(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.sig = null;
        this.ant = null;
    } 

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public NodoUsuario getSig() {
        return sig;
    }

    public NodoUsuario getAnt() {
        return ant;
    }

    public void setSig(NodoUsuario sig) {
        this.sig = sig;
    }

    public void setAnt(NodoUsuario ant) {
        this.ant = ant;
    }
    
    
    
}
