package Sistema;

import Estructuras.ListaDobleUsuario;
import Retorno.Retorno;

public class Sistema implements ISistema{

    private ListaDobleUsuario usuarios;
    private int maxPuntos;
    
    
    @Override
    public Retorno inicializarSistema(int maxPuntos) {
        Retorno retorno = new Retorno(Retorno.Resultado.OK);
        if(maxPuntos > 0) {
           this.usuarios = new ListaDobleUsuario();
           this.maxPuntos = maxPuntos;
        }else {
            retorno.resultado = retorno.resultado.ERROR_1;
        }
        return retorno;
        
    }

    @Override
    public Retorno destruirSistema() {
        Retorno retorno = new Retorno(Retorno.Resultado.OK);
        this.maxPuntos = 0;
        this.usuarios = null;
        return retorno;
    }

    @Override
    public Retorno registrarUsuario(String cedula, String nombre) {
        //validar cedula.
        Retorno existeUsuario = buscarUsuario(cedula);
        return null;
    }

    @Override
    public Retorno buscarUsuario(String cedula) {
        Retorno retorno = new Retorno(Retorno.Resultado.OK);
        //implementarlo el finde que viene.
        return null;
    }

    @Override
    public Retorno listarUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Retorno registrarEstacion(Double coordX, Double coordY, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Retorno registrarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int metros, int minutos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Retorno evacuacionEmergencia(Double coordXi, Double coordYi, Radio metros) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Retorno caminoMinimo(Double coordXi, Double coordYi, Double coordXf, Double coordYf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Retorno dibujarMapa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
