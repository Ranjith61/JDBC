package com.xworkz.jdbc.movie.service;

import java.util.List;

import com.xworkz.jdbc.dto.MovieDTO;

public interface MovieService {
	public String ValidateAndSave(MovieDTO dto);

	public String ValidateAndSave(List<MovieDTO> movielist);

}
