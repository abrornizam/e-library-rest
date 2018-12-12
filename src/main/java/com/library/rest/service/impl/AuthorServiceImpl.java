/**
 * 
 */
package com.library.rest.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.rest.model.Author;
import com.library.rest.repository.AuthorRepository;
import com.library.rest.service.AuthorService;

/**
 * @author ANIZAM
 *
 */

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorRepository authorRepository;
	
	@Override
	public List<Author> findAll() {
		// TODO Auto-generated method stub
		return authorRepository.findAll();
	}	
	
}
