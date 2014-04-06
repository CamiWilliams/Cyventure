package com.example.cyventure;

import java.util.ArrayList;

import com.firebase.client.Firebase;

import android.text.format.Time;

public class User
{
	private String username;
	private ArrayList<Integer> achievements;
	private ArrayList<Integer> notifications;
	private ArrayList<Integer> games;
	private int finishedClue;
	private int gamePlayed;
	private boolean isNewUser;
	private Firebase userRef;

	public User(String username, boolean isNewUser)
	{
		this.username = username;
		if (isNewUser)
		{
			achievements = new ArrayList<Integer>();
			notifications = new ArrayList<Integer>();
			games = new ArrayList<Integer>();
			achievements.add(1);
			achievements.add(2);
			achievements.add(4);
			achievements.add(5);
			notifications.add(0);
			finishedClue = 0;
			gamePlayed = 0;
		}
		else
		{
			// existing user
		}
		

	}

	public void connectData()
	{
		userRef = new Firebase("https://clues309.firebaseio.com/users/"
				+ username);

	}

	public String getUsername()
	{
		return username;
	}

	public ArrayList<Integer> getAchievements()
	{
		return achievements;
	}

	public ArrayList<Integer> getNotifications()
	{
		return notifications;
	}

	public ArrayList<Integer> getGames()
	{
		return games;
	}

	public int getFinishedClue()
	{
		return finishedClue;
	}

	public int getGamePlayed()
	{
		return gamePlayed;
	}

	public void updateAchievements(int index)
	{

	}

	public void createTable()
	{
		// And then we write data to this user's information
		userRef.child(username).setValue(null);
		userRef.child(username).child("achievements")
				.setValue(myToString(achievements));
		userRef.child(username).child("notifications")
				.setValue(myToString(notifications));
		userRef.child(username).child("games").setValue(myToString(games));
		userRef.child(username).child("scores").child("totalClues")
				.setValue(finishedClue);
		userRef.child(username).child("scores").child("totalGames")
				.setValue(gamePlayed);
		isNewUser = false;
	}

	/**
	 * Helper method that helps me to convert arrayList to String that I can
	 * write this into my database
	 * 
	 * @param a
	 * @return
	 */
	public String myToString(ArrayList<Integer> a)
	{
		String s = "{";
		for (int i = 0; i < a.size(); i++)
		{
			s += a.get(i);
			if (i != a.size() - 1)
			{
				s += ", ";
			}
			else
			{
				s += "}";
			}
		}

		return s;
	}

	/**
	 * Check this username is exist or not.
	 * 
	 * @return
	 */
	public boolean newUser()
	{
		return isNewUser;
	}
}
