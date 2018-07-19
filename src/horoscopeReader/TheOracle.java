package horoscopeReader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.time.Year;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

//*****Credit for the horoscope goes to www.astrology.com*****

/**This class handles all the methods that retrieve and parse the horoscope. 
 * 
 * @author Nathan Herrmann
 * @version 4/24/17
 */
public class TheOracle implements ActionListener{
	
	protected String s = "";
	protected HoroscopeTextArea textArea;
	protected String sign;
	
	public TheOracle(HoroscopeTextArea label)
	{
		this.textArea = label;
	}
	
	/**This method retrieves a horoscope from astrology.com.  When the page is retrieved, the horoscope is found using the appropreate sign.
	 *The HTML doc is scanned for the daily horoscope, and converted to a string and the parsed to only leave the horoscope message. 
	 *
	 *@param String sign
	 */
	public void getHoroscope(String sign)
	{
		try {
		
			//Connects to the web page and gets the content
			Document doc = Jsoup.connect("https://www.astrology.com/horoscope/daily/today/" +sign+ 
					".html").get();
			//Retrieves the body of text from the content and converts it to a string.
			String text = doc.body().text();
			
			//Find where to parse the beginning of the body for the horoscope.
			int startParse = text.indexOf(Year.now().getValue() + ":") + 6;
			int endParse = startParse + 1;
			
			/*
			 * The text that follows the horoscope is randomly different.  Each of these
			 * cases will find which text is generated to parse the end of the horoscope.
			 */
			if(text.contains("Struggling to move on?")) {
				endParse = text.indexOf("Struggling to move on?");
			}
			if(text.contains("Got Questions?")) {
				endParse = text.indexOf("Got Questions?");
			}
			if(text.contains("Is your relationship worth fighting for?")) {
				endParse = text.indexOf("Is your relationship worth fighting for?");
			}
			if(text.contains("Discover what's in the cards for you")) {
				endParse = text.indexOf("Discover what's in the cards for you");
			}
			if(text.contains("Find the love you deserve!")) {
				endParse = text.indexOf("Find the love you deserve!");
			}
			if(text.contains("Feeling lost lately?")) {
				endParse = text.indexOf("Feeling lost lately?");
			}
			if(text.contains("Need an accurate prediction?")) {
				endParse = text.indexOf("Need an accurate prediction?");
			}
			if(text.contains("Let the cards reveal your future.")) {
				endParse = text.indexOf("Let the cards reveal your future.");
			}
			if(text.contains("Is love in your stars?")) {
				endParse = text.indexOf("Is love in your stars?");
			}
			if(text.contains("Are you soulmates?")) {
				endParse = text.indexOf("Are you soulmates?");
			}
			if(text.contains("Relationship going nowhere?")) {
				endParse = text.indexOf("Relationship going nowhere?");
			}
			if(text.contains("Get Instant Answers to all your")) {
				endParse = text.indexOf("Get Instant Answers to all your");
			}
			if(text.contains("Confused about your relationship?")) {
				endParse = text.indexOf("Confused about your relationship?");
			}
			if(text.contains("Should you hold on or move on?")) {
				endParse = text.indexOf("Should you hold on or move on?");
			}
			if(text.contains("Are psychics the new love coaches?")) {
				endParse = text.indexOf("Are psychics the new love coaches?");
			}
			if(text.contains("Feeling discouraged lately?")) {
				endParse = text.indexOf("Feeling discouraged lately?");
			}
			if(text.contains("Let love find you.")) {
				endParse = text.indexOf("Let love find you.");
			}
			if(text.contains("Is it true love?")) {
				endParse = text.indexOf("Is it true love?");
			}
			if(text.contains("Looking for a psychic reading?")) {
				endParse = text.indexOf("Looking for a psychic reading?");
			}
			if(text.contains("When will it happen?")) {
				endParse = text.indexOf("When will it happen?");
			}
			
			//Display horoscope on the text area.
			textArea.setText(text);
		}
		catch(Exception e){
			
			System.out.println("Failed to contact the site");
			textArea.setText("Could not read the signs.  Try again later.");
		}
	}
	
	
	/**This method will tell the HoroscopePanel what image should be painted.  It save the loaded image directly into the image variable
	 * in the HoroscopePanel
	 * 
	 * @param String sign
	 */
	public void setImage(String sign)
	{
		
		try{
			//Creates a scanner to get the image from the file.
			ClassLoader myLoader = this.getClass().getClassLoader();
			InputStream imageStream = myLoader.getResourceAsStream("resources/" + sign + ".jpg");
            
			//Sets the image that is to be loaded on the TextArea
			textArea.image = javax.imageio.ImageIO.read(imageStream);  // A handy helper method
            
		}
		 catch (IOException e)
        {
			//If the image does not load, consol prints this message.
            System.out.println("Failed to load image"); 
        }
	}

	
	public void actionPerformed(ActionEvent event) {
		
		Object source = event.getSource();
		this.sign = ((SignButton) source).getSign();
		
		this.getHoroscope(sign);
		this.setImage(sign.toLowerCase());	
	}
}
		


	
