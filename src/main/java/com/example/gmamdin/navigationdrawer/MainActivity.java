package com.example.gmamdin.navigationdrawer;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout=(DrawerLayout)findViewById(R.id.nav_drawer);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        int id=menuItem.getItemId();

                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        drawerLayout.closeDrawers();
                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here
                        if(id==R.id.homes){
                            Home home=new Home();
                            FragmentManager fragmentManager=getSupportFragmentManager();
                            FragmentTransaction ft=fragmentManager.beginTransaction();
                            ft.replace(R.id.frame_layout,home);
                            ft.commit();
                        }
                        else if(id==R.id.settings){
                            Settings settings=new Settings();
                            FragmentManager fragmentManager=getSupportFragmentManager();
                            FragmentTransaction ft=fragmentManager.beginTransaction();
                            ft.replace(R.id.frame_layout,settings);
                            ft.commit();
                        }
                        else{
                            Logout logout=new Logout();
                            FragmentManager fragmentManager=getSupportFragmentManager();
                            FragmentTransaction ft=fragmentManager.beginTransaction();
                            ft.replace(R.id.frame_layout,logout);
                            ft.commit();

                        }

                        return true;
                    }
                });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
