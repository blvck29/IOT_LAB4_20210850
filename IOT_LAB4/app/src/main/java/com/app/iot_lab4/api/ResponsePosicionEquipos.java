package com.app.iot_lab4.api;

import com.app.iot_lab4.model.PosicionEquipo;

import java.util.List;

public class ResponsePosicionEquipos {

    private List<PosicionEquipo> table;

    public List<PosicionEquipo> getTable() {
        return table;
    }

    public void setTable(List<PosicionEquipo> table) {
        this.table = table;
    }
}
