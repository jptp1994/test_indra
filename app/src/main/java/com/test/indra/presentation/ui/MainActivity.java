package com.test.indra.presentation.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.test.indra.R;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            return;
        }

        setTitle("Home");
        PhotoFragment homeFragment = new PhotoFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, homeFragment).commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
