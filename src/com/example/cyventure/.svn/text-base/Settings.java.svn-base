package com.example.cyventure;

import com.example.cyventure.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;

public class Settings extends Fragment implements View.OnClickListener{
    private Button about;
    private Button logout;
    private Switch sound;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.settings, container, false);
        getActivity().setTitle("Settings");
        
        about = (Button) rootView.findViewById(R.id.about);
        logout = (Button) rootView.findViewById(R.id.logout);
        sound = (Switch) rootView.findViewById(R.id.soundSwitch);
  
        
        return rootView;
    }

	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
			case R.id.soundSwitch:
				break;
			case R.id.about:
				break;
			case R.id.logout:
				break;
			default:
				break;
	    }
	}  
}