package newHW3.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import newHW3.model.Review;
import newHW3.model.dao.ReviewDao;


@Repository
public class ReviewDaoImpl implements ReviewDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Review> getReviews() {
		return entityManager.createQuery("from Review", Review.class)
				.getResultList();
	}

	@Override
	public Review getReview(Integer id) {
		return entityManager.find(Review.class, id);
	}

	@Override
	@Transactional
	public Review saveReview(Review review) {
		return entityManager.merge(review);
	}
	
}
