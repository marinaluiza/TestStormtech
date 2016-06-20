package sorting.service.model;

public class Book {

	private String title;
	private String author;
	private Integer editionYear;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getEditionYear() {
		return editionYear;
	}

	public void setEditionYear(Integer editionYear) {
		this.editionYear = editionYear;
	}
	
	@Override
	public String toString() {
		return title + " - " + author + " - " + editionYear;
	}

}
