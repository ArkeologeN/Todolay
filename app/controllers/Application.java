package controllers;

import java.util.List;

import models.Task;
import play.mvc.*;
import views.html.*;
import play.data.Form;
import play.db.ebean.Transactional;

public class Application extends Controller {
	
	static Form<Task> taskForm = form(Task.class);
  
  public static Result index() {
    return ok(index.render("Your new application is ready."));
  }
  
  @Transactional
  public static Result tasks() {
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
	  
	  //return ok(join.render());
	  return ok(
			  views.html.tasks.render(Task.all(), taskForm)
	  );
  }
  
  public static Result newTask() {
	  Form<Task> filledForm = taskForm.bindFromRequest();
	  if ( filledForm.hasErrors()) {
		  return badRequest(
				  views.html.tasks.render(Task.all(), filledForm)
		  );
	  } else {
		  Task.createTask(filledForm.get());
		  return redirect(routes.Application.tasks());
	  }

  }
  
  public static Result deleteTask(Long id) {
	  Task.deleteTask(id);
	  return redirect(routes.Application.tasks());
  }
  
  
}