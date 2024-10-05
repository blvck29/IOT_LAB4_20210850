package com.app.iot_lab4.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.iot_lab4.R;
import com.app.iot_lab4.model.PosicionEquipo;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PosicionAdapter extends RecyclerView.Adapter<PosicionAdapter.PosicionEquipoViewHolder> {

    private ArrayList<PosicionEquipo> posicionEquipos;

    public PosicionAdapter(ArrayList<PosicionEquipo> posicionEquipos) {
        this.posicionEquipos = posicionEquipos;
    }

    @NonNull
    @Override
    public PosicionAdapter.PosicionEquipoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_posicion, parent, false);
        return new PosicionEquipoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PosicionAdapter.PosicionEquipoViewHolder holder, int position) {
        PosicionEquipo posicionEquipo = posicionEquipos.get(position);

        holder.intRank.setText(String.valueOf(posicionEquipo.getIntRank()));
        holder.strTeam.setText(posicionEquipo.getStrTeam());
        holder.idTeam.setText(posicionEquipo.getIdTeam());
        holder.intPlayed.setText(String.valueOf(posicionEquipo.getIntPlayed()));
        holder.intWin.setText(String.valueOf(posicionEquipo.getIntWin()));
        holder.intLoss.setText(String.valueOf(posicionEquipo.getIntLoss()));
        holder.intDraw.setText(String.valueOf(posicionEquipo.getIntDraw()));
        holder.intGoalsFor.setText(String.valueOf(posicionEquipo.getIntGoalsFor()));
        holder.intGoalsAgainst.setText(String.valueOf(posicionEquipo.getIntGoalsAgainst()));
        holder.intGoalDifference.setText(String.valueOf(posicionEquipo.getIntGoalDifference()));
        holder.intPoints.setText(String.valueOf(posicionEquipo.getIntPoints()));

        Glide.with(holder.itemView.getContext())
                .load(posicionEquipo.getStrBadge()) // URL de la imagen
                .placeholder(R.drawable.baseline_sports_soccer_24) // Imagen de carga
                .error(R.drawable.baseline_sports_soccer_24) // Imagen de error
                .into(holder.imageViewBadge);
    }

    @Override
    public int getItemCount() {
        return posicionEquipos.size();
    }

    public static class PosicionEquipoViewHolder extends RecyclerView.ViewHolder {
        TextView intRank;
        TextView strTeam;
        TextView idTeam;
        TextView intPlayed;
        TextView intWin;
        TextView intLoss;
        TextView intDraw;
        TextView intGoalsFor;
        TextView intGoalsAgainst;
        TextView intGoalDifference;
        TextView intPoints;

        ImageView imageViewBadge;

        public PosicionEquipoViewHolder(@NonNull View itemView) {
            super(itemView);
            intRank = itemView.findViewById(R.id.intRank);
            strTeam = itemView.findViewById(R.id.strTeam);
            idTeam = itemView.findViewById(R.id.idTeam);
            intPlayed = itemView.findViewById(R.id.intPlayed);
            intWin = itemView.findViewById(R.id.intWin);
            intLoss = itemView.findViewById(R.id.intLoss);
            intDraw = itemView.findViewById(R.id.intDraw);
            intGoalsFor = itemView.findViewById(R.id.intGoalsFor);
            intGoalsAgainst = itemView.findViewById(R.id.intGoalsAgainst);
            intGoalDifference = itemView.findViewById(R.id.intGoalDifference);
            intPoints = itemView.findViewById(R.id.intPoints);

            imageViewBadge = itemView.findViewById(R.id.imageViewBadge);
        }
    }
}
