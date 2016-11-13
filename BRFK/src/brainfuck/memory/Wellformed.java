package brainfuck.memory;

import brainfuck.command.EnumCommands;
import static brainfuck.command.EnumCommands.BACK;
import static brainfuck.command.EnumCommands.JUMP;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Stack;

public class Wellformed {

    private Stack<String> stack = new Stack<>();

    //private final String path;
    private ArrayList<EnumCommands> commands;

    public Wellformed(ArrayList<EnumCommands> commands) {

        this.commands = commands;

    }

    public void execute() throws IOException, FileNotFoundException {

        commands.stream().map((get) -> {
            if (get == JUMP) {
                pushStack("[");
            }
            return get;
        }).map((get) -> {
            if (get == BACK && IsemptyStack()) {
                System.exit(4);
            }
            return get;
        }).filter((get) -> (get == BACK && !IsemptyStack())).forEach((_item) -> {
            popStack();
        });

    }

    private void popStack() {
        stack.pop();
    }

    private void pushStack(String line) {
        stack.push(line);
    }

    private boolean IsemptyStack() {
        return stack.empty();
    }

}
