package controllers;

import javax.inject.Inject;
import javax.inject.Singleton;

import models.Book;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

@Singleton
public class BookFormController extends Controller{

	public Form<BookData> bookform;

	@Inject
	public BookFormController(FormFactory formFactory) {
		this.bookform = formFactory.form(BookData.class);
	}

	public Result showForm() {
		return ok(views.html.bookform.render(bookform));
	}

	public Result process() {
		final Form<BookData> boundForm = bookform.bindFromRequest();
		BookData data = boundForm.get();
		Book book = new Book(data.getTitle(), data.getAuthor(), data.getYear());
		return ok(views.html.bookresult.render(book));
	}
}
