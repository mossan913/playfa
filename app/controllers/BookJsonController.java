package controllers;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.fasterxml.jackson.databind.JsonNode;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

@Singleton
public class BookJsonController extends Controller{

	public BookData booktest;
	public String jsontest;

	@Inject
	public BookJsonController() {
		this.booktest = new BookData();
		this.booktest.setTitle("はじめてのPlayFramework");
		this.booktest.setAuthor("清水美樹");
		this.booktest.setYear(2018);
		this.jsontest = "{\"title\":\"Javaではじめる「ラムダ式」\",\"author\":\"清水美樹\",\"year\":2017}";
	}

	public Result bToJ() {
		return ok(views.html.jsontest.render("Book Object to JSON", writeTest(booktest)));
	}

	public Result jToB() {
		return ok(views.html.jsontest.render("JSON to Book Object", readTest(jsontest)));
	}

	private String writeTest(BookData bookdata) {
		JsonNode jsonBook = Json.toJson(bookdata);
		return jsonBook.toString();
	}

	private String readTest(String jsonStr) {
		JsonNode jsonObj = Json.parse(jsonStr);
		BookData result = Json.fromJson(jsonObj, BookData.class);
		return result.getYear() + "年：" + result.getAuthor() + "作：「" + result.getTitle() + "」あるかも。";
	}
}
