package br.com.liax.bookstore.validator.impl;

import br.com.liax.bookstore.validator.AuthorNameValidator;

public class AuthorNameValidatorImpl implements AuthorNameValidator {

	public boolean validate(String value) {
		return value != null && !value.isEmpty() && value.length() <= 255;
	}

}
