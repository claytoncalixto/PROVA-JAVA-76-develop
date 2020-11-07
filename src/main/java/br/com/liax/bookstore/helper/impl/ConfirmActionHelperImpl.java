package br.com.liax.bookstore.helper.impl;

import br.com.liax.bookstore.helper.ConfirmActionHelper;

public class ConfirmActionHelperImpl implements ConfirmActionHelper {

	@Override
	public boolean confirm(String value) {
		return value.isEmpty() || "S".equalsIgnoreCase(value);
	}

	@Override
	public String getOptions() {
		return "[S/n]";
	}

}
