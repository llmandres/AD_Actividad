package modelo.negocio;

import java.lang.reflect.Array;
import java.util.ArrayList;

import modelo.entidad.Videojuego;
import modelo.persistencia.DaoVideojuego;

public class GestorVideojuego {
	private DaoVideojuego dv;
	
	/**
	 * Método que valida un videojuego pasado por parametro contra un videojuego guardado
	 * en la persistencia. Un videojuego esta validado cuando el nombre  guardado coincide 
	 * con el Videojuego pasado por parametro.
	 * 
	 * @param v Videojuego a comparar
	 * @return <b>0</b> el Videojuego no existe, <b>1</b> el Videojuego existe y es
	 *         valido, <b>2</b> el Videojuego existe pero no es valido y <b>404</b> en
	 *         caso de que haya algún problema en el de entrada salida
	 */
	public int validarVideojuego(Videojuego v) {
		dv = new DaoVideojuego();
		try {
			Videojuego vFichero = dv.getByName(v.getNombre());
			if (vFichero == null) {
				return 0;
			}

			if (vFichero.equals(v)) {
				return 1;
			} else {
				return 2;
			}
		} catch (Exception e) {
			return 404;
		}
	}


	/**
	 * Método que guarda un Videojuego pasado por parametro
	 * 
	 * @param v el Videojuego a guardar
	 * @return <b>0</b> el Videojuego pasado por parametro es null, <b>1</b> el nombre
	 *         esta vacio o tiene menos de 3 caracteres, <b>2</b> la compania esta
	 *         vacio o tiene menos de 5 caracteres , <b>3</b> el Videojuego se ha
	 *         guardado <b>4</b> La nota del videojuego no esta en el rango de 0 a 100
	 *          <b>404</b> en caso de que haya algún problema en el de
	 *         entrada salida
	 */
	public int guardar(Videojuego v) {
		if (v == null) {
			return 0;
		}

		dv = new DaoVideojuego();
		try {
			if (v.getNombre().isBlank() || v.getNombre().length() < 3) {
				return 1;
			} else if (v.getCompania().isBlank() || v.getCompania().length()< 5) {
				return 2;
			}else if(v.getNota()<0 || v.getNota()>100){
				return 4;
			} 
			else {
				dv.register(v);
				return 3;
			}
		} catch (Exception e) {
			return 404;
		}
	}
	
	public ArrayList<Videojuego> listarVideojuego(){
			dv = new DaoVideojuego();  
		    ArrayList<Videojuego> listaVideojuegos = null;
		    try {
		        listaVideojuegos = dv.listarVideojuego();
		    } catch (Exception e) {
		        e.printStackTrace();  
		    }
		    return listaVideojuegos;  
		}

}
