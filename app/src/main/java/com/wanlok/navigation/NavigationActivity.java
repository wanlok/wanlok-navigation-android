package com.wanlok.navigation;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NavigationActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {
    private static final String TAG = NavigationActivity.class.getName();

    private BottomNavigationView bottomNavigationView;
    private View previousView;

    private Map<Integer, ArrayList<NavigationFragment>> map;
    private int itemId;

    public NavigationActivity() {
        Bundle bundle = new Bundle();
        bundle.putString("name", "Robert Wan");

        A1Fragment a1Fragment = new A1Fragment();
        a1Fragment.setArguments(bundle);

        ArrayList<NavigationFragment> aFragments = new ArrayList<>();
        aFragments.add(a1Fragment);

        ArrayList<NavigationFragment> bFragments = new ArrayList<>();
        bFragments.add(new B1Fragment());

        ArrayList<NavigationFragment> cFragments = new ArrayList<>();
        cFragments.add(new C1Fragment());

        map = new HashMap<>();
        map.put(R.id.a, aFragments);
        map.put(R.id.b, bFragments);
        map.put(R.id.c, cFragments);

        itemId = R.id.b;
    }

    private void updateTopNavigation(boolean backButtonEnabled) {
        ArrayList<NavigationFragment> fragments = map.get(itemId);
        if (fragments.size() > 0) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(backButtonEnabled);
            setTitle(fragments.get(fragments.size() - 1).getTitle());
        }
    }

    private void updateBottomNavigation() {
        Menu menu = bottomNavigationView.getMenu();
        for (int i = 0; i < menu.size(); i++) {
            MenuItem menuItem = menu.getItem(i);
            if (menuItem.getItemId() == itemId) {
                onNavigationItemSelected(menuItem);
                menuItem.setChecked(true);
            }
        }
    }

    @Override
    public void onBackPressed() {
        ArrayList<NavigationFragment> fragments = map.get(itemId);
        fragments.remove(fragments.get(fragments.size() - 1));
        previousView = null;
        updateTopNavigation(fragments.size() > 1);
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

    private void replace(NavigationFragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment);
        fragmentTransaction.commit();
        updateTopNavigation(false);
    }

    private void add(NavigationFragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.add(R.id.fragmentContainerView, fragment);
        fragmentTransaction.commit();
        updateTopNavigation(true);
    }

    public void open(NavigationFragment fragment, View view) {
        if (view != previousView) {
            ArrayList<NavigationFragment> fragments = map.get(itemId);
            fragments.add(fragment);
            add(fragment);
        }
        previousView = view;
    }

    private void clearStack() {
        ArrayList<NavigationFragment> fragments = map.get(itemId);
        FragmentManager fragmentManager = getSupportFragmentManager();
        for (int i = 0; i < fragments.size(); i++) {
            fragmentManager.popBackStack();
        }
    }

    private void buildStack() {
        ArrayList<NavigationFragment> fragments = map.get(itemId);
        for (int i = 0; i < fragments.size(); i++) {
            if (i == 0) {
                replace(fragments.get(i));
            } else {
                add(fragments.get(i));
            }
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        int itemId = item.getItemId();
        if (fragmentManager.getFragments().size() == 0 || itemId != this.itemId) {
            this.itemId = itemId;
            clearStack();
            buildStack();
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);

        updateBottomNavigation();
    }
}