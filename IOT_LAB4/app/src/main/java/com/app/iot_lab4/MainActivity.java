package com.app.iot_lab4;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    Button appButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        boolean tieneInternet = false;
        if (connectivityManager != null) {
            NetworkCapabilities capabilities =
                    connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    Log.i("msg-Internet", "NetworkCapabilities.TRANSPORT_CELLULAR");
                    tieneInternet = true;
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    Log.i("msg-Internet", "NetworkCapabilities.TRANSPORT_WIFI");
                    tieneInternet = true;
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    Log.i("msg-Internet", "NetworkCapabilities.TRANSPORT_ETHERNET");
                    tieneInternet = true;
                }
            }
        }

        if (!tieneInternet){

            MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
            builder.setMessage("Sin Internet. ¿Quieres ir a los ajustes?")
                    .setCancelable(false)
                    .setPositiveButton("Configuración", (dialog, id) -> {
                        startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
                    })
                    .setNegativeButton("Cancelar", (dialog, id) -> {
                        dialog.dismiss();
                        finish();
                    });

            AlertDialog alert = builder.create();
            alert.show();
        }

        appButton = findViewById(R.id.app_button);
        appButton.setOnClickListener(openAppListener);

    }

    View.OnClickListener openAppListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(MainActivity.this, AppActivity.class);
            startActivity(intent);
        }
    };

}