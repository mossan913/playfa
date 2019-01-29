package models;

import java.util.Date;

public class Room {

	public String name;
	public Date date;
	public String use;
	public boolean member;

	public Room(String name, Date date, String use, boolean member) {
		this.name = name;
		this.date = date;
		this.use = use;
		this.member = member;
	}

}
