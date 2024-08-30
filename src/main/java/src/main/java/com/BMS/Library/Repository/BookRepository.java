package src.main.java.com.BMS.Library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import src.main.java.com.BMS.Library.Model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
