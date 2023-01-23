# UNIDAD 7. FICHEROS

## INTRODUCCIÓN

Un fichero es un conjunto de bits almacenado en un dispositivo. Tienen nombre y se ubican en directorios. Ese nombre es único en el directorio.

Los ficheros tienen diferentes extensiones que indican el tipo de contenido y formato.

Si el fichero almacena datos organizados en elementos, cada elemento se denomina registro y cada registro está compuesto por campos. 
La forma de agrupar los datos depende de la persona que lo diseñe.

Para trabajar con ficheros en Java existen diferentes APIs diferentes. Por un lado está la API java.io, y luego está la API java.nio y java.nio2.

## CLASES PARA TRABAJAR CON EL SISTEMA DE FICHEROS

**API java.io**

Se introduce por primera vez en Java 1.0, actualmente consta de diferentes clases, pero nos vamos a centrar en la **clase File** que tiene específicamente para trabajar con el sistema de ficheros del sistema operativo:

- File: proporciona un conjunto de utilidades relacionadas con los ficheros que nos da información de los mismos y nos permite realizar acciones sobre ellos.

- Constructores para File: (Buscar en la API Java)
    - File(string directorioyFichero)
    - File(string directorio, string fichero)
    - File(File directorio, string fichero)
- Métodos importantes:	
    - getName(), getPath(), getAbsolutePath(), getParent(), length(), createNewFile(), delete(), exists(), isDirectory(), isFile(), mkdir(), mkdirs(), renameTo(),list(),listFiles()
- Otros
    - canExecute(), canRead(), canWrite(), setExecutable(boolean), isHidden(), lastModified(), setReadable(boolean), setWritable(boolean), setReadOnly()

Ejemplo: 

```java
File f=new File("prueba.txt");
if(f.exists()){
    System.out.println("El fichero existe");
}else{
    System.out.println("El fichero no existe");
}
```

**Ejemplo:** Ejemplo File

## EJERCICIOS

:computer: Hoja de ejercicios 1

**API java.nio**

La API java.nio aparece para solucionar los problemas de la API java.io:

- La clase File carece de algunas funciones importantes, como un método de copia.
- También definió muchos métodos que devolvían valores booleanos, que en caso de error, se devolvía false, en lugar de lanzar una excepción, lo que dificulta saber por qué falló.
- No proporcionó un buen manejo en el soporte de enlaces simbólicos.
- Se proporciono un conjunto limitado de atributos de archivo.

Para solucionar estos problemas se introduce en Java 1.4 la API java New Input/Output (NIO) dentro del paquete java.nio. En Java 1.7 se actualiza java NIO introduciendo un nuevo paquete java.nio.file con el nombre de Java Non Blocking Input/Output (NIO2), que introduce:

- Files
- Path
- Paths
- FileSystem
- FileSystems

La **clase Paths** principalmente dispone del método estático get(Uri uri), que devuelve la instancia de un **objeto Path**. Con un objeto Path podemos gestionar la información relativa a la ruta o path de un fichero o de un directorio.
Mediante objetos de la clase  Path podemos usar métodos como:

- getFileName(): Devuelve el path extrayendo sólo nombre del elemento (fichero o carpeta)
- getParent(): Devuelve el Path de la carpeta que contiene al elemento.
- Iterator(): Aplicándose al path de una carpeta, devuelve un Iterator de objetos Path que apuntan a cada elemento contenido en la carpeta.

La **clase Files** perteneciente al paquete java.nio tiene muchos métodos estáticos para hacer múltiples operaciones con ficheros y directorios.
La clase Files tiene métodos para realizar:
1. Comprobaciones: 
    - Exists
    - notExists
    - isSameFile
    - isRegularFile
    - isReadable
    - isWritable
    - isExecutable
    - Etc.
  
**Ejemplo:** EjemploNIO

1. Manipulación de ficheros a nivel de sistema
    - Borrar (delete, deleteIfExists)
    - Copiar (copy)
    - Mover (move)
    - Para crear ficheros: Regulares (createFile) y Temporales (createTempFile)

2. La lectura y escritura con Java NIO de ficheros es mucho más sencilla:
    - Dispone de métodos que agilizan la lectura sobre ficheros de texto: readAllLines, lines, readString (desde Java 11)
    - Disponen de métodos más eficientes para instanciar flujos de caracteres
    - Para flujos de lectura (newBufferedReader). Ojo! No se trata del constructor
    - Para flujos de escritura (newBufferedWriter)
    - Disponen de métodos más eficientes para instanciar flujos de bytes
    - Para flujos de lectura (newInputStream)
    - Para flujos de escritura (newOutputStream)

3. Files también tiene métodos para trabajar con carpetas o directorios
    - Listar:	Contenido de directorios (newDirectoryStream, list, find, walk)
    - Crear: Crear un directorio (createDirectory, createDirectories) o directorio temporal (createTempDirectory)

**Ejemplo:** EjemploNIO2

## FLUJOS DE DATOS

Un **stream o flujo de datos** es un objeto que establece la conexión o vía de comunicación entre el programa y un dispositivo de entrada o de salida (teclado, pantalla, fichero, conexión de Internet). Los flujos nos permitirán introducir o sacar datos de nuestro sistema. Pueden ser de Entrada o de salida.

Ejemplos típicos:

- Lectura y escritura de ficheros.
- Entrada por teclado.
- Envío de datos por la red.
- Etc.

**Pasos para trabajar con Flujos**

1. Se abre el fichero
  - Para ello hay que crear un objeto de la clase correspondiente al tipo de fichero que vamos a manejar, y el tipo de acceso que vamos a utilizar:
  ```
	TipoDeFichero obj = new TipoDeFichero(ruta);
  ```
  - Donde ruta es la ruta de disco en que se encuentra el fichero o un descriptor de fichero válido.

2. Se utiliza el fichero
  - Para ello cada clase presenta diferentes métodos de acceso para escribir o leer en el fichero.

3. Gestión de excepciones (es opcional, pero recomendado).
  - Se puede observar que todos los métodos que utilicen clases de este paquete deben tener en su definición una cláusula throws IOException. Los métodos de estas clases pueden lanzar excepciones de esta clase (o sus hijas) en el transcurso de su ejecución, y dichas excepciones deben de ser capturadas y debidamente gestionadas para evitar problemas.
4. Se cierra el fichero y se destruye el objeto.
  - Para cerrar un fichero lo que hay que hacer es destruir el objeto. Esto se puede realizar de dos formas, dejando que sea el recolector de basura de Java el que lo destruya cuando no lo necesite (no se recomienda) o destruyendo el objeto explícitamente mediante el uso del método close() del objeto: obj.close().

**Tipos de ficheros en Java**

En Java es posible utilizar dos tipos de ficheros (de texto o binarios) y dos tipos de acceso a los ficheros (secuencial o aleatorio).

![Ficheros](img/Imagen1.png)

Las clases para trabajar con ficheros se encuentran en el paquete java.io, por lo que al principio del código fuente tendremos que escribir la sentencia import java.io.*;

![Ficheros](img/Imagen2.png)

## FICHEROS DE TEXTO

**Gestión de ficheros de texto (Byte a byte)**

### Lectura de ficheros de texto:

La **clase InputStream** y sus hijas se utilizan para leer corrientes de datos byte a byte. Con la clase FileInputStream leemos de ficheros de texto de forma secuencial.

Presenta el método read() para la lectura del fichero. Este método se puede invocar de varias formas:

- int read(): Devuelve el siguiente carácter del fichero ó -1 si no hay más.
- int read( byte a[] ): Llena el vector a con los caracteres leídos del fichero. Devuelve la longitud del vector que se ha llenado si se realizó con éxito o –1 si no había suficientes caracteres en el fichero para llenar el vector.
- int read( byte a[], int off, int len ): Lee len caracteres del fichero, insertándolos en el vector a.

Todos ellos devuelven -1 si se ha llegado al final del fichero (momento de cerrarle).

El siguiente ejemplo mostrará por pantalla el contenido del fichero mifichero.txt
```java
int c;
FileInputStream f = null;
try {
  f = new FileInputStream("mifichero.txt");
  while ((c = f.read()) != -1) {
    System.out.print((char) c);
  }
} catch (IOException e) {
  System.out.println(e.toString());
} finally {
  if (f != null)
    try {
      f.close();
    } catch (IOException ex) {
      System.out.println("Error al cerrar el fichero.");
    }
}

```
**Ejemplo:** LeerByteaByte

La **clase OutputStream** y sus hijas se utilizan para escribir corrientes de datos byte a byte. Con la clase FileOutputStream escribimos en ficheros de texto de forma secuencial.

Presenta el método write() para la escritura en el fichero. Presenta varios formatos:

- int write( int c ): Escribe el carácter en el fichero.
- int write( byte a[] ): Escribe el contenido del vector en el fichero.
- int write( byte a[], int off, int len ): Escribe len caracteres del vector a en el fichero, comenzando desde la posición off. 

En el siguiente ejemplo se crea el fichero “mifichero.txt’ carácter a carácter con los datos tecleados:

```java
public static void main(String[ ] args) 
{
	int c;
	FileOutputStream f=null;
	try{
		f=new FileOutputStream("mifichero.txt");
		while((c=System.in.read())!='\n')
			f.write((char)c);
	}
	catch(IOException e){
		System.out.println(e.toString());
	}
	finally{
		if(f!=null)
			f.close();
	}
}
```

En este otro ejemplo creamos “otrofichero.txt” byte a byte:

```java
public static void main(String[ ] args) {
  byte[ ]buffer=new byte[81];  //define una matriz 			        //buffer de  longitud 81 bytes
  int nbytes;
  FileOutputStream f=null;;
  try{
	  f=new FileOutputStream("otrofichero.txt",true);
	  nbytes=System.in.read(buffer);
	  f.write(buffer,0,nbytes); 
    //buffer=matriz que contiene los bytes
    //0= posisicon en la matriz del 1º byte que se desea escribir
    //nbytes=nº de bytes a escribir
  }
  catch(IOException e){
	  System.err.println(e.toString());
  }
  finally{
	  if(f!=null)
		  f.close();
  }
```

En este ejemplo hemos añadido palabra true después del nombre del fichero para que grabe a continuación, y también hemos añadido la clausula finally de la excepción para que en caso de que se haya podido abrir el fichero, al final lo cierre.

**Ejemplo:** EscribirCarACar

## EJERCICIOS

:computer: Hoja de ejercicios 2