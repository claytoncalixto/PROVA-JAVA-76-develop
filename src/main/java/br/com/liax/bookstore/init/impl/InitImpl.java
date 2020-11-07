package br.com.liax.bookstore.init.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.liax.bookstore.bo.AuthorBO;
import br.com.liax.bookstore.bo.BookBO;
import br.com.liax.bookstore.bo.MenuBO;
import br.com.liax.bookstore.bo.impl.AuthorBOImpl;
import br.com.liax.bookstore.bo.impl.BookBOImpl;
import br.com.liax.bookstore.bo.impl.MenuBOImpl;
import br.com.liax.bookstore.facade.InputFacade;
import br.com.liax.bookstore.facade.OutputFacade;
import br.com.liax.bookstore.facade.impl.InputScannerFacadeImpl;
import br.com.liax.bookstore.facade.impl.OutputSysOutFacadeImpl;
import br.com.liax.bookstore.factory.ConnectionFactory;
import br.com.liax.bookstore.factory.impl.ConnectionFactoryImpl;
import br.com.liax.bookstore.helper.ConfirmActionHelper;
import br.com.liax.bookstore.helper.DateConversorHelper;
import br.com.liax.bookstore.helper.PrinterHelper;
import br.com.liax.bookstore.helper.impl.ConfirmActionHelperImpl;
import br.com.liax.bookstore.helper.impl.DateConversorHelperImpl;
import br.com.liax.bookstore.helper.impl.PrinterHelperImpl;
import br.com.liax.bookstore.init.Init;
import br.com.liax.bookstore.mapper.AuthorRowMapper;
import br.com.liax.bookstore.mapper.BookRowMapper;
import br.com.liax.bookstore.mapper.impl.AuthorResultSetRowMapperImpl;
import br.com.liax.bookstore.mapper.impl.BookResultSetRowMapperImpl;
import br.com.liax.bookstore.model.Author;
import br.com.liax.bookstore.model.Book;
import br.com.liax.bookstore.repository.AuthorRepository;
import br.com.liax.bookstore.repository.BookRepository;
import br.com.liax.bookstore.repository.impl.AuthorRepositoryImpl;
import br.com.liax.bookstore.repository.impl.BookRepositoryImpl;
import br.com.liax.bookstore.service.AuthorService;
import br.com.liax.bookstore.service.BookService;
import br.com.liax.bookstore.service.impl.AuthorServiceImpl;
import br.com.liax.bookstore.service.impl.BookServiceImpl;
import br.com.liax.bookstore.validator.AuthorBioValidator;
import br.com.liax.bookstore.validator.AuthorBirthdateValidator;
import br.com.liax.bookstore.validator.AuthorNameValidator;
import br.com.liax.bookstore.validator.BookDescriptionValidator;
import br.com.liax.bookstore.validator.BookIsbnValidator;
import br.com.liax.bookstore.validator.BookReleaseDateValidator;
import br.com.liax.bookstore.validator.BookTitleValidator;
import br.com.liax.bookstore.validator.impl.AuthorBioValidatorImpl;
import br.com.liax.bookstore.validator.impl.AuthorBirthdateValidatorImpl;
import br.com.liax.bookstore.validator.impl.AuthorNameValidatorImpl;
import br.com.liax.bookstore.validator.impl.BookDescriptionValidatorImpl;
import br.com.liax.bookstore.validator.impl.BookIsbnValidatorImpl;
import br.com.liax.bookstore.validator.impl.BookReleaseDateValidatorImpl;
import br.com.liax.bookstore.validator.impl.BookTitleValidatorImpl;

public class InitImpl implements Init {

	public void execute() {

		// connection
		ConnectionFactory connectionFactory = new ConnectionFactoryImpl();
		try (Connection connection = connectionFactory.get(); InputFacade inputFacade = new InputScannerFacadeImpl()) {
			OutputFacade outputFacade = new OutputSysOutFacadeImpl();
			// mapper
			AuthorRowMapper<ResultSet> authorRowMapper = new AuthorResultSetRowMapperImpl();
			BookRowMapper<ResultSet> bookRowMapper = new BookResultSetRowMapperImpl(authorRowMapper);

			// repository
			AuthorRepository authorRepository = new AuthorRepositoryImpl(connection, authorRowMapper);
			BookRepository bookRepository = new BookRepositoryImpl(connection, bookRowMapper);

			// service
			AuthorService authorService = new AuthorServiceImpl(authorRepository);
			BookService bookService = new BookServiceImpl(bookRepository);

			// convertDate
			DateConversorHelper dateConvertConversorHelper = new DateConversorHelperImpl();

			// validator
			// author
			AuthorNameValidator authorNameValidator = new AuthorNameValidatorImpl();
			AuthorBioValidator authorBioValidator = new AuthorBioValidatorImpl();
			AuthorBirthdateValidator authorBirthdateValidator = new AuthorBirthdateValidatorImpl(
					dateConvertConversorHelper);

			// book
			BookTitleValidator bookTitleValidator = new BookTitleValidatorImpl();
			BookDescriptionValidator bookDescriptionValidator = new BookDescriptionValidatorImpl();
			BookIsbnValidator bookIsbnValidator = new BookIsbnValidatorImpl();
			BookReleaseDateValidator bookReleaseDateValidator = new BookReleaseDateValidatorImpl(
					dateConvertConversorHelper);

			// printer
			PrinterHelper<Author> printerAuthorHelper = new PrinterHelperImpl<Author>();
			PrinterHelper<Book> printerBookHelper = new PrinterHelperImpl<Book>();

			// confirm action
			ConfirmActionHelper confirmActionHelper = new ConfirmActionHelperImpl();

			// bo
			AuthorBO authorBO = new AuthorBOImpl(authorNameValidator, authorBioValidator, authorBirthdateValidator,
					 inputFacade, outputFacade, authorService, 
					dateConvertConversorHelper);

			BookBO bookBO = new BookBOImpl(bookTitleValidator, bookDescriptionValidator, bookIsbnValidator,
					bookReleaseDateValidator, printerBookHelper, inputFacade, outputFacade, bookService, authorBO,
					confirmActionHelper, dateConvertConversorHelper);

			MenuBO menuBO = new MenuBOImpl(inputFacade, outputFacade, authorBO, bookBO);

			menuBO.loadMenu();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
