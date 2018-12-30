package controllers;

import javax.inject.Inject;
import javax.inject.Singleton;

import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
@Singleton
public class FormsController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
	// Formクラス
	public static class SampleForm {
		public String message;

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}
	private final Form<SampleForm> form;

	@Inject
	public FormsController(FormFactory formFactory) {
		this.form = formFactory.form(SampleForm.class);
	}

	// /(root)
	public Result index() {
	    return ok(views.html.forms.render(
	    		"Please type something!",
	    		form
	    		));
	}

	// /send
	public Result send() {
		final Form<SampleForm> f = form.bindFromRequest();
		if (!f.hasErrors()){
			SampleForm data = f.get();
	    	String msg = "you typed: " + data.message;
	    return ok(views.html.forms.render(msg, f));
	} else {
		return badRequest(views.html.forms.render("Error!", form));
		}
	}

}
