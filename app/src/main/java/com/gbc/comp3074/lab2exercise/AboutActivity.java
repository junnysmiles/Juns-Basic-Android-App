package com.gbc.comp3074.lab2exercise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    private void goHome() {
        Intent home = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(home);
    }

    private void startSearch() {
        Intent search = new Intent(getApplicationContext(), SearchActivity.class);
        startActivity(search);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.aboutpage_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_home: goHome(); break;
            case R.id.menu_search: startSearch(); break;
            case R.id.menu_location: startMaps(); break;
            case R.id.menu_link: openLink(); break;

            default: return super.onOptionsItemSelected(item);
        }

        return true;
    }
}