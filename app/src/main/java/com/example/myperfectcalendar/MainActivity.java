package com.example.myperfectcalendar;

import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new CalFagment()).commit();
            navigationView.setCheckedItem(R.id.frag_cal);
        }


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.cal:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CalFagment()).commit();
                break;

            case R.id.digital:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DigitalFagment()).commit();
                break;

            case R.id.stw:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new STWFagment()).commit();
                break;

            case R.id.notify:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new NotifyFagment()).commit();
                break;

            case R.id.task:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TaskFagment()).commit();
                break;

            case R.id.todo:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TodoFagment()).commit();
                break;

            case R.id.game:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new GameFagment()).commit();
                break;

            case R.id.about:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AboutFagment()).commit();
                break;

            case R.id.help:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HelpFagment()).commit();
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


}