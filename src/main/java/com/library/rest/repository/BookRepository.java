package com.library.rest.repository;

/**
 * @author ANIZAM
 *
 */

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.library.rest.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

	@Query(value = "SELECT * FROM book b WHERE b.status = true", nativeQuery = true)
	List<Book> findAll();

	Book findById(int id);
	
	Book findByIdbook(String bookid);

	@Query(value = "SELECT * FROM book b WHERE b.year = :year and b.status = true", nativeQuery = true)
	List<Book> findByYear(@Param("year") String year);
	
	@Query(value = "SELECT count(id) from book", nativeQuery = true)
	int getTotalData();
	
	@Query(value = "SELECT max(id) from book", nativeQuery = true)
	int getSequenceId();
}
