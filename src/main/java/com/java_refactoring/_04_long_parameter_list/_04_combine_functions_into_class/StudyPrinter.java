package com.java_refactoring._04_long_parameter_list._04_combine_functions_into_class;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class StudyPrinter {
    private final List<Participant> participants;
    private final int totalNumberOfEvents;

    public StudyPrinter(List<Participant> participants, int totalNumberOfEvents) {
        this.participants = participants;
        this.totalNumberOfEvents = totalNumberOfEvents;
    }

    public void printMarkDown() throws IOException {
        try (FileWriter fileWriter = new FileWriter("participants.md");
             PrintWriter writer = new PrintWriter(fileWriter)) {
            participants.sort(Comparator.comparing(Participant::username));

            writer.print(header());

            participants.forEach(p -> {
                String markdownForHomework = getMarkdownForParticipant(p);
                writer.print(markdownForHomework);
            });
        }
    }

    /**
     * | 참여자 (420) | 1주차 | 2주차 | 3주차 | 참석율 |
     * | --- | --- | --- | --- | --- |
     */
    private String header() {
        StringBuilder header = new StringBuilder(String.format("| 참여자 (%d) |", participants.size()));

        for (int index = 1; index <= this.totalNumberOfEvents; index++) {
            header.append(String.format(" %d주차 |", index));
        }
        header.append(" 참석율 |\n");

        header.append("| --- ".repeat(Math.max(0, this.totalNumberOfEvents + 2)));
        header.append("|\n");

        return header.toString();
    }

    private String getMarkdownForParticipant(Participant participant) {
        return String.format("| %s %s | %.2f%% |\n",
                participant.username(), checkMark(participant.homework()), getRate(participant.homework()));
    }

    /**
     * |:white_check_mark:|:white_check_mark:|:white_check_mark:|:x:|
     */
    private String checkMark(Map<Integer, Boolean> homework) {
        StringBuilder line = new StringBuilder();
        for (int i = 1 ; i <= this.totalNumberOfEvents ; i++) {
            if(homework.containsKey(i) && homework.get(i)) {
                line.append("|:white_check_mark:");
            } else {
                line.append("|:x:");
            }
        }
        return line.toString();
    }

    private double getRate(Map<Integer, Boolean> homework) {
        long count = homework.values().stream()
                .filter(v -> v == true)
                .count();
        return (double) (count * 100 / this.totalNumberOfEvents);
    }
}
