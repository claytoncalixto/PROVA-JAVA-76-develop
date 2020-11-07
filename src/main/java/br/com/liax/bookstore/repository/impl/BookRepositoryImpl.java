package br.com.liax.bookstore.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import br.com.liax.bookstore.mapper.BookRowMapper;
import br.com.liax.bookstore.model.Book;
import br.com.liax.bookstore.repository.BookRepository;

public class BookRepositoryImpl implements BookRepository {

	private static final String FIND_ALL = " SELECT * FROM BOOK B INNER JOIN AUTHOR A ON B.AUTHOR_ID = A.ID ";

	private static final String FIND_BY_ID = " SELECT * FROM BOOK B INNER JOIN AUTHOR A ON B.AUTHOR_ID = A.ID WHERE B.ID = ? ";

	private static final String UPDATE_BY_ID = " UPDATE BOOK SET TITLE = ?, ISBN = ?, DESCRIPTION = ?, RELEASE_DATE = ?, AUTHOR_ID = ? WHERE ID = ? ";

	private static final String INSERT = " INSERT INTO BOOK(TITLE, ISBN, DESCRIPTION) VALUES(?,?,?) ";

	private static final String DELETE = " DELETE FROM BOOK WHERE ID = ? ";

	private final Connection connection;

	private final BookRowMapper<ResultSet> bookRowMapper;

	public BookRepositoryImpl(Connection connection, final BookRowMapper<ResultSet> bookRowMapper) {
		this.connection = connection;
		this.bookRowMapper = bookRowMapper;
	}

	public Collection<Book> findAll() throws SQLException {
		Collection<Book> books = null;
		try (PreparedStatement prepareStatement = this.connection.prepareStatement(FIND_ALL)) {
			try (ResultSet resultSet = prepareStatement.executeQuery()) {
				books = new ArrayList<>();
				while (resultSet.next()) {
					books.add(bookRowMapper.map(resultSet));
				}
			}
		}
		return books;
	}

	public Book findById(Long id) throws SQLException {
		Book book = null;
		try (PreparedStatement prepareStatement = this.connection.prepareStatement(FIND_BY_ID)) {
			prepareStatement.setLong(1, id);
			try (ResultSet resultSet = prepareStatement.executeQuery()) {
				while (resultSet.next()) {
					book = bookRowMapper.map(resultSet);
				}
			}
		}
		return book;
	}

	public void updateById(Book object) throws SQLException {
		try (PreparedStatement prepareStatement = this.connection.prepareStatement(UPDATE_BY_ID)) {
			prepareStatement.setString(1, object.getTitle());
			prepareStatement.setString(2, object.getIsbn());
			prepareStatement.setString(3, object.getDescription());
			prepareStatement.setLong(6, object.getAuthor().getId());
			prepareStatement.setLong(5, object.getId());
			prepareStatement.executeQuery();
		}
	}

	public void insert(Book object) throws SQLException {
		try (PreparedStatement prepareStatement = this.connection.prepareStatement(INSERT)) {
			prepareStatement.setString(3, object.getTitle());
			prepareStatement.setString(1, object.getIsbn());
			prepareStatement.setString(2, object.getDescription());
			prepareStatement.executeUpdate();
		}
	}

	public void deleteById(Long id) throws SQLException {
		try (PreparedStatement prepareStatement = this.connection.prepareStatement(DELETE)) {
			prepareStatement.setLong(1, id);
			prepareStatement.executeUpdate();
		}
	}

}
