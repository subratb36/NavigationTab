package com.example.navigationtab.drawerFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigationtab.R;
import com.example.navigationtab.Utils.IFragmentCommunicator;

/**
 * Created by subratkumar on 21-05-2017.
 */
public class AboutUs extends Fragment {
    private AppCompatButton home;
    private View view;

    public AboutUs(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_aboutus,container,false);
        home= (AppCompatButton) view.findViewById(R.id.home_bt);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IFragmentCommunicator communicator= (IFragmentCommunicator) getActivity();
                communicator.homeScreen();
            }
        });

        return view;
    }
}
