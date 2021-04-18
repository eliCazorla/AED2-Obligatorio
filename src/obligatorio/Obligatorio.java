package obligatorio;

import Dominio.NodoUsuario;
import Estructuras.ListaDobleUsuario;

public class Obligatorio {

    public static void main(String[] args) {
        ListaDobleUsuario lista = new ListaDobleUsuario();
        
        NodoUsuario usuario1 = new NodoUsuario("1.234.567-8", "Usuario1");
        NodoUsuario usuario2 = new NodoUsuario("2.234.567-8", "Usuario2");
        NodoUsuario usuario3 = new NodoUsuario("0.234.567-8", "Usuario3");
        NodoUsuario usuario4 = new NodoUsuario("0.534.567-8", "Usuario4");
        NodoUsuario usuario5 = new NodoUsuario("1.534.567-8", "Usuario5");
        NodoUsuario usuario6 = new NodoUsuario("3.534.567-8", "Usuario6");
        
        lista.InsertarOrdenado(usuario1);
        lista.InsertarOrdenado(usuario2);
        lista.InsertarOrdenado(usuario3);
        lista.InsertarOrdenado(usuario4);
        lista.InsertarOrdenado(usuario5);
        lista.InsertarOrdenado(usuario6);
        
        lista.imprimirLista();
    }
    
}
