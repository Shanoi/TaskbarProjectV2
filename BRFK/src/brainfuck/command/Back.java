package brainfuck.command;

import brainfuck.lecture.Run;

/**
 *
 * @author TeamTaskbar
 */
public class Back implements Command {

    int i = 0;

    @Override
    public void execute() {
        
        Run run = new Run("");
        
        if (run.getCm().getCurrentCaseValue() > 0) {
            
            run.getCm().setI(run.backAssoc(run.getCm().getI()));
            
        }

    }

}
