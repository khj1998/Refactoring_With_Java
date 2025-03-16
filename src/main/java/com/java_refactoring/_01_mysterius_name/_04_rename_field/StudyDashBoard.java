package com.java_refactoring._01_myserius_name._04_rename_field;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudyDashBoard {
    /**
     * refactor smell 4.필드 네이밍을 사용 의도가 잘 드러나도록 수정
     */
    private Set<StudyReview> studyReviews = new HashSet<>();

    private void loadReviews() throws IOException {
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        GHIssue issue = repository.getIssue(30);

        List<GHIssueComment> reviews = issue.getComments();

        for (GHIssueComment review : reviews) {
            studyReviews.add(new StudyReview(review.getUserName(),review.getBody()));
        }
    }

    public Set<StudyReview> getStudyReviews() {
        return studyReviews;
    }

    public static void main(String[] args) throws IOException {
        StudyDashBoard studyDashBoard = new StudyDashBoard();
        studyDashBoard.loadReviews();
        studyDashBoard.getStudyReviews().forEach(System.out::println);
    }
}
