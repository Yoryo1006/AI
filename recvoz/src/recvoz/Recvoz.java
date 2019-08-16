
package recvoz;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.

/**
 *
 * @author Cmop
 */
import com.sun.speech.freetts.VoiceManager;
import javax.speech.*;
import javax.speech.recognition.*;
import java.io.FileReader;
import java.util.Locale;
import com.sun.speech.freetts.Voice;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Formatter;
import javax.swing.JOptionPane;
 import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
 
public class Recvoz extends ResultAdapter{

    public static Voice voice;
    VoiceManager voz=VoiceManager.getInstance();
 static Recognizer recognizer;
 String gst;
 String palabra="";
 
 @Override

 public void resultAccepted(ResultEvent re){
 try
 {
 Result res = (Result)(re.getSource());
 ResultToken tokens[] = res.getBestTokens();
 
 
 String args[]= new String[1];
 args[0]="";
 for (int i=0; i < tokens.length; i++)
 {
 gst = tokens[i].getSpokenText();
 args[0]+=gst+" ";

 System.out.print(gst + " ");
 palabra=palabra+" "+gst;
 }
 System.out.println();
 
 //si cumple esto empieza a ejecutar el codigo
//if(palabra.equals(" compu")||palabra.equals(" computadora")||palabra.equals(" comando")){
    String codigo_bat="";
//  \\
   switch (palabra) {
    case " compu sonido de hoy":
        System.out.println("entor");
        
    Player apl = new Player(new FileInputStream("C:\\Users\\jorge\\Downloads\\Hielo.mp3"));
        apl.play();
          break;
    case " computadora apaga el computador T2R":
        codigo_bat="start \"\" \"C:\\Users\\jorge\\Downloads\\nircmd.exe\" nircmd.exe monitor off";
        // Ejecutar si el valor de variable es igual a valor_1 o a valor_2
        
        //
        break; // Salir del switch
    case " compu di alguna cosa":
        // Ejecutar si el valor de variable es igual a valor_3
      //
        break; // Salir del switch
    case " computadora baja el volumen h":
        // Ejecutar si el valor de variable es igual a valor_3
        //
        break; // Salir del switch   
        case " compu sube el bolumen o":
        // Ejecutar si el valor de variable es igual a valor_3
        //
        break; // Salir del switch
    default:
        // Ejecutar si el valor de varible es distinto del del resto de casos
       // ejecutarC();
        break; // Salir del switch
} 

//crear archivo
    
   String ubicacion= System.getProperty("user.dir")+"\\Registros\\";
   String archivo="Comando"+".bat";
   File crea_ubicacion = new File(ubicacion);
   File crea_archivo = new File(ubicacion+archivo);
   
  
       try {
       crea_ubicacion.mkdir();
       Formatter crea = new Formatter(ubicacion+archivo);   
       crea.format("%s\r\n",""+codigo_bat);
       crea.close();
        JOptionPane.showMessageDialog(null,"Archivo exitoso");
       } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se pudo");
       }
     
  // }
   

     

     

     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     

     
     
     
     
     
     
     
     
     
     
     
     
     
       try {
      Runtime.getRuntime().exec( "wscript C:\\Users\\jorge\\Desktop\\como.VBS" );
       
   }
   catch( IOException e ) {
      System.out.println(e);
      System.exit(0);
   }
     
 if(palabra.equals("Salir")){    
 
   
 recognizer.deallocate();
 args[0]="Hasta la proxima Cmop!";
 System.out.println(args[0]);

 System.exit(0);
 }
 else
 {
 recognizer.suspend();
 
 recognizer.resume();
 }
 palabra="";
 }catch(Exception ex)
 {
 System.out.println("Ha ocurrido algo inesperado " + ex);
 }
 }
 
 public static void main(String args[])
 {
 try
 {
 recognizer = Central.createRecognizer(new EngineModeDesc(Locale.ROOT));
 recognizer.allocate();
 
 FileReader grammar1 =new FileReader("libreria/diccionario.txt");
 
 RuleGrammar rg = recognizer.loadJSGF(grammar1);
 rg.setEnabled(true);
 
 recognizer.addResultListener(new Recvoz());
 
 System.out.println("Empieze Dictado");
 recognizer.commitChanges();
 
 recognizer.requestFocus();
 recognizer.resume();
 }catch (Exception e)
 {
 System.out.println("Exception en " + e.toString());
 e.printStackTrace();
 System.exit(0);
 }
 }
}
