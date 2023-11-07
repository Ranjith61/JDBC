package com.xworkz.jdbc.movie.service;

import java.util.List;

import com.xworkz.jdbc.dto.MovieDTO;
import com.xworkz.jdbc.movie.repo.MovieRepo;
import com.xworkz.jdbc.movie.repo.MovieRepoImpl;

public class MovieServiceImpl implements MovieService {

	public String ValidateAndSave(MovieDTO movieDto) {
		if (movieDto != null) {
			// save to repo
			if(movieDto.getName()!=null) {
				MovieRepo repo  = new MovieRepoImpl();
				boolean saved=repo.ValidateAndSave(movieDto);
				System.out.println(saved);
				return "Data Saved";
			}
		}
		return "It is not saved";
		
		}

	public String ValidateAndSave(List<MovieDTO> movielist) {
		// TODO Auto-generated method stub
		if (movielist != null) {
			// save to repo
				MovieRepo repo  = new MovieRepoImpl();
				boolean saved=repo.ValidateAndSave(movielist);
				System.out.println(saved);
				return "Data Saved";
		}
		return "It is not saved";
	}
		
	}


