package br.com.liax.bookstore.helper.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.liax.bookstore.helper.DateConversorHelper;

public class DateConversorHelperImpl implements DateConversorHelper {

	@Override
	public Date convert(String dateStr) throws ParseException {
		return new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
	}

}
