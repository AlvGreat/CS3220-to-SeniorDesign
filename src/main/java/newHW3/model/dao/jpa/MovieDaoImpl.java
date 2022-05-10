package newHW3.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import newHW3.model.Movie;
import newHW3.model.dao.MovieDao;


@Repository
public class MovieDaoImpl implements MovieDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Movie> getMovies() {
		return entityManager.createQuery("from Movie", Movie.class)
				.getResultList();
	}

	@Override
	public Movie getMovie(Integer id) {
		return entityManager.find(Movie.class, id);
	}

	@Override
	@Transactional
	public Movie saveMovie(Movie movie) {
		return entityManager.merge(movie);
	}

}
