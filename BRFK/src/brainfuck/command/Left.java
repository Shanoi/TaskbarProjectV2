package brainfuck.command;

import brainfuck.lecture.Fichiers;
import brainfuck.memory.ComputationalModel;

/**
 *
 * @author TeamTaskbar
 */
public class Left implements Command {

    /**
     * Change the current cell of the memory, taking the cell at the left of the
     * current cell
     *
     */
    @Override
    public void execute() {
       Fichiers tempfile = new Fichiers("");
        if (tempfile.getCm().getCurrentIndice() > 0) {
            tempfile.getCm().setCurrentIndice(tempfile.getCm().getCurrentIndice() - 1);
        } else {
            System.exit(2);
        }
    }

}
