package brainfuck.command;

import brainfuck.lecture.Fichiers;
import brainfuck.memory.ComputationalModel;

/**
 *
 * @author TeamTaskbar
 */
public class Right implements Command {

    /**
     * Change the current cell of the memory, taking the cell at the right of
     * the current cell
     *
     */
    @Override
    public void execute() {
        Fichiers tempfile = new Fichiers("");
        if (tempfile.getCm().getCurrentIndice() < tempfile.getCm().getMemorySize()) {
            tempfile.getCm().setCurrentIndice(tempfile.getCm().getCurrentIndice() + 1);
        } else {
            System.exit(2);
        }
    }

}
