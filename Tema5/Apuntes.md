# UNIDAD 5. USO AVANZADO DE CLASES

## MIEMBROS ESTÁTICOS O DE CLASE EN JAVA

Cuando se crea una instancia de la clase, los objetos tendrán sus propios miembros igual que en la clase.

A veces, es interesante que alguno de los miembros de la clase sea común para todos los objetos creados de esta clase.

Por  ejemplo,  si  creamos  una  clase  Coche  y  quisiéramos  disponer  de  un atributo con el nombre de la clase (un atributo de tipo String con la cadena "Coche"),  no  tiene  mucho  sentido  replicar  ese  atributo  para  todos  los objetos  de  la  clase  Coche,  pues  para  todos  va  a  tener  siempre  el  mismo valor  (la  cadena  "Coche"). 

Podría  no  haberse  creado  ningún  objeto  de  la  clase  Coche  y  sin  embargo seguiría  teniendo  sentido  poder  acceder  a  ese  atributo  de  nombre  de  la clase, pues se trata en efecto de un atributo de la propia clase más que de un atributo  de cada objeto instancia de la clase.

```java
public class Coche {
    private static String NOMBRE="Coche";
    private String matricula;
    private String color;

    public static String getNOMBRE() {
        return NOMBRE;
    }  
}

public class Ejercicio {

    public static void main(String[] args) {
        System.out.println(Coche.getNOMBRE());
    }
}

```
Para  poder  definir  miembros  estáticos  en  Java  se  utiliza  el  modificador static.  Los  miembros  (tanto  atributos  como  métodos)  declarados  utilizando este  modificador  son  conocidos  como  miembros  estáticos  o  miembros  de clase.

El modificador  static  hace  que  el  atributo  sea común  (el  mismo) para todos  los objetos de una misma  clase. El atributo será siempre el mismo para todos los objetos y tendrá un valor  único  independientemente  de  cada  objeto. Aunque no exista  ningún  objeto  de  esa  clase,  el  atributo  sí  existirá  y  podrá contener  un  valor  (pues  se  trata  de  un  atributo  de  la  clase  más  que del objeto).

Ejemplo de  atributos estáticos  o  de  clase:  un  contador  que  indica  el  número  de objetos  de  esa  clase  que  se  han  ido  creando.  Otro  ejemplo  de  atributo  estático  puede ser  un  atributo nombre, que contuviera un String con el nombre de la clase.

```java
class Punto {
    // Coordenadas del punto
    private  int x, y;
    // Atributos  de clase: cantidad  de puntos creados  hasta el momento
    public static cantidadPuntos;
    public static final nombre;
}
```
Obviamente,  para  que  esto  funcione  como  estás  pensando,  también  habrá  que  escribir  el código necesario para  que cada  vez que se cree  un objeto de la clase Punto se incremente  el valor del atributo  cantidadPuntos. 

En una clase también podemos encontrar métodos  static. La implementación es igual para todos los objetos, pero solo puede acceder a los atributos estáticos de la clase. Para llamar a un método estático, no es necesario tener una instancia de la clase. Se hace referencia al método con el nombre de la propia clase, y no el de una instancia. De todos modos, estos métodos también pueden ser invocados por un objeto.

Ejemplo típico  de  métodos  estáticos  se  encuentra  en  la clase  Math,  cuyos  métodos  son  todos  estáticos  (Math.abs,  Math.sin, Math.cos,  etc.). En Java es habitual encontrar métodos estáticos en muchas de sus clases.

Por  ejemplo,  la  mayoría  de  las  clases  del  paquete  java.lang  que  representan  tipos  (Integer , String,  Float,  Double,  Boolean,  etc.)  ofrecen  métodos  estáticos  para  hacer  conversiones. Aquí tienes algunos ejemplos:

- static  String  valueOf   (int  i): devuelve la representación en formato String (cadena) de un valor int. Se trata  de  un  método  que  no  tiene  que  ver  nada  en  absoluto  con  instancias  de  concretas  de  String,  sino de  un  método  auxiliar  que  puede  servir  como  herramienta  para  ser  usada  desde  otras  clases.  Se utilizaría  directamente  con el nombre de la clase. Por ejemplo:

```java
String enteroCadena= String.valueOf (23);
```
- static String valueOf  (float f): algo similar para un valor de tipo float. Ejemplo de uso:

```java
String floatCadena= String.valueOf (24.341);
```
- static int parseInt (String s): en este caso se trata de un método estático de la clase Integer . Analiza la cadena  pasada como parámetro y  la transforma  en un int. Ejemplo de uso:
```java
int cadenaEntero= Integer.parseInt ("-12");
```

Todos  los  ejemplos  anteriores  son  casos  en  los  que  se  utiliza  directamente  la  clase  como  una especie  de  caja  de  herramientas  que  contiene  métodos  que  pueden  ser  utilizados  desde cualquier parte, por eso suelen ser métodos públicos.

## EJERCICIOS

:computer: Ejemplo: Estático

:computer: Hoja de ejercicios 1 de Estático

## HERENCIA Y RELACIONES ENTRE CLASES

Las relaciones entre las clases nos van a permitir saber como se comunican los diferentes objetos de esas clases entre sí. Existen diferentes tipos. Los más interesantes para nosotros son: ASOCIACIÓN, AGREGACIÓN Y HERENCIA.

### Asociación entre clases

Hemos visto que los objetos de las diferentes clases se relacionan entre sí. Cuando una clase hace referencia o utiliza otra clase, ambas clases forman una asociación. Estas se representan a través de el uso de los diagramas de clases (UML)

![Diagrama UML](img/imagen1.png)

Dos clases tienen una asociación si:
- Un objeto de una clase envía un mensaje a un objeto de la otra clase. Enviar un  mensaje es utilizar alguno de sus métodos o propiedades para que el objeto realice  una determinada labor.
- Un objeto de una clase, crea un objeto de otra clase.
- Una clase tiene atributos cuyos valores son objetos o colecciones de objetos de otra  clase
- Un objeto de una clase recibe como parámetros de un método objetos de otra  clase.

En UML las asociaciones se representan con una línea entre las dos clases  relacionadas, encima de la cual se indica el nombre de la asociación y una  flecha para indicar el sentido de la asociación

![Asociación entre clases](img/imagen2.png)

### Agregación VS Composición

Son relaciones que se basan en la idea de entender un objeto como una composición o parte de otro. Son tipos especiales de asociación.
Definen relaciones del tipo es parte de o se compone de. Existen dos variantes:

- AGREGACIÓN

La agregación es un tipo de asociación que indica que una clase es parte de otra clase  (composición débil).Las partes pueden formar parte de diferentes agregados. La destrucción del compuesto no conlleva la destrucción de los componentes. Habitualmente se  da con mayor frecuencia que la composición. La agregación se representa en UML mediante  un diamante de color blanco colocado en el extremo en el que está la clase que representa el  “todo”.

![Agregación](img/imagen3.png)

- COMPOSICIÓN

Es una forma fuerte de agregación donde la vida de la clase contenida debe  coincidir con la vida de la clase contenedor. Los componentes constituyen una parte del objeto  compuesto. De esta forma, los componentes no pueden ser compartidos por varios objetos  compuestos. La supresión del objeto compuesto conlleva la supresión de los componentes. El símbolo de composición es un diamante de color negro colocado en el extremo en el que  está la clase que representa el “todo” (Compuesto).

![Agregación](img/imagen4.png)

### Herencia

La herencia define una relación entre clases en la cual una clase posee características (métodos y propiedades) que proceden de otra. Esto permite estructura de forma muy atractiva los programas y reutilizar código de forma  más eficiente. Es decir genera relaciones entre clases del tipo ES UN.

A la clase que posee las características a heredar se la llama superclase y la clase que las  hereda se llama subclase. Una subclase puede incluso ser superclase en otra relación de  herencia. También se emplea habitualmente los términos madre para referirnos a una superclase e hija para una subclase.

Para que una clase herede las características de otra hay que utilizar la palabra clave  extends tras el nombre de la clase. A esta palabra le sigue el nombre de la clase cuyas  características se heredarán. Una clase que extiende a otra hereda sus atributos y sus métodos (no los constructores). 

![Herencia](img/imagen5.png)

Puede haber varios niveles de herencia, es decir clases que heredan de otra clase que a su  vez es heredera de otra.

![Herencia](img/imagen6.png)

En Java sólo se puede hererar de una clase. No existe herencia múltiple como en otros lenguajes como Python

El ejemplo que proponemos es un caso en el que vamos a simular el comportamiento  que tendrían los diferentes integrantes de la selección española de futbol; tanto los  Futbolistas como el cuerpo técnico (Entrenadores, Masajistas, etc…).

Para simular este comportamiento vamos a definir tres clases que van a representaran  a objetos Futbolista, Entrenador y Masajista. De cada unos de ellos vamos a necesitar  algunos datos que reflejaremos en los atributos y una serie de acciones que  reflejaremos en sus métodos. Estos atributos y métodos los mostramos en el siguiente diagrama de clases:

![Herencia](img/imagen7.png)

Como se puede observar, vemos que en las tres clases tenemos atributos y  métodos que son iguales ya que los tres tienen los atributos id, Nombre,  Apellidos y Edad; y los tres tienen los métodos de Viajar y Concentrarse. A nivel de código tendremos algo así:

![Herencia](img/imagen8.png)

Lo que podemos ver en este punto es que estamos escribiendo mucho código repetido ya que las tres clases tienen métodos y atributos comunes.

Por tanto lo que haremos será crearnos una clase con el “código que es común a  las tres clases” (a esta clase se le denomina en la herencia como “Clase Padre o  SuperClase”) y el código que es específico de cada clase, lo dejaremos en ella,  siendo denominadas estas clases como “Clases Hijas”, las cuales heredan de la  clase padre todos los atributos y métodos públicos o protegidos.

Es muy importante saber que las clases hijas no van a heredar nunca los atributos y métodos privados de la clase padre.

Como podéis observar ahora queda un código mucho más limpio, estructurado y con  menos líneas de código, lo que lo hace más legible, cosa que es muy importante y lo  que todavía lo hace más importante es que es un código reutilizable.

Si ahora queremos añadir más clases a nuestra aplicación como por ejemplo una  clase Médico, Utiller@, Jefe/a de prensa etc. que pertenezcan también al equipo  técnico de la selección Española, lo podemos hacer de forma muy sencilla ya que  en la clase padre (SeleccionFutbol) tenemos implementado parte de sus datos y de  su comportamiento y solo habrá que implementar los atributos y métodos propios  de esa clase.

Nuestro diagrama de clases nos quedaría del siguiente modo:

![Herencia](img/imagen9.png)

A nivel de código nos quedaría algo así:

![Herencia](img/imagen10.png)

Además de public, private y default en Java se dispone del modificador protected (protegido). Este modificador de acceso está específicamente pensado para la  herencia. Cuando se utiliza sobre una propiedad o un método indica que dicha  propiedad o método serán visibles por las subclases que además heredarán la  propiedad o el método. Sin embargo permanecerán invisibles para el resto.

Se heredan todos los métodos y propiedades protected y public (no se heredan los private ni los default). La subclase por su parte puede definir nuevos métodos y propiedades.

|  | La misma clase | Otra clase del mismo paquete | Subclase de otro paquete | Otra clase de otro paquete |
| ------ | ------ | ------ | ------- | ------ |
| public | X | X | X | X |
| protected | X | X | X |  |
| default | X | X |  |  |
| private | X |  |  |  |

#### Sobreescritura de métodos

Las subclases heredan los métodos de las  superclases. Pero también los pueden sobrecargar  para proporcionar una versión de un determinado  método adaptado a las necesidades de la nueva  clase.

Por último, si una subclase define un método con el  mismo nombre, tipo y argumentos que un método  de la superclase, se dice entonces que se  sobrescribe o anula el método de la superclase.

Vamos a ver un ejemplo:

![Herencia](img/imagen11.png)

En el diagrama el objeto toby  que es un perro, usa el método  comer de la clase Perro (los  mamíferos y animales también  puede comer pero toby usa el  método redefinido en la clase  Perro).

Sin embargo toby duerme como  cualquier otro  animal ya que  dormir no ha sido redefinido, se  reproduce como un mamífero ya  que la reproducción es distinta en  un mamífero según el diagrama.  Lógicamente puede gruñir y  ladrar ya que es un perro.

Oto es un animal y por ello todo  lo que puede usar procede sólo  de la clase Animal.

A veces se requiere llamar a un método de la superclase. Eso se  realiza con la palabra reservada super. Anteriormente hemos visto que  this hace referencia a la clase actual. super hace referencia a la  superclase respecto a la clase actual, con lo que es un método  imprescindible para poder acceder a métodos anulados por herencia.

```java
public class Vehiculo {
    protected double velocidad;
    ...
    public void acelerar(double kmh)
    {
        velocidad += kmh;
    }
}

public class Coche extends Vehiculo {
    private int gasolina;
    public void acelerar(double kmh) {
        super.acelerar(kmh);
        gasolina*=0.9;
    }
}
```

En el ejemplo anterior, la llamada super.acelerar(kmh) llama al método acelerar de la clase Vehículo (el cual acelerará la marcha).

Es necesario redefinir el método acelerar en la clase Coche ya que aunque la  velocidad varía igual que en la superclase, hay que tener en cuenta el  consumo de gasolina. Por ello invocamos al método acelerar de la clase padre  (que no es oculto gracias a super).

Se puede incluso llamar a un constructor de una superclase, usando la sentencia super.

```java
public class Vehiculo {
    protected double velocidad;

    public Vehiculo(double kmh)
    {
        velocidad = kmh;
    }
}

public class Coche extends Vehiculo {
    private int gasolina;
    public Coche(double v, int g)
        super.(v);
        gasolina*=g;
    }
}
```

#### Constructores

Los constructores no se heredan de la clase base a las clases derivadas. Pero sí se puede invocar al constructor de la clase base. De hecho por defecto aunque haya o no haya constructor se hace una invocación al  constructor por defecto de la clase base.

```java
public classA{
    protected int valor;  
    public A(){
        valor=2;
    }
    public void escribir(){
        System.out.println(valor);
    }
}

public classB extends A{
    public void escribir(){  
        System.out.println(valor*2);
    }
}
```

¿Qué escribiría lo siguiente?

```java
A objA=new A();
B objB=new B();
objA.escribir();
objB.escribir();
```

Sin embargo si la clase A no tuviese constructor por defecto:

```java
public classA{
    protected int valor;  
    public A(int v){
        valor=v;
    }
    public void escribir(){  
        System.out.println(valor);
    }
}

//1º version
public classB extends A{
    public void escribir(){  
        System.out.println(valor*2);
    }
}
//error: NO SE PUEDE INVOCAR AL  CONSTRUCTOR POR DEFECTO

//2º version
public classB extends A{
    public B(int v){
        valor=v;
    } //ERROR! Falta el constructor A()  
    public void escribir(){
        System.out.println(valor*2);
    }
}

//3º versión, la correcta
public class B extends A {
    public B(int v){ //¡Ahora sí!
        super(v);
    }
    public void escribir(){  
        System.out.println(valor*2);
    }
}
```
En resumen: hay que tener en cuenta que en los constructores Java realiza estas acciones:

- Si la primera instrucción de un constructor de una subclase no es una invocación  a otro constructor con this o super, Java añade de forma invisible e implícita una  llamada super() con la que invoca al constructor por defecto de la superclase.  Luego continúa con las instrucciones de inicio de las variables de la subclase y  luego sigue con la ejecución normal. Si en la superclase no hay constructor por  defecto (sólo hay explícitos) ocurrirá un error.

- Si se invoca a constructores de superclases mediante super(…) en la primera  instrucción, entonces se llama al constructor seleccionado de la superclase, luego  inicia las propiedades de la subclase y luego sigue con el resto de sentencias  del constructor.

- Finalmente, si esa primera instrucción es una invocación a otro constructor de la  clase con this(…), entonces se llama al constructor seleccionado por medio de  this y realiza sus instrucciones, y después continúa con las sentencias del  constructor. La inicialización de variables la habrá realizado el constructor al  que se llamó mediante this(..).

## EJERCICIOS

:computer: Ejemplo: Herencia Simple  (Hay que buscarle, no le tengo)

:computer: Hoja de ejercicios 1 de Herencia


