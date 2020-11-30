package plantasvszombies;

import java.net.*;
//importar la libreria java.net
 
import java.io.*;
//importar la libreria java.io
 
// declaramos la clase servidortcp
 
public class Servidor {
    private boolean fin = false;
 
    // método principal main de la clase
    public void createServer(int port) {
 
        // declaramos un objeto ServerSocket para realizar la comunicación
        // ServerSocket socket;
        // creamos una varible boolean con el valor a false
        
        
        // Declaramos un bloque try y catch para controlar la ejecución del subprograma
        try (ServerSocket socket = new ServerSocket(port)) {
        
            // Instanciamos un ServerSocket con la dirección del destino y el
            // puerto que vamos a utilizar para la comunicación
            
            // socket = new ServerSocket(6000);
            
            // Creamos un socket_cli al que le pasamos el contenido del objeto socket después
            // de ejecutar la función accept que nos permitirá aceptar conexiones de clientes
            Socket socketCli = socket.accept();
            
            // Declaramos e instanciamos el objeto DataInputStream
            // que nos valdrá para recibir datos del cliente
            
            DataInputStream in =
            new DataInputStream(socketCli.getInputStream());
            
            // Creamos un bucle do while en el que recogemos el mensaje
            // que nos ha enviado el cliente y después lo mostramos
            // por consola
            
            do {
                String mensaje ="";
                mensaje = in.readUTF();
                System.out.println(mensaje);
            } while (!fin);
        }
        // utilizamos el catch para capturar los errores que puedan surgir
        catch (IOException e) {
        
            // si existen errores los mostrará en la consola y después saldrá del
            // programa
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
    public void setFin(boolean fin) {
        this.fin = fin;
    }
}
