package horoscopeReader;

import javax.swing.JButton;
/**JButton that allows the first word in its string to be parsed and returned as a string.
 * 
 * @author Nathan Herrmann
 * @version 4/24/17
 */
public class SignButton extends JButton{

	private static final long serialVersionUID = 7286666983678129879L;
	private String sign;
	
	/**Creates the JButton, the string what the Button shows.  The String is parsed in order to save which sign it is.
	 * 
	 * @param String s
	 * @param TheOracle oracle
	 */
	public SignButton(String s){
	
		//Super is called to create the normal button, with the full string shown.
		super(s);
		
		//Parses the string to only have the first word remain.
		int right = s.indexOf(" ");
		this.sign = s.substring(0, right);
	}

	/**Returns the String sign of the button that is pressed
	 * 
	 * @return
	 */
	public String getSign()
	{
		return this.sign;
	}
	
}
