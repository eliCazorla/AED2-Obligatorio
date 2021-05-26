package Estructuras;

import Dominio.Via;

public class ListaVia {
    NodoVia inicio;
    NodoVia ultimo;
    int id;

    public ListaVia() {
        this.inicio = null;
        this.ultimo = null;
        this.id = 1;
    }

    public NodoVia getInicio() {
        return inicio;
    }

    public void setInicio(NodoVia inicio) {
        this.inicio = inicio;
    }

    public NodoVia getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoVia ultimo) {
        this.ultimo = ultimo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void agregarInicio(Via via) {
        NodoVia nuevo = new NodoVia(this.getId(), via);
        if(this.getInicio()==null){
            this.setInicio(nuevo);
            this.setUltimo(nuevo);
        }    
        else{
            nuevo.setSig(this.getInicio());
            this.setInicio(nuevo);
        }
        this.setId(id +1);
    }

    public boolean getExiste() {
        if(this.getInicio()!=null) {
            if(this.getInicio().getVia().getExiste()) {
                return true;
            }
        }
        return false;
    }

    public int getLongitudMinima() {
        int minimo = Integer.MAX_VALUE;
        if(this.getInicio()!=null){
            NodoVia aux = this.getInicio();
            while(aux != null){
                if(aux.getVia().getLongitud() < minimo){
                    minimo = aux.getVia().getLongitud();
                }
                aux = aux.getSig();
            }
            return minimo;
        }
        return -1;
    }
}
