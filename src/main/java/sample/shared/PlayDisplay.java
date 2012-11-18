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
	Date playDate;

	/**
	 * @return the player
	 */
	public String getPlayer() {
		return player;
	}



	/**
	 * @param player the player to set
	 */
	public void setPlayer(String player) {
		this.player = player;
	}



	/**
	 * @return the hit
	 */
	public int getHit() {
		return hit;
	}



	/**
	 * @param hit the hit to set
	 */
	public void setHit(int hit) {
		this.hit = hit;
	}



	/**
	 * @return the birthday
	 */
	public Date getPlayDate() {
		return playDate;
	}



	/**
	 * @param birthday the birthday to set
	 */
	public void setPlayDate(Date birthday) {
		this.playDate = birthday;
	}



	@Override
	public String toString() {
		return player + hit + playDate;
	}

}
