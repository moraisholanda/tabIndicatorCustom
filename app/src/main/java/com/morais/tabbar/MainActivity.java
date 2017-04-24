package com.morais.tabbar;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            SlidingTabCustomColorIndicator fragment = new SlidingTabCustomColorIndicator();
            transaction.replace(R.id.sample_content_fragment, fragment);
            transaction.commit();
        }
    }
}
