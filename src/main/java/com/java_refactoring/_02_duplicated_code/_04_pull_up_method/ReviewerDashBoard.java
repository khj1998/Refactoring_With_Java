package com.java_refactoring._02_duplicated_code._04_pull_up_method;

import java.io.IOException;

public class ReviewerDashBoard extends DashBoard{
    public void printReviewers(int eventId) throws IOException {
        super.printUsernames(eventId);
    }
}
