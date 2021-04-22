package Sistema;

import Estructuras.AbbUsuario;
import Retorno.Retorno;

public class Sistema implements ISistema{

    private AbbUsuario usuarios;
    private int maxPuntos;
    
    
    @Override
    public Retorno inicializarSistema(int maxPuntos) {
        Retorno retorno = new Retorno();
        retorno.resultado = retorno.resultado.OK;
        if(maxPuntos > 0) {
           this.usuarios = new AbbUsuario();
           this.maxPuntos = maxPuntos;
        }else {
            retorno.resultado = retorno.resultado.ERROR_1;
        }
        return retorno;
        
    }

    @Override
    public Retorno destruirSistema() {
        Retorno retorno = new Retorno();
        retorno.resultado = retorno.resultado.OK;
        this.maxPuntos = 0;
        this.usuarios = null;
        return retorno;
    }

    @Override
    public Retorno registrarUsuario(String cedula, String nombre) {
        //validar cedula.
        //Retorno existeUsuario = buscarUsuario(cedula);
        Retorno retorno = new Retorno();
        retorno.resultado = retorno.resultado.OK;
        boolean inserto = usuarios.insertar(cedula, nombre);
        if (inserto) {
            return retorno;
        }
        return retorno;
    }

   /*@Override
    public Retorno buscarUsuario(String cedula) {
        Retorno retorno = new Retorno(Retorno.Resultado.OK);
        //implementarlo el finde que viene.
        return null;
    }
    */
    @Override
    public Retorno listarUsuarios() {
        Retorno retorno = new Retorno();
        if (usuarios.getRaiz() != null) {
            retorno.valorString = usuarios.listar();
            return retorno;
        }
        retorno.resultado = retorno.resultado.ERROR_1;
        retorno.valorString = "No existen usuarios";
        return retorno;
    }

    /*@Override
    public Retorno registrarEstacion(Double coordX, Double coordY, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Retorno registrarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int metros, int minutos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Retorno evacuacionEmergencia(Double coordXi, Double coordYi, int metros) {
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
    */
}
