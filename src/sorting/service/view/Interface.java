package sorting.service.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import sorting.service.SortingService;
import sorting.service.model.Book;
import sorting.service.model.SortAttributes;
import sorting.service.model.SortDirection;
import sorting.service.model.SortType;

public class Interface extends JFrame {

	private static final long serialVersionUID = -7318652831651269254L;
	private JPanel contentPane;
	private JTextField title;
	private JTextField author;
	private JTextField editionYear;
	private DefaultListModel<Book> booksToSortModel;
	private JComboBox<SortAttributes> comboAttributes;
	private JComboBox<SortDirection> comboDirections;
	private DefaultListModel<SortType> sortTypesModel;
	private DefaultListModel<Book> sortedBooksModel;
	private JList<Book> booksToSort;
	private JList<SortType> sortTypes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interface() {
		setTitle("Sorting Service");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewBook = new JLabel("New book:");
		lblNewBook.setBounds(10, 6, 83, 16);
		contentPane.add(lblNewBook);

		title = new JTextField();
		title.setBounds(47, 28, 134, 28);
		contentPane.add(title);
		title.setColumns(10);

		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(10, 34, 61, 16);
		contentPane.add(lblTitle);

		JLabel lblAuthors = new JLabel("Author(s)");
		lblAuthors.setBounds(10, 68, 61, 16);
		contentPane.add(lblAuthors);

		author = new JTextField();
		author.setBounds(83, 62, 134, 28);
		contentPane.add(author);
		author.setColumns(10);

		JLabel lblEditiorYear = new JLabel("Editior year");
		lblEditiorYear.setBounds(10, 104, 83, 16);
		contentPane.add(lblEditiorYear);

		editionYear = new JTextField();
		editionYear.setBounds(93, 98, 134, 28);
		contentPane.add(editionYear);
		editionYear.setColumns(10);

		booksToSortModel = new DefaultListModel<Book>();
		booksToSort = new JList<Book>(booksToSortModel);
		booksToSort.setBounds(453, 9, 240, 99);
		contentPane.add(booksToSort);

		JButton btnAdd = new JButton("Add new book >");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (title.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Add a title for the book!", "Empty field",
							JOptionPane.ERROR_MESSAGE);
				} else if (author.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Add an author for the book!", "Empty field",
							JOptionPane.ERROR_MESSAGE);
				} else if (editionYear.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Add an edition year for the book!", "Empty field",
							JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						Book book = new Book();
						book.setTitle(title.getText());
						book.setAuthor(author.getText());
						book.setEditionYear(Integer.parseInt(editionYear.getText()));
						booksToSortModel.addElement(book);
					} catch (NumberFormatException exception) {
						JOptionPane.showMessageDialog(null, "The edition year must be a number!", "Format exception",
								JOptionPane.ERROR_MESSAGE);
					}
				}

				title.setText("");
				author.setText("");
				editionYear.setText("");
			}
		});
		btnAdd.setBounds(229, 55, 179, 29);
		contentPane.add(btnAdd);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 142, 693, 12);
		contentPane.add(separator);

		JLabel lblSort = new JLabel("Sort:");
		lblSort.setBounds(10, 153, 61, 16);
		contentPane.add(lblSort);

		JLabel lblAttributes = new JLabel("Attributes");
		lblAttributes.setBounds(10, 181, 83, 16);
		contentPane.add(lblAttributes);

		JLabel lblDirection = new JLabel("Direction");
		lblDirection.setBounds(10, 209, 72, 16);
		contentPane.add(lblDirection);

		comboAttributes = new JComboBox<SortAttributes>();
		comboAttributes.setBounds(83, 177, 128, 27);
		comboAttributes.setModel(new DefaultComboBoxModel<SortAttributes>(SortAttributes.values()));
		contentPane.add(comboAttributes);

		comboDirections = new JComboBox<SortDirection>();
		comboDirections.setBounds(83, 205, 128, 27);
		comboDirections.setModel(new DefaultComboBoxModel<SortDirection>(SortDirection.values()));
		contentPane.add(comboDirections);

		sortTypesModel = new DefaultListModel<SortType>();
		sortTypes = new JList<SortType>(sortTypesModel);
		sortTypes.setBounds(453, 153, 237, 78);
		contentPane.add(sortTypes);

		JButton btnAddSortType = new JButton("Add sort type >");
		btnAddSortType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SortAttributes attribute = (SortAttributes) comboAttributes.getSelectedItem();
				SortDirection direction = (SortDirection) comboDirections.getSelectedItem();
				SortType sortType = new SortType(attribute, direction);
				sortTypesModel.addElement(sortType);
			}
		});
		btnAddSortType.setBounds(229, 181, 170, 29);
		contentPane.add(btnAddSortType);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 264, 691, 16);
		contentPane.add(separator_1);

		sortedBooksModel = new DefaultListModel<Book>();
		JList<Book> sortedBooks = new JList<Book>(sortedBooksModel);
		sortedBooks.setBounds(140, 292, 301, 121);
		contentPane.add(sortedBooks);

		JButton btnSort = new JButton("Sort >");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!sortedBooksModel.isEmpty()) {
					sortedBooksModel.clear();
				}
				if (booksToSortModel.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Add books to sort!", "Empty list", JOptionPane.ERROR_MESSAGE);
				}
				if (sortTypesModel.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Add sort types to sort!", "Empty list",
							JOptionPane.ERROR_MESSAGE);
				}
				SortingService sortService = new SortingService();
				sortService.setBooks(Collections.list(booksToSortModel.elements()));

				ArrayList<SortType> sortTypeList = Collections.list(sortTypesModel.elements());
				SortType[] sortTypesArray = new SortType[sortTypeList.size()];
				sortTypesArray = sortTypeList.toArray(sortTypesArray);

				List<Book> booksSortedList = sortService.sort(sortTypesArray);
				for (Book book : booksSortedList) {
					sortedBooksModel.addElement(book);
				}
			}
		});
		btnSort.setBounds(10, 313, 117, 29);
		contentPane.add(btnSort);

		JButton btnRemobeBook = new JButton("Remove book");
		btnRemobeBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				booksToSortModel.removeElementAt(booksToSort.getSelectedIndex());
			}
		});
		btnRemobeBook.setBounds(445, 111, 155, 29);
		contentPane.add(btnRemobeBook);

		JButton btnClean = new JButton("Clean");
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				booksToSortModel.clear();
			}
		});
		btnClean.setBounds(605, 111, 93, 29);
		contentPane.add(btnClean);

		JButton btnRemoveSort = new JButton("Remove Sort Type");
		btnRemoveSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortTypesModel.removeElementAt(sortTypes.getSelectedIndex());
			}
		});
		btnRemoveSort.setBounds(439, 234, 174, 29);
		contentPane.add(btnRemoveSort);

		JButton btnCleanSortType = new JButton("Clean");
		btnCleanSortType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortTypesModel.clear();
			}
		});
		btnCleanSortType.setBounds(620, 235, 86, 29);
		contentPane.add(btnCleanSortType);
	}
}
