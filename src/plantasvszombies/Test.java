/*
   Clase test, utilizada para realizar una demostracion del funcionamiento del juego o jugarlo
 */
package plantasvszombies;
import java.util.Scanner;
/**
 *
 * @author Juanma
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Si desea jugar ingrese S, si quiere ver la demostracion de 50 movimientos ingrese otro caracter");
        char res = sc.next().charAt(0);
        Tablero game = new Tablero();
        if(res == 'S'){
            //La funcion iniciar realiza una llamada al metodo que pone en funcionamiento el sistema para que el juego se pueda jugar
            game.iniciar();
        }else{
            //La funcion demo dentro de tablero ejecuta una demostracion del sistema de 50 movimientos
            //en la cual se instancian todas las clases de plantas y zombies para probar su funcionamiento
            //las funciones de Tablero, Zombie y planta, no pueden llamarse de forma aislada, ya que requieren
            //de la totalidad del sistema para funcionar
            game.demo();
        }
        
    }
    
}
