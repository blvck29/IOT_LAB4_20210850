package com.app.iot_lab4.model;

public class Resultado {

    private String strEvent;
    private String strdateEvent;
    private String strHomeTeam;
    private String strAwayTeam;
    private int intRound;
    private Integer intSpectators;
    private String strThumb;

    public Resultado(String strEvent, String strdateEvent, String strHomeTeam, String strAwayTeam, int intRound, Integer intSpectators, String strThumb) {
        this.strEvent = strEvent;
        this.strdateEvent = strdateEvent;
        this.strHomeTeam = strHomeTeam;
        this.strAwayTeam = strAwayTeam;
        this.intRound = intRound;
        this.intSpectators = intSpectators;
        this.strThumb = strThumb;
    }

    public String getStrEvent() {
        return strEvent;
    }

    public void setStrEvent(String strEvent) {
        this.strEvent = strEvent;
    }

    public String getStrdateEvent() {
        return strdateEvent;
    }

    public void setStrdateEvent(String strdateEvent) {
        this.strdateEvent = strdateEvent;
    }

    public String getStrHomeTeam() {
        return strHomeTeam;
    }

    public void setStrHomeTeam(String strHomeTeam) {
        this.strHomeTeam = strHomeTeam;
    }

    public String getStrAwayTeam() {
        return strAwayTeam;
    }

    public void setStrAwayTeam(String strAwayTeam) {
        this.strAwayTeam = strAwayTeam;
    }

    public int getIntRound() {
        return intRound;
    }

    public void setIntRound(int intRound) {
        this.intRound = intRound;
    }

    public Integer getIntSpectators() {
        return intSpectators;
    }

    public void setIntSpectators(Integer intSpectators) {
        this.intSpectators = intSpectators;
    }

    public String getStrThumb() {
        return strThumb;
    }

    public void setStrThumb(String strThumb) {
        this.strThumb = strThumb;
    }
}
