package com.app.iot_lab4.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.iot_lab4.R;
import com.app.iot_lab4.model.Resultado;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ResultadoAdapter extends RecyclerView.Adapter<ResultadoAdapter.ResultadosViewHolder> {

    private ArrayList<Resultado> resultados;

    public ResultadoAdapter(ArrayList<Resultado> resultados) {
        this.resultados = resultados;
    }

    @NonNull
    @Override
    public ResultadoAdapter.ResultadosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_resultado, parent, false);
        return new ResultadoAdapter.ResultadosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultadoAdapter.ResultadosViewHolder holder, int position) {
        Resultado resultado = resultados.get(position);

        holder.textViewStrEvent.setText((String.valueOf(resultado.getStrEvent())));
        holder.textViewStrHomeTeam.setText((String.valueOf(resultado.getStrHomeTeam())));
        holder.textViewStrAwayTeam.setText((String.valueOf(resultado.getStrAwayTeam())));

        if (resultado.getIntSpectators() != null) {
            holder.textViewIntRound.setText((String.valueOf(resultado.getIntRound())));
        } else {
            holder.textViewIntRound.setText("Desconocido");
        }

        holder.textViewDateEvent.setText((String.valueOf(resultado.getStrdateEvent())));

        if (resultado.getIntSpectators() != null) {
            holder.textViewIntSpectators.setText((String.valueOf(resultado.getIntSpectators())));
        } else {
            holder.textViewIntSpectators.setText("Desconocido");
        }


        Glide.with(holder.itemView.getContext())
                .load(resultado.getStrThumb()) // URL de la imagen
                .placeholder(R.drawable.baseline_sports_soccer_24) // Imagen de carga
                .error(R.drawable.baseline_sports_soccer_24) // Imagen de error
                .into(holder.imageViewStrSquare);
    }


    @Override
    public int getItemCount() {
        return resultados.size();
    }

    public static class ResultadosViewHolder extends RecyclerView.ViewHolder {
        TextView textViewStrEvent;
        TextView textViewStrHomeTeam;
        TextView textViewStrAwayTeam;
        TextView textViewIntRound;
        TextView textViewDateEvent;
        TextView textViewIntSpectators;
        ImageView imageViewStrSquare;

        public ResultadosViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewStrEvent = itemView.findViewById(R.id.strEvent);
            textViewStrHomeTeam = itemView.findViewById(R.id.strHomeTeam);
            textViewStrAwayTeam = itemView.findViewById(R.id.strAwayTeam);
            textViewIntRound = itemView.findViewById(R.id.intRound);
            textViewDateEvent = itemView.findViewById(R.id.dateEvent);
            textViewIntSpectators = itemView.findViewById(R.id.intSpectators);
            imageViewStrSquare = itemView.findViewById(R.id.imageViewStrSquare);

            // Log to verify initialization
            Log.d("ViewHolder", "Initialized ViewHolder with ID: " + getAdapterPosition() +
                    " strEvent: " + (textViewStrEvent != null) +
                    ", strHomeTeam: " + (textViewStrHomeTeam != null) +
                    ", strAwayTeam: " + (textViewStrAwayTeam != null) +
                    ", intRound: " + (textViewIntRound != null) +
                    ", dateEvent: " + (textViewDateEvent != null) +
                    ", intSpectators: " + (textViewIntSpectators != null) +
                    ", imageViewStrSquare: " + (imageViewStrSquare != null));
        }
    }

}
