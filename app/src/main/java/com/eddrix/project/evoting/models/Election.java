package com.eddrix.project.evoting.models;

public class Election {

    private String electionName;
    private String startdate;
    private String EndDate;
    private boolean activestate;
    private int id;

    public Election(String electionName, String startdate, String endDate, boolean activestate, int id) {
        this.electionName = electionName;
        this.startdate = startdate;
        EndDate = endDate;
        this.activestate = activestate;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getElectionName() {
        return electionName;
    }

    public void setElectionName(String electionName) {
        this.electionName = electionName;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public boolean isActivestate() {
        return activestate;
    }

    public void setActivestate(boolean activestate) {
        this.activestate = activestate;
    }
}
