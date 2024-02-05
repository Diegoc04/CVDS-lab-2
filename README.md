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

![Screenshot 2024-02-05 163424](https://github.com/Diegoc04/CVDS-lab-2/assets/146139366/09677c5b-98b3-445b-8efa-3e4cb68491fc)


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

## COMPILAR Y EJECUTAR
Para compilar ejecute el comando:
```sh
$ mvn package
```

Si maven no actualiza las dependencias utilice la opción `-U` así:
```sh
$ mvn -U package
```

Busque cuál es el objetivo del parámetro "package" y qué otros parámetros se podrían enviar al comando `mvn`.

Busque cómo ejecutar desde línea de comandos, un proyecto maven y verifique la salida cuando se ejecuta con la clase `App.java` como parámetro en "mainClass". Tip: https://www.mojohaus.org/exec-maven-plugin/usage.html

Realice el cambio en la clase `App.java` para crear un saludo personalizado, basado en los parámetros de entrada a la aplicación. 

Utilizar la primera posición del parámetro que llega al método "main" para realizar elsaludo personalizado, en caso que no sea posible, se debe mantener el saludo como se encuentra actualmente:

Buscar cómo enviar parámetros al plugin "exec".

Ejecutar nuevamente la clase desde línea de comandos y verificar la salida: Hello World!

Ejecutar la clase desde línea de comandos enviando su nombre como parámetro y verificar la salida. Ej: Hello Pepito!

Ejecutar la clase con su nombre y apellido como parámetro. ¿Qué sucedió?

Verifique cómo enviar los parámetros de forma "compuesta" para que el saludo se realice con nombre y apellido.

Ejecutar nuevamente y verificar la salida en consola. Ej: Hello Pepito Perez!

## HACER EL ESQUELETO DE LA APLICACIÓN
Cree el paquete `edu.eci.cvds.patterns.shapes` y el paquete `edu.eci.cvds.patterns.shapes.concrete`.

Cree una interfaz llamada `Shape.java` en el directorio `src/main/java/edu/eci/cvds/patterns/shapes` de la siguiente manera:
```java
package edu.eci.cvds.patterns.shapes;

public interface Shape {
    public int getNumberOfEdges();
}
```

Cree una enumeración llamada `RegularShapeType.java` en el directorio `src/main/java/edu/eci/cvds/patterns/shapes` así:

```java
package edu.eci.cvds.patterns.shapes;

public enum RegularShapeType {
    Triangle, Quadrilateral, Pentagon, Hexagon
}
```

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

Analice y asegúrese de entender cada una de las instrucciones que se encuentran en todas las clases que se crearon anteriormente. Cree el archivo `ShapeFactory.java` en el directorio `src/main/java/edu/eci/cvds/patterns/shapes` implementando el patrón fábrica (Hint: https://refactoring.guru/design-patterns/catalog), haciendo uso de la instrucción switch-case de Java y usando las enumeraciones.

¿Cuál fábrica hiciste? y ¿Cuál es mejor?
- Simple Factory:

![imagen](https://github.com/PDSW-ECI/labs/assets/4140058/0788a0b7-a071-4b90-ac3f-5982289ff3b3)

- Factory Method:

![imagen](https://github.com/PDSW-ECI/labs/assets/4140058/cd82548d-347b-4a10-88bd-2d203dac12bd)
- Abstract Factory:

![imagen](https://github.com/PDSW-ECI/labs/assets/4140058/1c79a12b-21d4-46be-8f19-40f3b62b6af7)

Ejecute múltiples veces la clase ShapeMain, usando el plugin exec de maven con los siguientes parámetros y verifique la salida en consola para cada una:
- Sin parámetros
- Parámetro: qwerty
- Parámetro: pentagon
- Parámetro: Hexagon

¿Cuál(es) de las anteriores instrucciones se ejecutan y funcionan correctamente y por qué?

