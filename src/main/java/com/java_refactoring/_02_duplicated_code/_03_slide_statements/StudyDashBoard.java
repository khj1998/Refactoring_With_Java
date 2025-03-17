package com.java_refactoring._02_duplicated_code._03_slide_statements;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 원본 (before)과 동일한 코드이다.
 * 눈여겨 보아야 할 것은 관련 있는 코드끼리 묶어 작성했다는 점.
 * 지역변수를 맨 처음 시작 구문에서 모두 선언하는 것이 아닌, 필요할 때 선언했다는 점.
 * 저자 마틴 파울러, 백기선 강사님의 지역 변수 영향 범위를 최소화하여 코드 블럭을 명시적으로 드러낸다는 점이 인상깊음.
 */
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
