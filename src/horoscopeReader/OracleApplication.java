package horoscopeReader;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


/**This program will tell you your daily horoscope according to www.astrology.com
 * *****All credit for the horocope goes to www.astrology.com*****
 * 
 * 
 * @author Nathan Herrmann
 * @version 7/18/2018
 */
public class OracleApplication implements Runnable{
		
		
	public static void main(String[] args) 
	{	
		//Creates the separate thread of execution.
		SwingUtilities.invokeLater(new OracleApplication());
	}
		
	
	public void run()
	{
		//Creates the frame for the GUI.
		JFrame f = new JFrame("The Oracle");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Program exits on close
		Dimension panelSize = new Dimension(760,520);//Dimension set for the panel
		f.setPreferredSize(panelSize);
		
		//Content panel created along with the two panels to be used for the program
		JPanel content = new JPanel();
		JPanel northPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		
		//Content panel uses the border layout to organize the GUI.  North and Center used.
		content.setLayout(new BorderLayout());
		content.add(northPanel, BorderLayout.NORTH);
		content.add(centerPanel, BorderLayout.CENTER);
		
		
		//This is a JTextArea that can draw a background image in place of a solid color.
		HoroscopeTextArea horoscopeText = new HoroscopeTextArea();
		horoscopeText.setText("Choose your sign");
		
		horoscopeText.setEditable(false);  //The text within the area is not editable
		horoscopeText.setPreferredSize(new Dimension(740,600));  //The size of the panel is created
		
		//The HoroscopePanel is added to the center panel.
		centerPanel.add(horoscopeText);
		horoscopeText.setLineWrap(true);  //Text wraps to stay on screen
		horoscopeText.setWrapStyleWord(true);  //Text wraps in complete words.
		horoscopeText.setFont(new Font("Elephant", Font.ITALIC, 24));  //Text that is set will have this font, size and italicized
		horoscopeText.setBackground(new Color(1,1,1, (float) 0.000001));  //Sets the background transparent for the image to be seen on screen.
		
		//Button panel created to choose sign.
		JPanel buttonPanel = new JPanel();
		northPanel.add(buttonPanel);  //North panel holds the buttons for the horoscopes
		northPanel.setPreferredSize(new Dimension(750,105));
		buttonPanel.setBackground(Color.BLACK);//Background is set to black for appearance reasons.
		northPanel.setBackground(Color.BLACK);
		buttonPanel.setPreferredSize(new Dimension(800,205));  //Buttons are centered and contained in this area.
		
		//Oracle object that is used to pull the horoscope from the site.  Text area required for manipulation
		TheOracle theOracle = new TheOracle(horoscopeText);

		//These buttons are created.  Buttons need the string for the sign and the oracle to send actions to.
		SignButton aries = new SignButton("Aries (Mar 21-Apr 19)");
		SignButton taurus = new SignButton("Taurus (Apr 20-May 20)");
		SignButton gemini = new SignButton("Gemini (May 21-Jun 20)");
		SignButton cancer = new SignButton("Cancer (Jun 21-Jul 22)");
		SignButton leo = new SignButton("Leo (Jul 23-Aug 22)");
		SignButton virgo = new SignButton("Virgo (Aug 23-Sep 22)");
		SignButton libra = new SignButton("Libra (Sep 23-Oct 22)");
		SignButton scorpio = new SignButton("Scorpio (Oct 23-Nov 21)");
		SignButton sagittarius = new SignButton("Sagittarius (Nov 22-Dec 21)");
		SignButton capricorn = new SignButton("Capricorn (Dec 22-Jan 19)");
		SignButton aquarius = new SignButton("Aquarius (Jan 20-Feb 18)");
		SignButton pisces = new SignButton("Pisces (Feb 19-Mar 20)");	
		
		//buttons are added to the panel in the correct order of horoscopes.
		buttonPanel.add(aries);
		buttonPanel.add(taurus);
		buttonPanel.add(gemini);
		buttonPanel.add(cancer);
		buttonPanel.add(leo);
		buttonPanel.add(virgo);
		buttonPanel.add(libra);
		buttonPanel.add(scorpio);
		buttonPanel.add(sagittarius);
		buttonPanel.add(capricorn);
		buttonPanel.add(aquarius);
		buttonPanel.add(pisces);
		
		//Action listeners for each individual buttons to keep the signs separate.
		aries.addActionListener(theOracle);
		taurus.addActionListener(theOracle);
		gemini.addActionListener(theOracle);
		cancer.addActionListener(theOracle);
		leo.addActionListener(theOracle);
		virgo.addActionListener(theOracle);
		libra.addActionListener(theOracle);
		scorpio.addActionListener(theOracle);
		sagittarius.addActionListener(theOracle);
		capricorn.addActionListener(theOracle);
		aquarius.addActionListener(theOracle);
		pisces.addActionListener(theOracle);    
        
		//Content pane is set, packed and visible.
		f.setContentPane(content);
		f.pack();
        f.setVisible(true);	
	}
}
