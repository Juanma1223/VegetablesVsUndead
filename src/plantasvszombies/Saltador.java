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
public class Saltador extends Zombie{
    
    //Atributo que nos define si el zombie ya salto o no
    private boolean salto = false;
    
    public Saltador(){
    
        super(0);
        id = 'S';
        vida = 70;
        
    }
    public Saltador(double x){
    
        super(x);
        id = 'S';
        vida = 70;
    
    }
    
    //Ovrerride de doDamage para contemplar la posibilidad de salto
    @Override
    public void doDamage(ArrayList<Planta> plantas){
    
        //Reimplementamos de 0 ya que el cambio es muy estructural como para reutilizar la funcion de la superclase
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
                    //Podemos saltar la planta y por tanto caminamos por encima de ella
                    if(salto == false){
                        y--;
                        //Establecemos que ya se salto
                        salto = true;
                    
                    }else{
                        planta.takeDamage(damage);
                        attacking = true;   
                        break;
                    }
                }
            
            }
        
        }
    
    }
    
}
