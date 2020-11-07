package br.com.liax.bookstore.factory.impl;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.liax.bookstore.factory.ConnectionFactory;
import br.com.liax.bookstore.singleton.ConnectionSingleton;

public class ConnectionFactoryImpl implements ConnectionFactory {

	public Connection get() throws ClassNotFoundException, SQLException {
		return ConnectionSingleton.getConnection();
	}

}
