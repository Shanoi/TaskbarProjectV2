package brainfuck.command;

import brainfuck.memory.ComputationalModel;
import brainfuck.lecture.Run;

/**
 * @author TeamTaskbar
 */
public class Jump implements Command {

    @Override
    public void execute() {

        Run run = new Run("");

        if (run.getCm().getCurrentCaseValue() == 0) {

            run.getCm().setI(run.jumpAssoc(run.getCm().getI()));

        }

    }

}
