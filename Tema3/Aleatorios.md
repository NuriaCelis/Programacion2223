# GENERACIÓN DE NÚMEROS ALEATORIOS EN JAVA

La generación de números aleatorios en Java se puede hacer de dos formas distintas. El resultado es equivalente independientemente de la clase utilizada para ello.

He colocado un ejemplo de los tres casos más habituales a la hora de generar un número aleatorio:

- Generar un número entre 0 y n-1
- Generar un número entre 1 y n
- Generar un número entre m y n, siendo m mayor que n

## Con la clase Math:
```java
int x= (int) Math.floor(Math.random()*N);
// x será un número entre 0 y N-1
int x= (int) Math.floor(Math.random()*N)+1;
// x será un número entre 1 y N
int x= (int) Math.floor(Math.random()*(M-N+1))+N;
//x será un número entre M y N ambos incluidos y siendo M mayor que N
```
## Con la clase Random:
```java
import java.util.Random;

Random r = new Random();
int y= r.nextInt(N);
// y será un número entre 0 y N-1
int y= r.nextInt(N)+1;
// y será un número entre 1 y N
int y= r.nextInt(M-N+1)+N;
//y será un número entre M y N ambos incluidos y siendo M mayor que N
```
