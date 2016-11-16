/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brainfuck.lecture;

import static brainfuck.command.EnumCommands.isCommand;
import static brainfuck.command.EnumCommands.toCommand;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Olivier
 */
public class Image extends Fichiers {

    private final int pixelSize = 3;

    public Image(String path) {
        super(path);
    }

    private BufferedImage createImg(int dim) {

        final BufferedImage res = new BufferedImage(dim, dim, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < dim; i += 3) {

            for (int j = 0; j < dim; j += 3) {

                for (int k = i, cpt1 = 0; cpt1 < pixelSize; k++, cpt1++) {

                    for (int l = j, cpt2 = 0; cpt2 < pixelSize; l++, cpt2++) {

                        if (i + j > getNbI()) {

                            res.setRGB(k, l, Color.decode(getInstructions().get(i + j).getColor()).getRGB());

                        } else {

                            res.setRGB(k, l, Color.decode("#000000").getRGB());

                        }

                    }
                }

            }

        }

        return res;

    }

    private void saveImg(final BufferedImage img, String path) throws IOException {

        RenderedImage rendImg = img;
        ImageIO.write(rendImg, "bmp", new File(path));

    }

    @Override
    public void Read() {

        try {
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

                        if (isCommand(Integer.toString(pixelcolorBase.getRGB())) && pixelcolorBase != Color.BLACK) {
                            
                            list.add(toCommand(Integer.toString(pixelcolorBase.getRGB())));
                            
                        } else {
                            
                            System.exit(4);
                            
                        }
                        
                    }

                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void Encod() {

        try {
            saveImg(createImg(5), "lol");
        } catch (IOException ex) {
            Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
