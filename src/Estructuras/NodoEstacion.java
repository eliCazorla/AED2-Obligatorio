package Estructuras;

import Dominio.Estacion;

public class NodoEstacion {
    Estacion estacion;
    NodoEstacion sig;

    public NodoEstacion(Estacion estacion) {
        this.estacion = estacion;
        this.sig = null;
    }

    public Estacion getEstacion() {
        return estacion;
    }

    public void setEstacion(Estacion estacion) {
        this.estacion = estacion;
    }

    public NodoEstacion getSig() {
        return sig;
    }

    public void setSig(NodoEstacion sig) {
        this.sig = sig;
    }
    
    
}
