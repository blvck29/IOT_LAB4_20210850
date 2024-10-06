package com.app.iot_lab4.api;

import com.app.iot_lab4.model.Resultado;

import java.util.List;

public class ResponseResultados {
    private List<Resultado> events;

    public List<Resultado> getEvents() {
        return events;
    }

    public void setEvents(List<Resultado> events) {
        this.events = events;
    }
}