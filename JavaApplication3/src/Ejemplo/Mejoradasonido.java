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

public class Mejoradasonido {

   static boolean pausa = false;

   public static void main(String[] args) throws FileNotFoundException,
         JavaLayerException, InterruptedException {
      final Player pl = new Player(new FileInputStream(
            "C:\\Users\\jorge\\Downloads\\Hielo.mp3"));

      new Thread() {
         public void run() {
            try {
               while (true) {
                  if (!pausa) {
                     if (!pl.play(1)) {
                        break;
                     }
                  }
               }
            } catch (JavaLayerException e) {
               e.printStackTrace();
            }
         }
      }.start();

      Thread.sleep(5000);
      pausa = true;
      System.out.println("pausado");
      Thread.sleep(2000);
      pausa = false;
   }
}