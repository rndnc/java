package jp.co.sss.test.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class LoginForm {
	@NotBlank
	@Email
	private String email;
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	@Size(min = 8)
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
