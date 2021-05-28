package Estructuras;

import Dominio.Estacion;

public class ListaCamino {
    NodoEstacion inicio;
    NodoEstacion ultimo;

    public ListaCamino() {
        this.inicio = null;
        this.ultimo = null;
    }

    public NodoEstacion getInicio() {
        return inicio;
    }

    public void setInicio(NodoEstacion inicio) {
        this.inicio = inicio;
    }

    public NodoEstacion getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoEstacion ultimo) {
        this.ultimo = ultimo;
    }
    
    
    public void agregarInicio(Estacion estacion) {
        NodoEstacion nuevo = new NodoEstacion(estacion);
        if(this.getInicio()==null){
            this.setInicio(nuevo);
            this.setUltimo(nuevo);
        }    
        else{
            nuevo.setSig(this.getInicio());
            this.setInicio(nuevo);
        }
    }
}
