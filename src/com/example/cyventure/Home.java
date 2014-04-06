
package com.example.cyventure;

import com.example.cyventure.R;

import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Home extends Fragment implements View.OnClickListener{
    private Button create;
    private Button join;
    private Button games;
    private Button tempMap;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home, container, false);
        getActivity().setTitle("Home");
        
        create = (Button) rootView.findViewById(R.id.button1);
        join = (Button) rootView.findViewById(R.id.button2);
        games = (Button) rootView.findViewById(R.id.button3);
        tempMap = (Button) rootView.findViewById(R.id.button4);
        	create.setTextSize(23);
        	create.setTypeface(Typeface.DEFAULT_BOLD);
        	join.setTextSize(23);
        	join.setTypeface(Typeface.DEFAULT_BOLD);
        	games.setTextSize(23);
        	games.setTypeface(Typeface.DEFAULT_BOLD);
        create.setOnClickListener(this);
        join.setOnClickListener(this);
        games.setOnClickListener(this);
        tempMap.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				//Intent i = new Intent(this, FullMapActivity.class);
			}
		});
        
        return rootView;
    }

	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
			case R.id.button1:
				Fragment f1 = new CreateGame();
				FragmentManager fragmentManager1 = getFragmentManager();
		        fragmentManager1.beginTransaction().replace(R.id.content_frame, f1).commit();
				break;
			case R.id.button2:
				/*
				 * Fragment f2 = new JoinGame();
				 * FragmentManager fragmentManager2 = getFragmentManager();
		         * fragmentManager2.beginTransaction().replace(R.id.content_frame, f2).commit();
				 */
				break;
			case R.id.button3:
				Fragment f3 = new ViewGames();
				FragmentManager fragmentManager3 = getFragmentManager();
		        fragmentManager3.beginTransaction().replace(R.id.content_frame, f3).commit();
				break;
			default:
				break;
	    }
	}    
}