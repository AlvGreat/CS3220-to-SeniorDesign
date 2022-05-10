package newHW3.model.dao;

import java.util.List;

import newHW3.model.Movie;

public interface MovieDao {

	List<Movie> getMovies();
	
	Movie getMovie(Integer id);
	
	Movie saveMovie(Movie movie);
	
}
