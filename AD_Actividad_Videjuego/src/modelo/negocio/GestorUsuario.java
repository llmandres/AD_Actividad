package modelo.negocio;

import modelo.entidad.Usuario;
import modelo.persistencia.DaoUsuarioFichero;

public class GestorUsuario {

	private DaoUsuarioFichero duf;

	/**
	 * Método que valida un usuario pasado por parametro contra un usuario guardado
	 * en la persistencia. Un usuario esta validado cuando el nombre y el password
	 * guardado coincide con el usuario pasado por parametro
	 * 
	 * @param u usuario a validar/comparar
	 * @return <b>0</b> el usuario no existe, <b>1</b> el usuario existe y es
	 *         valido, <b>2</b> el usuario existe pero no es valido y <b>666</b> en
	 *         caso de que haya algún problema en el de entrada salida
	 */
	public int validar(Usuario u) {
		duf = new DaoUsuarioFichero();
		try {
			Usuario uFichero = duf.getByName(u.getNombre());
			if (uFichero == null) {
				return 0;
			}

			if (uFichero.equals(u)) {
				return 1;
			} else {
				return 2;
			}
		} catch (Exception e) {
			return 666;
		}
	}

	/**
	 * Método que guarda un usuario pasado por parametro
	 * 
	 * @param u el usuario a guardar
	 * @return <b>0</b> el usuario pasado por parametro es null, <b>1</b> el nombre
	 *         esta vacio o solo tiene espacios en blanco, <b>2</b> el password esta
	 *         vacio o solo tiene espacios en blanco, <b>3</b> el usuario se ha
	 *         guardado <b>666</b> en caso de que haya algún problema en el de
	 *         entrada salida
	 */
	public int guardar(Usuario u) {
		if (u == null) {
			return 0;
		}

		duf = new DaoUsuarioFichero();
		try {
			if (u.getNombre().isBlank()) {
				return 1;
			} else if (u.getPassword().isBlank()) {
				return 2;
			} else {
				duf.registrar(u);
				return 3;
			}
		} catch (Exception e) {
			return 666;
		}
	}
}
