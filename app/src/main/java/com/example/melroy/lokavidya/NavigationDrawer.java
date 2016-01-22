package com.example.melroy.lokavidya;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.melroy.lokavidya.fragments.CreatingFragment;
import com.example.melroy.lokavidya.fragments.DashboardFragment;
import com.example.melroy.lokavidya.fragments.HelpFeedbackFragment;
import com.example.melroy.lokavidya.fragments.SettingsFragment;
import com.example.melroy.lokavidya.fragments.ViewingFragment;

/**
 This class handles the complete set of functionality related to the Navigation Drawer.
 **/

public class NavigationDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //Handle all the variable declarations here
    FragmentManager fragmentManager;
    Boolean backPress;
    NavigationView navigationView;
    FloatingActionButton fab;
    Toolbar toolbar;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, new DashboardFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        backPress = false;
        int id = item.getItemId();

        if (id == R.id.nav_dashboard) {
            //This will toggle the dashboard fragment
            fab.setVisibility(View.GONE);
            navigationView.getMenu().getItem(0).setChecked(true);
            fragmentManager.beginTransaction().replace(R.id.content_frame, new DashboardFragment()).commit();
        } else if (id == R.id.nav_viewing) {
            //Handle the viewing mechanism
            fab.setVisibility(View.GONE);
            navigationView.getMenu().getItem(1).setChecked(true);
            fragmentManager.beginTransaction().replace(R.id.content_frame, new ViewingFragment()).commit();
        } else if (id == R.id.nav_creating) {
            //Handle the creation mechanism
            fab.setVisibility(View.GONE);
            navigationView.getMenu().getItem(2).setChecked(true);
            fragmentManager.beginTransaction().replace(R.id.content_frame, new CreatingFragment()).commit();
        } else if (id == R.id.nav_settings) {
            //Handle the settings mechanism
            fab.setVisibility(View.GONE);
            navigationView.getMenu().getItem(3).setChecked(true);
            fragmentManager.beginTransaction().replace(R.id.content_frame, new SettingsFragment()).commit();
        } else if (id == R.id.nav_help_feedback) {
            //Handle the help & feedback mechanism
            fab.setVisibility(View.GONE);
            navigationView.getMenu().getItem(2).setChecked(true);
            fragmentManager.beginTransaction().replace(R.id.content_frame, new HelpFeedbackFragment()).commit();
        } else if (id == R.id.nav_logout){
            //Handle the logout mechanism
        }

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
