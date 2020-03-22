package com.example.phc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.example.phc.models.Recipe;
import com.example.phc.services.HttpRequest;
import com.example.phc.utilities.AccountManagement;

import java.io.IOException;


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

//Example code to toast recipe title from id
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Recipe recipe = HttpRequest.getRecipeInformation("1034053");
//                    final String title = recipe.getTitle();
//
//                    new Handler(Looper.getMainLooper()).post(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(context, title, Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        thread.start();
