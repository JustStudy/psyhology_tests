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
