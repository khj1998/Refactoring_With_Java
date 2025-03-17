package com.java_refactoring._02_duplicated_code._04_pull_up_method;

import java.io.IOException;

public class ParticipantDashBoard extends DashBoard{
    public void printUsernames() throws IOException {
        super.printUsernames(30);
    }
}
