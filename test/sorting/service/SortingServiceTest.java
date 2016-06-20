package sorting.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import sorting.service.SortingService;
import sorting.service.exception.SortingServiceException;
import sorting.service.model.Book;
import sorting.service.model.SortType;
import sorting.service.model.SortAttributes;
import sorting.service.model.SortDirection;

public class SortingServiceTest {

	private List<Book> books;
	private Book book1;
	private Book book2;
	private Book book3;
	private Book book4;
	private SortingService sortingService;

	@Before
	public void setUp() {
		books = new ArrayList<Book>();
		book1 = createBook("Java How to Program", "Deitel & Deitel", 2007);
		book2 = createBook("Patterns of Enterprise Application Architecture", "Martin Fowler", 2002);
		book3 = createBook("Head First Design Patterns", "Elisabeth Freeman", 2004);
		book4 = createBook("Internet & World Wide Web: How to Program", "Deitel & Deitel", 2007);

		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		sortingService = new SortingService();
		sortingService.setBooks(books);
	}

	private Book createBook(String title, String author, Integer year) {
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setEditionYear(year);
		return book;
	}

	@Test
	public void titleAscsending() {
		List<Book> books = sortingService.sort(new SortType(SortAttributes.TITLE, SortDirection.ASCENDING));
		assertEquals(book3, books.get(0));
		assertEquals(book4, books.get(1));
		assertEquals(book1, books.get(2));
		assertEquals(book2, books.get(3));
	}

	@Test
	public void authorAscendingTitledescending() {
		SortType sort1 = new SortType(SortAttributes.AUTHOR, SortDirection.ASCENDING);
		SortType sort2 = new SortType(SortAttributes.TITLE, SortDirection.DESCENDING);
		List<Book> books = sortingService.sort(sort1, sort2);
		assertEquals(book1, books.get(0));
		assertEquals(book4, books.get(1));
		assertEquals(book3, books.get(2));
		assertEquals(book2, books.get(3));
	}

	@Test
	public void editionDescendigAuthorDescendingTitleAscending() {
		SortType sort1 = new SortType(SortAttributes.EDITION_YEAR, SortDirection.DESCENDING);
		SortType sort2 = new SortType(SortAttributes.AUTHOR, SortDirection.DESCENDING);
		SortType sort3 = new SortType(SortAttributes.TITLE, SortDirection.ASCENDING);
		List<Book> books = sortingService.sort(sort1, sort2, sort3);
		assertEquals(book4, books.get(0));
		assertEquals(book1, books.get(1));
		assertEquals(book3, books.get(2));
		assertEquals(book2, books.get(3));
	}

	@Test(expected = SortingServiceException.class)
	public void nullAttibutes() {
		sortingService.setBooks(null);
		sortingService.sort();
	}

	@Test
	public void emptyList() {
		sortingService.setBooks(Collections.<Book> emptyList());
		List<Book> books = sortingService.sort();
		assertTrue(books.isEmpty());

	}

}
