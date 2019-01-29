package controllers;

import javax.inject.Inject;
import javax.inject.Singleton;

import models.Book;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

@Singleton
public class BookValController extends Controller{

	public Form<BookValData> bookform;

	@Inject
	public BookValController(FormFactory formFactory) {
		this.bookform = formFactory.form(BookValData.class);
	}

	public Result showForm() {
		return ok(views.html.valform.render(bookform));
	}

	public Result process() {
		final Form<BookValData> boundForm = bookform.bindFromRequest();
		if(boundForm.hasErrors()) {
			return badRequest(views.html.valform.render(boundForm));
		} else {
			BookValData data = boundForm.get();
			Book book = new Book(data.getTitle(), data.getAuthor(), data.getYear());
			return ok(views.html.bookresult.render(book));
		}
	}
}
