package com.example.psyhology_tests;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created with IntelliJ IDEA.
 * User: Ruslik
 * Date: 15.10.13
 * Time: 9:08
 * To change this template use File | Settings | File Templates.
 */
public class MainStartActivity extends MainRelativeActivity {

    Intent intent = new Intent();
    StartFragment k;

   // FragmentTransaction tx;

   // boolean DrawerState;

    // String[] fragmentsList = {"com.example.psyhology_tests.StartFragment","com.example.psyhology_tests.FragmentTestList"};
  //  private String[] testArray;
   // Button exit;
    //String[] listForList = {"Главная", "Список тестов"};
    // FragmentTransaction fTrans;
    StartFragment fragmentTestList = new StartFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
       // setContentView(R.layout.activity_main);
          if(savedInstanceState==null)   {
              tx = getSupportFragmentManager().beginTransaction();
              k = new StartFragment();
              if(!getResources().getBoolean(R.bool.istablet)){


                  tx.replace(R.id.content_frame, k);

              }
              if(getResources().getBoolean(R.bool.istablet)){
                  tx.replace(R.id.fragment2ForTablet, k);
              }

              tx.commit();

          }



    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if(getResources().getBoolean(R.bool.istablet)){
            getSupportFragmentManager().putFragment(outState,"currentFrag",getSupportFragmentManager().findFragmentById(R.id.fragment2ForTablet));
            //getSupportFragmentManager().saveFragmentInstanceState(getSupportFragmentManager().findFragmentById(R.id.fragment2ForTablet));

        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(getResources().getBoolean(R.bool.istablet)){
        tx = getSupportFragmentManager().beginTransaction();
       // tx.replace(R.id.fragment2ForTablet, getSupportFragmentManager().getFragment(savedInstanceState.getBundle("currentFrag"),"currentFrag" ));
        tx.replace(R.id.fragment2ForTablet,getSupportFragmentManager().getFragment(savedInstanceState,"currentFrag")).commit();}
       //getSupportFragmentManager().getFragment(savedInstanceState.getBundle("currentFrag"),"currentFrag" );
       // Toast.makeText(getApplicationContext(),"good", Toast.LENGTH_LONG).show();
    }
}
