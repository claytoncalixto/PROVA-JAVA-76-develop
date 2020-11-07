package br.com.liax.bookstore.validator.impl;

import br.com.liax.bookstore.validator.BookTitleValidator;

public class BookTitleValidatorImpl implements BookTitleValidator {

	public boolean validate(String value) {
		return value != null && value.isEmpty() && value.length() <= 1000;
	}

}
