/**
 * 
 */
package com.library.rest.service;

import java.util.List;

import com.library.rest.model.Genre;

/**
 * @author ANIZAM
 *
 */

public interface GenreService {

	List<Genre> findAll();
	
	Genre saveData(Genre genre);
	
	Genre detailData(int id);
	
	void updateData(Genre genre);
	
	void deleteData(int id);
	
}
