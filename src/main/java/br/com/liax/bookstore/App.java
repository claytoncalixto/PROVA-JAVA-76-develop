package br.com.liax.bookstore;

import br.com.liax.bookstore.init.Init;
import br.com.liax.bookstore.init.impl.InitImpl;

public class App {
	
	public static void main(String[] args) {
		Init init = new InitImpl();
		init.execute();
	}
}
