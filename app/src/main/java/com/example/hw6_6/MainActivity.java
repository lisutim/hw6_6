package com.example.hw6_6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private EditText etProgramming, etDatasturcture, etAlgorithm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        etProgramming = findViewById(R.id.editText2);
        etDatasturcture = findViewById(R.id.editText);
        etAlgorithm = findViewById(R.id.editText3);
    }

    private boolean isValid(EditText editText) {
        String pattern = "1[0]{2}|[0-9]{1,2}";
        String text = editText.getText().toString();
        if (!text.matches(pattern)) {
            editText.setError("0~100");
            return false;
        } else {
            return true;
        }
    }


    public void onsubmitclick(View view) {
        boolean isValid =
                isValid(etProgramming) & isValid(etDatasturcture) & isValid(etAlgorithm);
        if (!isValid) {
            return;
        }
        int prog = Integer.parseInt(etProgramming.getText().toString());
        int data = Integer.parseInt(etDatasturcture.getText().toString());
        int alg = Integer.parseInt(etAlgorithm.getText().toString());
        Intent intent = new Intent(this, result.class);
        Bundle bundle = new Bundle();
        bundle.putInt("programming", prog);
        bundle.putInt("datastructure", data);
        bundle.putInt("algorithm", alg);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}