package brainfuck.command;

import brainfuck.lecture.Fichiers;

/**
 * @author TeamTaskbar
 */
public class Jump implements Command {

    @Override
    public void execute() {

        Fichiers tempfile = new Fichiers("");

        if (tempfile.getCm().getCurrentCaseValue() == 0) {

            tempfile.getCm().setI(tempfile.jumpAssoc(tempfile.getCm().getI()));

        }

    }

}
