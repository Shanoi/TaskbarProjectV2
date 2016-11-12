package brainfuck.command;

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
        ComputationalModel cm = new ComputationalModel();
        if (cm.getCurrentIndice() < cm.getMemorySize()) {
            cm.setCurrentIndice(cm.getCurrentIndice() + 1);
        } else {
            System.exit(2);
        }
    }

}
