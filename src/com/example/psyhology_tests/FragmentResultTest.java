package com.example.psyhology_tests;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Ruslik
 * Date: 19.10.13
 * Time: 1:01
 * To change this template use File | Settings | File Templates.
 */
public class FragmentResultTest extends Fragment implements Animation.AnimationListener {
    MainTest test;
    Button Bexit;
    Button tostart;
    TextView TVresult;
    TextView TVmasiv;
    Animation myAnim;
    int result = 0;
    int id;

    void ID() {
        id = getActivity().getIntent().getIntExtra("ID", id);

        Log.e("Re", "It works");
        switch (id) {
            case 2:
                test = new Test2();
                break;
            case 1:
                test = new BigEyes();
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.result, null);
        ID();

        myAnim = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.blink);
        myAnim.setAnimationListener(this);
        TVmasiv = (TextView) v.findViewById(R.id.masivresult);
        result = getActivity().getIntent().getIntExtra("result", result);
        TVresult = (TextView) v.findViewById(R.id.tvresult);
        Bexit = (Button) v.findViewById(R.id.Exit);
        tostart = (Button) v.findViewById(R.id.buttonStart);
        TVmasiv.setText("Ваш результат: " + result);
        TVmasiv.startAnimation(myAnim);
        test.result(TVresult, result);
        myAnim = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.zoom_out);
        TVresult.startAnimation(myAnim);
        Bexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        tostart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, Fragment.instantiate(getActivity(), "com.example.psyhology_tests.FragmentTestList")).commit();
            }
        });

        return v;

    }

    @Override
    public void onAnimationStart(Animation animation) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
