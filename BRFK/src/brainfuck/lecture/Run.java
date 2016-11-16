package brainfuck.lecture;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import brainfuck.command.EnumCommands;
import static brainfuck.command.EnumCommands.isCommand;
import static brainfuck.command.EnumCommands.toCommand;
import brainfuck.memory.ComputationalModel;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Run {

    protected final String path;

    private final ComputationalModel cm;

    //protected static final List<EnumCommands> list = new ArrayList<>();
    private int i = 0;

    public Run(String path) {

        cm = new ComputationalModel();
        this.path = path;

    }

    public ComputationalModel getCm() {
        return cm;
    }

    public void load() throws IOException, FileNotFoundException {

        if (path.lastIndexOf(".") > 0) {

            // On récupère l'extension du fichier
            String ext = path.substring(path.lastIndexOf("."));

            // Si le fichier n'est pas en .txt on le met en .txt
            if (".bmp".equals(ext)) {

                Image img = new Image(path);
                
            } else {

                Text txt = new Text(path);
                txt.Read();

            }

        } else {

            new Text(path).Read();

        }

    }

    public void execute() throws IOException, FileNotFoundException {

        cm.init();

        while (cm.getI() < Fichiers.list.size()) {

            Fichiers.list.get(i).getCommand().execute();

            i = (cm.getI() + 1);
            cm.setI(i);
        }

    }

}
