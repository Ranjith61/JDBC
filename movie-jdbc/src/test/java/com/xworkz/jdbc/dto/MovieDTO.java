package com.xworkz.jdbc.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Getter
@Setter

public class MovieDTO {
	private int id;
	private String name;	
	private int budjet;
	private String language;
	private Date realease_date;
	
	

}
