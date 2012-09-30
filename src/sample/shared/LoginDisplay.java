/**
 * 
 */
package sample.shared;

import javax.validation.constraints.NotNull;

import plumb.shared.display.DisplayBean;
import plumb.shared.display.DisplayProperty;

/**
 * @author bkhadige
 * 
 */
public class LoginDisplay extends DisplayBean {

	private static final long serialVersionUID = 2727212271948969186L;

	@NotNull
	@DisplayProperty(label = "Identifiant")
	String login;

	@NotNull
	@DisplayProperty(label = "Mot de passe")
	String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String toString() {
		String s = (login != null) ? " login : " + login : "";
		s = s + ((password != null) ? " password " + password : "");
		return s;
	}

}
