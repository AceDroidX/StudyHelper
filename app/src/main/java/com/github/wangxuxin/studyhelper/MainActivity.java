package com.github.wangxuxin.studyhelper;

import android.app.Fragment;
import android.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.github.wangxuxin.studyhelper.english.EnglishFragment;
import com.github.wangxuxin.studyhelper.help.AboutFragment;
import com.github.wangxuxin.studyhelper.help.HelpFragment;
import com.github.wangxuxin.studyhelper.math.MathFragment;

/**
 * By wxx
 */

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, BaseFragment.OnFragmentInteractionListener {
    DrawerLayout drawer;
    NavigationView navigationView;
    Bundle fbundle = new Bundle();
    FragmentManager fm;
    Fragment mfragment;//当前fragment
    BaseFragment[] fragments = new BaseFragment[10];

    /*private void initFragment(){
        getFragmentManager().putFragment();
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawer = findViewById(R.id.drawer_layout);
        drawer.openDrawer(GravityCompat.START);

        if (savedInstanceState == null) {
            initFragments();
            fm.beginTransaction().add(R.id.content_frame, fragments[0], "main").commit();
            mfragment = fragments[0];
        } else {
            mfragment = savedInstanceState.getParcelable("mfragment");
            fragments = (BaseFragment[]) savedInstanceState.getParcelableArray("fragments");
            //initFragments();
            //findFragments();
        }


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("isinit", true);
        outState.putParcelable("mfragment", (Parcelable) mfragment);
        outState.putParcelableArray("fragments", fragments);
    }

    @Override
    public void onBackPressed() {
        drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
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
        int id = item.getItemId();
        drawer.closeDrawer(GravityCompat.START);
        getSupportActionBar().setTitle(item.getTitle());
        navigationView.setCheckedItem(id);
        fm = getFragmentManager();
        if (id == R.id.nav_main) {
            mfragment = MainFragment.switchContent(fm, mfragment, fragments[0]);
        } else if (id == R.id.nav_math) {
            mfragment = MathFragment.switchContent(fm, mfragment, fragments[1]);
        } else if (id == R.id.nav_english) {
            mfragment = EnglishFragment.switchContent(fm, mfragment, fragments[2]);
        } else if (id == R.id.nav_help) {
            mfragment = HelpFragment.switchContent(fm, mfragment, fragments[3]);
        } else if (id == R.id.nav_about) {
            mfragment = AboutFragment.switchContent(fm, mfragment, fragments[4]);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initFragments() {
        fm = getFragmentManager();
        fragments[0] = MainFragment.newInstance();
        fragments[1] = MathFragment.newInstance();
        fragments[2] = EnglishFragment.newInstance();
        fragments[3] = HelpFragment.newInstance();
        fragments[4] = AboutFragment.newInstance();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    /*private void findFragments(){
        fm = getFragmentManager();
        fragments[0] = (BaseFragment) fm.findFragmentByTag(MainFragment.class.getName());
        fragments[1] = (BaseFragment) fm.findFragmentByTag(MathFragment.class.getName());
        fragments[2] = (BaseFragment) fm.findFragmentByTag(AboutFragment.class.getName());
    }*/
}
