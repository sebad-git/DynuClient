
package dynuclient.view.util;

import dynuclient.view.main.DynuClient;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author sebad-git
 */
public class LocalImages {
    
    public static final String DYN_ICON = "logodynu.png";
    public static final String DYN_LOGO = "logo.png";
    public static final String DYN_USER = "user.png";
    
    public static BufferedImage loadImage(String fileName){
    try {
        BufferedImage buff = ImageIO.read(LocalImages.class.getResourceAsStream(fileName));
       return buff;
    } catch (Exception e) { e.printStackTrace(); return null; }
  }
    
  public static ImageIcon loadIcon(String fileName){ return new ImageIcon(loadImage(fileName)); }
  
}
