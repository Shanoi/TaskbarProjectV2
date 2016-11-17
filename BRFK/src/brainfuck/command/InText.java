package brainfuck.command;

import brainfuck.lecture.Fichiers;
import brainfuck.memory.ComputationalModel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

/**
 * @author TeamTaskbar
 */
public class InText implements Command {

    private String file;
    private static int cnt = 0;
    private int temp = 0;

    public void InText(String file) {
        this.file = file;
    }

    @Override
    public void execute() {
        Fichiers tempfile = new Fichiers("");
        File inputFile = new File(file);
        FileReader in = null;
        try {
            in = new FileReader(inputFile);

            for (int i = 0; i <= cnt; i++) {
                temp = in.read();
            }
            if (temp != -1) {
                tempfile.getCm().setCurrentCaseValue((byte) (char) temp);
                cnt++;
            } else {
                System.exit(3);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
