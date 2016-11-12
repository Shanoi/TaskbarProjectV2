package brainfuck.command;

import brainfuck.memory.ComputationalModel;
import brainfuck.lecture.Run;

/**
 *
 * @author TeamTaskbar
 */
public class Back implements Command {
    int i=0;

    @Override
    public void execute() {
        ComputationalModel cm = new ComputationalModel();
        if(cm.getCurrentCaseValue() > 0) {
            setI(Run.backAssoc(cm.getI()));
        }


    }


}






