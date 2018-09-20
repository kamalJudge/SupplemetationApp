package com.lotusapps.kamaljudge.supplemetationapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        final TextView tv_result = findViewById(R.id.textView5);
        final EditText et_height = findViewById(R.id.editText4);
        final EditText et_weight = findViewById(R.id.editText5);
        Button calc = findViewById(R.id.button4);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                tv_result.setText("Your BMI is "+(Integer.parseInt(et_weight.getText().toString())/Integer.parseInt(et_height.getText().toString())));

            }
        });
    }
}
