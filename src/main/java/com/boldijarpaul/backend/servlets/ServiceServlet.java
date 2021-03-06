package com.boldijarpaul.backend.servlets;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.boldijarpaul.backend.entities.Quest;
import com.boldijarpaul.backend.entities.Quiz;
import com.boldijarpaul.backend.entities.Story;
import com.boldijarpaul.backend.entities.User;
import com.boldijarpaul.backend.service.ServiceManager;

@Path("/data")
public class ServiceServlet {

	@GET
	@Path("/users")
	public List<User> getUsers() {
		return ServiceManager.getUsers();
	}

	@POST
	@Path("/users/add")
	public User addUser(User user) {
		return ServiceManager.addUser(user);
	}

	@GET
	@Path("/stories")
	public List<Story> getStories() {
		return ServiceManager.getStories();
	}

	@POST
	@Path("/stories/add")
	public Story addStory(Story story) {
		return ServiceManager.addStory(story);
	}

	@PUT
	@Path("/stories/update")
	public Story updateStory(Story story) {
		return ServiceManager.updateStory(story);
	}

	@POST
	@Path("/quests/add")
	public Quest addQuest(Quest quest) {
		return ServiceManager.addQuest(quest);
	}

	@PUT
	@Path("/quests/update")
	public Quest updateQuest(Quest quest) {
		return ServiceManager.updateQuest(quest);
	}

	@POST
	@Path("/quizes/add")
	public Quiz addQuiz(Quiz quiz) {
		return ServiceManager.addQuiz(quiz);
	}

	@PUT
	@Path("/quizes/update")
	public Quiz updateQuiz(Quiz quiz) {
		return ServiceManager.updateQuiz(quiz);
	}

	@GET
	@Path("/quiz")
	public Object getQuizByHash(@PathParam("hash") String hash) {
		Quiz quiz = ServiceManager.getQuizByHash(hash);
		if (quiz == null) {
			return "Not found";
		} else {
			return quiz;
		}
	}

}
