package br.com.liax.bookstore.service.impl;

import java.sql.SQLException;
import java.util.Collection;

import br.com.liax.bookstore.model.Author;
import br.com.liax.bookstore.repository.AuthorRepository;
import br.com.liax.bookstore.service.AuthorService;

public class AuthorServiceImpl implements AuthorService {

	private final AuthorRepository authorRepository;

	public AuthorServiceImpl(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@Override
	public Author findById(Long id) throws SQLException {
		return this.authorRepository.findById(id);
	}

	@Override
	public void updateById(Author object) throws SQLException {
		this.authorRepository.updateById(object);
	}

	@Override
	public void insert(Author object) throws SQLException {
		this.authorRepository.insert(object);
	}

	@Override
	public Collection<Author> findAll() throws SQLException {
		return null;
	}

	@Override
	public void deleteById(Long id) throws SQLException {
	}


}
