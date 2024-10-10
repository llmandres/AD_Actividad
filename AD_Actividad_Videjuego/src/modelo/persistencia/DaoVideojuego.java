package modelo.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import modelo.entidad.Videojuego;

public class DaoVideojuego {
	private static final String NOMBRE_FICHERO = "videojuegos.txt";
	/**
	 * Método que dado un videojuego por parámetro busca su coincidencia en el
	 * fichero "videojuegos.txt" y en caso de que lo encuentre, lo devuelve junto
	 * con su nota y su compañía
	 * @param videojuego el videojuego a buscar en el fichero
	 * @return videojuego en el caso de que esté en el fichero o null 
	 * en caso contrario
	 * @throws Excepcion en caso de que haya algún problema en el fichero de texto
	 */

	public Videojuego getByName (String videojuego) throws Exception {
		Videojuego v = null;
		try(FileReader fr = new FileReader(NOMBRE_FICHERO);
				BufferedReader br = new BufferedReader(fr)){
				String cadena = br.readLine();
				while (cadena != null) {
					String[] cadenaPartida = cadena.split("/");
					String nombreVideojuego = cadenaPartida[0];
					int notaVideojuego = Integer.parseInt(cadenaPartida[1]);
					String companiaVideojuego = cadenaPartida[2];
					if(videojuego.equals(nombreVideojuego)) {
						v = new Videojuego();
						v.setNombre(nombreVideojuego);
						v.setNota(notaVideojuego);
						v.setCompania(companiaVideojuego);
						return v;
						}
					cadena = br.readLine();
					}
					return null;
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * Método que dado un videojuego en el fichero "videojuegos.txt". Se añadirá
	 * a la ultima línea. Se persistirá en formato "NOMBRE/NOTA/COMPAÑIA"
	 * @param v es el videojuego que queremos persistir
	 * @throws Exception en caso de que haya algún problema en el fichero de entrada salida
	 */
	public void register (Videojuego v) throws Exception{
		File f = new File (NOMBRE_FICHERO);
		if(!f.exists()) {
			throw new Exception("fichero no existe");
		}
		try (FileWriter fw = new FileWriter(NOMBRE_FICHERO, true);
				BufferedWriter bw = new BufferedWriter(fw)){
			bw.newLine();
			bw.write(v.toString());
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Videojuego> listarVideojuego() throws Exception {
	    ArrayList<Videojuego> listaVideojuegos = new ArrayList<>();

	    try (FileReader fr = new FileReader(NOMBRE_FICHERO);
	         BufferedReader br = new BufferedReader(fr)) {
	        
	        String cadena;
	        while ((cadena = br.readLine()) != null) {
	            String[] cadenaPartida = cadena.split("/");
	            if (cadenaPartida.length < 3) {
	 
	                continue; 
	            }

	            String nombreVideojuego = cadenaPartida[0];
	            int notaVideojuego;
	            

	            try {
	                notaVideojuego = Integer.parseInt(cadenaPartida[1]);
	            } catch (NumberFormatException e) {
	                continue;
	            }
	            
	            String companiaVideojuego = cadenaPartida[2];

	            Videojuego v = new Videojuego(nombreVideojuego, notaVideojuego, companiaVideojuego);
	            listaVideojuegos.add(v);
	        }

	    } catch (Exception e) {
	        throw e; 
	    }
	    return listaVideojuegos;
	}
	



	    public void eliminarVideojuego(String nombreVideojuego) throws IOException {
	        ArrayList<String> lineas = new ArrayList<>(); // Para almacenar las líneas del fichero
	        boolean encontrado = false;

	        // Leer el contenido actual del fichero
	        try (BufferedReader br = new BufferedReader(new FileReader(NOMBRE_FICHERO))) {
	            String linea;
	            while ((linea = br.readLine()) != null) {
	                // Verificar si la línea corresponde al videojuego que se quiere eliminar
	                if (linea.startsWith(nombreVideojuego.toLowerCase() + "/")) {
	                    encontrado = true; // Marcamos que encontramos el videojuego
	                    continue; // No añadimos esta línea a la lista
	                }
	                lineas.add(linea); // Añadir la línea a la lista
	            }
	        }

	        // Si el videojuego fue encontrado, sobrescribimos el archivo
	        if (encontrado) {
	            try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBRE_FICHERO))) {
	                for (String l : lineas) {
	                    writer.write(l);
	                    writer.newLine(); // Añadir nueva línea
	                }
	            }
	            System.out.println("Videojuego '" + nombreVideojuego + "' eliminado.");
	        } else {
	            System.out.println("Videojuego no encontrado: " + nombreVideojuego);
	        }
	    }
}
