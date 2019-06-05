package com.example.hw6_6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.view.View;

import java.text.NumberFormat;

public class result  extends AppCompatActivity {
    private TextView tvResult;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        tvResult = (TextView) findViewById(R.id.textView3);
        showResults();
    }
    private void showResults(){
        NumberFormat nf = NumberFormat.getInstance();
        Bundle bundle = getIntent().getExtras();
        int pro = bundle.getInt("programming");
        int data = bundle.getInt("datastructure");
        int alg = bundle.getInt("algorithm");
        int sum = pro+data+alg;
        double ave = sum/3.0;
        String text = "programming="+pro+
                "\ndataStructure = "+data+
                "\nalgorithm = "+alg+
                "\nsum = "+sum+
                "\naverage = " + nf.format(ave);
        tvResult.setText(text);
    }
    public void onBackclick(View view){finish();}
}
