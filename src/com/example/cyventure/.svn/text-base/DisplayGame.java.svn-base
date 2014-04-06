package com.example.cyventure;

import java.util.ArrayList;
import java.util.Random;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class DisplayGame extends MainFragment implements View.OnClickListener{
	
	private ArrayList<Integer> used = new ArrayList<Integer>();
	private Random num = new Random();
	private Button checkin;
	private Button hi;
	private Button back;
	private int clueCount;
	private int hintCount = currentGameHintProgress;
	private int index;
	//private static int randomNum;
	private TextView correct;
	private TextView clueNo;
	private TextView hint;
	private TextView description;
	
	public static ArrayList<Integer> gameNums;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.display_game, container, false);
        getActivity().setTitle("Game");		
		
		//Initialize values
		description = (TextView)rootView.findViewById(R.id.textView3);
		checkin = (Button)rootView.findViewById(R.id.startDate_b);
		hi = (Button)rootView.findViewById(R.id.hint);
		back = (Button)rootView.findViewById(R.id.leave);
		correct = (TextView) rootView.findViewById(R.id.textView1); //Correct!
		clueNo = (TextView) rootView.findViewById(R.id.textView2); //Clue 1/#
		hint = (TextView) rootView.findViewById(R.id.textView4); //Hint

		checkin.setOnClickListener(this);
		hi.setOnClickListener(this);
		back.setOnClickListener(this);
		
		int total = 10;
		
		String clues = "{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}";
		
		/*try {
			clues = GetDBInfo.getValue("https://clues309.firebaseio.com/games/"+selectedGameNum+"/clues");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		gameNums = new ArrayList<Integer>();
		
		
		String num1 = "";
			for(int i = 1; i < clues.length(); i++)
			{
				if(clues.charAt(i) == ',' || clues.charAt(i) == '}' || clues.charAt(i) == ' ')
				{
					if(!num1.equals(""))
					{
						gameNums.add(Integer.parseInt(num1));
					}
					num1 = "";
				}
				else if(Character.isDigit(clues.charAt(i)))
				{
					num1 += clues.charAt(i);
				}
				else
				{
					
				}
			}
			
		
		
		hi.setText("Hint (" + currentGameHintProgress + ")");
		correct.setVisibility(4);//Invisible
		hint.setVisibility(4);
		
		//clueCount++;
		//clueNo.setText("Clue " + clueCount + "/" + randomNum);
		this.getClueDescription();
		
		
		
		String j = description.getText().toString();
		String y = j + 1;
		
		return rootView;
	}

	public void getClueDescription()
	{
		index = gameNums.get(currentGameProgress);
		
		if(used.size() == gameNums.size())
		{
			correct.setText("Game Completed!");
			checkin.setEnabled(false);
			//back.setText("View Games");
			return;
		}
		else
		{
    		clueNo.setText("Clue " + currentGameProgress + "/" + totalClues);
		
			String url = "https://clues309.firebaseIO.com/clues/" + index + "/clue1";
		
			Firebase clues = new Firebase(url);
		
			clues.addValueEventListener(new ValueEventListener() {
		    	@Override
		    	public void onDataChange(DataSnapshot snapshot) {
		    		String des = (String) snapshot.getValue();
			    	description.setText(des);
		    	}

				@Override
				public void onCancelled(FirebaseError arg0) {
					System.err.println("Listener was cancelled");
				}
			});	
		}
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
			case R.id.startDate_b: //CHECKIN
				hint.setVisibility(4);
	      		  correct.setVisibility(0);
	        	  correct.setText("Correct!");
	        	  final Animation out = new AlphaAnimation(1.0f, 0.0f);
  		      out.setDuration(3000);
	        	  correct.startAnimation(out);
	        	  correct.setVisibility(4);
	        	  
	        	  if(hintCount > 0)
	        		  hi.setEnabled(true);

	        	  Firebase gameDB_clues = new Firebase("https://clues309.firebaseIO.com/usersGames/" + selectedGameNum + "/" + username + "/completedClues");
	      		  gameDB_clues.setValue(++currentGameProgress);
	        	  getClueDescription();
				break;
			case R.id.leave:
				Fragment f2 = new GameProfile();
				FragmentManager fragmentManager2 = getFragmentManager();
		        fragmentManager2.beginTransaction().replace(R.id.content_frame, f2).commit();
				break;
			case R.id.hint:
				String url = "https://clues309.firebaseIO.com/clues/" + index + "/clue2";
	      		
      			Firebase clues = new Firebase(url);
      			hi.setText("Hint (" + --hintCount + ")");
      			
      			Firebase gameDB_hints = new Firebase("https://clues309.firebaseIO.com/usersGames/" + selectedGameNum + "/" + username + "/hints");
      			gameDB_hints.setValue(hintCount);
      			++currentGameHintProgress;
      			
      			hi.setEnabled(false);
      			if(hintCount == 0)
      			{
	      			hi.setText("Hint (0)");
      				hi.setEnabled(false);
      			}
      			clues.addValueEventListener(new ValueEventListener() {
      		    @Override
      		    public void onDataChange(DataSnapshot snapshot) {
      		    	String des = (String) snapshot.getValue();
      			    hint.setText(des);
      			    hint.setVisibility(0);
      		    }

      			@Override
      			public void onCancelled(FirebaseError arg0) {
      				System.err.println("Listener was cancelled");
      			}});
				break;
			default:
				break;
	    }
	}    
}
