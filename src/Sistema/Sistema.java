package Sistema;

import Dominio.Estacion;
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
        this.metro = null;
        return retorno;
    }

    @Override
    public Retorno registrarUsuario(String cedula, String nombre) {
        Retorno retorno = new Retorno();
        if (!validarCedula(cedula)) {
            retorno.resultado = retorno.resultado.ERROR_1;
            return retorno;
        }
        Retorno existeUsuario = buscarUsuario(cedula);
        if (existeUsuario.resultado == retorno.resultado.OK) {
            retorno.resultado = retorno.resultado.ERROR_2;
            return retorno;
        }
        usuarios.insertar(cedula, nombre);
        retorno.resultado = retorno.resultado.OK;
        return retorno;
    }

   @Override
    public Retorno buscarUsuario(String cedula) {
        Retorno retorno = new Retorno();
        if (!validarCedula(cedula)) {
           retorno.resultado = retorno.resultado.ERROR_1;
           retorno.valorEntero = -1;
           retorno.valorString = "La cédula ingresada no es válida.";
           return retorno;
        }
        int pertenece = usuarios.pertenece(cedula);
        if (pertenece >= 0) {
           retorno.resultado = retorno.resultado.OK;
           String usuario = usuarios.buscarPorCedula(cedula);
           retorno.valorString = usuario;
           retorno.valorEntero = pertenece;
           return retorno;
        }
        retorno.resultado = retorno.resultado.ERROR_2;
        retorno.valorString = "El usuario no está registrado.";
        retorno.valorEntero = -1;
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

//    @Override
//    public Retorno evacuacionEmergencia(Double coordXi, Double coordYi, int metros) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public Retorno caminoMinimo(Double coordXi, Double coordYi, Double coordXf, Double coordYf) {
        Retorno retorno = new Retorno();
        if(!metro.estaEstacion(coordXi, coordYi) || !metro.estaEstacion(coordXf, coordYf)){
            retorno.resultado = retorno.resultado.ERROR_1;
            return retorno;
        }
        Estacion estacion1 = metro.getEstacionXCoordenadas(coordXi, coordYi);
        Estacion estacion2 = metro.getEstacionXCoordenadas(coordXf, coordYf);
        Retorno caminoMinimo = metro.caminoMinimo(estacion1, estacion2);
        return caminoMinimo;
    }

//    @Override
//    public Retorno dibujarMapa() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    
    public boolean validarCedula(String cedula){
        if (cedula.matches("[0-9].[0-9]{3}.[0-9]{3}-[0-9]")) {
            return true;
        }
        return false;
    }
}
