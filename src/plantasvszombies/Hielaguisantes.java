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
public class Hielaguisantes extends Planta{
    
    public Hielaguisantes(){
    
        super(0,0);
        id='H';
        coste= 175;
        rango=9;
        
    }
    public Hielaguisantes(int x, int y){
    
        super(x,y);
        id = 'H';
        coste = 175;
        rango = 9;
    
    }
    
    //Override de atacar para poder congelar a los zombies
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
                zombie.freeze();
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