/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantasvszombies;
import java.util.ArrayList;
/**
 *
 * @author Juanma
 */
public class Repetidora extends Planta{
    
    public Repetidora(){
    
        super(0,0);
        coste=200;
        id='D';
        
    
    }
    public Repetidora(int x, int y){
    
        super(x,y);
        coste=200;
        id='D';
    
    }
    
    @Override
    public void atacar(ArrayList<Zombie> zombies){
    
        //Atacamos dos veces como forma de ataque de la planta
        super.atacar(zombies);
        super.atacar(zombies);
    
    }
    
}
