package com.example.psyhology_tests;

import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Ruslik
 * Date: 02.10.13
 * Time: 19:22
 * To change this template use File | Settings | File Templates.
 */
public class BigEyes extends MainTest {
    BigEyes() {
        super();
        ID_question = R.array.test1_questions_array;
        ID_var_a = R.array.test1_variant_a;
        ID_var_b = R.array.test1_variant_b;
        ID_var_c = R.array.test1_variant_c;

    }

    void calculate(RadioGroup radiogroup, int i) {
        switch (radiogroup.getCheckedRadioButtonId()) {
            case R.id.variantA:
                rezultMasiv[i] = 10;
                break;
            case R.id.variantB:
                rezultMasiv[i] = 5;
                break;
            case R.id.variantC:
                rezultMasiv[i] = 3;
                break;
        }


    }

    ;

    void result(TextView TVresult, int result) {
        if (result > 60)
            TVresult.setText(R.string.test1_good);
        else if (result < 35)
            TVresult.setText(R.string.test1_so_so);
        else {
            TVresult.setText(R.string.test1_normal);
        }
    }
}
