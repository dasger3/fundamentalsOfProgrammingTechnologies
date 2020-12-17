package com.company;

import java.util.Date;

public class Voting {
    private String name;
    private Date dateOfVoting;

    public Voting (String name, Date dateOfVoting) {
        this.name = name;
        this.dateOfVoting = dateOfVoting;
    }
    public void changeManager (AdministrativeTerritorialUnit ATU, String name, String surname, String position) {
        ATU.setManager(name,surname,position);
    }
}
