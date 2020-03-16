package com.example.assignment9;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("*/*");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hey Study Partner");
                if(emailIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(emailIntent);
                }
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
public boolean onOptionsItemsSelected(MenuItem item){
        int id= item.getItemId();
        if(id == R.id.action_settings){
            Intent settingsIntent = new Intent(this, SettingsActivity.class);
            startActivity(settingsIntent);
            return true;
        }
    if(id == R.id.action_add){
        Snackbar.make(getWindow().getDecorView(),, "Add implemented", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        return true;
    }
    if(id == R.id.action_delete){
        Snackbar.make(getWindow().getDecorView(),, "Delete implemented", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        return true;
    } if(id == R.id.action_sms){
        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setData(Uri.parse("sms:2183911863"));
        sendIntent.putExtra("sms_body", "Content of the SMS goes here...");
        startActivity(sendIntent);
        return true;
    }
    if(id == R.id.action_email){
       Intent emailIntent = new Intent(Intent.ACTION_SEND);
       emailIntent.setType("*/*");
       emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hey Study Partner");
       if(emailIntent.resolveActivity(getPackageManager()) != null){
           startActivity(emailIntent);
       }
        return true;
    }

        return super.onOptionsItemSelected(item);
}
public boolean onNavigationItemsSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.nav_camera){

        }else if(id == R.id.nav_gallery){

        }
}
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
