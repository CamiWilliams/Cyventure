package com.example.cyventure;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.io.IOException;
import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ViewGames extends MainFragment{

	public ArrayList<String> gameNums = new ArrayList<String>();
	public ArrayList<String> gameNames = new ArrayList<String>();
	private String parser = "";
	//private String hey;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
        View rootView = inflater.inflate(R.layout.view_games, container, false);
        getActivity().setTitle("View Games");
        
        parser = "{1, 2}";
        
		if(parser != null)
		{
			String num1 = "";
			for(int i = 1; i < parser.length(); i++)
			{
				if(parser.charAt(i) == ',' || parser.charAt(i) == '}' || parser.charAt(i) == ' ')
				{
					gameNums.add(num1);
					num1 = "";
				}
				else if(Character.isDigit(parser.charAt(i)))
				{
					num1 += parser.charAt(i);
				}
				else
				{
				
				}
			}
			
			/*try {
				String x = getGameName("1");
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			/*for(int j = 0; j < gameNums.size(); j++)
			{
				try {
					gameNames.add(getGameName(gameNums.get(j) + 1));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}*/
			
			gameNames.add("Shirley's Game");
		}

		else
		{
			gameNames.add("No Games Available");
		}
		
		totalClues = 10;
		
		ListView list = (ListView)rootView.findViewById(R.id.listView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, gameNames);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {  
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {  
            	Fragment f = new GameProfile();
            	selectedGameName = gameNames.get(position);
            	selectedGameNum = gameNums.get(position);
				FragmentManager fragmentManager = getFragmentManager();
		        fragmentManager.beginTransaction().replace(R.id.content_frame, f).commit();
            }

         });
        
        //currentGameHintProgress = 5;
        totalClues = 10;
        selectedGameName = "Shirley's Game";
        currentGameHintProgress = 5;
        currentGameProgress = 0;
        
        return rootView;
	}
	
	
	public InputStream data;
	public String json = "";

	public JSONObject file;

	public void update() throws IOException, JSONException
	{
		  data = this.getResources().getAssets().open("clues309-export_03_31_14.json");
		  byte[] d = new byte[data.available()];
	      data.read(d);
	      data.close();
	      json = new String(d);
	      file = new JSONObject(json);
	        
	}
		
		public String getGameName(String num) throws JSONException
		{
			String name = file.getJSONObject("games").getJSONObject(num).getString("name");
			return name;
			
		}
}
