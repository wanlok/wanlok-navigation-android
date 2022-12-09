package com.wanlok.navigation;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class BaseActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {
    private static final String TAG = BaseActivity.class.getName();

    private BottomNavigationView bottomNavigationView;

    private ArrayList<Fragment> aFragments = new ArrayList<>();
    private ArrayList<Fragment> bFragments = new ArrayList<>();
    private ArrayList<Fragment> cFragments = new ArrayList<>();
    private ArrayList<Fragment> fragments = aFragments;

    @Override
    public void onBackPressed() {
        fragments.remove(fragments.get(fragments.size() - 1));
        getSupportActionBar().setDisplayHomeAsUpEnabled(fragments.size() > 1);
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

    private void replace(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment);
        fragmentTransaction.commit();
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    private void add(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.add(R.id.fragmentContainerView, fragment);
        fragmentTransaction.commit();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void open(Fragment fragment) {
        fragments.add(fragment);
        add(fragment);
    }

    private void clear() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        for (int i = 0; i < fragments.size(); i++) {
            fragmentManager.popBackStack();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        clear();
        int itemId = item.getItemId();
        if (itemId == R.id.a) {
            fragments = aFragments;
        } else if (itemId == R.id.b) {
            fragments = bFragments;
        } else if (itemId == R.id.c) {
            fragments = cFragments;
        }
        for (int i = 0; i < fragments.size(); i++) {
            if (i == 0) {
                replace(fragments.get(i));
            } else {
                add(fragments.get(i));
            }
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Navigation");

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);

        A1Fragment a1Fragment = new A1Fragment();
        B1Fragment b1Fragment = new B1Fragment();
        C1Fragment c1Fragment = new C1Fragment();

        Bundle bundle = new Bundle();
        bundle.putString("name", "Robert Wan");
        bundle.putDouble("dummy", 3.14);
        a1Fragment.setArguments(bundle);

        aFragments.add(a1Fragment);
        bFragments.add(b1Fragment);
        cFragments.add(c1Fragment);

        replace(a1Fragment);
    }
}