package newHW3.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import newHW3.model.Movie;
import newHW3.model.MovieDto;
import newHW3.model.dao.MovieDao;

@RestController
public class MovieAPIController {

	@Autowired
	private MovieDao movieDao;
	
	@GetMapping("/api/movies") 
	public @ResponseBody List<MovieDto> list(ModelMap models) {
		List<Movie> movies = movieDao.getMovies();
		List<MovieDto> dtos = new ArrayList<MovieDto>();
		for(Movie m : movies) {
			dtos.add(new MovieDto(m));
		}
		
		return dtos;
	}
	
}
