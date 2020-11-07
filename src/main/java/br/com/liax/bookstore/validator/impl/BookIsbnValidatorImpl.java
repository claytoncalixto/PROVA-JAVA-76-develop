package br.com.liax.bookstore.validator.impl;

import br.com.liax.bookstore.validator.BookIsbnValidator;

public class BookIsbnValidatorImpl implements BookIsbnValidator {

	public boolean validate(String value) {
		return value != null && !value.isEmpty() && value.length() <= 4 && value.matches("[0-9]{3}-[0-9]{2}-[0-9]{3}-[0-9]{4}-[0-9]{1}");
	}

}
