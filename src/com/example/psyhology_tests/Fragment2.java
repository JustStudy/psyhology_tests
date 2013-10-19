package com.example.psyhology_tests;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;

/**
 * Created with IntelliJ IDEA.
 * User: Ruslik
 * Date: 18.10.13
 * Time: 20:40
 * To change this template use File | Settings | File Templates.
 */
public class Fragment2 extends Fragment {
    MainTest test;
    int id;
    Button NextPage;
    Button PrevPage;
    TextView TVQuestion;
    RadioGroup maingroup;
    TextView TVNumber;
    RadioButton A;
    RadioButton B;
    RadioButton C;
    Animation simpleAnim;
    int i = 0;

    void initTest(MainTest test1) {
        id = getActivity().getIntent().getIntExtra("ID", id);

        switch (id) {
            case 2:
                test1 = new Test2();
                break;
            case 1:
                test1 = new BigEyes();
                break;
        }

    }

    void showInViewQuestion(MainTest test) {
        int k = i + 1;
        simpleAnim = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.blink);
        TVNumber.setText(k + " вопрос c " + test.someQuestion.length);
        TVNumber.startAnimation(simpleAnim);
        simpleAnim = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.from_left);
        TVQuestion.setText(test.someQuestion[i]);
        TVQuestion.startAnimation(simpleAnim);
        simpleAnim = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.zoom_out);
        A.setText(test.variantA[i]);
        A.startAnimation(simpleAnim);
        B.setText(test.variantB[i]);
        B.startAnimation(simpleAnim);
        C.setText(test.variantC[i]);
        C.startAnimation(simpleAnim);
    }

    void initResources(MainTest test) {

        test.someQuestion = getResources().getStringArray(test.ID_question);
        test.rezultMasiv = new int[test.someQuestion.length];
        test.variantA = getResources().getStringArray(test.ID_var_a);
        test.variantB = getResources().getStringArray(test.ID_var_b);
        test.variantC = getResources().getStringArray(test.ID_var_c);
    }

    public void onBackPressed() {
// do something on back.
        Toast.makeText(getActivity().getApplicationContext(), "Back pressed", Toast.LENGTH_SHORT).show();
        return;
    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.questionlayout, null);
        switch (getActivity().getIntent().getIntExtra("ID", id)) {
            case 2:
                test = new Test2();
                break;
            case 1:
                test = new BigEyes();
                break;
        }
        // initTest(test);
        //test=new BigEyes();
        initResources(test);

        //init components
        PrevPage = (Button) v.findViewById(R.id.buttonPref);
        TVNumber = (TextView) v.findViewById(R.id.questionNumber);
        NextPage = (Button) v.findViewById(R.id.buttonNextQuestion);
        TVQuestion = (TextView) v.findViewById(R.id.questionName);
        maingroup = (RadioGroup) v.findViewById(R.id.radiogroup);
        A = (RadioButton) v.findViewById(R.id.variantA);
        B = (RadioButton) v.findViewById(R.id.variantB);
        C = (RadioButton) v.findViewById(R.id.variantC);

        showInViewQuestion(test);

        PrevPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i >= 1) {
                    i--;
                    showInViewQuestion(test);
                }
            }
        });


        NextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                test.calculate(maingroup, i);
                i++;
                if (i < test.someQuestion.length) {
                    showInViewQuestion(test);
                } else {
                    for (int h = 0; h < test.rezultMasiv.length; h++) {
                        test.total_result += test.rezultMasiv[h];
                    }

                    getActivity().getIntent().putExtra("result", test.total_result);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, Fragment.instantiate(getActivity(), "com.example.psyhology_tests.FragmentResultTest")).commit();


                }

            }
        });
        return v;
    }
}
