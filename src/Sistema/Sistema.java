package Sistema;

import Dominio.GrafoMetro;
import Estructuras.AbbUsuario;
import Retorno.Retorno;

public class Sistema implements ISistema{

    private AbbUsuario usuarios;
    private int maxPuntos;
    private int codigoEstacion = 0;
    public GrafoMetro metro;
    
    @Override
    public Retorno inicializarSistema(int maxPuntos) {
        Retorno retorno = new Retorno();
        retorno.resultado = retorno.resultado.OK;
        if(maxPuntos > 0) {
           this.usuarios = new AbbUsuario();
           this.maxPuntos = maxPuntos;
           this.metro = new GrafoMetro(maxPuntos);
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

   @Override
    public Retorno buscarUsuario(String cedula) {
        Retorno retorno = new Retorno();
        /*if (!validarCedula(cedula)) {
           retorno.resultado = retorno.resultado.ERROR_1;
        }*/
        retorno.resultado = retorno.resultado.ERROR_2;
        retorno.valorString = "El usuario no está registrado.";
        int pertenece = usuarios.pertenece(cedula);
        if (pertenece >= 0) {
           retorno.resultado = retorno.resultado.OK;
           String usuario = usuarios.buscarPorCedula(cedula);
           retorno.valorString = usuario;
        }
        retorno.valorEntero = pertenece;
        return retorno;
    }
    
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

    @Override
    public Retorno registrarEstacion(Double coordX, Double coordY, String nombre) {
        Retorno retorno = new Retorno();
        if (codigoEstacion == maxPuntos) {
            retorno.resultado = retorno.resultado.ERROR_1;
            return retorno;
        }
        if (metro.estaEstacion(coordX,coordY)) {
            retorno.resultado = retorno.resultado.ERROR_2;
            return retorno;
        }
        codigoEstacion++;
        metro.agregarEstacion(nombre,coordX,coordY, codigoEstacion);
        retorno.resultado = retorno.resultado.OK;
        return retorno;
    }

    @Override
    public Retorno registrarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int metros, int minutos) {
        Retorno retorno = new Retorno();
        if (metros <= 0) {
            retorno.resultado = retorno.resultado.ERROR_1;
            return retorno;
        }
        if (minutos <= 0) {
            retorno.resultado = retorno.resultado.ERROR_2;
            return retorno;
        }
        if(!metro.estaEstacion(coordXi, coordYi) || !metro.estaEstacion(coordXf, coordYf)){
            retorno.resultado = retorno.resultado.ERROR_3;
            return retorno;
        }
        metro.agregarTramo(coordXi, coordYi, coordXf, coordYf, metros, minutos);
        retorno.resultado = retorno.resultado.OK;
        return retorno;
    }

    /*@Override
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
