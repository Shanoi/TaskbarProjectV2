package brainfuck.lecture;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import brainfuck.command.EnumCommands;
import static brainfuck.command.EnumCommands.BACK;
import static brainfuck.command.EnumCommands.JUMP;
import static brainfuck.command.EnumCommands.isCommand;
import static brainfuck.command.EnumCommands.toCommand;
import brainfuck.memory.ComputationalModel;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Stack;
import javax.imageio.ImageIO;

public class Run {

    private final String path;

    private ComputationalModel cm;

    private static List<EnumCommands> list = new ArrayList<>();
    private static int i = 0;

    public Run(String path) {
        cm = new ComputationalModel();
        this.path = path;
    }

    public void load() throws IOException, FileNotFoundException {

        if (path.lastIndexOf(".") > 0) {

            // On récupère l'extension du fichier
            String ext = path.substring(path.lastIndexOf("."));

            // Si le fichier n'est pas en .txt on le met en .txt
            if (".bmp".equals(ext)) {

                new Image().ReadImage();
                
            } else {

                new Text().ReadText();

            }

        } else {

            new Text().ReadText();

        }

    }

    public int getNbI() {
        return list.size();
    }

    public List<EnumCommands> getInstructions() {
        return Run.list;
    }

    public ComputationalModel getCm() {
        return cm;
    }

    public int jumpAssoc(int i) {

        Stack<EnumCommands> stack = new Stack<>();
        int o = cm.getI();

        stack.push(list.get(o));

        while (!stack.isEmpty()) {

            o++;

            if (list.get(o) == JUMP) {

                stack.push(list.get(o));

            }

            if (list.get(o) == BACK) {

                stack.pop();

            }
        }
        return o;
    }

    public int backAssoc(int i) {

        Stack<EnumCommands> stack = new Stack<>();
        int o = cm.getI();

        stack.push(list.get(o));

        while (!stack.isEmpty()) {

            o--;

            if (list.get(o) == JUMP) {

                stack.pop();
            }

            if (list.get(o) == BACK) {

                stack.push(list.get(o));

            }
        }
        return o;
    }

    public void execute() throws IOException, FileNotFoundException {

        cm.init();

        while (cm.getI() < list.size()) {

            list.get(i).getCommand().execute();

            i = (cm.getI() + 1);
            cm.setI(i);
        }

    }

    private class Image {

        private void ReadImage() throws IOException {

            BufferedImage img = null;

            img = ImageIO.read(new File(path));

            if (img.getHeight() % 3 == 0 && img.getWidth() % 3 == 0) {

                for (int o = 0; o < img.getHeight(); o += 3) {

                    for (int j = 0; j < img.getWidth(); j += 3) {

                        Color pixelcolorBase = new Color(img.getRGB(j, o));

                        for (int k = o, cpt1 = 0; cpt1 < 3; k++, cpt1++) {

                            for (int l = j, cpt2 = 0; cpt2 < 3; l++, cpt2++) {

                                Color pixelcolor = new Color(img.getRGB(l, k));

                                if (!pixelcolor.equals(pixelcolorBase)) {

                                    System.exit(9);

                                }

                            }

                        }

                        list.add(toCommand(Integer.toString(pixelcolorBase.getRGB())));

                    }

                }
            }

        }

    }

    private class Text {

        private void ReadText() throws FileNotFoundException, IOException {

            BufferedReader file = new BufferedReader(new FileReader(path));
            String line = new String();

            while ((line = file.readLine()) != null) {

                if ((line.charAt(0) >= 'A') && (line.charAt(0) <= 'Z')) {

                    for (int j = 0; j < line.length(); j++) {

                        if (isCommand(line)) {

                            list.add(toCommand((Character.toString(line.charAt(j)))));

                        } else {

                            System.exit(4);

                        }

                    }

                } else {

                    if (isCommand(line)) {

                        list.add(toCommand(line));

                    } else {

                        System.exit(4);

                    }

                }
            }

            file.close();

        }

    }

}
