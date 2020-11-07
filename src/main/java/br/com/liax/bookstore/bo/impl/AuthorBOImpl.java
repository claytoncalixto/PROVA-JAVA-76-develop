package br.com.liax.bookstore.bo.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;


import br.com.liax.bookstore.bo.AuthorBO;
import br.com.liax.bookstore.facade.InputFacade;
import br.com.liax.bookstore.facade.OutputFacade;
import br.com.liax.bookstore.helper.DateConversorHelper;
import br.com.liax.bookstore.model.Author;
import br.com.liax.bookstore.service.AuthorService;
import br.com.liax.bookstore.validator.AuthorBioValidator;
import br.com.liax.bookstore.validator.AuthorBirthdateValidator;
import br.com.liax.bookstore.validator.AuthorNameValidator;

public class AuthorBOImpl implements AuthorBO {

	private final AuthorNameValidator authorNameValidator;

	private final AuthorBioValidator authorBioValidator;

	private final AuthorBirthdateValidator authorBirthdateValidator;

	private final InputFacade inputFacade;

	private final OutputFacade outputFacade;

	private final AuthorService authorService;

	private final DateConversorHelper dateConversorHelper;

	public AuthorBOImpl(AuthorNameValidator authorNameValidator, AuthorBioValidator authorBioValidator,
			AuthorBirthdateValidator authorBirthdateValidator,
			InputFacade inputFacade, OutputFacade outputFacade, AuthorService authorService,
			 DateConversorHelper dateConversorHelper) {
		this.authorNameValidator = authorNameValidator;
		this.authorBioValidator = authorBioValidator;
		this.authorBirthdateValidator = authorBirthdateValidator;
		this.inputFacade = inputFacade;
		this.outputFacade = outputFacade;
		this.authorService = authorService;
		this.dateConversorHelper = dateConversorHelper;
	}

	@Override
	public void delete() throws SQLException {
		Author author =  null;
		outputFacade.print("Deletar Autores");
		outputFacade.print("Digite o ID do autor:");
		long id = inputFacade.nextLong();
		if(author.equals(id)) {
		    authorService.deleteById(id);
		} else {
				outputFacade.print("Não foi encontrado Autor para o ID informado. Por favor, insira um ID válido.");
			}
		

	}

	@Override
	public void update() throws ParseException, SQLException {
		Author author = this.findById();
		outputFacade.print("Informe os novos dados do Autor ou tecle enter para manter o dado");
		String name = null;
		boolean isValid = false;
		do {
			outputFacade.print("Digite o nome do autor:");
			name = inputFacade.nextLine();

			if (!name.isEmpty()) {
				isValid = authorNameValidator.validate(name);
				if (isValid) {
					author.setName(name);
				} else {
					outputFacade.print("Nome invalido");
				}
			} else {
				isValid = true;
			}
		} while (!isValid);

		String bio = null;
		do {
			outputFacade.print("Digite a bio do autor:");
			bio = inputFacade.nextLine();

			if (!bio.isEmpty()) {
				isValid = authorBioValidator.validate(bio);
				if (isValid) {
					author.setBio(bio);
				} else {
					outputFacade.print("Bio invalida");
				}
			} else {
				isValid = true;
			}
		} while (!isValid);

		do {
			outputFacade.print("Digite a data de nascimento do autor:");
			String birthDateStr = inputFacade.nextLine();
			if (!birthDateStr.isEmpty()) {
				isValid = authorBirthdateValidator.validate(birthDateStr);
				if (isValid) {
					author.setBirthdate(dateConversorHelper.convert(birthDateStr));
				} else {
					outputFacade.print("Data de nascimento invalida");
				}
			} else {
				isValid = true;
			}
		} while (!isValid);

		authorService.updateById(author);

	}

	@Override
	public void insert() throws ParseException, SQLException {
		boolean isValid = false;
		String name = null;
		do {
			outputFacade.print("Digite o nome do autor:");
			name = inputFacade.nextLine();
			isValid = authorNameValidator.validate(name);
			if (!isValid) {
				outputFacade.print("Nome invalido");
			}
		} while (!authorNameValidator.validate(name));

		String bio = null;
		do {
			outputFacade.print("Digite a bio do autor:");
			bio = inputFacade.nextLine();
			isValid = authorBioValidator.validate(bio);
			if (!isValid) {
				outputFacade.print("Bio invalido");
			}
		} while (!isValid);

		Date birthdate = null;
		do {
			outputFacade.print("Digite a data de nascimento do autor:");
			String birthDateStr = inputFacade.nextLine();
			isValid = authorBirthdateValidator.validate(birthDateStr);
			if (isValid) {
				birthdate = dateConversorHelper.convert(birthDateStr);
			} else {
				outputFacade.print("Data de nascimento invalido");
			}
		} while (!isValid);

		Author author = new Author();
		author.setName(name);
		author.setBio(bio);
		author.setBirthdate(birthdate);
		authorService.insert(author);
	}

	@Override
	public void findAll() throws SQLException {
		this.findAll();
		Author author = null;
		outputFacade.print("Mostrar Todos os Autores");
		do {			
			long id = inputFacade.nextLong();
			author = authorService.findById(id);
			outputFacade.print(author.getId());
			outputFacade.print(author.getName());
			Date dateNow1 = new Date();
			Date birthdate1 = author.getBirthdate();
			Duration idade1 =  new Duration (dateNow1, birthdate1);	
			idade1 = dateConversorHelper.convert(idade1);
			outputFacade.print(idade1);
			
		}
		while(author != null);
		
	}

	

	@Override
	public Author findById() throws SQLException {
		this.findAll();
		Author author = null;
		do {
			outputFacade.print("Digite o ID do autor:");
			long id = inputFacade.nextLong();
			author = authorService.findById(id);
			if (author == null) {
				outputFacade.print("Não foi encontrado Autor para o ID informado. Por favor, insira um ID válido.");
			}
		} while (author == null);

		return author;
	}

}
