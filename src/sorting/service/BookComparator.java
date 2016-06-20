package sorting.service;
import java.util.Comparator;

import sorting.service.model.Book;
import sorting.service.model.SortType;
import sorting.service.model.SortAttributes;
import sorting.service.model.SortDirection;

public class BookComparator implements Comparator<Book> {

	private SortType[] sorts;

	public BookComparator(SortType[] sorts) {
		this.sorts = sorts;
	}
	
	/* Method to compare two books. It iterates the array of sort type objects.
	 * The first step is to verify if the sort type is descending and if it is, 
	 * it inverts the first and second book.
	 * The next step is to verify what is the attribute of sorting (author, title or event year).
	 * In each one, the method compare the two books using the chosen attribute and if they are different,
	 * it returns -1 or 1 (less than and greater than, respectively) to the sort method and if they are equal, 
	 * it returns 0 and the comparator continues and check if there is
	 * another attribute.
	 * 
	 * @return int
	 */
	@Override
	public int compare(Book o1, Book o2) {
		for (SortType sort : sorts) {
			if (sort.getDirection().equals(SortDirection.DESCENDING)) {
				Book temp = o1;
				o1 = o2;
				o2 = temp;
			}
			if (sort.getAttribute().equals(SortAttributes.AUTHOR)) {
				int c = o1.getAuthor().compareTo(o2.getAuthor());
				if (c != 0) {
					return c;
				}
			}
			if (sort.getAttribute().equals(SortAttributes.TITLE)) {
				int c = o1.getTitle().compareTo(o2.getTitle());
				if (c != 0) {
					return c;
				}
			}
			if (sort.getAttribute().equals(SortAttributes.EDITION_YEAR)) {
				int c = o1.getEditionYear().compareTo(o2.getEditionYear());
				if (c != 0) {
					return c;
				}
			}
		}
		return 0;
	}

}
