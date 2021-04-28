package obligatorio;

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
    }
    
}
