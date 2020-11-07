package br.com.liax.bookstore.mapper.impl;

import java.sql.SQLException;
import java.sql.ResultSet;

import br.com.liax.bookstore.mapper.AuthorRowMapper;
import br.com.liax.bookstore.model.Author;

public class AuthorResultSetRowMapperImpl implements AuthorRowMapper<ResultSet> {

	@Override
	public Author map(ResultSet resultSet) throws SQLException {
		Author author = new Author();
		author.setId(resultSet.getLong("ID"));
		author.setName(resultSet.getString("NAME"));
		author.setBio(resultSet.getString("BIO"));
		author.setBirthdate(resultSet.getDate("BIRTHDATE"));
		return author;
	}

}
