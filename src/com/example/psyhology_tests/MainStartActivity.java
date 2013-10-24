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



        // enable ActionBar app icon to behave as action to toggle nav drawer
       //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      //   getSupportActionBar().setHomeButtonEnabled(true);


        /*mDrawerLayout.setDrawerListener(mDrawerToggle);
        if (savedInstanceState == null) {
           fTrans.replace(R.id.content_frame,fragmentTestList);
        }*/
    }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    public void replace(Fragment fr) {

        tx.replace(R.id.content_frame, fr);
    }*/

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        tx = getSupportFragmentManager().beginTransaction();
        switch (item.getItemId()) {

            case R.id.item2:
                // Toast.makeText(getApplicationContext(),"item1",Toast.LENGTH_LONG).show();
                 DrawerState=mDrawerLayout.isDrawerOpen(mDrawerList);
                if(DrawerState){
                mDrawerLayout.closeDrawer(mDrawerList);
            }
                if(!DrawerState) {
                    mDrawerLayout.openDrawer(mDrawerList);
                }
                //tx.replace(R.id.content_frame, Fragment.instantiate(MainStartActivity.this, "com.example.psyhology_tests.FragmentTestList")).commit();

                //  replace(Fragment.instantiate(MainStartActivity.this, "com.example.psyhology_tests.FragmentTestList"));
                return true;
            case R.id.item1:
                //Toast.makeText(getApplicationContext(),"item2",Toast.LENGTH_LONG).show();
                if(!getResources().getBoolean(R.bool.istablet)){
                    tx.replace(R.id.content_frame, Fragment.instantiate(MainStartActivity.this, "com.example.psyhology_tests.StartFragment")).commit();
                }
              else  tx.replace(R.id.fragment2ForTablet, Fragment.instantiate(MainStartActivity.this, "com.example.psyhology_tests.StartFragment")).commit();
                // replace(Fragment.instantiate(MainStartActivity.this, "com.example.psyhology_tests.FragmentTestAction"));
                return true;
            case android.R.id.home:
                DrawerState=mDrawerLayout.isDrawerOpen(mDrawerList);
                if(DrawerState){
                    mDrawerLayout.closeDrawer(mDrawerList);
                }
                if(!DrawerState) {
                    mDrawerLayout.openDrawer(mDrawerList);
                }
                return true;
        }

        return super.onOptionsItemSelected(item);

    }*/
}
