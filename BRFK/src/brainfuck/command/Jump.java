package brainfuck.command;

import brainfuck.lecture.Fichiers;

/**
 * @author TeamTaskbar
 */
public class Jump implements Command {

    @Override
    public void execute() {

        Fichiers temp = new Fichiers("");

        if (temp.getCm().getCurrentCaseValue() == 0) {

            temp.getCm().setI(temp.jumpAssoc(temp.getCm().getI()));

        }

    }

}
