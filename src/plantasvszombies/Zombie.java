/*
    Superclase Zombie, esta representa al zombie comun y de esta herederan todos los tipos de zombies
    en esta clase se encuentran todos los comportamientos basicos de los zombies
    pueden ser reimplementados por las subclases
 */
package plantasvszombies;
import java.util.Iterator;
import java.util.ArrayList;

/**
 *
 * @author Juanma
 */
public class Zombie {
    
    protected int vida;
    //Variable que define su posicion en x dentro del tablero
    protected int x;
    //Variable que defina la posicion en y dentro del tablero
    protected int y;
    //Variable que representa el daño que produce el zombie
    protected int damage;
    //Caracter utilizado para identificar al zombie
    protected char id;
    //Bandera que nos indica si el zombie esta atacando y no debe avanzar
    protected boolean attacking;
    //0 significa no relentizado, 1 significa relentizado hace poco, 2 significa recien relentizado
    private int relentizado;
    
    public Zombie(){
    
        vida = 100;
        this.x = 0;
        id = 'Z';
        y=9;
        damage = 30;
        attacking = false;
        relentizado = 0;
    
    }
    //Constructor del zombie
    public Zombie(double x){
        
        vida = 100;
        this.x = (int)x;
        id = 'Z';
        y=9;
        damage = 30;
        attacking = false;
        relentizado = 0;
    
    }
    
    //Funcion que aumenta en 1 la posicion en y del zombie
    public void caminar(ArrayList<Planta> plantas){
        doDamage(plantas);
        //Verificamos si llegamos al final del tablero
        if((y>0) && (attacking == false) && (relentizado < 2)){
            
            y--;
         
        }
        if(relentizado > 0){
            
            relentizado--;
                
        }
    
    }
    
    //Este metodo congela al zombie, y en su proximo movimiento no podra caminar
    public void freeze(){
        
        //Si no ha sido relentizado hace poco, relentizarlo
        if(relentizado == 0){
            relentizado = 2;
        }
    
    }
    //Metodo que hace daño a las plantas
    public void doDamage(ArrayList<Planta> plantas){
    
        //Verificamos si tenemos una planta en frente
        Iterator<Planta> it = plantas.iterator();
        while(it.hasNext()){
        
            Planta planta = it.next();
            if(planta.getPosX() == x && (planta.getPosY()+1) == y){
                //Verificamos si no matamos la planta
                if(planta.getVida() <= damage){
                    //La matamos
                    it.remove();
                    System.out.println("Ha muerto una planta!");
                    attacking = false;
                
                }else{
                
                    planta.takeDamage(damage);
                    attacking = true;   
                    break;
                
                }
            
            }
        
        }
    
    }
    
    //Getter para la posicion en x
    public int getPosX(){
    
        return x;
        
    }
    
    //Getter para la posicion en y
    public int getPosY(){
    
        return y;
        
    }
    
    //Getter para el id del zombie
    public char getId(){
    
        return id;
    
    }
    
    //Getter para el daño del zombie
    public int getDamage(){
    
        return damage;
    
    }
    
    //Getter que nos devuelve la vida del zombie
    public int getVida(){
    
        return vida;
        
    }
    
    
    public void takeDamage(int damage){
    
        vida -= damage;
    
    }
    
}
