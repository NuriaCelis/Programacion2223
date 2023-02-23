# CADENAS DE TEXTO EN JAVA.

## INTRODUCCIÓN

La clase String nos permitirá almacenar cadenas de caracteres.Realmente es una secuencia de 0 a n caracteres. Es dinámica, por lo tanto le podemos asignar diferentes valores (cadenas), con diferente tamaño. Esto se debe a la asignación dinámica que se hace en memoria.

### Creación

Aunque como ya dije anteriormente es una Clase, podemos tratarla como un dato primitivo inicialmente. Una vez asignado un valor este es inmodificable. Cada vez que yo asigno un nuevo valor (nueva cadena), realmente provoca una nueva instanciación interna pero es transparente para nosotros.

```java
public class usoString{
  public static void main(String[] args){
    String modulo="programación";
    String ciclo= new String();
    ciclo="Desarrollo de Aplicaciones Multiplataforma";
  }
}
```

### Asignación de valores

Las cadenas de caractéres o Strings en Java, se representan con comillas dobles. Si queremos que la propia " sea un carácter en si, y no el final de la cadena, hay que anteponer la secuencia de escape \.

```java
System.out.println("*****ASIGNACION DE VALORES*****");
String introduccion;
introduccion="Trataremos inicialmente los 'String' para el manejo de cadenas. Son muy \"IMPORTANTES\"");
```

### Extracción de un carácter individual

Cada uno de los caractéres que forman parte de la cadena, tiene asignado una posición. El primer carácter de la cadena ocupa la posición 0, el segundo carácter la posición 1, y así sucesivamente.

Con el metodo charAt(posición), podemos acceder al carácter que ocupa dicha posición.

```java
public class usoString{
  public static void main(String[] args){
    String modulo="programación";
    String ciclo= new String();
    ciclo="Desarrollo de Aplicaciones Multiplataforma";
    
    char c=ciclo.charAt(0);
    System.out.println("El primer caracter de ciclo es: "+c);
    System.out.println("El quinto caracter de ciclo es: "+ciclo.charAt(4));
  }
}
```

### Obtener la longitud de la cadena

Otra función interesante en el manejo de cadenas es la que nos proporciona la longitud de la cadena. Incluye también los espacios en blanco ocupados dentro de la cadena. Para ello hacemos uso del método length().

```java
public class usoString{
  public static void main(String[] args){
    String modulo="programación";
    String ciclo= new String();
    ciclo="Desarrollo de Aplicaciones Multiplataforma";
    
    char c=ciclo.charAt(0);
    System.out.println("El primer caracter de ciclo es: "+c);
    System.out.println("El quinto caracter de ciclo es: "+ciclo.charAt(4));
    
    System.out.println("*****Longitud de la cadena*****");
    System.out.println("La longitud de la cadena ciclo es: "+ciclo.length());
  }
}
```

### Descomposición de una cadena

Es un método que permite extraer una subcadena dada, indicando la posición inicial y final de los caracteres a extraer. El método es substring(posIni, posFin);

PosIni indica la posición desde donde empiezas a extraer la cadena. PosFin indica el número de elementos que quieres recuperar desde la posición inicial.

```java
System.out.println("*****Extraccion de una subcadena*****");
System.out.println("Subcadena de la cadena ciclo entre las posiciones 3 y 6: "+ciclo.substring(3,6);
```
La
### Igualdad de dos cadenas

Si queremos averiguar si dos cadenas son iguales, o lo podemos hacer con el operador == como con el resto de tipos simples. Para ello tenemos que utilizar el metodo equals, que devuelve true si ambas cadenas son iguales. 

```java
System.out.println("*****COMPARACIÓN ENTRE CADENAS*****);
String texto1="Buenos días";
String texto2=new String("Buenos días");
System.out.println("¿Las cadenas son iguales?: "+texto1.equals(texto2));
System.out.println("¿Las cadenas son iguales?: " + texto1==texto2); // El resultado de esta instrucción puede ser incorrecto.
```

Al preguntar si dos cadenas son iguales, distingue si está en mayúsculas o minúsculas. Si necesitamos preguntar sin distinguir mayúsculas de minúsculas, utilizamos equalsIgnoreCase().

```java
System.out.println("*****COMPARACIÓN ENTRE CADENAS*****);
String texto1="Buenos días";
String texto2=new String("BUENOS DÍAS");
System.out.println("¿Las cadenas son iguales?: "+texto1.equalsIgnoreCase(texto2));
```

Otro modo de comparar cadenas, para saber si una es mayor que la otra, es con el método compareTo. Este método devuelve un entero >0, <0 o =0. Veamos un ejemplo:

```java
System.out.println("*****COMPARACIÓN ENTRE CADENAS*****);
String texto1="Buenos días";
String texto2=new String("Buenos dias");
if (texto1.compareTo(texto2)>0)
  System.out.println("texto1 es superior a texto2");
else if(texto1.compareTo(texto2)<0)
  System.out.println("texto1 es inferior a texto2");
else
  System.out.println("texto1 y texto2 son iguales");
```

### Otras funciones de Strings

Existen un montón de funciones para trabajar con Strings en Java. Si os vais a la API de Java, podéis buscar la clase String y veréis todas las que hay. Algunas de ellas son las siguientes:

- startsWith(subcadena) y endsWith(subcadena): para comprobar si una cadena comienza o finaliza con una subcadena determinada.
- trim(): elimina los espacios en blanco de una cadena que tenga por delante o por detrás. No elimina los espacios intermedios.
- toUpperCase() y to LowerCase(): me permite cambiar todos los caracteres por mayúsculas o minúsculas.
- indexOf(cadenaABuscar): permite buscar una cadena dentro de otra.
- indexOf(cadenaABuscar,posicion): igual que la anterior, pero desde una posición determinada.
- replace(cadenaABuscar, cadenaSustituta): permite reemplazar una cadena por otra.
- lastIndexOf (String cad): Retorna la posición de la ultima ocurrencia de la cadena dada como parámetro.
- lastIndexOf (String cad,int ini): Retorna la posición de la última ocurrencia de la cadena dada como parámetro buscando en retroceso a partir de la posición dada como parámetro.

Como ya hemos comentado, existen muchas más funciones que podeis probar e investigar por vuestra cuenta.

## EJERCICIOS

## EJERCICIOS

:computer: Hoja de ejercicios 1



