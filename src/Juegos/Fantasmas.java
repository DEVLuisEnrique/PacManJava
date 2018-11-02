
package Juegos;

import static Juegos.Juego.mat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
//import Juegos.Juego;
 
public class Fantasmas {
  //Juego j = new Juego();
    //atributos
    int fanx,fany;
    Timer timer;
    Random aleatorio;
    int direccion,mx,my;
    
    //constructor
    public Fantasmas(int x,int y)//coordenadas del fantasm
    {
     aleatorio = new Random(); 
      fanx = x;
      fany = y;
      Juego.mat[fanx][fany]=7;
      direccion = aleatorio.nextInt(4);
      this.Movimiento();
    }
    public void Movimiento(){
        
          timer = new Timer (100, new ActionListener()//TIMER UTILIZADO PARA AJUSTAR LA VELOCIDAD DE MOVIMIENTO
        {
            public void actionPerformed(ActionEvent e)
            { 
                //System.out.println("Esta funcionando el timer");
                //izquierda
               if(direccion == 0){
                   System.out.println("aqui "+direccion);
                   //camina
                   if(Juego.mat[fanx-1][fany] != 2 &&(Juego.mat[fanx-1][fany] == 0 ||Juego.mat[fanx-1][fany] == 1 )){
                    Juego.mat[fanx][fany] = Juego.matAux[fanx][fany];
                    fanx -=1;
                    Juego.mat[fanx][fany] =7;
                    Juego.pintarMatriz();
                    //j.pintarMatriz();
                   }else
                   //choca con la pared
                   if(fanx > 0 && Juego.mat[fanx-1][fany] == 2)
                    {
                        direccion = aleatorio.nextInt(4);
                    }else
                   
                   //choca con otro fantasma
                   if(Juego.mat[fanx-1][fany] == 7)
                    {
                        direccion = aleatorio.nextInt(4);
                    }
                   

                 }
                //derecha
               if(direccion == 1){
                   System.out.println("aqui "+direccion);
                   //caminar
                   if(Juego.mat[fanx+1][fany] != 2 &&(Juego.mat[fanx+1][fany] == 0 || Juego.mat[fanx+1][fany] == 1 )){
                    Juego.mat[fanx][fany] = Juego.matAux[fanx][fany];
                    fanx +=1;
                    Juego.mat[fanx][fany] =7;
                    Juego.pintarMatriz();
                    //j.pintarMatriz();
                    
                   
                   }else
                   //choca con la pared
                   if(fanx < 14  && Juego.mat[fanx+1][fany] == 2)
                    {
                        direccion = aleatorio.nextInt(4);
                    }else
                   
                   //choca con otro fantasma
                   if(Juego.mat[fanx+1][fany] == 7)
                    {
                        direccion = aleatorio.nextInt(4);
                    }

                 }
                 //arriba
                if(direccion == 2){
                    System.out.println("aqui "+direccion);
                    //caminar
                    if(Juego.mat[fanx][fany-1] != 2 &&(Juego.mat[fanx][fany-1] == 0 ||Juego.mat[fanx][fany-1] == 1 )){
                    Juego.mat[fanx][fany] = Juego.matAux[fanx][fany];
                    fany -=1;
                    Juego.mat[fanx][fany] =7;
                    Juego.pintarMatriz();
                   //j.pintarMatriz();
                    
                    }else
                     //choca con la pared
                     if(fanx > 0 && Juego.mat[fanx][fany-1] == 2)
                    {
                        direccion = aleatorio.nextInt(4);
                    }else
                     
                     //choca con otro fantasma
                   if(Juego.mat[fanx][fany-1] == 7)
                    {
                        direccion = aleatorio.nextInt(4);
                    } 

                 }
                  //abajo
                if(direccion == 3){
                    System.out.println("aqui "+direccion);
                   //caminar 
                   if(Juego.mat[fanx][fany+1] != 2 &&(Juego.mat[fanx][fany+1] == 0 ||Juego.mat[fanx][fany+1] == 1 )){
                    Juego.mat[fanx][fany] = Juego.matAux[fanx][fany];
                       fany +=1;
                    Juego.mat[fanx][fany] =7;
                    Juego.pintarMatriz();
                    //j.pintarMatriz();
                   
                   }else
                    //choca con la pared
                    if(fanx < 14  && Juego.mat[fanx][fany+1] == 2)
                    {
                        direccion = aleatorio.nextInt(4);
                    }else
                    //choca con otro fantasma
                   if(Juego.mat[fanx][fany+1] == 7)
                    {
                        direccion = aleatorio.nextInt(4);
                    }  

                 }
                
                
               
               
            }});
          timer.start();
    
    }
    
}
