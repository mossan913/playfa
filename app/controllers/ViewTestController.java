package controllers;

import javax.inject.Singleton;

import play.mvc.Controller;
import play.mvc.Result;

@Singleton
public class ViewTestController extends Controller{

	public Result index() {
		return ok(views.html.viewtest_index.render());
	}
}
