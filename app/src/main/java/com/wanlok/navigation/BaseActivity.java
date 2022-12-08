package com.wanlok.navigation;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {
    private static final String TAG = BaseActivity.class.getName();
    private BottomNavigationView bottomNavigationView;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void open(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.add(R.id.fragmentContainerView, fragment).commit();
    }

    public void dummy() {
        Bundle bundle = new Bundle();
        bundle.putString("name", "Robert Wan");
        bundle.putDouble("dummy", 3.14);
        Fragment fragment = new A1Fragment();
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainerView, fragment).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.a) {
            Bundle bundle = new Bundle();
            bundle.putString("name", "Robert Wan");
            bundle.putDouble("dummy", 3.14);
            Fragment fragment = new A1Fragment();
            fragment.setArguments(bundle);
            open(fragment);
        } else if (item.getItemId() == R.id.b) {
            Fragment fragment = new B1Fragment();
            open(fragment);
        } else if (item.getItemId() == R.id.c) {
            Fragment fragment = new C1Fragment();
            open(fragment);
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);
        dummy();
    }
}