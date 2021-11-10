package com.example.mynotsjava;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentList fragmentList = new FragmentList();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragmentList)
                .commit();

    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getFragments().size() > 1) {
            getSupportFragmentManager()
                    .popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}

