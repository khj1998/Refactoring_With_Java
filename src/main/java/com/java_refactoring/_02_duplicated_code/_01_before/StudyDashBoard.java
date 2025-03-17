package com.java_refactoring._02_duplicated_code._01_before;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class StudyDashBoard {
    private void printParticipants(int eventId) throws IOException {
        GitHub gitHub = GitHub.connect();
        GHRepository ghRepository = gitHub.getRepository("whiteship/live-study");
        GHIssue issue = ghRepository.getIssue(eventId);

        Set<String> participants = new HashSet<>();
        issue.getComments().forEach(c -> participants.add(c.getUserName()));

        participants.forEach(System.out::println);
    }

    private void printReviewers() throws IOException {
        GitHub gitHub = GitHub.connect();
        GHRepository ghRepository = gitHub.getRepository("whiteship/live-study");
        GHIssue issue = ghRepository.getIssue(30);

        Set<String> reviewers = new HashSet<>();
        issue.getComments().forEach(c -> reviewers.add(c.getUserName()));

        reviewers.forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        StudyDashBoard studyDashBoard = new StudyDashBoard();
        studyDashBoard.printReviewers();
        studyDashBoard.printParticipants(15);
    }
}
