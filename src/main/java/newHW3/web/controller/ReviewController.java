package newHW3.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import newHW3.model.Movie;
import newHW3.model.Review;
import newHW3.model.dao.MovieDao;
import newHW3.model.dao.ReviewDao;

@Controller
public class ReviewController {

	@Autowired
	private MovieDao movieDao;
	
	@Autowired
	private ReviewDao reviewDao;
	
	
	@RequestMapping("/movies/list/{id}")
	public String list(@PathVariable Integer id, ModelMap models) {
		models.put("movie", movieDao.getMovie(id));
		models.put("id", id);
		return "reviews/list";
	}
	
	@RequestMapping(value="/movies/add/{id}", method=RequestMethod.GET)
	public String add(@PathVariable Integer id, ModelMap models) {
		models.put("movie", movieDao.getMovie(id));
		return "reviews/add";
	}
	
	@RequestMapping(value="movies/add/{id}", method=RequestMethod.POST)
	public String add(@PathVariable Integer id, String username, int rating, String review) {
		Review r = new Review();
		r.setMovie(movieDao.getMovie(id));
		r.setUsername(username);
		r.setRating(rating);
		r.setReview(review);
		reviewDao.saveReview(r);
		return "redirect:/movies/list";
	}
	
}
