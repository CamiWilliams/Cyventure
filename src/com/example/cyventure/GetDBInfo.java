package com.example.cyventure;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class GetDBInfo {

	public static String arr = new String();
	public static String getValue(String url) throws InterruptedException
	{
		Firebase fb = new Firebase(url);
		
		fb.addValueEventListener(new ValueEventListener() {
			@Override
	    	public void onDataChange(DataSnapshot snapshot) {
				GetDBInfo.this.arr = (String) snapshot.getValue();
				System.out.println(arr);
	    	}

			@Override
			public void onCancelled(FirebaseError arg0) {
				System.err.println("Listener was cancelled");
			}
			
		});

		Thread.sleep(5000);
		
		return arr;
	}
	
	
}
