package br.com.liax.bookstore.factory;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionFactory {
	
	public Connection get() throws ClassNotFoundException, SQLException;

}
