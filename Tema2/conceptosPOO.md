# CONCEPTOS DE LA PROGRAMACIÓN ORIENTADA A OBJETOS

## ÍNDICE
  - [INTRODUCCIÓN](#introducción)
  - [CLASES, OBJETOS E INSTANCIA](#clases-objetos-e-instancia)
  - [LOS CONCEPTOS DE LA POO](#los-conceptos-de-la-poo)
    - [ENCAPSULACIÓN](#encapsulación)
    - [ABSTRACCIÓN](#abstracción)
    - [HERENCIA](#herencia)
    - [POLIMORFISMO](#polimorfismo)
    - [MODULARIDAD](#modularidad)

## INTRODUCCIÓN

En este paradigma, los programas se modelan en torno a **objetos** que aglutinan toda la funcionalidad relacionada con ellos.
en POO se crean **clases**, que representan entidades que quieres manejar en tu programa. Por ejemplo, facturas, líneas de factura, clientes, coches... o cualquier entidad que necesites gestionar conceptualmente.

## CLASES, OBJETOS E INSTANCIA

El primer concepto y más importante de la POO es la **distinción entre clase y objeto**.

**Una clase es una plantilla**. Define de manera genérica cómo van a ser los objetos de determinado tipo. Por ejemplo, en un juego, una clase para representar a personas puede llamarse Persona y tener una serie de atributos como Nombre, Apellidos o Edad (que normalmente son propiedades), y una serie de comportamientos que pueden tener, como Hablar(), Caminar() o Comer() y que se implementan como métodos de la clase (funciones).

Una clase por sí sola no sirve de nada, pues no es más que un concepto, sin entidad real. Para poder utilizar una clase en un programa lo que hay que hacer es **instanciarla**. Instanciar una clase consiste en **crear un nuevo objeto** concreto de la misma. Es decir, un objeto es ya una entidad concreta que se crea a partir de la plantilla que es la clase. Este nuevo objeto tiene ya "existencia" real, puesto que ocupa memoria y se puede utilizar en el programa.

Ejemplo: La clase Persona, creamos los objetos María y Pedro que son instancias de la clase

De este modo, si tenemos que manejar personas podemos ir creándolas a medida que las necesitemos, y actuar sobre ellas individualmente. Cada una tiene sus propios datos y sus propias acciones.

Ejemplo: María tiene 0 años y no camina, ni habla  y Pedro tiene 17 años, camina y habla

> La clase define de forma genérica cómo son las personas, y los objetos son personas concretas.

<div class="page"/>

## LOS CONCEPTOS DE LA POO

Para poder manejar de manera eficiente las clases y los objetos que se generan con la Programación Orientada a Objetos son necesarios algunos principios que nos ayudarán a reducir la complejidad, ser más eficientes y evitar problemas. Son los 4 pilares de la POO. Todos los lenguajes orientados a objetos los implementan de una u otra manera, y es indispensable conocerlos bien.

### ENCAPSULACIÓN

**La encapsulación** es la característica de un lenguaje POO que **permite que todo lo referente a un objeto quede aislado dentro de éste**. Es decir, que todos los datos referentes a un objeto queden "encerrados" dentro de éste y sólo se puede acceder a ellos a través de los miembros que la clase proporcione (propiedades y métodos).

Por ejemplo, en el caso de las personas que estábamos viendo, toda la información sobre éstas (nombre, apellidos, edad... y cualquier otro dato interno que se utilice y que no necesariamente se ve desde el exterior del objeto) está circunscrito al ámbito de dicha persona.

> Gracias a la encapsulación, toda la información de un objeto está contenida dentro del propio objeto.

### ABSTRACCIÓN
Como la propia palabra indica, el principio de **abstracción** lo que implica es que la clase debe **representar las características de la entidad hacia el mundo exterior, pero ocultando la complejidad** que llevan aparejada. O sea, nos abstrae de la complejidad que haya dentro dándonos una serie de atributos y comportamientos (propiedades y funciones) que podemos usar sin preocuparnos de qué pasa por dentro cuando lo hagamos.

Así, una clase (y por lo tanto todos los objetos que se crean a partir de ella) debe exponer para su uso solo lo que sea necesario. Cómo se haga "por dentro" es irrelevante para los programas que hagan uso de los objetos de esa clase.

En nuestro ejemplo de las personas en un juego, puede ser que tengamos un dato interno que llamamos energía y que nunca es accesible directamente desde fuera. Sin embargo, cada vez que la persona anda (o corre, si tuviésemos un método para ello) gasta energía y el valor de este dato disminuye. Y cuando la persona come, el valor sube en función de lo que haya comido.

Otro ejemplo incluso más claro podría ser la acción Hablar(). Ésta puede suponer que se genere una voz sintética a partir de un texto que se le indica como parámetro de la acción para lo cual quizá ocurran un montón de cosas: se llama a un componente para síntesis de voz que está en la nube, se lanza la síntesis de voz en el dispositivo local de audio y se anota en una base de datos la frase que se ha pronunciado para guardar un histórico entre otras cosas. Pero todo esto es indiferente para el programa que hace uso de esta funcionalidad.

>La abstracción está muy relacionada con la encapsulación, pero va un paso más allá pues no sólo controla el acceso a la información, sino también oculta la complejidad de los procesos que estemos implementando.

<div class="page"/>

### HERENCIA

Desde el punto de vista de la genética, cuando una persona obtiene de sus padres ciertos rasgos (el color de los ojos o de la piel, una enfermedad genética, etc...) se dice que los hereda. Del mismo modo **en POO cuando una clase hereda de otra obtiene todos los rasgos que tuviese la primera**.

Dado que una clase es un patrón que define cómo es y cómo se comporta una cierta entidad, **una clase que hereda de otra obtiene todos los rasgos de la primera** y **añade otros nuevos** y además también **puede modificar algunos de los que ha heredado**.

A la clase de la que se hereda se le llama **clase base**, y a la clase que hereda de ésta se le llama **clase derivada**.

Así, en nuestro juego que involucra personas, podemos tener clases de personas más especializadas para representar personajes especiales del juego. Por ejemplo, podríamos definir **clases como Pirata, Piloto o Estratega que heredan de la clase Persona**. Todos los objetos de estas clases heredan las propiedades y los métodos de Persona, pero pueden particularizar algunos de ellos y además añadir cosas propias.

Por ejemplo, los objetos de la **clase Pirata** tienen un **método nuevo que es Abordar()** que en el juego sirve para asaltar un barco enemigo. Pero además presentan **una propiedad** que solo tienen los piratas llamada **Sobrenombre**, que es el nombre por el que se les conoce (un pirata puede ser de nombre Hızır y de apellido bin Yakup pero su sobrenombre es Barbaroja).

No solo eso. Lo bueno de la herencia es que podemos reutilizar todo lo que tuviésemos en la clase base. Supongamos que en nuestro juego, los piratas hablan de forma diferente a los demás. El método Hablar() se modifica para que le añada un ¡Arrrr! o un ¡Por todos los demonios! aleatoriamente a la frase y que así parezca más un pirata.

Para que el pirata hable no tendríamos que volver a hacer todo el código relacionado con hablar. Eso ya sabe cómo hacerlo por el mero hecho de ser una persona (por heredar de la clase Persona). Lo único que tendríamos que hacer es añadir esas interjecciones de pirata a la frase y luego delegar la síntesis de voz y todo lo demás a la clase base. Sería facilísimo y conseguiríamos consistencia entre todas las clases a la hora de particularizar la forma de hablar.

> La herencia es una de las características más potentes de la POO ya que fomenta la reutilización del código permitiendo al mismo tiempo la particularización o especialización del mismo.

### POLIMORFISMO

La palabra polimorfismo viene del griego "polys" (muchos) y "morfo" (forma), y quiere decir "cualidad de tener muchas formas".

En POO, el concepto de polimorfismo se refiere al hecho de que **varios objetos de diferentes clases, pero con una base común, se pueden usar de manera indistinta**, sin tener que saber de qué clase exacta son para poder hacerlo.

Supongamos que en nuestro juego tenemos un montón de personajes que están juntos en un mismo escenario. Hay varios piratas, algunos estrategas y un montón de otros tipos de personas. En un momento dado necesitamos que todos se pongan a hablar. Cada uno lo hace de una forma diferente, ya que son tipos de personajes distintos. Sería algo bastante tedioso tener que localizar primero a los de un tipo y hacerlos hablar, lo luego a los de otro y así sucesivamente. La idea es que puedas tratarlos a todos como personas, independientemente del tipo específico de persona que sean y simplemente decirles que hablen.

Al derivar todos de la **clase Persona** todos pueden hablar, y al llamar al **método Hablar()** de cada uno de ellos se utilizará el proceso adecuado según el tipo (los piratas meterán sus expresiones adicionales que hemos visto, los pilotos dirán "Entrando en pista" o lo que sea, y los estrategas añadirán a todo "Déjame que lo piense bien"). Todo esto de manera transparente para el programador. Esto es el polimorfismo.

> El polimorfismo nos permite utilizar a los objetos de manera genérica, aunque internamente se comporten según su variedad específica.

### MODULARIDAD
 La **modularidad** es la **descomposición** del sistema en **un conjunto de “piezas”** (módulos).
 
 La realización de un **diseño modular** consiste en **descomponer** el sistema en **módulos (clases)**.

Criterios para valorar un diseño modular:
• **Cohesión**: grado de relación entre los elementos de cada módulo
• **Acoplamiento**: grado de interrelación entre los distintos módulos

>Buen diseño => alta cohesión y bajo acoplamiento

**Alta cohesión en la POO**:
• Cada **clase** del sistema se refiere a **una única entidad**, es decir, puede **describirse con un único nombre**
• Cada **método** realiza **una única tarea**, es decir, lo que hace puede **describirse con una única frase**

**Bajo acoplamiento en la POO**:
• Las clases son lo más independientes posible entre sí, sólo utilizan métodos y manejan objetos de un pequeño conjunto de clases
• Cada clase tiene una parte pública pequeña y bien definida para usar una clase no es necesario conocer detalles de su implementación

Ventajas Un buen diseño con alta cohesión y bajo acoplamiento:
• Facilita la comprensión del código, implica que la arquitectura es más sencilla
• Facilita el mantenimiento, el código afectado al corregir un error o añadir una nueva funcionalidad se encuentra localizado en unas pocas clases.
• Posibilita la reutilización del software, al tener un propósito claro y ser (casi) independientes, es fácil reutilizar clases entre distintas aplicaciones
• Facilita la prueba de las clases, cada clase realiza un conjunto de tareas que pueden ser probadas de forma (casi) independiente de las demás clases

Siguiendo el ejemplo nuestros métodos solo realizan una tarea hablar, caminar, abordar y cada una de estas acciones son distintas. 

[Resumen de Programación en lenguaje Java.Tema 7. Modularidad](https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&cad=rja&uact=8&ved=2ahUKEwjBv7_Q8Ov6AhVMQRoKHdM2AuUQFnoECA0QAQ&url=https%3A%2F%2Focw.unican.es%2Fpluginfile.php%2F293%2Fcourse%2Fsection%2F228%2Fcap7-modularidad.pdf&usg=AOvVaw3cQ1GnxH3o3GODs9KRlz6H)
[Resumen del artículo de José Manuel Alarcón](https://www.campusmvp.es/recursos/post/los-conceptos-fundamentales-sobre-programacion-orientada-objetos-explicados-de-manera-simple.aspx) 
