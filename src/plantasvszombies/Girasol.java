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
public class Girasol extends Planta{
    
    //Atributo que nos dice la cantidad de soles que genera
    private int soles;
    
    public Girasol(){
    
        super(0,0);
        vida = 125;
        id='G';
        coste = 50;
        rango=0;
        damage=0;
        soles=25;
    
    }
    public Girasol(int x, int y){
        
        super(x,y);
        vida = 125;
        id = 'G';
        coste = 50;
        rango = 0;
        damage = 0;
        soles = 25;
    
    }
    
    //Metodo que devuelve la cantidad de soles generados
    public int getSoles(){
    
        return soles;
    
    }
    
    //Sobreescribimos el metodo atacar para que no haga nada y no gaste recursos
    @Override
    public void atacar(ArrayList<Zombie> zombies){
    
        //Los girasoles no atacan!
    
    }
    
}
