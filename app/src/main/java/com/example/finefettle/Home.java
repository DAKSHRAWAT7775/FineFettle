package com.example.finefettle;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.finefettle.databinding.HomeBinding;

public class Home extends AppCompatActivity {
    public static class AlarmHolder {
        public static PendingIntent pendingIntent;
    }

    private HomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = HomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.home, R.id.add_alarm, R.id.chatbot, R.id.shop, R.id.maps)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main7);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle menu item selections
        switch (item.getItemId()) {
            case R.id.logout_menu:
                onLogoutButtonClick();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onLogoutButtonClick() {
        // Delete saved user credentials and return to login screen
        final SharedPreferences sf=getSharedPreferences("Data", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sf.edit();
        editor.clear();

        editor.commit();

        Intent intent = new Intent(Home.this, Login_main.class);
        startActivity(intent);
        finish();
    }
}



