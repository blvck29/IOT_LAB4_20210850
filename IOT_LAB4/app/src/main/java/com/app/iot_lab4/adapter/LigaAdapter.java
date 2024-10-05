package com.app.iot_lab4.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.iot_lab4.R;
import com.app.iot_lab4.model.Liga;

import java.util.ArrayList;

public class LigaAdapter extends RecyclerView.Adapter<LigaAdapter.ligaViewHolder> {

    private ArrayList<Liga> ligas;

    public LigaAdapter(ArrayList<Liga> ligas) {
        this.ligas = ligas;
    }

    @NonNull
    @Override
    public LigaAdapter.ligaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_liga, parent, false);
        return new ligaViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull LigaAdapter.ligaViewHolder holder, int position) {
        Liga liga = ligas.get(position);

        holder.idLeague.setText(liga.getIdLeague());
        holder.strLeague.setText(liga.getStrLeague());
        holder.strSport.setText(liga.getStrSport());
        holder.strLeagueAlternate.setText(liga.getStrLeagueAlternate());
    }

    @Override
    public int getItemCount() {
        return ligas.size();
    }


    public static class ligaViewHolder extends RecyclerView.ViewHolder {
        TextView idLeague;
        TextView strLeague;
        TextView strSport;
        TextView strLeagueAlternate;

        public ligaViewHolder(@NonNull View itemView) {
            super(itemView);
            idLeague = itemView.findViewById(R.id.idLeague);
            strLeague = itemView.findViewById(R.id.strLeague);
            strSport = itemView.findViewById(R.id.strSport);
            strLeagueAlternate = itemView.findViewById(R.id.strLeagueAlternate);
        }
    }

}
