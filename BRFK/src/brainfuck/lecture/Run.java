package brainfuck.lecture;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import brainfuck.command.EnumCommands;
import static brainfuck.command.EnumCommands.BACK;
import static brainfuck.command.EnumCommands.JUMP;
import static brainfuck.command.EnumCommands.isCommand;
import static brainfuck.command.EnumCommands.toCommand;
import brainfuck.memory.ComputationalModel;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Stack;

public class Run {

    private final String path;

    private ComputationalModel cm;

    private static List<EnumCommands> list = new ArrayList<>();
    private static int i = 0;

    public Run(String path) {
        cm = new ComputationalModel();
        this.path = path;
    }

    public void load() throws IOException, FileNotFoundException {

        BufferedReader file = new BufferedReader(new FileReader(path));
        String line = new String();

        while ((line = file.readLine()) != null) {

            if ((line.charAt(0) >= 'A') && (line.charAt(0) <= 'Z')) {

                for (int j = 0; j < line.length(); j++) {

                    if (isCommand(line)) {

                        list.add(toCommand((Character.toString(line.charAt(j)))));

                    } else {

                        System.exit(4);

                    }

                }

            } else {

                if (isCommand(line)) {

                    list.add(toCommand(line));

                } else {

                    System.exit(4);

                }

            }
        }

        file.close();
    }

    public int getNbI() {
        return list.size();
    }

    public List<EnumCommands> getInstructions() {
        return Run.list;
    }

    public ComputationalModel getCm() {
        return cm;
    }

    public int jumpAssoc(int i) {

        Stack<EnumCommands> stack = new Stack<>();
        int o = cm.getI();

        stack.push(list.get(o));

        while (!stack.isEmpty()) {

            o++;

            if (list.get(o) == JUMP) {

                stack.push(list.get(o));

            }

            if (list.get(o) == BACK) {

                stack.pop();

            }
        }
        return o;
    }

    public int backAssoc(int i) {

        Stack<EnumCommands> stack = new Stack<>();
        int o = cm.getI();

        stack.push(list.get(o));

        while (!stack.isEmpty()) {

            o--;

            if (list.get(o) == JUMP) {

                stack.pop();
            }

            if (list.get(o) == BACK) {

                stack.push(list.get(o));

            }
        }
        return o;
    }

    public void execute() throws IOException, FileNotFoundException {

        cm.init();

        while (cm.getI() < list.size()) {

            list.get(i).getCommand().execute();

            i = (cm.getI() + 1);
            cm.setI(i);
        }

    }

}
