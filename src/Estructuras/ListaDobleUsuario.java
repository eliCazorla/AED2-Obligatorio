package Estructuras;

import Dominio.NodoUsuario;

public class ListaDobleUsuario {
    
    private NodoUsuario inicio;
    private NodoUsuario ultimo;

    public ListaDobleUsuario() {
    }

    public NodoUsuario getInicio() {
        return inicio;
    }

    public void setInicio(NodoUsuario inicio) {
        this.inicio = inicio;
    }

    public NodoUsuario getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoUsuario ultimo) {
        this.ultimo = ultimo;
    }
    
    
    
    public boolean InsertarOrdenado(NodoUsuario usuario) {
        if(this.getInicio() == null) {
            this.setInicio(usuario);
            this.setUltimo(usuario);
            return true;
        }else if(!compararValor(usuario.getCedula(), ultimo.getCedula())){
            this.getUltimo().setSig(usuario);
            usuario.setAnt(ultimo);
            this.setUltimo(usuario);
            return true;
        }else {
            NodoUsuario aux = this.getInicio();
            while(aux!=null) { 
                if(compararValor(usuario.getCedula(), aux.getCedula())) {
                    NodoUsuario anterior = aux.getAnt();
                    if(anterior == null) {
                        aux.setAnt(usuario);
                        usuario.setSig(aux);
                        this.setInicio(usuario);
                        return true;
                    }else {
                        anterior.setSig(usuario);
                        aux.setAnt(usuario);
                        usuario.setAnt(anterior);
                        usuario.setSig(aux);
                        return true;
                    }
                }
                aux = aux.getSig();
            }
        }
        return false;
    }    

    private boolean compararValor(String texto1, String texto2) {
        int numTexto1 = parsearTexto(texto1);
        int numTexto2 = parsearTexto(texto2);
        return numTexto1 < numTexto2;
    }

    private int parsearTexto(String texto) {
        String[] arrayConGuion = texto.split("\\.");
        String strConGuion = arrayConGuion[0] + arrayConGuion[1] + arrayConGuion[2];
        String[] arrayFinal = strConGuion.split("\\-");
        String strFinal = arrayFinal[0] + arrayFinal[1];
        int numFinal = Integer.parseInt(strFinal);
        return numFinal;
    }
    
    public void imprimirLista() {
        if(this.getInicio() == null) {
            System.out.println("La lista esta vacia!");
        }else {
            NodoUsuario aux = this.getInicio();
            while(aux!=null) {
                System.out.println(aux.getCedula());
                aux = aux.getSig();
            }
        }
    }
}
