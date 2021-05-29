package obligatorio;

import Dominio.Estacion;
import Dominio.Via;
import Sistema.Sistema;

public class Obligatorio {

    public static void main(String[] args) {
       Sistema sistema = new Sistema();
        System.out.println("inicializarSistema: " + sistema.inicializarSistema(4).resultado);
        //System.out.println("destruirSistema: " + sistema.destruirSistema().resultado);
//        System.out.println("registrarUsuario: " + sistema.registrarUsuario("0.123.456-5","Usuario1").resultado);
//        System.out.println("registrarUsuario: " + sistema.registrarUsuario("1.123.456-5","Usuario2").resultado);
//        System.out.println("registrarUsuario: " + sistema.registrarUsuario("3.123.456-5","Usuario4").resultado);
//        System.out.println("registrarUsuario: " + sistema.registrarUsuario(".123.456-5","Usuario3").resultado);
//        System.out.println("registrarUsuario: " + sistema.registrarUsuario("3.123.456-5","Usuario4").resultado);
//        System.out.println("registrarUsuario: " + sistema.registrarUsuario("0.523.456-5","Usuario3").resultado);
//        System.out.println("listarUsuarios: " + sistema.listarUsuarios().valorString);
//        System.out.println("buscarUsuario " + sistema.buscarUsuario("3.123.456-5").resultado);
//        System.out.println("buscarUsuario " + sistema.buscarUsuario("3.123.456-5").valorEntero);
//        System.out.println("buscarUsuario " + sistema.buscarUsuario("3.123.456-5").valorString);
//        System.out.println("buscarUsuario " + sistema.buscarUsuario("7.123.456-5").resultado);
//        System.out.println("buscarUsuario " + sistema.buscarUsuario("7.123.456-5").valorEntero);
//        System.out.println("buscarUsuario " + sistema.buscarUsuario("7.123.456-5").valorString);
//        System.out.println("buscarUsuario " + sistema.buscarUsuario(".123.456-5").resultado);
//        System.out.println("buscarUsuario " + sistema.buscarUsuario(".123.456-5").valorEntero);
//        System.out.println("buscarUsuario " + sistema.buscarUsuario(".123.456-5").valorString);
        System.out.println("agregarEstacion " + sistema.registrarEstacion(-34.90329736867486, -56.190495769312, "Universidad ORT Uruguay Montevideo").resultado);
        System.out.println("agregarEstacion " + sistema.registrarEstacion(-34.884237654255045, -56.15876197338285, "Estadio Gran Parque Central").resultado);
        System.out.println("agregarEstacion " + sistema.registrarEstacion(-34.89433078341417, -56.15283963105457, "Estadio Centenario").resultado);
        System.out.println("agregarEstacion " + sistema.registrarEstacion(-34.79665694300997, -56.067230087300224, "Estadio Campeon del Siglo").resultado);
//        System.out.println("agregarEstacion " + sistema.registrarEstacion(-34.89433078341417, -56.15283963105457, "Estadio Centenario").resultado);
        //Centenario y ORT
        System.out.println("agregarTramo " + sistema.registrarTramo(-34.89433078341417, -56.15283963105457,-34.90329736867486, -56.190495769312,
                5000,37).resultado);
        System.out.println("agregarTramo " + sistema.registrarTramo(-34.89433078341417, -56.15283963105457,-34.90329736867486, -56.190495769312,
                3815,15).resultado);
//        
        //Ort y Parque
        System.out.println("agregarTramo " + sistema.registrarTramo(-34.90329736867486, -56.190495769312,-34.884237654255045, -56.15876197338285,
                4500,8).resultado);
        System.out.println("agregarTramo " + sistema.registrarTramo(-34.90329736867486, -56.190495769312,-34.884237654255045, -56.15876197338285,
                2000,8).resultado);
        
        //Parque y Centenario
        System.out.println("agregarTramo " + sistema.registrarTramo(-34.884237654255045, -56.15876197338285,-34.89433078341417, -56.15283963105457,
                1500,6).resultado);
        
        //Centenario y CDS
        System.out.println("agregarTramo " + sistema.registrarTramo(-34.89433078341417, -56.15283963105457,-34.79665694300997, -56.067230087300224,
                1800,12).resultado);
        
        //CDS y Parque
        System.out.println("agregarTramo " + sistema.registrarTramo(-34.79665694300997, -56.067230087300224,-34.884237654255045, -56.15876197338285,
                500,8).resultado);
        
        //CDS y ORT
        System.out.println("agregarTramo " + sistema.registrarTramo(-34.79665694300997, -56.067230087300224,-34.90329736867486, -56.190495769312,
                3500,30).resultado);
        //ORT A CDS
//        System.out.println("camino minimo" + sistema.caminoMinimo(-34.90329736867486, -56.190495769312, -34.79665694300997, -56.067230087300224).resultado);
//        System.out.println("camino minimo" + sistema.caminoMinimo(-34.90329736867486, -56.190495769312, -34.79665694300997, -56.067230087300224).valorEntero);
//        System.out.println("camino minimo" + sistema.caminoMinimo(-34.90329736867486, -56.190495769312, -34.79665694300997, -56.067230087300224).valorString);
        
        //EVACUACION
        System.out.println("evacuacion" + sistema.evacuacionEmergencia(-34.90329736867486, -56.190495769312, 1500).resultado);
        System.out.println("evacuacion" + sistema.evacuacionEmergencia(-34.90329736867486, -56.190495769312, 1500).valorString);
    }
    
}
