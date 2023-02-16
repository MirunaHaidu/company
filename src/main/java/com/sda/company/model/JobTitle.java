package com.sda.company.model;

public enum JobTitle {
    DEVELOPER ("Developer"),
    TESTER ("Tester"),
    TEAMLEAD("Team leader");

    private final String title;

    JobTitle (String title){
        this.title = title;
    }
}