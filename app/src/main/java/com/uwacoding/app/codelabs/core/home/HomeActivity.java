package com.uwacoding.app.codelabs.core.home;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.ahmadrosid.lib.baseapp.core.BaseActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.uwacoding.app.codelabs.R;
import com.uwacoding.app.codelabs.core.iklan_saya.IklanSayaFragment;
import com.uwacoding.app.codelabs.core.profile.ProfileFragment;
import com.uwacoding.app.codelabs.core.welcome.login.LoginActivity;

/**
 * Created by Firman on 3/29/2017.
 */

public class HomeActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected int getResourceLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setActiveFragment(new HomeFragment(), R.id.container);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public  boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            FirebaseAuth.getInstance().signOut();
            open(LoginActivity.class);
            finish();
        } else if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_home:
                setActiveFragment(new HomeFragment(), R.id.container);
                break;
            case R.id.nav_profile:
                setActiveFragment(new ProfileFragment(), R.id.container);
                break;
            case R.id.nav_iklan_saya:
                setActiveFragment(new IklanSayaFragment(), R.id.container);
                break;
            case R.id.nav_info:
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                alert("By FirmanMFK");
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;


    }
}
