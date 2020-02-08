package com.mukesh.navigationwithjava;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        setupBottomNavigationBar();
        setupSideNavigationBar();
        setupActionBar();

    }

    private void setupActionBar() {
         //we can add custom toolbar in main activity
        //To handle Title for fragments
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout);
    }

    private void setupBottomNavigationBar() {

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        if (bottomNavigationView != null) {
            NavigationUI.setupWithNavController(bottomNavigationView, navController);
        }

    }
    private void setupSideNavigationBar() {
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        if (drawerLayout != null && navigationView != null) {
            NavigationUI.setupWithNavController(navigationView, navController);
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        //To support back button click
        return NavigationUI.navigateUp(navController, drawerLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        boolean navigated = NavigationUI.onNavDestinationSelected(item, navController);
        //If item is selected, Simply return selected item else return super
        return navigated || super.onOptionsItemSelected(item);
    }
}
