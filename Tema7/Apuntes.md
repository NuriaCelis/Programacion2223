# UNIDAD 7. FICHEROS

## INTRODUCCIÓN

IO/NIO

No confundir Streams de la API Stream con IO Streams de la API IO/NIO.

Las operaciones de entrada y salida son muy comunes en cualquier aplicación.

**API java.io**

Se introduce por primera vez en Java 1.0, actualmente consta de:

- File: representa un archivo/directorio y le permitió realizar algunas operaciones como verificar si existe un archivo/directorio, obtener propiedades y eliminarlo
- InputStream y OutputStream: clases abstractas para leer/escribir byte a byte. Los datos se almacenan en el sistema como 0 y 1, es decir, bit, estos se agrupan en conjuntos de 8 bits formando un byte. Se utilizan estos IO Streams para almacenar datos de forma binaria, como por ejemplo, una imagen o un archivo ejecutable.
  - Clases concretas:
    - FileInputStream, FileOutputStream
    - BufferedInputStream, BufferedOutputStream
- Reader y Writer: clases abstractas para leer/escribir caracteres en lugar de bytes. Se utilizan estos Character Streams para almacenar archivos de texto.
  - Clases concretas:
    - FileReader, FileWriter
    - BufferedReader, BufferedWriter
Otra forma de entender esta API es con base a su nivel de abstracción:
- Low-level: conecta directamente con la fuente de los datos, por ejemplo: FileInputStream.
- High-level: se construye sobre otro IO Stream usando wrapping o un envoltorio, por ejemplo: BufferedReader.

**API java.nio**

La API java.nio aparece para solucionar los problemas de la API java.io:
- La clase File carece de algunas funciones importantes, como un método de copia.
- También definió muchos métodos que devolvían valores booleanos, que en caso de error, se devolvía false, en lugar de lanzar una excepción, lo que dificulta saber por qué falló.
- No proporcionó un buen manejo en el soporte de enlaces simbólicos.
- Se proporciono un conjunto limitado de atributos de archivo.

Para solucionar estos problemas se introduce en Java 1.4 la API java New Input/Output (NIO) dentro del paquete java.nio:
- Channels y Selectors: un canal es una abstracción de las funciones del sistema de archivo de nivel inferior, por ejemplo, archivos mapeados en memoria.
- Buffers: almacenamiento en búfer para todas las clases primitivas(excepto para Boolean).
- Charset: Charset (java.nio.charset), codificadores y decodificadores para mapear bytes y símbolos Unicode.

**API java.nio 2**

En Java 1.7 se actualiza java NIO introduciendo un nuevo paquete java.nio.file con el nombre de Java Non Blocking Input/Output (NIO2), que introduce:

- Files
- Path
- Paths
- FileSystem
- FileSystems

## CLASE FILE

Fue la clase hasta Java 6 que nos permitía trabajar con la estructura de ficheros. Está desfasada debido a la aparición de NIO.2 en Java 8.

La clase File se usa para obtener información sobre archivos y directorios.
Además la clase File permite crear y eliminar archivos y directorios. Un objeto de la clase Java File representa un archivo o directorio.

| Nombre | Uso |
| ------ | ------ |
| isDirectory | Devuelve true si el File es un directorio |
| isFile | Devuelve true si el File es un fichero |
|createNewFile | Crea un nuevo fichero, si aún no existe |
| createTempFile | Crea un nuevo fichero temporal |
| delete | Elimina el fichero o directorio |
| getName | Devuelve el nombre del fichero o directorio |
| getAbsolutePath | Devuelve la ruta absoluta del File |
| getCanonicalPath | Devuelve la ruta canónica del File |
| list, listFiles | Devuelve el contenido de un directorio |

Ejemplo: 

```java
File f=new File("prueba.txt");
if(f.exists()){
    System.out.println("El fichero existe");
}else{
    System.out.println("El fichero no existe");
}
```

## EJERCICIOS

:computer: Ejemplo File

:computer: Hoja de ejercicios 1

## CLASE PATH
