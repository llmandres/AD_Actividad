package interfaz;

import java.util.Scanner;

import modelo.entidad.Usuario;
import modelo.negocio.GestorUsuario;

public class InterfazUsuario {

	private GestorUsuario gu = null;
	private Scanner scString = new Scanner(System.in);
	private Scanner sc = new Scanner(System.in);

	public void mostrarInterfaz() {
		System.out.println("Bienvenido a la app");
		Usuario usuario = null;
		gu = new GestorUsuario();
		int respuesta = 0;

		int contador = 0;
		boolean validado = false;
		boolean romper = true;
		int opcion = 0;

	    do{
	    opcion = menu();
	    switch (opcion) {
			case 1: {
				login();
				romper = false;
			}
			break;
			case 2: {
				darAltaUsuario();
			}
			break;
			case 0: {
	      	System.out.println("Saliendo");
			}
			break;
			default:{
				System.out.println("Opcion No Valida");
				}	
			}}while(opcion !=0 || !romper);
	
			System.out.println("Fin de la aplicación");
	}


	private void iniciarAplicacion(Usuario u) {
		System.out.println("--------------------------");
		System.out.println("Perfil de " + u.getNombre());
		System.out.println("--------------------------");
		int opcion = 0;
		
		/*
		 * Aqui iria lo nuevo de videojuegos ahora
		 */
	
	}

	private void darAltaUsuario() {
		Usuario usuario = pedirDatos();
		int respuesta = gu.guardar(usuario);
		switch (respuesta) {
		case 1:
			System.out.println("Usuario en blanco o con solo espacios en blanco");
			break;
		case 2:
			System.out.println("Password en blanco o con solo espacios en blanco");
			break;
		case 3:
			System.out.println("Usuario guardado con exito!! :) :)");
			break;
		case 666:
			System.out.println("Error de acceso. Intentelo mas tarde. Codigo 666");
			break;
		}
	}

	private int menu() {
		boolean correcto = false;
		int opcion = 0;
		while(!correcto) {
			System.out.println("Elija una opción: ");
      System.out.println("1 - Login");
			System.out.println("2 - Register");
			System.out.println("0 - Salir del programa");
			opcion = sc.nextInt();
			if(opcion >= 0 && opcion <= 2) {
				correcto = true;
			}
		}		
		return opcion;
	}
  private void login(){
		Usuario usuario = null;
		gu = new GestorUsuario();
		int respuesta = 0;

		int contador = 0;
		boolean validado = false;
    while (contador < 3 && !validado) {
			usuario = pedirDatos();
			respuesta = gu.validar(usuario);
			switch (respuesta) {
			case 0:
				System.out.println("Usuario no existe");
				break;
			case 1:
				System.out.println("Usuario correcto, bienvenido a la app");
				validado = true;
				iniciarAplicacion(usuario);
				break;
			case 2:
				System.out.println("Usuario y/o password incorrectos");
				contador++;
				break;
			case 666:
				System.out.println("Error de acceso. Intentelo mas tarde");
				break;
			}
    }
  }

	private Usuario pedirDatos() {
		System.out.println("Introduzca el nombre: ");
		String nombre = scString.nextLine();
		System.out.println("Introduzca el password: ");
		String pass = scString.nextLine();
		Usuario u = new Usuario();
		u.setNombre(nombre);
		u.setPassword(pass);
		return u;
	}
}
