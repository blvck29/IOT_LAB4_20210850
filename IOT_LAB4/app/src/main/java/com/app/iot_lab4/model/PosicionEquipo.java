package com.app.iot_lab4.model;

public class PosicionEquipo {

    private String idStanding;
    private int intRank;
    private String idTeam;
    private String strTeam;
    private String strBadge;
    private String idLeague;
    private String strLeague;
    private String strSeason;
    private String strForm;
    private String strDescription;
    private int intPlayed;
    private int intWin;
    private int intLoss;
    private int intDraw;
    private int intGoalsFor;
    private int intGoalsAgainst;
    private int intGoalDifference;
    private int intPoints;
    private String dateUpdated;

    public PosicionEquipo(String idStanding, int intRank, String idTeam, String strTeam, String strBadge, String idLeague, String strLeague, String strSeason, String strForm, String strDescription, int intPlayed, int intWin, int intLoss, int intDraw, int intGoalsFor, int intGoalsAgainst, int intGoalDifference, int intPoints, String dateUpdated) {
        this.idStanding = idStanding;
        this.intRank = intRank;
        this.idTeam = idTeam;
        this.strTeam = strTeam;
        this.strBadge = strBadge;
        this.idLeague = idLeague;
        this.strLeague = strLeague;
        this.strSeason = strSeason;
        this.strForm = strForm;
        this.strDescription = strDescription;
        this.intPlayed = intPlayed;
        this.intWin = intWin;
        this.intLoss = intLoss;
        this.intDraw = intDraw;
        this.intGoalsFor = intGoalsFor;
        this.intGoalsAgainst = intGoalsAgainst;
        this.intGoalDifference = intGoalDifference;
        this.intPoints = intPoints;
        this.dateUpdated = dateUpdated;
    }

    public String getIdStanding() {
        return idStanding;
    }

    public void setIdStanding(String idStanding) {
        this.idStanding = idStanding;
    }

    public int getIntRank() {
        return intRank;
    }

    public void setIntRank(int intRank) {
        this.intRank = intRank;
    }

    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrBadge() {
        return strBadge;
    }

    public void setStrBadge(String strBadge) {
        this.strBadge = strBadge;
    }

    public String getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
    }

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public String getStrSeason() {
        return strSeason;
    }

    public void setStrSeason(String strSeason) {
        this.strSeason = strSeason;
    }

    public String getStrForm() {
        return strForm;
    }

    public void setStrForm(String strForm) {
        this.strForm = strForm;
    }

    public String getStrDescription() {
        return strDescription;
    }

    public void setStrDescription(String strDescription) {
        this.strDescription = strDescription;
    }

    public int getIntPlayed() {
        return intPlayed;
    }

    public void setIntPlayed(int intPlayed) {
        this.intPlayed = intPlayed;
    }

    public int getIntWin() {
        return intWin;
    }

    public void setIntWin(int intWin) {
        this.intWin = intWin;
    }

    public int getIntLoss() {
        return intLoss;
    }

    public void setIntLoss(int intLoss) {
        this.intLoss = intLoss;
    }

    public int getIntDraw() {
        return intDraw;
    }

    public void setIntDraw(int intDraw) {
        this.intDraw = intDraw;
    }

    public int getIntGoalsFor() {
        return intGoalsFor;
    }

    public void setIntGoalsFor(int intGoalsFor) {
        this.intGoalsFor = intGoalsFor;
    }

    public int getIntGoalsAgainst() {
        return intGoalsAgainst;
    }

    public void setIntGoalsAgainst(int intGoalsAgainst) {
        this.intGoalsAgainst = intGoalsAgainst;
    }

    public int getIntGoalDifference() {
        return intGoalDifference;
    }

    public void setIntGoalDifference(int intGoalDifference) {
        this.intGoalDifference = intGoalDifference;
    }

    public int getIntPoints() {
        return intPoints;
    }

    public void setIntPoints(int intPoints) {
        this.intPoints = intPoints;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
