
package com.sdm.dynuclient.resources;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author sebad-git
 */
public class Resources {
    
    public static final String DYN_ICON = "logodynu.png";
    public static final String DYN_LOGO = "logo.png";
    public static final String DYN_USER = "user.png";
    
    public static final BufferedImage loadImage(final String fileName){
    try {
        final BufferedImage buff = ImageIO.read(Resources.class.getResourceAsStream(fileName));
       return buff;
    } catch (Exception e) { e.printStackTrace(); return null; }
  }
    
  public static final ImageIcon loadIcon(final String fileName){ return new ImageIcon(loadImage(fileName)); }
  
}
