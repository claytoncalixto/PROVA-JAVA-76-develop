package br.com.liax.bookstore.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import br.com.liax.bookstore.mapper.AuthorRowMapper;
import br.com.liax.bookstore.model.Author;
import br.com.liax.bookstore.repository.AuthorRepository;

public class AuthorRepositoryImpl implements AuthorRepository {


	private static final String FIND_BY_ID = " SELECT * FROM AUTHOR WHERE ID = ? ";

	private static final String UPDATE_BY_ID = " UPDATE AUTHOR SET NAME = ?, BIO = ?, BIRTHDATE = ? WHERE ID = ? ";

	private static final String INSERT = " INSERT INTO AUTHOR(NAME, BIO, BIRTHDATE) VALUES(?,?,?) ";


	private final Connection connection;

	private AuthorRowMapper<ResultSet> authorRowMapper;

	public AuthorRepositoryImpl(Connection connection, AuthorRowMapper<ResultSet> authorRowMapper) {
		this.connection = connection;
		this.authorRowMapper = authorRowMapper;
	}

	@Override
	public Collection<Author> findAll() throws SQLException {
		return null;
	}

	@Override
	public Author findById(Long id) throws SQLException {
		Author author = null;
		try (PreparedStatement prepareStatement = this.connection.prepareStatement(FIND_BY_ID)) {
			prepareStatement.setLong(1, id);
			try (ResultSet resultSet = prepareStatement.executeQuery()) {
				while (resultSet.next()) {
					author = authorRowMapper.map(resultSet);
				}
			}
		}
		return author;
	}

	@Override
	public void updateById(Author object) throws SQLException {
		try (PreparedStatement prepareStatement = this.connection.prepareStatement(UPDATE_BY_ID)) {
			prepareStatement.setString(1, object.getName());
			prepareStatement.setString(2, object.getBio());
			prepareStatement.setDate(3, new java.sql.Date(object.getBirthdate().getTime()));
			prepareStatement.setLong(4, object.getId());
			prepareStatement.executeUpdate();
		}
	}

	@Override
	public void insert(Author object) throws SQLException {
		try (PreparedStatement prepareStatement = this.connection.prepareStatement(INSERT)) {
			prepareStatement.setString(1, object.getName());
			prepareStatement.setString(2, object.getBio());
			prepareStatement.setDate(3, new java.sql.Date(object.getBirthdate().getTime()));
			prepareStatement.executeUpdate();
		}
	}

	@Override
	public void deleteById(Long id) throws SQLException {
	}

}
