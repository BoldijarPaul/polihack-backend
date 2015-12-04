package com.boldijarpaul.backend.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.boldijarpaul.backend.CacheArrayList;
import com.boldijarpaul.backend.entities.CRUDHelper;
import com.boldijarpaul.backend.entities.Quest;
import com.boldijarpaul.backend.entities.Quiz;
import com.boldijarpaul.backend.entities.Story;
import com.boldijarpaul.backend.entities.User;

public class ServiceManager {

	private static String dataVersion = "1.0";
	public static List<User> users = new CacheArrayList<User>(dataVersion
			+ "users.json");
	public static List<Quest> quests = new CacheArrayList<Quest>(dataVersion
			+ "quests.json");
	public static List<Story> stories = new CacheArrayList<Story>(dataVersion
			+ "stories.json");
	public static List<Quiz> quizes = new CacheArrayList<Quiz>(dataVersion
			+ "quizes.json");

	public static User addUser(User user) {
		for (User currentUser : users) {
			if (currentUser.facebookId.equals(user.facebookId)) {
				return currentUser;
			}
		}
		user._id = (int) (Math.random() * 10000);
		return CRUDHelper.addObject(user, users);
	}

	public static List<User> getUsers() {
		return users;
	}

	public static User updateUser(User user) {
		return CRUDHelper.updateObject(user, users);
	}

	public static Story addStory(Story story) {
		story._id = (int) (Math.random() * 10000);
		return CRUDHelper.addObject(story, stories);
	}

	public static Story updateStory(Story story) {
		return CRUDHelper.updateObject(story, stories);
	}

	public static List<Story> getStories() {
		for (Story story : stories) {
			story.quests = new ArrayList<Quest>();
			story.quests.clear();
			for (Quest quest : quests) {
				if (quest.storyId == quest._id) {
					story.quests.add(quest);
				}
			}
		}
		return stories;
	}

	public static Quest addQuest(Quest quest) {
		quest._id = (int) (Math.random() * 10000);
		return CRUDHelper.addObject(quest, quests);
	}

	public static Quest updateQuest(Quest quest) {
		return CRUDHelper.updateObject(quest, quests);
	}

	public static Quiz addQuiz(Quiz quiz) {
		return CRUDHelper.addObject(quiz, quizes);
	}

	public static Quiz updateQuiz(Quiz quiz) {
		return CRUDHelper.updateObject(quiz, quizes);
	}

	public static Quiz getQuizByHash(String hash) {
		for (Quiz quiz : quizes) {
			if (quiz.hash.equals(hash))
				return quiz;
		}
		return null;
	}

}
