# Sink a Ship
***
El programa consiste en un juego de nombre BattleShip, aunque más especificamente Sink a Ship.
Este programa consiste en crear un campo con barcos de batalla los cuales se encontrarán escondidos en el mar, tu deber como jugador es buscar esos barcos y hundirlos, para hacer esto contarás con el campo de batalla y procederás a seleccionar o digitar la ubicación donde crees que se encuentra el barco enemigo, si lo encuentras se indicará que has impactado un barco, pero en caso contrario se indicará que fallaste, al haber derrotado a todos los barcos enemigos, ganarás la partida!

## General Info
***
Para ejecutar este programa tienes dos formas distintas, la primera es a través de la consola, donde para buscar cada posicion deberás poner la información en base a una letra de A hasta G, acompañada de un número de 0 a 6, ejemplo: A6.

La otra forma sería a través de la UI la cual fue creada con mucho cariño :D, al abrir el UI encontrarás una cálida y simple pantalla de Bienvenida, para iniciar el juego deberás seleccionar la pestaña "Juego" y luego seleccionar la opción llamada "Nuevo", en caso de que te aburras o desees continuar luego puedes darle al botón "Guardar Partida", y se guardará en la ubicación que hayas ingresado al correr el programa, en caso de que esa ubicación no se haya dado o no haya sido válida, entonces la ubicación de guardado deberá ser seleccionada antes de iniciar una partida o no te dejará crear una partida.

Para seleccionar una ruta de guardado se debe seleccionar la pestaña "Configuración" y la opción Ruta Guardado, ahi te aparecerá un seleccionador de directorio para poder elegir la ruta donde guardarás tus archivos!

Para cargar tus archivos luego, solo debes dirigirte a la pestaña de "Juego" y seleccionar la opción Cargar, la cual te abrira un seleccionador de archivos, solo busca el archivo de guardado y listo, dale abir y continua donde lo dejaste!

En caso de ejecutar la UI se recomienda NO USAR mvn clean [args], puesto que esto eliminaría los archivos de audio que se encuentran en la carpeta Target, dañando asi un poco la experiencia del juego, no se perderan los datos ni se dañará el juego, pero los sonidos estarán inhabilitados.

## Instalación
***
Como instalar e iniciar? (Recordar no usar clean y debe encontrarse en la carpeta target)

#### Juego desde comando:
```
$ mvn compile package
$ java -jar battleship-swing-1.0.0.jar
```

#### Juego desde UI:
```
$ mvn compile package
$ java -jar battleship-swing-1.0.0.jar -ui -folder [path]
```
## FAQs
***
Lista de preguntas frecuentes
1. **Que sucede si no escribo un path?**
Se solicitará un path para poder crear una partida_. 
2. __Que sucede si uso el mvn clean?__ 
To answer this question we use an unordered list:
* Se eliminarán los archivos de audio pero todo funcionará igual y sin problemas
* Se puede solucionar esta situación copiando los archivos de formato .wav de la carpeta src\main\resources en la carpeta target 