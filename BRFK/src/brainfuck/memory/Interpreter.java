package brainfuck.memory;

import java.util.Arrays;
import brainfuck.lecture.*;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Interpreter {

    private ComputationalModel cm = new ComputationalModel();
    private String path = new String();
    private List<String> args;

    private static String filein = "";
    private static String fileout = "";

    /**
     * Initialize the different command
     *
     * @param path
     * @param args
     */
    public Text(String path, String[] args) {

        this.path = path;
	this.args = new ArrayList(Arrays.asList(args));

        for (int i = 0; i < args.length; i++) {

            if (args[i].equals("-o")) {

                fileout = args[i + 1];

            }

            if (args[i].equals("-i")) {

                filein = args[i + 1];

            }

        }

    }

    public static String getFileIn() {
        return filein;
    }

    public static String getFileOut() {
        return fileout;
    }

    /**
     * This method read the content of the file and execute the different
     * Command associate This method can read long and short synthaxe and also
     * the mixed syntaxe
     *
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     */
    public void launchInterpreter() throws IOException, FileNotFoundException {

        Lecture test2 = new Wellformed(path);
        test2.execute();

    }

}
