package com.v.payloads;

import javax.validation.constraints.NotBlank;

public class UserEntityDTO {
	
	@NotBlank(message = "{app.messages.nameEmpty}")
	private String name;
	
	@NotBlank(message = "{app.messages.firstMessage}")
	private String lastName;
	
	public UserEntityDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserEntityDTO(@NotBlank(message = "{app.messages.nameEmpty}") String name,
			@NotBlank(message = "{app.messages.firstMessage}") String lastName) {
		super();
		this.name = name;
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "UserEntityDTO [name=" + name + ", lastName=" + lastName + "]";
	}
}
