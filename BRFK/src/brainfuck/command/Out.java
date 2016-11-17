package brainfuck.command;

import brainfuck.lecture.Fichiers;
import brainfuck.memory.ComputationalModel;
import brainfuck.memory.Interpreter;

import java.io.*;

public class Out implements Command {
    private String file;
    private static String tempString="";

    @Override
    public void execute() {
        Fichiers tempfile = new Fichiers("");
        if(file.equals("")){
            System.out.println((char) tempfile.getCm().getCurrentCaseValue());
        }
        else{
            file= Interpreter.getFileOut();
            try {
                FileWriter inputFile = new FileWriter(new File(file));
                FileReader tampon=new FileReader(new File(file));
                int temp=tampon.read();
                while(temp!=-1){
                    tempString+=(char)temp;
                }
                tempString+=(char)tempfile.getCm().getCurrentCaseValue();
                inputFile.write(tempString);
                inputFile.close();
                tampon.close();

            } catch(FileNotFoundException e){
                System.exit(3);

            } catch(IOException e){
                System.exit(3);
            }
        }

    }

}
