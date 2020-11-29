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
public class Petacereza extends Planta{
    
    public Petacereza(){
    
        super(0,0);
        damage=200;
        id='B';
        coste=150;
    
    }
    public Petacereza(int x, int y){
    
        super(x,y);
        damage = 200;
        id = 'B';
        coste = 150;
    
    }
    
    //Override de atacar para poder realizar una explosion en el instante de plantarla
    @Override
    public void atacar(ArrayList<Zombie> zombies){
        
    //Flag para saber si daño
    //Buscamos entre los zombies a aquellos que corresponda atacar
    Iterator<Zombie> it = zombies.iterator();
    while(it.hasNext()){

        Zombie zombie = it.next();
        if(Math.abs(zombie.getPosX()-x) <= 3 && Math.abs(zombie.getPosY()-y) <= 3){
            zombie.takeDamage(damage);
            
        }
        if(zombie.getVida() <= 0){
        
            it.remove();
        
        }
        
    }
    //Dejamos a la planta inutilizable hasta que un zombie la detecte y la mate
    id=' ';
    vida=0;
    damage=0;
}
    
}
