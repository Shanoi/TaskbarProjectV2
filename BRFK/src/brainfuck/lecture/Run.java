package brainfuck.lecture;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import brainfuck.Syntaxe;
import brainfuck.memory.ComputationalModel;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Stack;

public class Run {

    private final String path;

    private ComputationalModel cm;

    private static List<String> list = new ArrayList<String>();
    private static int i = 0;

    public Run(String path) {
        cm = new ComputationalModel();
        this.path = path;
    }

    public void load() throws IOException, FileNotFoundException {

        BufferedReader file = new BufferedReader(new FileReader(path));
        String line = new String();

        while ((line = file.readLine()) != null) {
            if (Syntaxe.isShort(line)) {
                for (int j = 0; j < line.length(); j++) {
                    list.add(Character.toString(line.charAt(j)));
                }
            } else {
                list.add(line);
            }
        }
        file.close();
    }

    public int getNbI() {
        return list.size();
    }

    public List<String> getInstructions() {
        return Run.list;
    }

    public ComputationalModel getCm() {
        return cm;
    }

    public int jumpAssoc(int i) {

        Stack<String> stack = new Stack<>();
        int o = cm.getI();

        stack.push(list.get(o));

        while (!stack.isEmpty()) {

            o++;

            if (list.get(o).equals("[")) {

                stack.push("[");

            }

            if (list.get(o).equals("]")) {

                stack.pop();

            }
        }
        return o;
    }

    public int backAssoc(int i) {

        Stack<String> stack = new Stack<String>();
        int o = cm.getI();

        stack.push(list.get(o));

        while (!stack.isEmpty()) {

            o--;

            if (list.get(o).equals("[")) {
                stack.pop();
            }

            if (list.get(o).equals("]")) {
                stack.push("]");
            }
        }
        return o;
    }

    public void execute() throws IOException, FileNotFoundException {

        cm.init();

        while (cm.getI() < list.size()) {

            if (Syntaxe.isShort(list.get(cm.getI()))) {

                shortSyntaxe.run(list.get(cm.getI()));

            } else {

                longSyntaxe.run(list.get(cm.getI()));

            }

            i = (cm.getI() + 1);
            cm.setI(i);
        }

    }

}
