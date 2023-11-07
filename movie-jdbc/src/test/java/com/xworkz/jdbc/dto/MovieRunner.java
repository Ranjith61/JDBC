package com.xworkz.jdbc.dto;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import com.xworkz.jdbc.movie.service.MovieService;
import com.xworkz.jdbc.movie.service.MovieServiceImpl;

public class MovieRunner {
	public static void main(String[] args) {
		MovieDTO dto = new MovieDTO(3, "Ghost", 32444, "Kannada", Date.valueOf("2023-11-11"));
		MovieDTO dto1 = new MovieDTO(4, "RRR", 98769, "Telegu", Date.valueOf("2023-09-12"));

		List<MovieDTO> movielist = new LinkedList<MovieDTO>();
		movielist.add(dto);
		movielist.add(dto1);
		MovieService service = new MovieServiceImpl();
			service.ValidateAndSave(movielist);
	}

}
