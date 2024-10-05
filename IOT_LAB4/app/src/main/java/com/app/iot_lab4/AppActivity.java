package com.app.iot_lab4;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.app.iot_lab4.fragments.LigasFragment;
import com.app.iot_lab4.fragments.PosicionesFragment;
import com.app.iot_lab4.fragments.ResultadosFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AppActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    private final Fragment ligasFragment = new LigasFragment();
    private final Fragment posicionesFragment = new PosicionesFragment();
    private final Fragment resultadosFragment = new ResultadosFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_app);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bottomNavigationView = findViewById(R.id.bottomNavigationApp);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerApp, ligasFragment)
                    .commit();
        }

        bottomNavigationView.setOnItemSelectedListener(this::onNavigationItemSelected);

    }

    private boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;

        if (item.getItemId() == R.id.optionMenuLigas){
            selectedFragment = ligasFragment;

            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerApp, selectedFragment).commit();
            return true;
        }

        if (item.getItemId() == R.id.optionMenuPosiciones){
            selectedFragment = posicionesFragment;

            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerApp, selectedFragment).commit();
            return true;
        }

        if (item.getItemId() == R.id.optionMenuResultados){
            selectedFragment = resultadosFragment;

            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerApp, selectedFragment).commit();
            return true;
        }

        return false;
    }

}