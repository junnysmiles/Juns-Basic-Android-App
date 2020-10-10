package com.gbc.comp3074.lab2exercise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button map_button = findViewById(R.id.mapbutton);
        map_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMaps();
            }
        });

        Button about_button = findViewById(R.id.aboutbutton);
        about_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity();
            }
        });

        Button link_button = findViewById(R.id.gbcbutton);
        link_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLink();
            }
        });

        Button search_button = findViewById(R.id.searchbutton);
        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSearch();
            }
        });
    }

    private void startSearch() {
        Intent search = new Intent(getApplicationContext(), SearchActivity.class);
        startActivity(search);
    }

    private void startActivity() {
        Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(intent);
    }

    private void startMaps() {
        Uri location = Uri.parse("geo: 49.382259, -121.442209");
        Intent map = new Intent(Intent.ACTION_VIEW, location);
        startActivity(map);
    }

    private void openLink() {
        Uri link_location = Uri.parse("http://georgebrown.ca");
        Intent link = new Intent(Intent.ACTION_VIEW, link_location);
        startActivity(link);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_search: startSearch(); break;
            case R.id.menu_about: startActivity(); break;
            case R.id.menu_location: startMaps(); break;
            case R.id.menu_link: openLink(); break;

            default: return super.onOptionsItemSelected(item);
        }

        return true;
    }
}