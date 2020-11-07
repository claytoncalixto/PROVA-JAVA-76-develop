package br.com.liax.bookstore.validator.impl;

import br.com.liax.bookstore.validator.BookDescriptionValidator;

public class BookDescriptionValidatorImpl implements BookDescriptionValidator {

	public boolean validate(String value) {
		return value != null && !value.isEmpty();
	}

}
