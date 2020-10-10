package com.gbc.comp3074.lab2exercise;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class SearchActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        findViewById(R.id.searchbutton).setOnClickListener(new HandleClick());
    }

    private class HandleClick implements View.OnClickListener {
        public void onClick(View arg0) {
            // String search = ((EditText) findViewById(R.id.searchtext)).getText().toString();

            TextView search = (TextView) findViewById(R.id.editSearchText);
            String searchIt = search.getText().toString();

            Intent viewSearch = new Intent(Intent.ACTION_WEB_SEARCH);
            viewSearch.putExtra(SearchManager.QUERY, searchIt);
            startActivity(viewSearch);
        }
    }

    private void goHome() {
        Intent home = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(home);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.searchpage_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_home: goHome(); break;
            case R.id.menu_about: startActivity(); break;
            case R.id.menu_location: startMaps(); break;
            case R.id.menu_link: openLink(); break;

            default: return super.onOptionsItemSelected(item);
        }

        return true;
    }
}
