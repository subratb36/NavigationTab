package com.example.navigationtab;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.navigationtab.Utils.IFragmentCommunicator;
import com.example.navigationtab.drawerFragment.AboutUs;
import com.example.navigationtab.drawerFragment.HomeFragment;
import com.example.navigationtab.Utils.ColorUtil;
import com.example.navigationtab.drawerFragment.MileStoneFragment;

/**
 * Created by subratkumar on 21-05-2017.
 */
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,IFragmentCommunicator {
    private static final String TAG=MainActivity.class.getSimpleName();
    private Fragment fragment=null;
    private FragmentManager fragmentManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        int color = Color.parseColor("#F2"+ ColorUtil.APP_COLOR);


        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(
                getResources().getColor(R.color.toolbar_color)));
        toolbar.setTitleTextColor(0xFFFFFFFF);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        fragmentManager =getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction
                =fragmentManager.beginTransaction();
        fragment = new HomeFragment();
        fragmentTransaction.replace(R.id.content_frame, fragment);
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("Home");


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Home) {
            fragment=new HomeFragment();
            getSupportActionBar().setTitle("Home");
        } else if (id == R.id.nav_AboutUs) {
            fragment=new AboutUs();
            getSupportActionBar().setTitle(" About Us");
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content_frame, fragment);
        transaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        assert drawer!=null;
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void homeScreen() {
        fragment=new HomeFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content_frame, fragment);
        transaction.commit();
        getSupportActionBar().setTitle("Home");
    }
}
