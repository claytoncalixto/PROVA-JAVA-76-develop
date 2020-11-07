package br.com.liax.bookstore.helper.impl;

import java.util.Collection;

import br.com.liax.bookstore.helper.PrinterHelper;
import br.com.liax.bookstore.model.Printeable;

public class PrinterHelperImpl<T extends Printeable> implements PrinterHelper<T> {

	private int i = 0;

	@Override
	public void print(Collection<T> printeables) {
		if (printeables != null && printeables.size() > 0) {
			this.i = 0;
			printeables.forEach(printeable -> {
				if (this.i == 0) {
					System.out.println(printeable.getHeader());
				}

				System.out.println(printeable.getContent());
				this.i++;
			});
		}
	}

}
