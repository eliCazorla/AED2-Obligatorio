package Estructuras;

import Dominio.NodoAbbUsuario;
import Retorno.Retorno;

public class AbbUsuario {
    
    private NodoAbbUsuario raiz;

    public AbbUsuario() {
        this.raiz = null;
    }

    public NodoAbbUsuario getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoAbbUsuario raiz) {
        this.raiz = raiz;
    }
        
    public boolean insertar(String cedula, String nombre) {
        NodoAbbUsuario insertado = insertar(cedula, nombre, this.getRaiz());
        this.setRaiz(insertado);
        return true;
    } 
    
    private NodoAbbUsuario insertar(String cedula, String nombre, NodoAbbUsuario nodo) {
        if (nodo == null){
            nodo = new NodoAbbUsuario(cedula, nombre);
        }else if(compararValor(cedula,nodo.getCedula())) {
            nodo.setIzq(insertar(cedula,nombre,nodo.getIzq()));
        }else{
            nodo.setDer(insertar(cedula, nombre, nodo.getDer()));
        }
        return nodo;
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
    
    public String listar(){
        return listar(this.raiz);
    }
    
    private String listar(NodoAbbUsuario nodo) {
        String texto = "";
        if (nodo != null){
            listar(nodo.getIzq());
            texto += nodo.getCedula() + ";" + nodo.getNombre() + "|";
            listar(nodo.getDer());
        }
        return texto;
    }
    
}
