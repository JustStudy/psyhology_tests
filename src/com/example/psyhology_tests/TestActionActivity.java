package com.example.psyhology_tests;

import android.os.Bundle;

/**
 * Created with IntelliJ IDEA.
 * User: Ruslik
 * Date: 24.10.13
 * Time: 13:49
 * To change this template use File | Settings | File Templates.
 */
public class TestActionActivity extends MainRelativeActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tx = getSupportFragmentManager().beginTransaction();
       FragmentTestAction k = new FragmentTestAction();
        if(!getResources().getBoolean(R.bool.istablet)){


            tx.replace(R.id.content_frame, k);

        }

        tx.commit();
    }


}
