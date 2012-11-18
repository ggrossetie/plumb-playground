/**
 * 
 */
package sample.shared;

import java.util.Date;

import javax.validation.constraints.NotNull;

import plumb.shared.display.DisplayBean;
import plumb.shared.display.DisplayProperty;
import plumb.shared.validation.ValidationType;

/**
 * @author bkhadige
 * 
 */
public class PlayerDisplay extends DisplayBean {

	private static final long serialVersionUID = 2727212271948969186L;

	@NotNull
	@DisplayProperty(label = "Pseudo", order = 1)
	String nickname;
	
	@NotNull
	@DisplayProperty(label = "Prénom", order = 2)
	String firstName;

	@NotNull
	@DisplayProperty(label = "Nom de famille", order = 3)
	String lastName;

	@NotNull
	@DisplayProperty(label = "Mail", order = 4, validation = { ValidationType.EMAIL })
	String email;


	@DisplayProperty(label = "Téléphone portable")
	String cellPhone;

	@DisplayProperty(label = "Ville")
	String city;
	
	@NotNull
	@DisplayProperty(label = "Date de naissance")
	Date birthday;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return firstName + lastName + email + birthday;
	}

}
