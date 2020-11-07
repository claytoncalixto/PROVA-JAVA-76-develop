package br.com.liax.bookstore.facade.impl;

import br.com.liax.bookstore.facade.OutputFacade;

public class OutputSysOutFacadeImpl implements OutputFacade {

	@Override
	public void print(String value) {
		System.out.println(value);
	}

}
