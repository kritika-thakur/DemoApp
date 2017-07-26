package com.example.ideafoundation.grouplistdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ideafoundation on 25/07/17.
 */

public class AbouUsFragment extends Fragment

    {

    public AbouUsFragment() {
        // Required empty public constructor
    }

        @Override
        public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.about_us, container, false);


        // Inflate the layout for this fragment
        return rootView;
    }

        @Override
        public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

        @Override
        public void onDetach() {
        super.onDetach();
    }
    }
