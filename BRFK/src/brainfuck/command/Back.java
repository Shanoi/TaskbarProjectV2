package brainfuck.command;

import brainfuck.lecture.Fichiers;

/**
 *
 * @author TeamTaskbar
 */
public class Back implements Command {

    int i = 0;

    @Override
    public void execute() {

        Fichiers tempfile = new Fichiers("");

        if (tempfile.getCm().getCurrentCaseValue() > 0) {

            tempfile.getCm().setI(tempfile.backAssoc(tempfile.getCm().getI()));

        }

    }

}
