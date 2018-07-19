package horoscopeReader;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JTextArea;


/**Functions as a JTextArea with the exception of having a background image printed, rather than a solid color.
 * 
 * @author Nathan Herrmann
 * @version 4/24/17
 */
public class HoroscopeTextArea extends JTextArea {
	private static final long serialVersionUID = -2879025440902582285L;
	
	
	//This image is saved here in order to paint it later, TheOracle has direct control over which image is saved here.
	protected BufferedImage image;
	
	
	//Overrides the paintComponent of the superclass
	public void paintComponent(Graphics g)
	{	
		//This creates a pink background, similar to the pictures that are loaded by TheOracle, but blank
		g.setColor(new Color(255, 170, 255));
		g.fillRect(0, 0, 800, 370);
		
		//Calls the image to be drawn over the background.
		g.drawImage(image, 0, 0, null);
		//After the image is painted, the JTextArea resumes its paint method as it should be.
		super.paintComponent(g);	
	}
	
	
}