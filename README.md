# VegetablesVsUndead
<!-- Just a java console application of the famous game "Plants vs Zombies", the idea is to show how POO works and to have some fun while doing it!

You can find the source code in the "src" folder, there you can find every single code line.
Also you can find a built version with the jar file, or you can create your own with the built .class files if you wish. -->
Un remake del famoso juego "Plantas vs Zombies", la idea del proyecto es mostrar como la POO funciona y divertirse haciendolo!
Puedes encontrar el codigo fuente en la carpeta "src", ahi veras cada linea de codigo, e incluso tu puedes crear tu version del juego con el codigo!
## Instrucciones para compilar
### Windows:

    DEL Build\.class 
    COPY src\plantasvszombies\*.java Build\plantasvszombies 
    cd Build\plantasvszombies
    javac *.java
    DEL *.java
    cd ..\..\Build
    jar cfe PlantasVsZombies.jar plantasvszombies.Test plantasvszombies/*

### Linux: 
    
    rm -r Build/*
    cp src\plantasvszombies\*.java Build\plantasvszombies 
    cd Build\plantasvszombies
    javac *.java
    rm *.java
    cd ../../Build
    jar cfe PlantasVsZombies.jar plantasvszombies.Test plantasvszombies/*
