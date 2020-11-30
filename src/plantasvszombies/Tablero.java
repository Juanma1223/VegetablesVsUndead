/*
Esta clase es en torno a la cual el juego gira, es la encargada tanto de manipular el tablero como de dibujarlo
asi como tambien manejar las estadisticas y mostrarlas por pantalla, en esta, se encuentran los arreglos
en donde se encuentran los zombies y las plantas que estan instanciados.
 */
package plantasvszombies;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Tablero {
    //Variable que almacena la salud del jugador
    private double vida;
    private int soles;
    //Arreglo en el cual almacenamos los zombies instanciados
    private ArrayList<Zombie> zombies;
    //Variable en la que almacenamos las plantas instanciadas
    private ArrayList<Planta> plantas;
    //Variable que nos dice cuantos zombies tenemos en el tablero
    private int cantZombies;
    //Variable que determina el maximo de zombies, cambia segun el nivel
    private int maxZombies;
    //Variable que indica cuantas plantas tenemos en el tablero
    private int cantPlantas;
    //Matriz que representa el tablero en si
    private char[][] tablero;
    //Variable que nos dice cuantos movimientos de zombie deben pasar para poder poner plantas
    private int zombieMoves;
    //Variable que alamacena los soles totales de la partida
    private int totalSoles;
    //Flag que pone el juego en modo demostracion
    
    //Constructor para el tablero
    public Tablero(){
        //Construimos el tablero inicial sin plantas ni zombies
        tablero = new char[5][10];
        for(int i=0;i<5;i++){
            for(int j=0;j<10;j++){
                tablero[i][j] = ' ';
            }
        }
        vida = 100;
        soles = 350;
        totalSoles = soles;
        //Inicializamos los arreglos de plantas y zombies en 50, ya que es el maximo que puede haber de cada uno 
        zombies = new ArrayList<Zombie>();
        plantas = new ArrayList<Planta>();
        cantZombies = 0;
        maxZombies = 4;
        cantPlantas = 0;
        zombieMoves = 4;
    }
    
    //Metodo que imita un reloj para manejar el tiempo en el juego, recibe como parametro los milisegundos que queremos esperar
    private void wait(int ms){
    try
    {
        Thread.sleep(ms);
    }
    catch(InterruptedException ex)
    {
        Thread.currentThread().interrupt();
    }
    
    }
    
    public void demo(){
    
        maxZombies = 5;
        //Inicializamos las plantas para las pruebas
        Planta petacereza = new Petacereza(2,3);
        plantas.add(petacereza);
        for(int i=0; i<5;i++){
        
            Planta nuez = new Nuez(i,6);
            Planta repetidora = new Repetidora(i,1);
            Planta girasol = new Girasol(i,0);
            Planta patapum = new Patapum(i,4);
            plantas.add(nuez);
            plantas.add(repetidora);
            plantas.add(girasol);
            plantas.add(patapum);
        
        }
        //Moviemientos totales en la partida
        int totalMoves=0;
        //Variable que lleva el conteo de los movimientos de los zombies, antes de que el jugador pueda actuar
        int moves = zombieMoves;
        dibujar();
        while(vida > 0 && totalMoves <= 50){
            
            if(moves == 0){
                
                //Se obtienen los soles para que el jugador los use
                genSoles();
                dibujar();
                moves = zombieMoves;
            
            }
            
            //Esperamos 1 segundos entre movimiento y movimiento para realizar las acciones
            wait(1000); 
            cantZombies = zombies.size();
            //Cada dos segundos se crea un zombie
            if(cantZombies < maxZombies){
                
                createZombie();
                
            }
            dibujar();
            avanzar();
            moves--;
            totalMoves++;
        
        }
        Scanner sc = new Scanner(System.in);
        if(totalMoves < 50){
            System.out.println("Perdiste!");
        }else{
            System.out.println("Ganaste! Sobreviviste a 50 movimientos");
            System.out.println("Cantidad de soles generados:"+totalSoles);
        }
        System.out.println("Ingrese algun caracter para salir...");
        sc.next();
        
    
    }
    //Esta es el metodo que ejecuta todo el sistema, en el se encuentra el bucle principal del juego
    public void iniciar(){
        //Moviemientos totales en la partida
        int totalMoves=0;
        //Variable que lleva el conteo de los movimientos de los zombies, antes de que el jugador pueda actuar
        int moves = zombieMoves;
        dibujar();
        menu();
        while(vida > 0 && totalMoves <= 50){
            
            if(moves == 0){
                
                //Se obtienen los soles para que el jugador los use
                genSoles();
                dibujar();
                menu();
                moves = zombieMoves;
            
            }
            
            //Esperamos 1 segundos entre movimiento y movimiento para realizar las acciones
            wait(1000); 
            cantZombies = zombies.size();
            //Cada dos segundos se crea un zombie
            if(cantZombies < maxZombies){
                
                createZombie();
                
            }
            dibujar();
            avanzar();
            moves--;
            totalMoves++;
        
        }
        
        Scanner sc = new Scanner(System.in);
        if(totalMoves < 50){
            System.out.println("Perdiste!");
        }else{
            System.out.println("Ganaste! Sobreviviste a 50 movimientos");
            System.out.println("Cantidad de soles generados:"+totalSoles);
        }
        System.out.println("Ingrese algun caracter para salir...");
        sc.next();
    
    }
    
    private void createZombie(){
    
        //Variable que hace referencia a los tipos de zombies que pueden llegar a crearse
        int tipos = 4;
        //Generamos un numero aleatorio para definir el tipo de zombie que va a aparecer
        int tipo = (int)Math.floor(Math.random()*tipos+1);
        Zombie newZombie = new Zombie(Math.floor(Math.random()*5));
        switch(tipo){
            case 1:
                break;
            case 2:
                newZombie = new Saltador(Math.floor(Math.random()*5));
                break;
            case 3:
                newZombie = new Caracono(Math.floor(Math.random()*5));
                break;
            case 4:
                newZombie = new Caracubo(Math.floor(Math.random()*5));
                break;
            default:
                break;
        }
        zombies.add(newZombie);
    
    }
    
    private void menu(){

            Scanner sc = new Scanner(System.in);
            System.out.println("¿Quiere mejorar sus defensas?");
            char res = 'Z';
            while((res != 'N') && (res != 'S')){
                System.out.println("Ingrese S para si o N para no");
                try{

                   res = sc.next().charAt(0);

                }catch(Exception e){

                    System.out.println("Solo puede ingresar S o N !");

                }
            
            }
            if(res == 'S'){
                //Esta es la funcion que hace que el juego sea facilmente escalable en cuanto a tipos de plantas
                //Seleccion del tipo de planta
                System.out.println("Seleccione la planta!");
                System.out.println("1-Lanzaguisantes (100)");
                System.out.println("2-Nuez (50)");
                System.out.println("3-Girasol (50)");
                System.out.println("4-Patapum! (25)");
                System.out.println("5-Hielaguisantes (175)");
                System.out.println("6-Petacereza (150)");
                System.out.println("7-Repetidora (200)");
                int plantNum = 1;
                try{
                    
                    plantNum = sc.nextInt();
                    
                }catch(Exception e){
                
                    System.out.println("Debe ingresar un numero correcto!");
                
                }
                System.out.println("Ingrese las coordenadas para plantar!");
                int x = -1;
                int y = -1;
                try{

                    System.out.println("Ingrese en que fila quiere plantarla");
                    x = sc.nextInt();
                    System.out.println("Ingrese la columna en la que plantar");
                    y = sc.nextInt();
                    while(x>4 || y>9){
                        System.out.println("Solo se pueden ingresar numeros menores que 5 en x y 10 en y!");
                        System.out.println("Ingrese en que fila quiere plantarla");
                        x = sc.nextInt();
                        System.out.println("Ingrese la columna en la que plantar");
                        y = sc.nextInt();
                        
                    }
                    //Instanciamos la planta en el tablero, del tipo que se quiere se inicializa en lanzaguisantes
                    Planta newPlant = new Planta(x,y);
                    switch (plantNum){
                        case 1:
                            newPlant = new Planta(x,y);
                            break;
                        case 2:
                            newPlant = new Nuez(x,y);
                            break;
                        case 3:
                            newPlant = new Girasol(x,y);
                            break;
                        case 4:
                            newPlant = new Patapum(x,y);
                            break;
                        case 5:
                            newPlant = new Hielaguisantes(x,y);
                            break;
                        case 6:
                            newPlant = new Petacereza(x,y);
                            break;
                        case 7:
                            newPlant = new Repetidora(x,y);
                            break;
                    }
                    int coste = newPlant.getCoste();
                    if(soles-coste < 0){
                    
                        System.out.println("No hay suficientes soles!");
                    
                    }else{
                        
                        plantas.add(newPlant);
                        soles -= coste;
                        
                    }

                }catch(Exception e){

                    System.out.println("Solo se pueden ingresar numeros menores que 5 en x y 10 en y!");

                }
                //Volvemos a llamar a la funcion por si se quieren poner mas de una planta
                dibujar();
                menu();


            
            }
    
    }
    
    //Funcion encargada de dibujar el tablero con las plantas y los zombies
    private void dibujar(){
        //Reiniciamos el tablero
        limpiarPantalla();
        //Imprimimos por pantalla las estadisticas
        System.out.println("######################################################################################################");
        System.out.println("# Soles: "+soles);
        System.out.println("# Salud: "+vida);
        System.out.println("# Glosario:");
        System.out.println("# Z: Zombie comun, R: Caracubo, S: Saltarin, C: Caracono");
        System.out.println("# L: lanzaguisantes, N:Nuez, G:Girasol, P:Patapum, H:hielaguisantes, B:Petacereza, D:Repetidora");
        System.out.println("");
        System.out.println("#######################################################################################################");
        for(int i=0;i<5;i++){
            for(int j=0;j<10;j++){
                tablero[i][j] = ' ';
            }
        }
        //En primer lugar recorremos los zombies para buscar su posicion y ponerlos en el tablero
        posZombies();
        //Recorremos las plantas para saber donde estan
        posPlantas();
        //Luego dibujamos el tablero
         System.out.println("  |0|1|2|3|4|5|6|7|8|9|");
         System.out.println("--------------------------");
         for(int i=0;i<5;i++){
             System.out.print(i+" ");
            for(int j=0;j<10;j++){
                System.out.print("|");
                System.out.print(tablero[i][j]);
                System.out.print("");
            }
             System.out.println("");
             System.out.println("--------------------------");
        }
    
    }
    
    public void limpiarPantalla() {
        //Solo funciona en windows
        try {
            // System.out.println(System.getProperty("os.name"));
            if (System.getProperty("os.name").toLowerCase().contains("windows")){ //Determina si el sistema es Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();//Borrar consola Windows
            }else{
                Runtime.getRuntime().exec("echo sdasdas"); //Borrar consola en Linux
                // System.out.print("\033[H\033[2J");
                // System.out.flush();
                // Robot  robot = new Robot();
                // robot.keyPress(KeyEvent.VK_CONTROL);
                // robot.keyPress(KeyEvent.VK_L);
            }
           
        } catch (Exception e) {
            System.out.println("No se puede limpiar la pantalla!");
        }
    }
    
    //Esta funcion localiza los zombies en el tablero y elimina aquellos que llegan al final
    private void posZombies(){
        //Variables provisionales para almacenar las posiciones
        int x;
        int y;
        //Creamos una nueva lista sobre la que iteramos para evitar errores de concurrencia
        Iterator<Zombie> it = zombies.iterator();
        //Vamos a utilizar este arreglo auxiliar para detectar los zombies que debemos eliminar pero modificando el original
        while(it.hasNext()){
    
            Zombie zombie = it.next();
            x = zombie.getPosX();
            y = zombie.getPosY();
            //Si el zombie se encuentra en la linea final, hace daño al jugador y se elimina la instancia
            if(y <= 0){
                //deleteZombie(i);
                it.remove();
                takeDamage(zombie.getDamage());
                soles += 10;
            }else{
                tablero[x][y] = zombie.getId();
            }
        
        }
    
    }
    
    //Funcion que se encarga de encontrar las plantas en el tablero
    private void posPlantas(){
    
        Iterator<Planta> it = plantas.iterator();
        while(it.hasNext()){
            
            Planta plant = it.next();
            int x = plant.getPosX();
            int y = plant.getPosY();
            tablero[x][y] = plant.getId();
        }
    
    }
    
    
    //Funcion que simula el avance en el tiempo del juego
    private void avanzar(){
        //Esta funcion resulta polimorfica, ya que llama a las superclases zombie y plantas, pero puede ser cualquier subclase dentro de los arreglos correspondientes
        //Ejecutamos las acciones de todas las plantas
        Iterator<Planta> itP = plantas.iterator();
        while(itP.hasNext()){

            Planta plant = itP.next();
            //Hay subclases de plantas que implementan distintos tipo de disparo
            plant.atacar(zombies);
        
        }
        //Ejecutamos las acciones de todos los zombies
        Iterator<Zombie> itZ = zombies.iterator();
        while(itZ.hasNext()){
            Zombie zombie = itZ.next();
            //Hay subclases de zombie que implementan distintos metodos de caminar
            zombie.caminar(plantas);
        }
       
    
    }
    
    //Setter para quitar vida al jugador
    public void takeDamage(int damage){
    
        vida -= damage;
        System.out.println("PERDISTE VIDA!");
    
    }
    
    //Generamos los soles de los girasoles
    public void genSoles(){
        
        //Contamos la cantidad de girasoles
        int cant = 0;
        //Cantidad de soles a sumar por planta, obtenido de la clase girasol
        int ganancia = 0;
        Iterator<Planta> it = plantas.iterator();
        while(it.hasNext()){
            Planta plant = it.next();
            if(plant instanceof Girasol ){
                
                ganancia = ((Girasol) plant).getSoles();
                cant++;
            
            }
        
        }
        //Sumamos la cantidad de girasoles que tenemos por la ganancia que generan
        soles += cant*ganancia;
        totalSoles += cant*ganancia;
    
    }

}
