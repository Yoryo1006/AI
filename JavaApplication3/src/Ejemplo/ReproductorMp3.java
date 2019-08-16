/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejemplo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class ReproductorMp3 {

   public static void main(String[] args) throws FileNotFoundException,JavaLayerException, InterruptedException {

      Player apl = new Player(new FileInputStream("C:\\Users\\jorge\\Downloads\\Hielo.mp3"));
     int pregunta=0;
       System.out.println("Seguir o parar");
      for(int h=0;h<10;h++){
         if(pregunta==0){
          apl.play();   
           
       }else{
             
         
         
       } 
      }
       
      
      
   }
   
           
}