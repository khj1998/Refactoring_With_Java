package com.java_refactoring._03_long_function._04_preserve_whole_object;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * refactoring smell : 메서드에 전달되는 매개변수들이 하나의 오브젝트에서 파생되는 경우, 객체로 넘긴다.
 * 전달해야하는 매개변수의 목록을 줄일 수 있다.
 * 
 * 메서드의 위치를 옮기고 고민해야할 점들.
 * 과연 이 메서드가 이 클래스에 의존하고 있는 것이 맞는가?
 * 메서드가 매개 변수 타입 오브젝트에 가는 것이 맞는가? => 타입 오브젝트에서 파생시키는 변수일 경우 고려해 볼만 하다.
 */
public class StudyDashBoard {
    public static void main(String[] args) throws IOException, InterruptedException {
        StudyDashBoard studyDashboard = new StudyDashBoard(15);
        studyDashboard.print();
    }

    private final int totalNumberOfEvents;

    public StudyDashBoard(int totalNumberOfEvents) {
        this.totalNumberOfEvents = totalNumberOfEvents;
    }

    private void print() throws IOException, InterruptedException {
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        List<Participant> participants = new CopyOnWriteArrayList<>();

        ExecutorService service = Executors.newFixedThreadPool(8);
        CountDownLatch latch = new CountDownLatch(totalNumberOfEvents);

        for (int index = 1 ; index <= totalNumberOfEvents ; index++) {
            int eventId = index;
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        GHIssue issue = repository.getIssue(eventId);
                        List<GHIssueComment> comments = issue.getComments();

                        for (GHIssueComment comment : comments) {
                            String username = comment.getUserName();
                            boolean isNewUser = participants.stream().noneMatch(p -> p.username().equals(username));
                            Participant participant = null;
                            if (isNewUser) {
                                participant = new Participant(username);
                                participants.add(participant);
                            } else {
                                participant = participants.stream().filter(p -> p.username().equals(username)).findFirst().orElseThrow();
                            }

                            participant.setHomeworkDone(eventId);
                        }

                        latch.countDown();
                    } catch (IOException e) {
                        throw new IllegalArgumentException(e);
                    }
                }
            });
        }

        latch.await();
        service.shutdown();

        try (FileWriter fileWriter = new FileWriter("participants.md");
             PrintWriter writer = new PrintWriter(fileWriter)) {
            participants.sort(Comparator.comparing(Participant::username));

            writer.print(header(participants.size()));

            participants.forEach(p -> {
                String markdownForHomework = getMarkdownForParticipant(p);
                writer.print(markdownForHomework);
            });
        }
    }

    private String getMarkdownForParticipant(Participant participant) {
        return String.format("| %s %s | %.2f%% |\n", participant.username(),
                checkMark(participant, this.totalNumberOfEvents),
                participant.getRate(this.totalNumberOfEvents));
    }

    /**
     * | 참여자 (420) | 1주차 | 2주차 | 3주차 | 참석율 |
     * | --- | --- | --- | --- | --- |
     */
    private String header(int totalNumberOfParticipants) {
        StringBuilder header = new StringBuilder(String.format("| 참여자 (%d) |", totalNumberOfParticipants));

        for (int index = 1; index <= this.totalNumberOfEvents; index++) {
            header.append(String.format(" %d주차 |", index));
        }
        header.append(" 참석율 |\n");

        header.append("| --- ".repeat(Math.max(0, this.totalNumberOfEvents + 2)));
        header.append("|\n");

        return header.toString();
    }

    /**
     * |:white_check_mark:|:white_check_mark:|:white_check_mark:|:x:|
     */
    private String checkMark(Participant participant,int totalEvents) {
        StringBuilder line = new StringBuilder();
        for (int i = 1 ; i <= totalEvents ; i++) {
            if(participant.homework().containsKey(i) && participant.homework().get(i)) {
                line.append("|:white_check_mark:");
            } else {
                line.append("|:x:");
            }
        }
        return line.toString();
    }
}
