/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
public class Comandos {

    /**
     * @param args the command line arguments
     */
    public static  void main(String[] args) {
 try {
      Runtime.getRuntime().exec( "wscript C:\\Users\\jorge\\Desktop\\como.VBS" );
   }
   catch( IOException e ) {
      System.out.println(e);
      System.exit(0);
   }
            //String cmd;
//cmd ="C:\\Users\\jorge\\Desktop\\como.VBS";
            
//cmd = "C:/ruta/de/script/VB/Script.vbs";
//try {
//Runtime r = Runtime.getRuntime();
//Process p = r.exec(cmd);
//}catch(Exception ex) {
//System.err.println("Error cargandoloading script: " + ex.toString());
//}
            //    Runtime.getRuntime().exec("cmd /c start C:\\Users\\jorge\\Desktop\\comaa.bat");
            // } catch (IOException ex) {
            //      Logger.getLogger(Comandos.class.getName()).log(Level.SEVERE, null, ex);
            // }
      
      
        
       
       
    }
    
}
