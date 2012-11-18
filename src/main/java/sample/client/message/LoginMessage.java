package sample.client.message;

import org.jboss.errai.common.client.api.annotations.Portable;


@Portable
public class LoginMessage {

	private String login;
	private String password;

	public LoginMessage() {
	}

	public LoginMessage(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}