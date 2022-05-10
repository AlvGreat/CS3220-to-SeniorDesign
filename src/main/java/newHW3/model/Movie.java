package newHW3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String title;
	private int year;
	
	@OneToMany(mappedBy="movie")
	private List<Review> reviews;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAverageRating() {
		if (reviews.size() == 0) return "N/A";
		
		int ratingSum = 0;
		
		for(Review review : reviews) {
			ratingSum += review.getRating();
		}
		
		// round (truncate) to 1 decimal place
		return String.valueOf((double)(10*ratingSum / reviews.size()) / 10);
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(ArrayList<Review> reviews) {
		this.reviews = reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}
}

