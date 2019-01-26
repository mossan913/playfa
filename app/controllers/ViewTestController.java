package controllers;

import java.util.Random;

import javax.inject.Singleton;

import models.ViewTestData;
import play.mvc.Controller;
import play.mvc.Result;

@Singleton
public class ViewTestController extends Controller{

	public Result index() {
		return ok(views.html.viewtest_index.render("自作テンプレートファイル", 1));
	}

	public Result twoArgs() {
		return ok(views.html.viewtest_twoargs.render("新タイトル", new Random().nextInt(10)));
	}

	public Result forLoop() {
		return ok(views.html.viewtest_for.render("ループ＆ループ", new ViewTestData().getTopics()));
	}
}
