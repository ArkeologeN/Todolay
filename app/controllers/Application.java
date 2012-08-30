package controllers;

import java.util.List;

import models.Task;
import play.mvc.*;
import views.html.*;
import play.db.ebean.Transactional;

public class Application extends Controller {
  
  public static Result index() {
    return ok(index.render("Your new application is ready."));
  }
  
  @Transactional
  public static Result join() {
	  /*
	  Task task = new Task();
	  task.name = "Goto Office";
	  task.dueDate = new Date();
	  task.done = false;
	  try {
		  task.save();
	  } catch(Exception ex) {
		  System.out.println(ex.getMessage());
	  }
	  */
	  List<Task> tasks = Task.find.all();
	  
	  return ok(index.render("Total Task: "+tasks.size()));
  }
  
}