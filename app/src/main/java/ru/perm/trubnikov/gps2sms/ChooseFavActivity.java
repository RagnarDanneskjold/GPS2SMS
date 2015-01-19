package ru.perm.trubnikov.gps2sms;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

public class ChooseFavActivity extends ActionBarActivity {

    @Override
    protected void onResume() {
        super.onResume();
    }

    // ------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Определение темы должно быть ДО super.onCreate и setContentView
        SharedPreferences sharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(this);

        setTheme(sharedPrefs.getString("prefAppTheme", "1").equalsIgnoreCase(
                "1") ? R.style.AppTheme_Dark : R.style.AppTheme_Light);

        setTitle(R.string.choose_fav_app);
        super.onCreate(savedInstanceState);

        ShowBackButton();

        // ListView on Fragments
        ChooseFavListFragment fragment = new ChooseFavListFragment();
        getSupportFragmentManager().beginTransaction().replace(android.R.id.content, fragment).commit();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void ShowBackButton() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


}
