package br.com.liax.bookstore.helper;

import java.util.Collection;

import br.com.liax.bookstore.model.Printeable;

public interface PrinterHelper<T extends Printeable> {
	
	void print(Collection<T> printeable);

}
