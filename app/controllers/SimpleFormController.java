package controllers;

import javax.inject.Inject;
import javax.inject.Singleton;

import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

@Singleton
public class SimpleFormController extends Controller{

	public Form<String> form;

	@Inject
	public SimpleFormController(FormFactory formFactory) {
		this.form = formFactory.form(String.class);
	}

	public Result showForm() {
		return ok(views.html.simpleform.render(form));
	}

	public Result process() {
		final Form<String> f = form.bindFromRequest();
		String sentData = f.field("name").getValue().get();
		return ok(views.html.simpleform_result.render(sentData));
	}
}
