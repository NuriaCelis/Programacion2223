# XML en Java

## Índice
- [XML en Java](#xml-en-java)
  - [Índice](#índice)
  - [Introducción](#introducción)
  - [Analizador DOM de Java](#analizador-dom-de-java)
  - [Analizador Java SAX](#analizador-java-sax)

## Introducción
¿Cómo leer un archivo XML en java?
Java proporciona muchas formas de analizar un archivo XML. Hay dos analizadores en Java que analizan un archivo XML:
* Analizador DOM de Java
* Analizador Java SAX

## Analizador DOM de Java
La API DOM proporciona las clases para leer y escribir un archivo XML. Podemos crear, eliminar, modificar y reorganizar el nodo utilizando la API DOM. El analizador DOM analiza todo el archivo XML y crea un objeto DOM en la memoria. Modela un archivo XML en una estructura de árbol para facilitar su recorrido y manipulación. En DOM todo el archivo XML es un nodo. El nodo representa un componente de un archivo XML. El analizador DOM tiene un proceso lento y ocupa mucha memoria cuando carga un archivo XML en la memoria.

Debemos haber seguido el proceso para leer un archivo XML en Java:

* __Crear una instancia del archivo XML__: el analizador DOM carga el archivo XML en la memoria y considera cada etiqueta como un elemento.
* __Obtener nodo raíz__: __la clase Document__ proporciona el __método getDocumentElement()__ para obtener el nodo raíz y el elemento del archivo XML.
* __Obtener todos los nodos__: el __método getElementByTagName()__ recupera todos los nombres de etiqueta específicos del archivo XML. Donde el tipo ELEMENT_NODE se refiere a un nodo que no es de texto que tiene subelementos. Si necesitamos acceder a todos los nodos desde el principio, incluido el nodo raíz, podemos llamar recursivamente al __método getChildElement()__.
* __Obtener nodo por valor de texto__: podemos usar el __método getElementByTextValue()__ para buscar un nodo por su valor.
* __Obtener nodo por valor de atributo__: si queremos buscar un nodo por el valor de un atributo específico, podemos usar el __método getElementByTagName()__ junto con el __método getAttribute()__.

<div class="page"/>

## Analizador Java SAX

El analizador Java SAX significa API simple para XML. El analizador SAX analiza un archivo XML línea por línea. Activa eventos cuando encuentra la etiqueta de apertura, la etiqueta de cierre y los datos de caracteres en un archivo xml. El analizador SAX también se denomina analizador basado en eventos.

El analizador SAX no carga ningún archivo XML en la memoria. No crea ninguna representación de objeto del documento XML. El analizador SAX utiliza la función de devolución de llamada para informar sobre la estructura del documento XML. Es más rápido y usa menos memoria que el analizador DOM.

SAX es una interfaz de transmisión para XML, lo que significa que el archivo XML analiza en orden secuencial comenzando en la parte superior del documento y terminando con el cierre del elemento raíz.

:computer: Hoja de ejemplos(Ejemplo10 -Java XML)

:computer:Hoja 01 de XML