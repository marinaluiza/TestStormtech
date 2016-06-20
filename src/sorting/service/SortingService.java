package sorting.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sorting.service.exception.SortingServiceException;
import sorting.service.model.Book;
import sorting.service.model.SortType;

public class SortingService implements BooksSort {

	private List<Book> books;

	public void setBooks(List<Book> books) {
		if (books == null) {
			throw new SortingServiceException();
		}
		this.books = books;
	}

	
	/* Method to sort a list of books using the chosen type of sorting.
	 * It uses the java util Collections method of sorting, using a book comparator
	 * class which implements the java util Comparator class.
	 * Both Comparator and Collections can facilitate the work, but I had to overwrite
	 * the comparator so I could compare as the requirements of the assessment.
	 * 
	 * @return List<Book>
	 */
	@Override
	public List<Book> sort(SortType... sorts) {
		List<Book> books = new ArrayList<Book>(this.books);
		Collections.sort(books, new BookComparator(sorts));
		return books;

	}

}
