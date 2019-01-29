package controllers;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Singleton;

import models.Room;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

@Singleton
public class RoomController extends Controller{

	public Form<RoomData> roomform;
	public Form<RoomData> initform;

	@Inject
	public RoomController(FormFactory formFactory) {
		this.roomform = formFactory.form(RoomData.class);
		RoomData initdata = new RoomData();
		initdata.setName("");
		initdata.setDate(new Date());
		initdata.setUse("会議");
		initdata.setMember(false);
		this.initform = roomform.fill(initdata);
	}

	public Result showForm() {
		return ok(views.html.roomform.render(initform));
	}

	public Result process() {
		final Form<RoomData> boundForm = roomform.bindFromRequest();
		RoomData data = boundForm.get();
		Room room = new Room(data.getName(), data.getDate(), data.getUse(), data.isMember());
		return ok(views.html.roomresult.render(room));
	}
}
