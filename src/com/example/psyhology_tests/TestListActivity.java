package com.example.psyhology_tests;

import android.os.Bundle;

/**
 * Created with IntelliJ IDEA.
 * User: Ruslik
 * Date: 24.10.13
 * Time: 13:23
 * To change this template use File | Settings | File Templates.
 */
public class TestListActivity extends MainRelativeActivity{
    //Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // intent = new Intent(TestListActivity.this,TestActionActivity.class);
        FragmentTestList fragmentTestList1 = new FragmentTestList();
        tx= getSupportFragmentManager().beginTransaction();
        if(!getResources().getBoolean(R.bool.istablet)){


            tx.replace(R.id.content_frame, fragmentTestList1);

        }
       /* if(getResources().getBoolean(R.bool.istablet)){
            tx.replace(R.id.fragment2ForTablet, fragmentTestList1);
        }*/
      //  tx.addToBackStack(null);
        tx.commit();
    }
}
