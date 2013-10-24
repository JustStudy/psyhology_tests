package com.example.psyhology_tests;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Ruslik
 * Date: 16.10.13
 * Time: 17:32
 * To change this template use File | Settings | File Templates.
 */
public class FragmentTestList extends Fragment implements Animation.AnimationListener {

    TextView tvFinish;
    Animation simpleAnim;
    TextView tv1Test;
    TextView tv2Test;
    TextView tvMain;
    int ID_Test;
        /*public static Fragment newInstance(Context context) {
            FragmentTestList f = new FragmentTestList();

                return f;                               `
        }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment1, container,false);

        tv1Test = (TextView) v.findViewById(R.id.BtnBigEyes);
        tv2Test = (TextView) v.findViewById(R.id.BtnYourNerve);
        simpleAnim = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.blink);
        tv2Test.startAnimation(simpleAnim);
        tv1Test.startAnimation(simpleAnim);

        View.OnClickListener forInitTest = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.BtnBigEyes:
                        ID_Test = 1;
                        break;
                    case R.id.BtnYourNerve:
                        ID_Test = 2;
                        break;
                }
                //Intent intent = new Intent(getActivity(),MainStartActivity.class);

                if(!getResources().getBoolean(R.bool.istablet)){
                  //  Intent intent = new Intent(getActivity(),TestActionActivity.class);
                  Intent myintent = new Intent(getActivity(),TestActionActivity.class);
                         myintent.putExtra("ID", ID_Test);
                    getActivity().startActivity(myintent);
                   // getActivity().getIntent().putExtra("ID", ID_Test);

                   // getActivity().startActivity( getActivity().getIntent());
                   // getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, Fragment.instantiate(getActivity(), "com.example.psyhology_tests.FragmentTestAction")).addToBackStack(null).commit();

                }
                if(getResources().getBoolean(R.bool.istablet)){
                    getActivity().getIntent().putExtra("ID", ID_Test);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment2ForTablet, Fragment.instantiate(getActivity(), "com.example.psyhology_tests.FragmentTestAction")).commit();

                }
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };

        if(getResources().getBoolean(R.bool.istablet)){
            tvMain = (TextView) v.findViewById(R.id.TVMainPage);
            tvMain.startAnimation(simpleAnim);
             tvFinish=(TextView)v.findViewById(R.id.textViewExit);
            tvFinish.startAnimation(simpleAnim);
        View.OnClickListener myOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //To change body of implemented methods use File | Settings | File Templates.
                switch (v.getId()){
                    case R.id.TVMainPage:
                        /*Intent k =new Intent(getActivity(),TestActionActivity.class);
                         getActivity().startActivity(k);*/
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment2ForTablet, Fragment.instantiate(getActivity(), "com.example.psyhology_tests.StartFragment")).commit();
                       // getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null);
                       // getActivity().getSupportFragmentManager().beginTransaction().commit();
                        break;
                    case R.id.textViewExit: getActivity().finish();
                        break;
                }
            }
        } ;
            tvMain.setOnClickListener(myOnClickListener);
            tvFinish.setOnClickListener(myOnClickListener);
        }

        simpleAnim.setAnimationListener(this);
        tv1Test.setOnClickListener(forInitTest);
        tv2Test.setOnClickListener(forInitTest);
        if(!getResources().getBoolean(R.bool.istablet)){


        }
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
