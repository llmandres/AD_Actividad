package interfaz;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.entidad.Usuario;
import modelo.entidad.Videojuego;
import modelo.negocio.GestorUsuario;
import modelo.negocio.GestorVideojuego;

public class InterfazVideojuego {
	private GestorVideojuego gv = null;
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

		do {
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
			default: {
				System.out.println("Opcion No Valida");
			}
			}
		} while (opcion != 0 || !romper);

		System.out.println("Fin de la aplicación");
	}

	private void iniciarAplicacion(Usuario u) {
		System.out.println("--------------------------");
		System.out.println("Perfil de " + u.getNombre());
		System.out.println("--------------------------");
		mostrarInterfazVideojuego();
		//int opcion = 0;
	}

	/*
	 * Aqui iria lo nuevo de videojuegos ahora
	 */
	public void mostrarInterfazVideojuego() {
		System.out.println("Bienvenido a la app");
		Videojuego v = null;
		gv = new GestorVideojuego();
		int respuesta = 0;

		int contador = 0;
		boolean validado = false;
		boolean romper = true;
		int opcion = 0;

		do {
			opcion = menuVideojuego();
			switch (opcion) {
			case 1: {
				agregarVideojuego();
				romper = false;
			}
				break;
			case 2: {
				listarVideojuegos();
				romper = false;
			}
				break;
			case 0: {
				break;
			}

			default: {
				System.out.println("Opcion No Valida");
			}
			}
		} while (opcion != 0 || !romper);

		System.out.println("Fin de la aplicación");
	}

	private void agregarVideojuego() {
		Videojuego v = pedirDatosVideojuego();
		int respuesta = gv.guardar(v);
		switch (respuesta) {
		case 1:
			System.out.println("Nombre en blanco o con solo espacios en blanco");
			break;
		case 2:
			System.out.println("Compania en blanco o con solo espacios en blanco");
			break;
		case 3:
			System.out.println("Videojuego guardado");
			break;
		case 4:
			System.out.println("La nota no esta en el rango correcto");
			break;
		case 404:
			System.out.println("Error. Intentelo mas tarde. Codigo 404");
			break;
		}
	}

	private void listarVideojuegos() {
		 listarVideojuegos();
}

	private Videojuego pedirDatosVideojuego() {
		System.out.println("Introduzca el nombre del videojuego: ");
		String nombre = scString.nextLine();
		System.out.println("Introduzca la compania del videojuego: ");
		String compania = scString.nextLine();
		System.out.println("Introduzca la nota para el videojuego: ");
		int nota = sc.nextInt();
		Videojuego v = new Videojuego();
		v.setNombre(nombre);
		v.setCompania(compania);
		v.setNota(nota);
		return v;
	}

	private int menuVideojuego() {
		boolean correcto = false;
		int opcion = 0;
		while (!correcto) {
			System.out.println("Elija una opción: ");
			System.out.println("1 - Agregar Videojuego");
			System.out.println("2 - Listado de videojuegos");
			//System.out.println("3 - Borrar videojuego");
			System.out.println("0 - Cerrar Sesión");
			opcion = sc.nextInt();
			if (opcion >= 0 && opcion <= 3) {
				correcto = true;
			}
		}
		return opcion;
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
		while (!correcto) {
			System.out.println("Elija una opción: ");
			System.out.println("1 - Login");
			System.out.println("2 - Register");
			System.out.println("0 - Salir del programa");
			opcion = sc.nextInt();
			if (opcion >= 0 && opcion <= 2) {
				correcto = true;
			}
		}
		return opcion;
	}

	private void login() {
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
