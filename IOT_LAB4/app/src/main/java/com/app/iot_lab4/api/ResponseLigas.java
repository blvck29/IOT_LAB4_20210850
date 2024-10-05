package com.app.iot_lab4.api;

import com.app.iot_lab4.model.Liga;

import java.util.List;

public class ResponseLigas {
    private List<Liga> leagues;

    public List<Liga> getLeagues() {
        return leagues;
    }

    public void setLeagues(List<Liga> leagues) {
        this.leagues = leagues;
    }
}
