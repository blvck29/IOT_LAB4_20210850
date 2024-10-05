package com.app.iot_lab4.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.app.iot_lab4.model.Liga;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LigasFragment extends Fragment {

    ApiService apiService = ApiClient.getRetrofitInstance().create(ApiService.class);

    private RecyclerView categoryRecycler;
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

        categoryRecycler = view.findViewById(R.id.ligasRecyclerFragment1); // Asegúrate de tener este ID en tu layout
        ligasAdapter = new LigaAdapter(ligas);
        categoryRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        categoryRecycler.setAdapter(ligasAdapter);

        return view;
    }

    View.OnClickListener SearchButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String inputText = textInputEditText.getText().toString();

            if (inputText.isEmpty()) {

                obtenerLigasGenerales();

            } else {

                
            }
        }
    };


    private void obtenerLigasGenerales() {
        ApiService apiService = ApiClient.getRetrofitInstance().create(ApiService.class);
        Call<ResponseLigas> call = apiService.getAllLeagues();

        call.enqueue(new Callback<ResponseLigas>() {
            @Override
            public void onResponse(Call<ResponseLigas> call, Response<ResponseLigas> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ligas.clear();
                    ligas.addAll(response.body().getLeagues());
                    ligasAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getContext(), "No se pudieron obtener las ligas", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseLigas> call, Throwable t) {
                Toast.makeText(getContext(), "Error al obtener las ligas: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



}