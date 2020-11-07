package br.com.liax.bookstore.mapper;

import java.sql.SQLException;

public interface RowMapper<T,K> {
	
	T map(K row) throws SQLException;

}
