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
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Notification extends Fragment
{
	private ArrayList<String> noti = new ArrayList<String>();
	private String[] s = new String[10];// it depends on how many notifications
										// we have in database
	public InputStream data;
	public String json = "";
	
	public JSONObject file;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		
		
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.notification, container,
				false);
		getActivity().setTitle("Notifications");
		ListView list = (ListView) rootView
				.findViewById(R.id.listViewForNotifications);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, noti);
		list.setAdapter(adapter);
		
		
		try
		{
			update();
		}
		catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (JSONException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try
		{
			for(String s : getNotifications())
			{
				noti.add(s);
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
	
	

	public String[] getNotifications() throws JSONException
	{
		String[] a = new String[6];
		JSONArray msg = (JSONArray) file.get("notifications");
		for(int i = 0; i<6; i++)
		{
			a[i] = msg.getString(i);
		}
		return a;

	}

}
