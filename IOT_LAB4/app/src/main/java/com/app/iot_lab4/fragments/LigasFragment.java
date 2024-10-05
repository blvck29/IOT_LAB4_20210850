package com.app.iot_lab4.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.app.iot_lab4.AppActivity;
import com.app.iot_lab4.MainActivity;
import com.app.iot_lab4.R;
import com.app.iot_lab4.adapter.LigaAdapter;
import com.app.iot_lab4.api.ApiClient;
import com.app.iot_lab4.api.ApiService;
import com.app.iot_lab4.api.ResponseLigas;
import com.app.iot_lab4.api.ResponseLigasPorPais;
import com.app.iot_lab4.model.Liga;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LigasFragment extends Fragment {

    ApiService apiService = ApiClient.getRetrofitInstance().create(ApiService.class);

    private RecyclerView ligasRecycler;
    private LigaAdapter ligasAdapter;
    private ArrayList<Liga> ligas = new ArrayList<>();

    TextInputEditText textInputEditText;
    ImageButton searchButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ligas, container, false);

        textInputEditText = view.findViewById(R.id.input1_fragment_liga);
        searchButton = view.findViewById(R.id.button_fragment_liga);

        searchButton.setOnClickListener(SearchButtonListener);

        ligasRecycler = view.findViewById(R.id.ligasRecyclerFragment1);
        ligasAdapter = new LigaAdapter(ligas);
        ligasRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        ligasRecycler.setAdapter(ligasAdapter);

        return view;
    }

    View.OnClickListener SearchButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String inputText = textInputEditText.getText().toString();

            if (inputText.isEmpty()) {

                getLigasGenerales();

            } else {

                getLigasPorPais(inputText);

            }
        }
    };


    private void getLigasGenerales() {
        ApiClient.getRetrofitInstance().create(ApiService.class);
        Call<ResponseLigas> call = apiService.getAllLeagues();

        call.enqueue(new Callback<ResponseLigas>() {
            @Override
            public void onResponse(Call<ResponseLigas> call, Response<ResponseLigas> response) {
                if (response.isSuccessful()  && response.body() != null && response.body().getLeagues() != null) {
                    ligas.clear();
                    ligas.addAll(response.body().getLeagues());
                    ligasAdapter.notifyDataSetChanged();
                } else {
                    showAlertDialog("Error", "No se pudieron obtener las ligas");

                }
            }

            @Override
            public void onFailure(Call<ResponseLigas> call, Throwable t) {
                showAlertDialog("Error", "Error al obtener las ligas: " + t.getMessage());
            }
        });
    }

    private void getLigasPorPais(String pais) {
        ApiClient.getRetrofitInstance().create(ApiService.class);
        Call<ResponseLigasPorPais> call = apiService.getLeaguesByCountry(pais);

        call.enqueue(new Callback<ResponseLigasPorPais>() {
            @Override
            public void onResponse(Call<ResponseLigasPorPais> call, Response<ResponseLigasPorPais> response) {
                Log.d("API_RESPONSE", "Response Code: " + response.code());
                Log.d("API_RESPONSE2", "Response Code: " + response.body().getCountries());
                if (response.isSuccessful() && response.body() != null && response.body().getCountries() != null) {
                    ligas.clear();
                    ligas.addAll(response.body().getCountries());
                    ligasAdapter.notifyDataSetChanged();
                } else {
                    showAlertDialog("Error", "No se pudieron obtener las ligas para el país ingresado, intente de nuevo.");
                }
            }

            @Override
            public void onFailure(Call<ResponseLigasPorPais> call, Throwable t) {
                showAlertDialog("Error", "Error al obtener las ligas: " + t.getMessage());
            }
        });
    }

    private void showAlertDialog(String title, String message) {
        new MaterialAlertDialogBuilder(getContext())
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .show();
    }

}