package com.example.phc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.phc.Fragments.UserRecipesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private static Context context;
    private FragmentManager fragmentManager;
    public BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        fragmentManager = getSupportFragmentManager();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getTitle().toString()) {
            case "Home":
//                Toast.makeText(this, "1: " + item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                //TODO remove any already existing fragment first
                fragmentManager.beginTransaction().add(R.id.fragmentContainerView, new UserRecipesFragment()).commit();
                break;
            case "Discover":
                Toast.makeText(this, "2: " + item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case "My Account":
                Toast.makeText(this, "3: " + item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            default:
                return false;
        }
        return true;
    }
}
