package br.com.liax.bookstore.validator.impl;

import br.com.liax.bookstore.validator.AuthorBioValidator;

public class AuthorBioValidatorImpl implements AuthorBioValidator {

	public boolean validate(String value) {
		return value != null && !value.isEmpty();
	}

}
