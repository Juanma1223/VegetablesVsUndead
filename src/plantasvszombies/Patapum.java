/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantasvszombies;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Juanma
 */
public class Patapum extends Planta{
    
    public Patapum(){
    
        super(0,0);
        damage=200;
        vida=100;
        coste=25;
        rango=1;
        id='P';
    
    }
    public Patapum(int x, int y){
    
        super(x,y);
        damage = 200;
        vida = 100;
        coste = 25;
        rango = 1;
        id = 'P';
    
    }
  
    //Overriding de atacar para poder eliminar la planta una vez atacado
    @Override
    public void atacar(ArrayList<Zombie> zombies){
        
        boolean damaged = false;
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
                        //Matamos nuestra planta, ya que una vez que explota muere
                        id = ' ';
                        damage = 0;
                        vida = 0;
                        
                    }
                    //Ya dañamos al primero, pero no podemos dañar al resto
                    break;
                
                }
            
            }
        
    
        }
    }
}
