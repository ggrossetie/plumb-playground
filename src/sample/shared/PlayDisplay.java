/**
 * 
 */
package sample.shared;

import java.util.Date;

import javax.validation.constraints.NotNull;

import plumb.shared.display.DisplayBean;
import plumb.shared.display.DisplayProperty;

/**
 * @author bkhadige
 * 
 */
public class PlayDisplay extends DisplayBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@DisplayProperty(label = "Joueur", order = 1)
	String player;

	@NotNull
	@DisplayProperty(label = "Somme", order = 2)
	int hit;
	
	@NotNull
	@DisplayProperty(label = "Date du jeu")
	Date birthday;


	@Override
	public String toString() {
		return player + hit + birthday;
	}

}
