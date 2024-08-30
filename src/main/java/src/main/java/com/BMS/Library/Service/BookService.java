package src.main.java.com.BMS.Library.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.BMS.Library.Model.Book;
import src.main.java.com.BMS.Library.Repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBooks() {
		List<Book> books = bookRepository.findAll();
		return books;
	}

	public Book saveBook(Book book) {
		Book savedBook = bookRepository.save(book);
		return savedBook;
	}

	public Book findBook(int id) {
		Book find = bookRepository.findById(id).get();
		return find;
	}

	public Book updateBook(int id, Book book) {
		Book findBook = bookRepository.findById(id).get();
		findBook.setAuthor(book.getAuthor());
		findBook.setAvailable(book.isAvailable());
		findBook.setPrice(book.getPrice());
		findBook.setTitle(book.getTitle());
		bookRepository.save(findBook);
		return findBook;
	}

	public String deleteBook(int id) {
		Book find = bookRepository.findById(id).get();
		bookRepository.delete(find);
		return "Removed Successfully...";
	}
}
