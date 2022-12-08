package com.wanlok.navigation;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BaseActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {
    private static final String TAG = BaseActivity.class.getName();
    private BottomNavigationView bottomNavigationView;
    private Map<Integer, ArrayList<Fragment>> navigationMap;

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

    public void open(Fragment fragment, int itemId) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        ArrayList<Fragment> fragments = navigationMap.get(itemId);
        if (navigationMap.get(itemId) == null) {
            fragments = new ArrayList();
            navigationMap.put(itemId, fragments);
        }
        if (fragments.size() > 0) {
            fragmentTransaction.addToBackStack(null);
        }
        fragments.add(fragment);
        fragmentTransaction.add(R.id.fragmentContainerView, fragment).commit();
    }

    public Fragment getFirstFragment() {
        Fragment fragment = new A1Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", "Robert Wan");
        bundle.putDouble("dummy", 3.14);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        int itemId = item.getItemId();
        if (itemId == R.id.a) {
            getFirstFragment();
        } else if (itemId == R.id.b) {
            fragment = new B1Fragment();
        } else if (itemId == R.id.c) {
            fragment = new C1Fragment();
        }
        if (fragment != null) {
            open(fragment, itemId);
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Navigation");
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);
        navigationMap = new HashMap<>();
        open(getFirstFragment(), R.id.a);
    }
}