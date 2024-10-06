package com.app.iot_lab4.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.app.iot_lab4.R;
import com.app.iot_lab4.adapter.ResultadoAdapter;
import com.app.iot_lab4.api.ApiService;
import com.app.iot_lab4.api.ApiClient;
import com.app.iot_lab4.api.ResponseResultados;
import com.app.iot_lab4.model.Resultado;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultadosFragment extends Fragment {

    private ApiService apiService;
    private RecyclerView resultadosRecycler;
    private ResultadoAdapter resultadoAdapter;
    private ArrayList<Resultado> resultados = new ArrayList<>();

    private TextInputEditText textInputIdLiga;
    private TextInputEditText textInputTemporada;
    private TextInputEditText textInputRonda;
    private ImageButton searchButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiService = ApiClient.getRetrofitInstance().create(ApiService.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resultados, container, false);

        textInputIdLiga = view.findViewById(R.id.input1_fragment_resultados);
        textInputTemporada = view.findViewById(R.id.input2_fragment_resultados);
        textInputRonda = view.findViewById(R.id.input3_fragment_resultados);
        searchButton = view.findViewById(R.id.button_fragment_resultados);

        resultadosRecycler = view.findViewById(R.id.resultadosRecyclerFragment3);
        resultadoAdapter = new ResultadoAdapter(resultados);
        resultadosRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        resultadosRecycler.setAdapter(resultadoAdapter);

        searchButton.setOnClickListener(searchButtonListener);

        return view;
    }

    View.OnClickListener searchButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String inputTextIdLiga = textInputIdLiga.getText().toString();
            String inputTextTemporada = textInputTemporada.getText().toString();
            String inputTextRonda = textInputRonda.getText().toString();

            if (!inputTextIdLiga.isEmpty() && !inputTextTemporada.isEmpty()) {
                getResultadosByLigaTemporadaRonda(inputTextIdLiga, inputTextTemporada, inputTextRonda);
            } else {
                showAlertDialog("Error", "Por favor ingrese ID de liga y temporada");
            }
        }
    };

    private void getResultadosByLigaTemporadaRonda(String idLiga, String temporada, String ronda) {
        Call<ResponseResultados> call = apiService.getResultadosByLigaTemporadaRonda(idLiga, ronda, temporada);
        call.enqueue(new Callback<ResponseResultados>() {
            @Override
            public void onResponse(Call<ResponseResultados> call, Response<ResponseResultados> response) {
                if (response.isSuccessful() && response.body() != null && response.body().getEvents() != null) {
                    resultados.clear();
                    resultados.addAll(response.body().getEvents());
                    resultadoAdapter.notifyDataSetChanged();
                } else {
                    showAlertDialog("Error", "No se encontraron resultados para la liga, temporada y ronda introducidas.");
                }
            }

            @Override
            public void onFailure(Call<ResponseResultados> call, Throwable t) {
                showAlertDialog("Error", "Error al obtener los resultados, el ID introducido, la temporada o la ronda son inválidos.");
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

