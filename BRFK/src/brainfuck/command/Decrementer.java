package brainfuck.command;

import brainfuck.lecture.Fichiers;
import brainfuck.lecture.Run;
import brainfuck.memory.ComputationalModel;

/**
 *
 * @author TeamTaskbar
 */
public class Decrementer implements Command {

    /**
     * Decrement the value of the current cell of the memory
     *
     */
    @Override
    public void execute() {
        
        Fichiers tempfile = new Fichiers("");
            
        Run.IncrEXEC_MOVE();
        Run.IncrDATA_WRITE();
        
        if (tempfile.getCm().getCurrentCaseValue() > 0) {
            tempfile.getCm().setCurrentCaseValue((byte) (tempfile.getCm().getCurrentCaseValue() - 1));
        } else {
            System.exit(1);
        }
    }

}
