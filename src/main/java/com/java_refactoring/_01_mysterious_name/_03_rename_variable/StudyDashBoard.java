package com.java_refactoring._01_mysterious_name._03_rename_variable;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudyDashBoard {
    private Set<String> usernames = new HashSet<>();
    private Set<String> reviews = new HashSet<>();

    /**
     * refactor smell 3.리뷰와 관련된 지역변수 명으로 변경
     */
    private void loadReviews() throws IOException {
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        GHIssue issue = repository.getIssue(30);

        List<GHIssueComment> reviews = issue.getComments();

        for (GHIssueComment review : reviews) {
            usernames.add(review.getUserName());
            this.reviews.add(review.getBody());
        }
    }

    public Set<String> getUsernames() {
        return usernames;
    }

    public Set<String> getReviews() {
        return reviews;
    }

    public static void main(String[] args) throws IOException {
        StudyDashBoard studyDashBoard = new StudyDashBoard();
        studyDashBoard.loadReviews();
        studyDashBoard.getUsernames().forEach(System.out::println);
        studyDashBoard.getReviews().forEach(System.out::println);
    }
}
