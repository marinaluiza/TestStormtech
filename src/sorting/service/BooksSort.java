package sorting.service;

import java.util.List;

import sorting.service.model.Book;
import sorting.service.model.SortType;

public interface BooksSort {

	public List<Book> sort(SortType... sorts);
}
