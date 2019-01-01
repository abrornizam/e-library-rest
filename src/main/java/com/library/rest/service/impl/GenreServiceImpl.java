/**
 * 
 */
package com.library.rest.service.impl;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.rest.model.Genre;
import com.library.rest.repository.GenreRepository;
import com.library.rest.service.GenreService;

/**
 * @author ANIZAM
 *
 */

@Service
@Transactional
public class GenreServiceImpl implements GenreService {

	@Autowired
	private GenreRepository genreRepository;

	@Override
	public List<Genre> findAll() {
		// TODO Auto-generated method stub
		return genreRepository.findAll();
	}

	@Override
	public Genre saveData(Genre genre) {
		// TODO Auto-generated method stub
		int totalData = genreRepository.getTotalData();
		int seqId = 0;
		if(totalData == 0) {
			seqId = 1;
		}else {
			seqId = genreRepository.getSequenceId()+1;
		}
		genre.setId(seqId);		
		return genreRepository.save(genre);
	}

	@Override
	public Genre detailData(int id) {
		// TODO Auto-generated method stub
		return genreRepository.findById(id);
	}	
	
	@Override
	public void updateData(Genre genre) {
		// TODO Auto-generated method stub
		Genre entity = genreRepository.findById(genre.getId());
		if(entity != null) {
			entity.setIdgenre(genre.getIdgenre());
			entity.setDescription(genre.getDescription());
			entity.setStatus(true);
		}
	}

	@Override
	public void deleteData(int id) {
		// TODO Auto-generated method stub
		Genre entity = genreRepository.findById(id);
		if(entity != null) {
			entity.setStatus(false);
		}
	}
	
}
