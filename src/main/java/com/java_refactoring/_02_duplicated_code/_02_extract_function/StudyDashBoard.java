package com.java_refactoring._02_duplicated_code._02_extract_function;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * refactoring smell : 비슷한 의도를 구현한 로직을 메서드로 추출
 */
public class StudyDashBoard {
    private void printParticipants(int eventId) throws IOException {
        GHIssue issue = getGhIssue(eventId);

        Set<String> usernames = getUsernames(issue);

        printUsernames(usernames);
    }

    private void printReviewers() throws IOException {
        GHIssue issue = getGhIssue(30);

        Set<String> reviewers = getUsernames(issue);

        printUsernames(reviewers);
    }

    private GHIssue getGhIssue(int eventId) throws IOException {
        GitHub gitHub = GitHub.connect();
        GHRepository ghRepository = gitHub.getRepository("whiteship/live-study");
        GHIssue issue = ghRepository.getIssue(eventId);

        return issue;
    }

    private Set<String> getUsernames(GHIssue ghIssue) throws IOException {
        Set<String> usernames = new HashSet<>();
        ghIssue.getComments().forEach(c -> usernames.add(c.getUserName()));
        return usernames;
    }

    private void printUsernames(Set<String> usernames) {
        usernames.forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        StudyDashBoard studyDashBoard = new StudyDashBoard();
        studyDashBoard.printReviewers();
        studyDashBoard.printParticipants(15);
    }
}
