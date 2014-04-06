package com.example.cyventure;

import java.util.ArrayList;
import java.util.Random;

import com.firebase.client.Firebase;

public class Game
{
	private int gameID;
	private String adminName;
	private int[] clues;
	private String gameName;
	private String notes;
	private boolean isOpen;
	private int totalClues;
	private Random generator;
	public Game(int gameID, String adminName, String gameName,
			String notes, boolean isOpen, int totalClues)
	{
		this.gameID = gameID;
		this.adminName = adminName;
		this.gameName = gameName;
		this.notes = notes;
		this.isOpen = isOpen;
		this.totalClues = totalClues;
		clues = new int[totalClues];
		generator = new Random();
		int clueIndex = generator.nextInt(totalClues);
		
		createTable();
	}

	public int getID()
	{
		return gameID;
	}

	public String getAdminName()
	{
		return adminName;
	}

	public int[] getClues()
	{
		return clues;
	}

	public String gameName()
	{
		return gameName;
	}

	public String getNotes()
	{
		return notes;
	}

	public boolean isOpen()
	{
		return isOpen;
	}

	public int getTotalClues()
	{
		return totalClues;
	}

	public void createTable()
	{
		// First we get a reference to the location of the user's name data:
		Firebase gameRef = new Firebase(
				"https://clues309.firebaseio.com/games");

		// And then we write data to his first and last name locations:
		gameRef.child("gameID").child("admin").setValue(adminName);
		String clue = myToString(clues);
		gameRef.child("gameID").child("clues").setValue(clue);
		gameRef.child("gameID").child("name").setValue(gameName);
		gameRef.child("gameID").child("notes").setValue(notes);
		String temp = (isOpen) ? "true" : "false";
		gameRef.child("gameID").child("name").setValue(temp);
		gameRef.child("gameID").child("totalClues").setValue(totalClues);

	}

	public String myToString(int[] a)
	{
		String s = "{";
		for (int i = 0; i < a.length; i++)
		{
			s += a[i];
			if (i != a.length - 1)
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
}
