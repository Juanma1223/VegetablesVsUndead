/*
    Superclase Planta, esta clase contiene todos los comportamientos basicos de una planta
    cada una de las subclases puede reimplementar los comportamientos segun el tipo de planta que sea
    
 */
package plantasvszombies;
import java.util.ArrayList;
import java.util.Iterator;

public class Planta {
    
    protected int vida;
    protected int x;
    protected int y;
    //Constante que identifica la planta con un caracter
    protected char id;
    protected int coste;
    //Atributo que nos indica el daño de la planta
    protected int damage;
    //Atributo que indica la cantidad de casillas a la que la planta puede disparar
    protected int rango;
    
    public Planta(){
    
        vida=100;
        id='L';
        this.x = x;
        this.y = y;
        coste = 100;
        rango=6;
        damage=30;
    
    }
    public Planta(int x, int y){
    
        vida = 100;
        id = 'L';
        this.x = x;
        this.y = y;
        coste = 100;
        rango = 6;
        damage = 30;
    
    }
    
    public int getPosX(){
    
        return x;
    
    }
    
    public int getPosY(){
    
        return y;
    
    }
    
    public int getCoste(){
    
        return coste;
        
    }
    
    public char getId(){
    
        return id;
        
    }
    
    public int getDamage(){
    
        return damage;
    
    }
    
    public int getVida(){
    
        return vida;
    
    }
    
    public void takeDamage(int damage){
    
        vida -= damage;
    
    }
    
    //Esta funcion es la encargada de buscar y atacar a los zombies
    public void atacar(ArrayList<Zombie> zombies){
    
        //Buscamos entre los zombies a aquellos que corresponda atacar
        Iterator<Zombie> it = zombies.iterator();
        while(it.hasNext()){
        
            Zombie zombie = it.next();
            //Verificamos si esta en la misma fila
            if(zombie.getPosX() == x){
                //Verificamos que el zombi este en rango
                if(zombie.getPosY() <= (y+rango)){
                
                    //Encontramos un zombie en el camino
                    zombie.takeDamage(damage);
                    //Verificamos si matamos al zombie
                    if(zombie.getVida() <= 0){
                        
                        it.remove();
                    
                    }
                    //Ya dañamos al primero, pero no podemos dañar al resto
                    break;
                
                }
            
            }
        
        }
        
    
    }
    
    
    
}
