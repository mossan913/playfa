package controllers;

import java.util.Date;

public class RoomData {

	private String name;

//	@Constraints.Pattern(value="\\d{4}-\\d{2}-\\d{2}", message="yyyy-MM-dd形式")
	private Date date;

	private String use;

	private boolean member;

	public RoomData() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public boolean isMember() {
		return member;
	}

	public void setMember(boolean member) {
		this.member = member;
	}

}
