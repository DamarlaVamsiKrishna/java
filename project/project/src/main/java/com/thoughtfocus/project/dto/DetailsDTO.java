package com.thoughtfocus.project.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DetailsDTO {

	private String firstName;
	private String lastName;
	private String email;
	private long contact;
	private String password;

}
