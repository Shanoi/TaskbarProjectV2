package brainfuck.command;

import brainfuck.memory.ComputationalModel;
import brainfuck.lecture.Run;

/**
 * @author TeamTaskbar
 */
public class Jump implements Command {

    @Override
    public void execute() {
        ComputationalModel cm = new ComputationalModel();
        if (cm.getCurrentCaseValue() == 0) {
            cm.setI(Run.jumpAssoc(cm.getI()));
        }

    }

}
