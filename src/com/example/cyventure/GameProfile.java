package com.example.cyventure;


import java.util.ArrayList;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class GameProfile extends MainFragment implements View.OnClickListener {
	
	private Button bClue;
	private Button bEnd;
	private TextView tName;
	private TextView tPlayers;
	private TextView tProgress;
	private TextView tNotes;
	private TextView tHints;
	private TextView hidden;
	private String total;
	private String admin;
	private ArrayList<String> players = new ArrayList<String>();
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
        View rootView = inflater.inflate(R.layout.game_profile, container, false);
        getActivity().setTitle("Game Profile");
        
        bClue = (Button)rootView.findViewById(R.id.gBClues);
        bEnd = (Button)rootView.findViewById(R.id.gBEnd);
        tName = (TextView)rootView.findViewById(R.id.gName);
        tPlayers = (TextView)rootView.findViewById(R.id.gPlayers);
        tProgress = (TextView)rootView.findViewById(R.id.gProgress);
        tNotes = (TextView)rootView.findViewById(R.id.gNotes);
        tHints = (TextView)rootView.findViewById(R.id.gHints);
        
        tName.setText("Shirley's Game");
        tPlayers.setText("lambacama, xuanliw");
        tProgress.setText(currentGameProgress + "/10");
        //tHints.setText(5);
        tNotes.setText("This is a great game");
        
        /*try {
			admin = GetDBInfo.getValue("https://clues309.firebaseIO.com/games/" + selectedGameNum + "/admin");
			tName.setText(GetDBInfo.getValue("https://clues309.firebaseIO.com/games/" + selectedGameNum + "/name"));
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	//Get notes
        Firebase gameDB_notes = new Firebase("https://clues309.firebaseIO.com/games/" + selectedGameNum + "/notes");
    	gameDB_notes.addValueEventListener(new ValueEventListener() {
    		@Override
    		public void onDataChange(DataSnapshot snapshot) {
    			tNotes.setText((String) snapshot.getValue());
    		}

			@Override
			public void onCancelled(FirebaseError arg0) {
				System.err.println("Listener was cancelled");
			}
		});	
    	
    	//Get total
    	try {
			total = GetDBInfo.getValue("https://clues309.firebaseIO.com/games/" + selectedGameNum + "/totalClues");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	totalClues = Integer.parseInt(total);
    	
    	//Get Progress
        Firebase gameDB_progress = new Firebase("https://clues309.firebaseIO.com/usersGames/" + selectedGameNum + "/" + username + "/completedClues");
    	gameDB_progress.addValueEventListener(new ValueEventListener() {
    		@Override
    		public void onDataChange(DataSnapshot snapshot) {
    			String p = (String) snapshot.getValue();
    			tProgress.setText(p + "/" + total);
    			currentGameProgress = Integer.parseInt(p);
    			 
    		}

			@Override
			public void onCancelled(FirebaseError arg0) {
				System.err.println("Listener was cancelled");
			}
		});	
    	
    	//Get Hints
        Firebase gameDB_hints = new Firebase("https://clues309.firebaseIO.com/usersGames/" + selectedGameNum + "/" + username + "/hints");
    	gameDB_hints.addValueEventListener(new ValueEventListener() {
    		@Override
    		public void onDataChange(DataSnapshot snapshot) {
    			String p = (String) snapshot.getValue();
    			tHints.setText(p);
    			currentGameHintProgress = Integer.parseInt(p);
    		}

			@Override
			public void onCancelled(FirebaseError arg0) {
				System.err.println("Listener was cancelled");
			}
		});	
    	
    	//Get Players ------------------------------------------------------------------------------------------------
        Firebase gameDB_players = new Firebase("https://clues309.firebaseIO.com/usersGames/" + selectedGameNum);
    	gameDB_players.addValueEventListener(new ValueEventListener() {
    		@Override
    		public void onDataChange(DataSnapshot snapshot) {
    			Iterable<DataSnapshot> iter = snapshot.getChildren();
    			while(iter.iterator().hasNext())
    			{
    				players.add(iter.iterator().next().getName());
    			}
    		}

			@Override
			public void onCancelled(FirebaseError arg0) {
				System.err.println("Listener was cancelled");
			}
		});	
    	
    	String playDisplay = "";
    	int i = 0;
    	for(i = 0; i < players.size() - 1; i++)
    	{
    		playDisplay += players.get(i) + ", ";
    	}
    	
    	playDisplay += players.get(i);
    	tPlayers.setText(playDisplay);
    	*/
        
        bClue.setOnClickListener(this);
        bEnd.setOnClickListener(this);
        
        return rootView;
    }
	
	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
			case R.id.gBClues:
				Fragment f1 = new DisplayGame();
				FragmentManager fragmentManager1 = getFragmentManager();
		        fragmentManager1.beginTransaction().replace(R.id.content_frame, f1).commit();
				break;
			case R.id.gBEnd:
				//RemoveGame
				//    if admin remove game from games, gameUser, and Users involved
				//    else remove user from games, gameUser, and Users
				Fragment f2 = new ViewGames();
				FragmentManager fragmentManager2 = getFragmentManager();
		        fragmentManager2.beginTransaction().replace(R.id.content_frame, f2).commit();
				break;
			default:
				break;
	    }
	}    
}
