package com.java_refactoring._01_myserius_name._02_change_method_declaration;

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
     * refactor smell 1.메서드 네이밍 의미를 드러낼 수 있도록 수정
     * refactor smell 2.불필요한 함수 매개변수 제거
     */
    private void loadReviews() throws IOException {
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        GHIssue issue = repository.getIssue(30);

        List<GHIssueComment> comments = issue.getComments();

        for (GHIssueComment comment : comments) {
            usernames.add(comment.getUserName());
            reviews.add(comment.getBody());
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
