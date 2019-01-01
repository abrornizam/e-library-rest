/**
 * 
 */
package com.library.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.library.rest.model.Genre;

/**
 * @author ANIZAM
 *
 */

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer>{

	@Query(value = "SELECT * FROM genre g WHERE g.status = true", nativeQuery = true)
	List<Genre> findAll();
	
	@Query(value = "SELECT * FROM genre g WHERE g.id = :id AND g.status = true", nativeQuery = true)
	Genre findById(@Param("id") int id);
	
	@Query(value = "SELECT count(id) from genre", nativeQuery = true)
	int getTotalData();
	
	@Query(value = "SELECT max(id) from genre", nativeQuery = true)
	int getSequenceId();
}
