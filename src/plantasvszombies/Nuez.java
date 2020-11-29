/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantasvszombies;

import java.util.ArrayList;


public class Nuez extends Planta{
    
    public Nuez(){
    
        super(0,0);
        id='N';
        vida=400;
        coste=50;
        rango=0;
        damage=0;
    
    }
    public Nuez(int x, int y){
    
        super(x,y);
        id = 'N';
        vida = 400;
        coste = 50;
        rango = 0;
        damage = 0;
    
    }
    
    //Sobreescribimos el metodo atacar para que no haga nada y no gaste recursos
    @Override
    public void atacar(ArrayList<Zombie> zombies){
    
        //Las nueces no atacan!
    
    }
}
