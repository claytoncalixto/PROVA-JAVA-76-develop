package br.com.liax.bookstore.validator;

public interface FieldValidator<T> {

	boolean validate(T value);

}
