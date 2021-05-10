package obligatorio;

import Dominio.Estacion;
import Sistema.Sistema;

public class Obligatorio {

    public static void main(String[] args) {
       Sistema sistema = new Sistema();
        System.out.println("inicializarSistema: " + sistema.inicializarSistema(5).resultado);
        //System.out.println("destruirSistema: " + sistema.destruirSistema().resultado);
        System.out.println("registrarUsuario: " + sistema.registrarUsuario("0.123.456-5","Usuario1").resultado);
        System.out.println("registrarUsuario: " + sistema.registrarUsuario("1.123.456-5","Usuario2").resultado);
        //System.out.println("registrarUsuario: " + sistema.registrarUsuario("3.123.456-5","Usuario4").resultado);
        System.out.println("registrarUsuario: " + sistema.registrarUsuario("5.123.456-5","Usuario3").resultado);
        System.out.println("registrarUsuario: " + sistema.registrarUsuario("3.123.456-5","Usuario4").resultado);
        System.out.println("registrarUsuario: " + sistema.registrarUsuario("0.523.456-5","Usuario1").resultado);
        System.out.println("listarUsuarios: " + sistema.listarUsuarios().valorString);
        System.out.println("buscarUsuario " + sistema.buscarUsuario("0.523.456-5").resultado);
        System.out.println("buscarUsuario " + sistema.buscarUsuario("0.523.456-5").valorEntero);
        System.out.println("buscarUsuario " + sistema.buscarUsuario("0.523.456-5").valorString);
        System.out.println("agregarEstacion " + sistema.registrarEstacion(-34.90329736867486, -56.190495769312, "Universidad ORT Uruguay Montevideo").resultado);
        
        for (Estacion estacion : sistema.metro.estacionesUsadas) {
            System.out.println(estacion.getNombre() + " - " + estacion.getCoordX() + " - " + estacion.getCoordY() + " - " + estacion.getExiste());
        }
    }
    
}
