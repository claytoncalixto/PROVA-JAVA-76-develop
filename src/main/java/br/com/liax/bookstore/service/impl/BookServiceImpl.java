package br.com.liax.bookstore.service.impl;

import java.sql.SQLException;
import java.util.Collection;

import br.com.liax.bookstore.model.Book;
import br.com.liax.bookstore.repository.BookRepository;
import br.com.liax.bookstore.service.BookService;

public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;

	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public Collection<Book> findAll() throws SQLException {
		return this.bookRepository.findAll();
	}

	@Override
	public Book findById(Long id) throws SQLException {
		return this.bookRepository.findById(id);
	}

	@Override
	public void updateById(Book object) throws SQLException {
		Book book = new Book();
		this.bookRepository.updateById(book);
	}

	@Override
	public void insert(Book object) throws SQLException {
		this.bookRepository.insert(null);

	}

	@Override
	public void deleteById(Long id) throws SQLException {
		this.bookRepository.deleteById(id);
	}

}
