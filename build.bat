DEL Build\.class
COPY src\plantasvszombies\*.java Build\plantasvszombies
cd Build\plantasvszombies
javac *.java
DEL *.java
cd ..\..\Build
jar cfe PlantasVsZombies.jar plantasvszombies.Test plantasvszombies/*