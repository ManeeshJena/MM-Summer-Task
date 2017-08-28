package com.example.android.mondaymorning;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import static com.example.android.mondaymorning.R.id.viewpager;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{

    //This is our tablayout
    private TabLayout tabLayout;

    //This is our viewPager
    private ViewPager viewPager;


    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);

        //Initializing viewPager
        viewPager = (ViewPager) findViewById(viewpager);



        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("This Week"));
        tabLayout.addTab(tabLayout.newTab().setText("Sections"));
        tabLayout.setTabGravity(tabLayout.GRAVITY_FILL);


        //Creating our pager adapter
        pager adapter = new pager(getSupportFragmentManager(), tabLayout.getTabCount());
        //Adding adapter to pager
        viewPager.setAdapter(adapter);
       viewPager.setOffscreenPageLimit(2);


        //Adding onTabSelectedListener to swipe views
        tabLayout.addOnTabSelectedListener(this);




        //Initializing NavigationView
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                int id = menuItem.getItemId();


                if (id == R.id.favourites) {
                    Intent i = new Intent(getApplicationContext(), favourites.class);
                            startActivity(i);
                    return true;
                } else if (id == R.id.offline_articles) {
                    Intent i = new Intent(getApplicationContext(), offline_articles.class);
                    startActivity(i);
                    return true;
                } else if (id == R.id.settings) {
                    Intent i = new Intent(getApplicationContext(), settings.class);
                    startActivity(i);
                    return true;

                } else if (id == R.id.upcoming_events) {
                    Intent i = new Intent(getApplicationContext(), upcoming_events.class);
                    startActivity(i);
                    return true;
                } else if (id == R.id.ask_a_question) {
                    Intent i = new Intent(getApplicationContext(), ask_a_question.class);
                    startActivity(i);
                    return true;
                } else if (id == R.id.share_us_anything) {
                    Intent i = new Intent(getApplicationContext(), share_us_anything.class);
                    startActivity(i);
                    return true;
                } else if (id == R.id.contact_us) {
                    Intent i = new Intent(getApplicationContext(), contact_us.class);
                    startActivity(i);
                    return true;
                }else if (id == R.id.log_in) {
                    Intent i = new Intent(getApplicationContext(), log_in.class);
                    startActivity(i);
                    return true;
                }
                return true;
            }
        });

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close){

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();


    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


}
