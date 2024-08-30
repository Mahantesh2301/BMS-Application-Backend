package src.main.java.com.BMS.Library.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import src.main.java.com.BMS.Library.Model.Book;
import src.main.java.com.BMS.Library.Service.BookService;

@RestController
@RequestMapping("/api/library")
public class BookController {
	@Autowired
	private BookService bookService;

	@GetMapping
	public ResponseEntity<List<Book>> allBooks() {
		List<Book> books = bookService.getAllBooks();
		return ResponseEntity.ok(books);
	}

	@PostMapping
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book savedBook = bookService.saveBook(book);
		return ResponseEntity.ok(savedBook);
	}

	@GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable int id){
    	Book foundBook = bookService.findBook(id);
           return ResponseEntity.ok(foundBook);
    }

	@PutMapping("/{id}")
    public ResponseEntity<Book> editBook(@PathVariable int id, @RequestBody Book book){
    	Book editedBook = bookService.updateBook(id, book);
    	return ResponseEntity.ok(editedBook);
    }
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable int id){
		String message = bookService.deleteBook(id);
		return ResponseEntity.ok(message);
	}
}
