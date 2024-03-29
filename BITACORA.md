# CVDS-lab-2
Laboratorio de CVDS 

# LA HERRAMIENTA MAVEN
**Ingresar a la página de la herramienta y entender**   

1. *Cuál es su mayor utilidad:* Se puede utilizar para crear y gestionar cualquier proyecto basado en Java.
2. *Fases de maven:*  clean - validate - compile - test - package - verify- install - deploy
3. *Ciclo de vida de la construcción:*  clean - default - site
4. *Para qué sirven los plugins:*  Para extender las funcionalidades del codigo.
5. *Qué es y para qué sirve el repositorio central de maven:*  Es un repositorio en línea que sirve como almacén central. Su función principal es proporcionar un lugar centralizado donde los desarrolladores pueden compartir software utilizado en proyectos Maven.

## EJERCICIO DE LAS FIGURAS
### CREAR UN PROYECTO CON MAVEN
Buscar cómo se crea un proyecto maven con ayuda de los arquetipos (archetypes).
* Se crean con el comando : mvn archetype:generate

![Screenshot 2024-02-05 155610](https://github.com/Diegoc04/CVDS-lab-2/assets/146139366/a719583c-7345-4f12-a27c-b98ac00e347a)


Busque cómo ejecutar desde línea de comandos el objetivo "generate" del plugin "archetype", con los siguientes parámetros:
```yml
ProjectId: org.apache.maven.archetypes:maven-archetype-quickstart:1.0
Id del Grupo: edu.eci.cvds
Id del Artefacto: Patterns
Paquete: edu.eci.cvds.patterns.archetype
```


![Screenshot 2024-02-05 155930](https://github.com/Diegoc04/CVDS-lab-2/assets/146139366/1e9c5296-fc1c-49f6-9f79-612ba91bd2b7)


Se debió haber creado en el directorio, un nuevo proyecto `Patterns` a partir de un modelo o arquetipo, que crea un conjunto de directorios con un conjunto de archivos básicos.

Cambie al directorio `Patterns`:
```sh
$ cd Patterns
```

Para ver el conjunto de archivos y directorios creados por el comando `mvn` ejecute el comando `tree`.
```sh
$ tree
```

En algunos sistemas operativos, este comando no funciona correctamente o puede requerir un parámetro (por ejemplo: `tree /f`). En caso que funcione, la
salida muestra la estructura del proyecto, similar a como se muestra a continuación:
```sh
.
│ pom.xml
└───src
├───main
│ └───java
│ └───edu
│ └───eci
│ └───cvds
│ └───patterns
  └───archetype
│ App.java
│
└───test
└───java
└───edu
└───eci
└───cvds
└───patterns
└───archetype
AppTest.java
```

![tree](https://github.com/Diegoc04/CVDS-lab-2/assets/146139366/56fef9c0-1ec9-4125-afd6-c8e09fd53b75)



## AJUSTAR ALGUNAS CONFIGURACIONES EN EL PROYECTO
Edite el archivo `pom.xml` y realize la siguiente actualización:

Hay que cambiar la version del compilador de Java a la versión 8, para ello, agregue la sección `properties` antes de la sección de
dependencias:

```xml
<properties>
  <maven.compiler.target>1.8</maven.compiler.target>
  <maven.compiler.source>1.8</maven.compiler.source>
</properties>
```

![image](https://github.com/Diegoc04/CVDS-lab-2/assets/89041250/844055cf-06f4-4fd6-bc26-dece436215c8)


## COMPILAR Y EJECUTAR
Para compilar ejecute el comando:
```sh
$ mvn package
```

![Screenshot 2024-02-05 164511](https://github.com/Diegoc04/CVDS-lab-2/assets/146139366/7b47470a-add3-4427-a7dd-a88495e35bb4)


Si maven no actualiza las dependencias utilice la opción `-U` así:
```sh
$ mvn -U package
```

*Busque cuál es el objetivo del parámetro "package" y qué otros parámetros se podrían enviar al comando `mvn`.*

* Generar el paquete del proyecto después de haber compilado los archivos fuente y ejecutado las pruebas unitarias. 

*Busque cómo ejecutar desde línea de comandos, un proyecto maven y verifique la salida cuando se ejecuta con la clase `App.java` como parámetro en "mainClass". Tip: https://www.mojohaus.org/exec-maven-plugin/usage.html*

* Se utiliza el siguiente comando: mvn exec:java -Dexec.mainClass="com.example.Main" [-Dexec.args="argumento1"]

*Realice el cambio en la clase `App.java` para crear un saludo personalizado, basado en los parámetros de entrada a la aplicación.*

*Utilizar la primera posición del parámetro que llega al método "main" para realizar el saludo personalizado, en caso que no sea posible, se debe mantener el saludo como se encuentra actualmente*

![image](https://github.com/Diegoc04/CVDS-lab-2/assets/89041250/9edfc123-c25c-4f52-94d7-8ef532c545da)

* Para que los cambios se vean reflejados necesitamos utilizar el comando mvn compile

![image](https://github.com/Diegoc04/CVDS-lab-2/assets/89041250/3bc6fac4-5a82-4e57-9d43-da04b6a9a331)
  
*Buscar cómo enviar parámetros al plugin "exec".*

* Utilizando -Dexec.args="parametro"

*Ejecutar nuevamente la clase desde línea de comandos y verificar la salida: Hello World!*

![image](https://github.com/Diegoc04/CVDS-lab-2/assets/89041250/d1147087-4e75-46ff-afd8-82d976baec70)

*Ejecutar la clase desde línea de comandos enviando su nombre como parámetro y verificar la salida. Ej: Hello Pepito!*

![image](https://github.com/Diegoc04/CVDS-lab-2/assets/89041250/9295730c-af39-434d-b928-8834b804fa26)

*Ejecutar la clase con su nombre y apellido como parámetro. ¿Qué sucedió?*

![image](https://github.com/Diegoc04/CVDS-lab-2/assets/89041250/ba2296ae-6d01-4c08-b9ce-a585bc6c495c)

* Solo aceptó el nombre como parametro, el apellido lo omitió.

Verifique cómo enviar los parámetros de forma "compuesta" para que el saludo se realice con nombre y apellido.

* Podemos separar los parametros con las posiciones de la lista args[] (parametro1 = args[0], parametro2 = args[1])

 ![image](https://github.com/Diegoc04/CVDS-lab-2/assets/89041250/fb9e23e5-efc5-413a-b960-d612c943d5d7)

Ejecutar nuevamente y verificar la salida en consola. Ej: Hello Pepito Perez!

![image](https://github.com/Diegoc04/CVDS-lab-2/assets/89041250/889b00a5-811e-4f30-b25e-d5d84e421740)

## HACER EL ESQUELETO DE LA APLICACIÓN
*Cree el paquete `edu.eci.cvds.patterns.shapes` y el paquete `edu.eci.cvds.patterns.shapes.concrete`.*

![image](https://github.com/Diegoc04/CVDS-lab-2/assets/89041250/98ac7818-87e4-45f9-92ab-ecd366f9aff9)

![image](https://github.com/Diegoc04/CVDS-lab-2/assets/89041250/1e6d0221-f0af-488a-b6e2-d132eaa70910)

*Cree una interfaz llamada `Shape.java` en el directorio `src/main/java/edu/eci/cvds/patterns/shapes` de la siguiente manera:*

```java
package edu.eci.cvds.patterns.shapes;

public interface Shape {
    public int getNumberOfEdges();
}
```
![image](https://github.com/Diegoc04/CVDS-lab-2/assets/89041250/f982dc1e-03e9-4ab6-8f7b-ab569b9b06f2)

Cree una enumeración llamada `RegularShapeType.java` en el directorio `src/main/java/edu/eci/cvds/patterns/shapes` así:

```java
package edu.eci.cvds.patterns.shapes;

public enum RegularShapeType {
    Triangle, Quadrilateral, Pentagon, Hexagon
}
```
![image](https://github.com/Diegoc04/CVDS-lab-2/assets/89041250/03a7a525-b24c-4637-9ddb-1f6ccb16736f)

En el directorio `src/main/java/edu/eci/cvds/patterns/shapes/concrete` cree las diferentes clases (Triangle, Quadrilateral, Pentagon, Hexagon), que implementen la interfaz creada y retornen el número correspondiente de vértices que tiene la figura. 

Siguiendo el ejemplo del triángulo:
```java
package edu.eci.cvds.patterns.shapes.concrete;

import edu.eci.cvds.patterns.shapes.Shape;

public class Triangle implements Shape {
    public int getNumberOfEdges() {
        return 3;
    }
}
```
![image](https://github.com/Diegoc04/CVDS-lab-2/assets/89041250/66efbbaf-82de-4a33-8f97-84bc87e56243)

Cree el archivo `ShapeMain.java` en el directorio `src/main/java/edu/eci/cvds/patterns/shapes` con el metodo main:
```java
package edu.eci.cvds.patterns.shapes;

public class ShapeMain {

  public static void main(String[] args) {
    if (args == null || args.length != 1) {
      System.err.println("Parameter of type RegularShapeType is required.");
      return;
    }
    try {
      RegularShapeType type = RegularShapeType.valueOf(args[0]);
      Shape shape = ShapeFactory.create(type);
      System.out.println(
        String.format(
          "Successfully created a %s with %s sides.",
          type,
          shape.getNumberOfEdges()
        )
      );
    } catch (IllegalArgumentException ex) {
      System.err.println(
        "Parameter '" + args[0] + "' is not a valid RegularShapeType"
      );
      return;
    }
  }
}
```
![image](https://github.com/Diegoc04/CVDS-lab-2/assets/89041250/2d793944-8dfb-4e3a-8302-5a7fa5b3b019)

*Analice y asegúrese de entender cada una de las instrucciones que se encuentran en todas las clases que se crearon anteriormente. Cree el archivo `ShapeFactory.java` en el directorio `src/main/java/edu/eci/cvds/patterns/shapes` implementando el patrón fábrica (Hint: https://refactoring.guru/design-patterns/catalog), haciendo uso de la instrucción switch-case de Java y usando las enumeraciones.*

![image](https://github.com/Diegoc04/CVDS-lab-2/assets/89041250/209c1acf-e937-41fe-a957-ee822ad81277)

¿Cuál fábrica hiciste? y ¿Cuál es mejor?

* Hicimos la fabrica simple debido a que es la mas facil de implementar pero la mejor fabrica depende de las necesidades y requisitos del diseño, que en este caso y como estamos aprendiendo a usar maven, seria la fabrica simple.


- Simple Factory:

![imagen](https://github.com/PDSW-ECI/labs/assets/4140058/0788a0b7-a071-4b90-ac3f-5982289ff3b3)

- Factory Method:

![imagen](https://github.com/PDSW-ECI/labs/assets/4140058/cd82548d-347b-4a10-88bd-2d203dac12bd)
- Abstract Factory:

![imagen](https://github.com/PDSW-ECI/labs/assets/4140058/1c79a12b-21d4-46be-8f19-40f3b62b6af7)

Ejecute múltiples veces la clase ShapeMain, usando el plugin exec de maven con los siguientes parámetros y verifique la salida en consola para cada una:

**- Sin parámetros**

![image](https://github.com/Diegoc04/CVDS-lab-2/assets/89041250/5eb22415-3e15-481a-ac8e-a3f7e9c12ab5)

**- Parámetro: qwerty**

![image](https://github.com/Diegoc04/CVDS-lab-2/assets/89041250/c3cf1a68-f3fb-4398-a2ce-65e85fa02e44)

**- Parámetro: pentagon**

![image](https://github.com/Diegoc04/CVDS-lab-2/assets/89041250/4d546e32-c73d-4814-83a8-1f544254e34b)

**- Parámetro: Hexagon**

![image](https://github.com/Diegoc04/CVDS-lab-2/assets/89041250/77cf6fb6-b192-4835-95e4-c08bb7a28548)
  
*¿Cuál(es) de las anteriores instrucciones se ejecutan y funcionan correctamente y por qué?*

* Unicamente Hexagon funciona correctamente, en el caso de ´pentagon´ no funciona debido a que empieza con ´p´ minuscula y para que funcione se necesita con ´P´ mayuscula, ´qwerty´ no es una opción valida de parametro y sin parametros nos menciona que necesita parametros.
