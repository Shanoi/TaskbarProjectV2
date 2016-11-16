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
        
        Fichiers temp = new Fichiers("");
        
        if (temp.getCm().getCurrentCaseValue() > 0) {
            
            temp.getCm().setI(temp.backAssoc(temp.getCm().getI()));
            
        }

    }

}
