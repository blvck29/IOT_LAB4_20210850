package com.app.iot_lab4.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;
import com.app.iot_lab4.R;
import com.app.iot_lab4.adapter.PosicionAdapter;
import com.app.iot_lab4.api.ApiClient;
import com.app.iot_lab4.api.ApiService;
import com.app.iot_lab4.api.ResponsePosicionEquipos;
import com.app.iot_lab4.model.PosicionEquipo;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PosicionesFragment extends Fragment {

    private ApiService apiService;
    private RecyclerView posicionesRecycler;
    private PosicionAdapter posicionAdapter;
    private ArrayList<PosicionEquipo> posicionEquipos = new ArrayList<>();

    private TextInputEditText textInputIdLiga;
    private TextInputEditText textInputTemporada;
    private ImageButton searchButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiService = ApiClient.getRetrofitInstance().create(ApiService.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_posiciones, container, false);

        textInputIdLiga = view.findViewById(R.id.input1_fragment_posiciones);
        textInputTemporada = view.findViewById(R.id.input2_fragment_posiciones);
        searchButton = view.findViewById(R.id.button_fragment_posiciones);

        posicionesRecycler = view.findViewById(R.id.posicionesRecyclerFragment2);
        posicionAdapter = new PosicionAdapter(posicionEquipos);
        posicionesRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        posicionesRecycler.setAdapter(posicionAdapter);

        searchButton.setOnClickListener(SearchButtonListener);

        return view;
    }

    View.OnClickListener SearchButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String inputTextIdLiga = textInputIdLiga.getText().toString();
            String inputTextTemporada = textInputTemporada.getText().toString();

            if (!inputTextIdLiga.isEmpty() && !inputTextTemporada.isEmpty()) {
                getPosicionesByLiga(inputTextIdLiga, inputTextTemporada);

            } else {
                showAlertDialog("Error", "Por favor ingrese ID de liga y temporada");
            }
        }
    };



    private void getPosicionesByLiga(String idLiga, String temporada) {
        Call<ResponsePosicionEquipos> call = apiService.getPosicionesByLiga(idLiga, temporada);
        call.enqueue(new Callback<ResponsePosicionEquipos>() {
            @Override
            public void onResponse(Call<ResponsePosicionEquipos> call, Response<ResponsePosicionEquipos> response) {
                if (response.isSuccessful() && response.body() != null && response.body().getTable() != null) {

                    posicionEquipos.clear();
                    posicionEquipos.addAll(response.body().getTable());
                    posicionAdapter.notifyDataSetChanged();
                } else {
                }
            }

            @Override
            public void onFailure(Call<ResponsePosicionEquipos> call, Throwable t) {
                showAlertDialog("Error", "Error al obtener las posiciones, el ID introducido o la Temporada son inválidos.");
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
