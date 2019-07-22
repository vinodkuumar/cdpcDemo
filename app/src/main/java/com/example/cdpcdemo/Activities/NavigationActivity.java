package com.example.cdpcdemo.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cdpcdemo.Fragments.CdpcTeamFragment;
import com.example.cdpcdemo.Fragments.DriveFragment;
import com.example.cdpcdemo.Fragments.HomeFragment;
import com.example.cdpcdemo.Fragments.InternshipFormFragment;
import com.example.cdpcdemo.Fragments.PlacementStatisticsFragment;
import com.example.cdpcdemo.Fragments.ProfileFragment;
import com.example.cdpcdemo.Fragments.RateFragment;
import com.example.cdpcdemo.Fragments.SettingsFragment;
import com.example.cdpcdemo.Fragments.ShuffleFragment;
import com.example.cdpcdemo.Fragments.TrackChargesFragment;
import com.example.cdpcdemo.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FirebaseUser currentUser;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();



        //rating bar
      /*  SmileRating smileRating = findViewById(R.id.smile_rating);
        smileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(int smiley, boolean reselected) {
                switch (smiley){
                    case SmileRating.BAD:
                        Toast.makeText(getApplicationContext(),"bad",Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.GOOD:
                        Toast.makeText(getApplicationContext(),"Good",Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.GREAT:
                        Toast.makeText(getApplicationContext(),"GREAT",Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.OKAY:
                        Toast.makeText(getApplicationContext(),"OKAY",Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.TERRIBLE:
                        Toast.makeText(getApplicationContext(),"Terrible",Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });*/



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        updateNavHeader();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
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
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            getSupportActionBar().setTitle("Home");
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();
            // Handle the camera action
        } else if (id == R.id.nav_profile) {
            getSupportActionBar().setTitle("Profile");
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new ProfileFragment()).commit();
        } else if (id == R.id.nav_settings) {
            getSupportActionBar().setTitle("Settings");
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new SettingsFragment()).commit();

        }

        else if(id == R.id.nav_drives){
            getSupportActionBar().setTitle("Drives");
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new DriveFragment()).commit();
        }
        else if(id == R.id.nav_placementStatistics){
            getSupportActionBar().setTitle("Placement Statistics");
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new PlacementStatisticsFragment()).commit();
        }
        else if(id == R.id.nav_trackcharges){
            getSupportActionBar().setTitle("Track Charges");
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new TrackChargesFragment()).commit();
        }
        else if(id == R.id.nav_shuffle){
            getSupportActionBar().setTitle("Shuffle");
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new ShuffleFragment()).commit();
        }
        else if(id == R.id.nav_internshipforms){
            getSupportActionBar().setTitle("Internship Forms");
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new InternshipFormFragment()).commit();
        }
        else if(id == R.id.nav_cdpcteam){
            getSupportActionBar().setTitle("CDPC Team");
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new CdpcTeamFragment()).commit();
        }
        else if(id == R.id.nav_rate){
            getSupportActionBar().setTitle("Rate");
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new RateFragment()).commit();
        }
        else if(id == R.id.nav_signout){
            FirebaseAuth.getInstance().signOut();
            Intent loginActivity = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(loginActivity);
            finish();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void updateNavHeader(){

        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = (View) navigationView.getHeaderView(0);
        TextView navUserName = headerView.findViewById(R.id.nav_user_name);
        TextView navUserMail = headerView.findViewById(R.id.nav_user_mail);
        ImageView navUserPhoto = headerView.findViewById(R.id.nav_user_photo);


        navUserMail.setText(currentUser.getEmail());
        navUserName.setText(currentUser.getDisplayName());
        //loading photo using glide

        Glide.with(this).load(currentUser.getPhotoUrl()).into(navUserPhoto);



    }

}
