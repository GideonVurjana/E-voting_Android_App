package com.eddrix.project.evoting.models;

public class ElectionCandidates {

    int id;
    String partyname;
    String leadername;
    int partyimage;
    String partyDescription;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPartyname() {
        return partyname;
    }

    public void setPartyname(String partyname) {
        this.partyname = partyname;
    }

    public String getLeadername() {
        return leadername;
    }

    public void setLeadername(String leadername) {
        this.leadername = leadername;
    }

    public int getPartyimage() {
        return partyimage;
    }

    public void setPartyimage(int partyimage) {
        this.partyimage = partyimage;
    }

    public String getPartyDescription() {
        return partyDescription;
    }

    public void setPartyDescription(String partyDescription) {
        this.partyDescription = partyDescription;
    }

    public ElectionCandidates(int id, String partyname, String leadername, int partyimage, String partyDescription) {

        this.id = id;
        this.partyname = partyname;
        this.leadername = leadername;
        this.partyimage = partyimage;
        this.partyDescription = partyDescription;
    }
}
