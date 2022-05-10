package newHW3.model;

public class MovieDto {

	private Integer id;
	private String title;
	private int year;
	
	public MovieDto() { }
	
	public MovieDto(Movie m) {
		this.id = m.getId();
		this.title = m.getTitle();
		this.year = m.getYear();
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
}
