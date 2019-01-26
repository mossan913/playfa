package controllers;

import javax.inject.Singleton;

import models.ViewTestData;
import play.mvc.Controller;
import play.mvc.Result;

@Singleton
public class RoutingTestController extends Controller{

	public Result simple(String something) {
		return ok(something+"様、お世話になっております。");
	}

	public Result showData(Integer index) {
		return ok(views.html.routingtest_showdata.render("選択されたトピック", new ViewTestData().getTopic(index)));
	}
}
