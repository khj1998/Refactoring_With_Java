package com.java_refactoring._01_mysterious_name._01_before;

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
     * smell 4.필드 네이밍이 구체적이지 않다.
     */
    private Set<String> usernames = new HashSet<>();
    private Set<String> reviews = new HashSet<>();

    /**
     * 기능 : 스터디 리뷰 이슈에 작성되어 있는 리뷰어 목록과 리뷰를 읽어온다.
     * smell 1. 함수의 네이밍에서 수행할 기능이 명확히 보이지 않는다.
     * smell 2. 함수의 불필요한 파라미터 존재.
     * smell 3. 리뷰 관련 함수지만, 리뷰와 연관되어 보이는 지역변수명이 확인되지 않는다.
     */
    private void studyReviews(GHIssue issue) throws IOException {
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
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        GHIssue issue = repository.getIssue(30);

        StudyDashBoard studyDashBoard = new StudyDashBoard();
        studyDashBoard.studyReviews(issue);
        studyDashBoard.getUsernames().forEach(System.out::println);
        studyDashBoard.getReviews().forEach(System.out::println);
    }
}
