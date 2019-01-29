package controllers;

import play.data.validation.Constraints;

public class BookValData {

	@Constraints.Required
	private String title;

	private String author;

	@Constraints.Max(2019)
	private int year;

	public BookValData() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
