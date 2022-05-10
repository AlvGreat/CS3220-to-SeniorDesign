package newHW3.model.dao;

import java.util.List;

import newHW3.model.Review;

public interface ReviewDao {

	List<Review> getReviews();
	
	Review getReview(Integer id);
	
	Review saveReview(Review review);
}
