package brainfuck.command;

import brainfuck.memory.ComputationalModel;
import static brainfuck.ComputationalModel.getI;
import static brainfuck.ComputationalModel.setI;
import brainfuck.lecture.Lecture;
import brainfuck.lecture.Run;

/**
 * @author TeamTaskbar
 */
public class Jump implements Command {

    @Override
    public void execute() {
        ComputationalModel cm = new ComputationalModel();
        if (cm.getCurrentCaseValue() == 0) {
            setI(Run.jumpAssoc(getI()));
        }

    }

}
