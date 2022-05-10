package newHW3.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import newHW3.model.Movie;
import newHW3.model.dao.MovieDao;

@Controller
public class MovieController {

	@Autowired
	private MovieDao movieDao;
	
	@RequestMapping("/movies/list") 
	public String list(ModelMap models) {
		models.put("movies", movieDao.getMovies());
		return "movies/list";
	}
	
	@RequestMapping(value="/movies/add", method=RequestMethod.GET)
	public String add() {
		return "movies/add";
	}
	
	@RequestMapping(value="movies/add", method=RequestMethod.POST)
	public String add(Movie movie) {
		movieDao.saveMovie(movie);
		return "redirect:/movies/list";
	}
	
}
