"# AD_Actividad" 

Git
  1. git checkout "tu rama"
  2. Una vez terminado todo
  3. git add .
  4. git commit -m ""
  5. git checkout main
  6. git merge "tu rama"
  7. git commit o add, lo que pida
  8. git push

Ejercicio
-> Partes

Interfaz - Aleksandra & Ivan
Modelo Negocio - Andres
Modelo Persistencia - Elena
Modelo Entidad - Comun

Interfaz
A partir del comentario del metodo iniciarAplicacion() 
 -> Otro metodo con
     1. Agregar Videojuego: En este caso nos pedirá un nombre, una compañía y una nota del videojuego. Dicho videojuego se persistirá en 
        un fichero "videojuegos.txt" con el formato "NOMBRE_COMPAÑIA_NOTA".
     2. Listar Videojuegos: e mostrarán todos los videojuegos que hay en el fichero con el formato "Nombre: NOMBRE - Compañía: COMPAÑIA -           Nota: NOTA"
     3. Lo opcional

 -> Utilizar el modelo negocio para validar etc
 
Modelo Negocio
 -> Validaciones
     El nombre del videojuego no puede estar vacio y debe tener al menos 3 letras
     La compañía no puede estar vacia y debe tener al menos 5 letras.
     La nota no puede ser inferior a 0 ni superior a 100. No admite decimales.
     
Modelo Persistencia
 -> Buscar por el metodo getByName() un Videojuego pasado por parametro en el fichero
     Este metodo devuelve un nuevo objeto videojuego con los atributos que deberia de tener segun el fichero
 -> Guardar un Videojuego en el fichero (Importante verificar si el fichero esta creado o no)
Modelo Entidad
-> COMUN
