package com.example.cyventure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;


public class CreateGame extends MainFragment implements View.OnClickListener {
	
	private Random rand = new Random();
	private Button create;
	private Button cancel;
	private SeekBar slider;
	private TextView numClues;
	private EditText gName;
	private EditText gNote;
	private Switch open;
	public static String NAME = "name";
	public static String NOTE = "note";
	public static int NUM = 1;
	private boolean isOpen;
	private String gameArray;
	private ArrayList<Integer> nums = new ArrayList<Integer>();
	private ArrayList<String> players = new ArrayList<String>();
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
        View rootView = inflater.inflate(R.layout.create_game, container, false);
        getActivity().setTitle("Create Game");
        
        create = (Button)rootView.findViewById(R.id.create);
        cancel = (Button)rootView.findViewById(R.id.cancel);
        slider = (SeekBar)rootView.findViewById(R.id.seekBar1);
        numClues = (TextView)rootView.findViewById(R.id.numClues);
        gName = (EditText)rootView.findViewById(R.id.nameEdit);
        gNote = (EditText)rootView.findViewById(R.id.notes);
        open = (Switch)rootView.findViewById(R.id.open);
        
        open.setOnCheckedChangeListener(new OnCheckedChangeListener() {

        	@Override
        	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) 
        	{
        		if(isChecked)
        			isOpen = true;
        		else
        			isOpen = false;
        	}
        });
        
        slider.setMax(60); //---------------------------------------------FIX THIS WITH DATABASE MAX
        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
	    {
		       public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
		       {
		            numClues.setText(Integer.toString(progress + 1));
		            NUM = (progress + 1);
		       }

		      public void onStartTrackingTouch(SeekBar seekBar) {}
		      public void onStopTrackingTouch(SeekBar seekBar) {}
		});
        
        int i = 0;
        //NUM = Integer.parseInt(numClues.getText().toString());
		NAME = gName.getText().toString();
		NOTE = gNote.getText().toString();
    	
        while(i < NUM)
        {
        	int clueIndex = rand.nextInt(NUM) + 1;
        	while(nums.contains(clueIndex))
        	{
				clueIndex = rand.nextInt(NUM) + 1;
			}
			nums.add(clueIndex);
			i++;
        }
        
        create.setOnClickListener(this);
        cancel.setOnClickListener(this);
        
        return rootView;
    }
	
	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
			case R.id.create:
		        // --------------------------- SEND DATA
		        Firebase gamesDB = new Firebase("https://clues309.firebaseio.com/games" + Integer.toString(dbMaxGameNum));
		        Map<String, Object> toSet1 = new HashMap<String, Object>();
		        toSet1.put("admin", username);
		        toSet1.put("clues", nums);
		        toSet1.put("name", NAME);
		        toSet1.put("notes", NOTE);
		        toSet1.put("open", isOpen);
		        toSet1.put("totalClues", NUM);
		        gamesDB.setValue(toSet1);
		        
		        for(String x : players)
		        {
		        	Firebase users_gamesDB = new Firebase("https://clues309.firebaseIO.com/usersGames/" + Integer.toString(dbMaxGameNum) + "/" + x);
		        	Map<String, Object> toSet2 = new HashMap<String, Object>();
			        toSet1.put("completedClues", 0);
			        toSet1.put("hints", 5);
		        	users_gamesDB.setValue(toSet2);
		        	
		        	
		        	Firebase usersDB = new Firebase("https://clues309.firebaseIO.com/users/" + x + "/games");
		        	
					usersDB.addValueEventListener(new ValueEventListener() {
				    	@Override
				    	public void onDataChange(DataSnapshot snapshot) {
				    		gameArray = (String) snapshot.getValue();
				    	}

						@Override
						public void onCancelled(FirebaseError arg0) {
							System.err.println("Listener was cancelled");
						}
					});	
					
		        	Map<String, Object> updates = new HashMap<String, Object>();
			        updates.put("games", gameArray.substring(0, gameArray.length() - 1) + ", " + dbMaxGameNum + "}");
			        usersDB.setValue(updates);
			        
		        }
		        
		        dbMaxGameNum++;
		        
		        Fragment f1 = new ViewGames();
				FragmentManager fragmentManager1 = getFragmentManager();
		        fragmentManager1.beginTransaction().replace(R.id.content_frame, f1).commit();
				break;
			case R.id.cancel:
				Fragment f2 = new Home();
				FragmentManager fragmentManager2 = getFragmentManager();
		        fragmentManager2.beginTransaction().replace(R.id.content_frame, f2).commit();
				break;
			default:
				break;
	    }
	}    
}
