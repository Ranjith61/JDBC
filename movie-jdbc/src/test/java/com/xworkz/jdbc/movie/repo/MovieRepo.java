package com.xworkz.jdbc.movie.repo;

import java.util.List;

import com.xworkz.jdbc.dto.MovieDTO;

public interface MovieRepo {
	
	public boolean ValidateAndSave(MovieDTO dto);

	public boolean ValidateAndSave(List<MovieDTO> movielist);
	
}