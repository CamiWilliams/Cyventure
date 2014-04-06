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
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Achievement extends Fragment
{
	private ArrayList<String> achieves = new ArrayList<String>();
	private String[] s = new String[17];
	public InputStream data;
	public String json = "";
	
	public JSONObject file;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		// achieves.add("On Create");
		// TODO Auto-generated method stub
		View rootView = inflater
				.inflate(R.layout.achievement, container, false);
		getActivity().setTitle("Achievements");
		ListView list = (ListView) rootView
				.findViewById(R.id.listViewForAchievements);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, achieves);
		list.setAdapter(adapter);
		// achieves.add("10 hours played");
		try
		{
			update();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// setAchievements();
		// addAchievements();
		// update();
		/*
		 * try{
		 * 
		 * s[0] = "00000"; s[1] = "00001"; s[2] = "00002"; s[3] = "00003"; s[4]
		 * = "00004";
		 * 
		 * achieves.add("Before Set"); setAchievements();
		 * achieves.add("After Set"); update();
		 * 
		 * 
		 * } catch(Exception exp) { achieves.add("EXP"); }
		 */
		catch (JSONException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try
		{
			for(String s : getAchievements())
			{
				achieves.add(s);
			}
			
		}
		catch (JSONException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rootView;
	}

	public void update() throws IOException, JSONException
	{

		data = this.getResources().getAssets().open("clues309-export_03_31_14.json");
		byte[] d = new byte[data.available()];
        data.read(d);
        data.close();
        json = new String(d);
        file = new JSONObject(json);
        
	}
	
	// get data under achivements.
	public String[] getAchievements() throws JSONException
	{
		String[] a = new String[16];
		JSONArray msg = (JSONArray) file.get("achievements");
		for(int i = 0; i<16; i++)
		{
			a[i] = msg.getString(i);
		}
		return a;
		
	}

	

	

}
