# VegetablesVsUndead
Just a java console application of the famous game "Plants vs Zombies", the idea is to show how POO works and to have some fun while doing it!

You can find the source code in the "src" folder, there you can find every single code line.
Also you can find a built version with the jar file, or you can create your own with the built .class files if you wish.

## Instruccions to compile
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
