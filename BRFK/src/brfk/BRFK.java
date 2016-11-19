/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brfk;

import brainfuck.command.EnumCommands;
import brainfuck.lecture.Image;
import brainfuck.lecture.Run;
import brainfuck.lecture.Text;
import brainfuck.memory.Wellformed;
import com.sun.prism.paint.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Olivier
 */
public class BRFK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Text txt = new Text("D:/Users/Olivier/Documents/NetBeansProjects/Brainfuck.v2/src/brainfuck/v2/instr.txt");

        try {
            txt.Read();
        } catch (IOException ex) {
            Logger.getLogger(BRFK.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("TAillel -- " + txt.getNbI());
        
        Image img = new Image("D:/Users/Olivier/Documents/NetBeansProjects/Brainfuck.v2/src/brainfuck/v2/instr.txt");

        img.Encod();

        /*Run run = new Run("D:/Users/Olivier/Documents/NetBeansProjects/Brainfuck.v2/src/brainfuck/v2/instr.txt");
        
         try {
         run.load();
         } catch (IOException ex) {
         Logger.getLogger(BRFK.class.getName()).log(Level.SEVERE, null, ex);
         }*/
        //System.out.println("NB : "+ run.getNbI());
        /*try {
         run.execute();
         } catch (IOException ex) {
         Logger.getLogger(BRFK.class.getName()).log(Level.SEVERE, null, ex);
         }
         run.getCm().affichememoire();*/
       // Wellformed WF = new Wellformed((ArrayList<EnumCommands>) run.getInstructions());
        /* try {
         WF.execute();
         } catch (IOException ex) {
         Logger.getLogger(BRFK.class.getName()).log(Level.SEVERE, null, ex);
         }
         System.out.println("NB : "+ run.getNbI());*/
        /*try {
         run.execute();
         } catch (IOException ex) {
         Logger.getLogger(BRFK.class.getName()).log(Level.SEVERE, null, ex);
         }
         run.getCm().affichememoire();*/
    }

}
