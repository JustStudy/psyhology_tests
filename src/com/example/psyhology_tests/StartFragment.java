package com.example.psyhology_tests;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created with IntelliJ IDEA.
 * User: Ruslik
 * Date: 19.10.13
 * Time: 20:42
 * To change this template use File | Settings | File Templates.
 */
public class StartFragment extends Fragment  {
    Button toTestList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View v= inflater.inflate(R.layout.main,container,false);
           //To change body of overridden methods use File | Settings | File Templates.
        if(!getResources().getBoolean(R.bool.istablet)){
            toTestList=(Button)v.findViewById(R.id.btnToListTest);
            toTestList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, Fragment.instantiate(getActivity(), "com.example.psyhology_tests.FragmentTestList")).addToBackStack(null).commit();
                    Intent intent = new Intent(getActivity(),TestListActivity.class);
                    getActivity().startActivity(intent);
                }
            });}


        return v;
    }
}
