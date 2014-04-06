package com.example.cyventure;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Profile extends Fragment
{
	private TextView username, gameW, gameP, hScore, tScore, tClue, sGame,
			totalTime;
	public InputStream data;
	public String json = "";

	public JSONObject file;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		View v = inflater.inflate(R.layout.profile, container, false);
		getActivity().setTitle("Profile");
		// Find all the views by ID
		try
		{
			update();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (JSONException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		findTextView(v);
		try
		{
			setView();
		}
		catch (JSONException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		username.setText("xuanliw");
		return v;
	}
 
	public void setView() throws JSONException
	{
		gameW.setText(getTotalClue("xuanliw","totalWins"));
		
	}
	
	public void findTextView(View v)
	{
		username = (TextView)v.findViewById(R.id.name);
		gameW = (TextView)v.findViewById(R.id.gameW);
		gameP = (TextView)v.findViewById(R.id.gameP);
		hScore = (TextView)v.findViewById(R.id.hScore);
		tScore = (TextView)v.findViewById(R.id.tScore);
		tClue = (TextView)v.findViewById(R.id.clue);
		sGame = (TextView)v.findViewById(R.id.sGame);
		totalTime = (TextView)v.findViewById(R.id.totalTime);
		
	}
	
	public void update() throws IOException, JSONException
	{

		data = this.getResources().getAssets()
				.open("clues309-export_03_31_14.json");
		byte[] d = new byte[data.available()];
		data.read(d);
		data.close();
		json = new String(d);
		file = new JSONObject(json);

	}

	public void setViewText() throws JSONException
	{
		//String wins = getTotalClue("xuanliw","totalWins");
		username.setText("xuanliw");
		//gameW.setText(wins);
		//tClue.setText(getTotalClue("xuanliw","totalClues"));
		//totalTime.setText(getTotalClue("xuanliw","totalTime"));
		
	}
	public String getTotalClue(String username, String info)
			throws JSONException
	{

		String s = file.getJSONObject("users").getJSONObject(username)
				.getJSONObject("scores").getString(info);
		return s;

	}
	
	

}