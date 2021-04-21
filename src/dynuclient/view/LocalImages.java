
package dynuclient.view;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 *
 * @author sebad-git
 */
public class LocalImages {
    
    public static final String DYN_ICON = "logodynu.png";
     
    public static BufferedImage loadImage(String fileName){
    try {
        BufferedImage buff = ImageIO.read(DynuClient.class.getResourceAsStream(fileName));
       return buff;
    } catch (Exception e) { e.printStackTrace(); return null; }
  }
    
}
