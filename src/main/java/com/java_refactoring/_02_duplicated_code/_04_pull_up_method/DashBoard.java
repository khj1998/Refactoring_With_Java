package com.java_refactoring._02_duplicated_code._04_pull_up_method;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * refactoring smell : 하위 클래스의 동일한 의도의 구현 코드를 상위 클래스로 올린다.
 */
public class DashBoard {
    public static void main(String[] args) throws IOException {
        ReviewerDashBoard reviewerDashBoard = new ReviewerDashBoard();
        reviewerDashBoard.printReviewers(15);

        ParticipantDashBoard participantDashBoard = new ParticipantDashBoard();
        participantDashBoard.printUsernames();
    }

    public void printUsernames(int eventId) throws IOException {
        GitHub gitHub = GitHub.connect();
        GHRepository ghRepository = gitHub.getRepository("whiteship/live-study");
        GHIssue issue = ghRepository.getIssue(eventId);

        Set<String> participants = new HashSet<>();
        issue.getComments().forEach(c -> participants.add(c.getUserName()));

        participants.forEach(System.out::println);
    }
}
