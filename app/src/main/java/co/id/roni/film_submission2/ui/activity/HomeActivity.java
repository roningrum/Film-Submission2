package co.id.roni.film_submission2.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import co.id.roni.film_submission2.R;
import co.id.roni.film_submission2.ui.fragment.MovieFragment;
import co.id.roni.film_submission2.ui.fragment.TVShowsFragment;

public class HomeActivity extends AppCompatActivity {
    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment fragment;

                    switch (menuItem.getItemId()) {
                        case R.id.nav_movie_menu:
                                fragment = new MovieFragment();
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName())
                                        .commit();
                            return true;
                        case R.id.nav_tvseries_menu:
                                fragment = new TVShowsFragment();
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName())
                                        .commit();
                            return true;
                    }
                    return false;
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navigationView = findViewById(R.id.navigation_menu_home);
        navigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);


        if(savedInstanceState == null){
            navigationView.setSelectedItemId(R.id.nav_movie_menu);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_change_languange) {
            Intent mIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(mIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}
