package com.example.psyhology_tests;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created with IntelliJ IDEA.
 * User: Ruslik
 * Date: 23.10.13
 * Time: 23:33
 * To change this template use File | Settings | File Templates.
 */
public class FragmentAbout extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.about,container,false);
        return v;
    }
}
