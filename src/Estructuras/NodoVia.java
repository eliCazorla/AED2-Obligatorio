package Estructuras;

import Dominio.Via;

public class NodoVia {
    int id;
    Via via;
    NodoVia sig;

    public NodoVia(int id, Via via) {
        this.via = via;
        this.sig = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Via getVia() {
        return via;
    }

    public NodoVia getSig() {
        return sig;
    }

    public void setVia(Via via) {
        this.via = via;
    }

    public void setSig(NodoVia sig) {
        this.sig = sig;
    }
   
}
