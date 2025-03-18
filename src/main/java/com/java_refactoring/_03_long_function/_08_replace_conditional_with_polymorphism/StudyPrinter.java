package com.java_refactoring._03_long_function._08_replace_conditional_with_polymorphism;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

/**
 * refactoring smell : 조건문을 다형성으로 수정.
 * 조건문보다 원하는 결과를 명확하게 드러낼 수 있다.
 */
public abstract class StudyPrinter {

    protected int totalNumberOfEvents;

    protected List<Participant> participants;

    protected StudyPrinter(int totalNumberOfEvents, List<Participant> participants) {
        this.totalNumberOfEvents = totalNumberOfEvents;
        this.participants = participants;
        this.participants.sort(Comparator.comparing(Participant::username));
    }

    /**
     * 런타임으로 구체 타입을 반환하기 위한 정적 팩터리 메서드.
     */
    public static StudyPrinter createStudyPrinter(PrinterMode mode,int totalNumberOfEvents,List<Participant> participants) {
        switch (mode) {
            case CONSOLE -> {
                return new ConsolePrinter(totalNumberOfEvents,participants);
            }
            case CVS -> {
                return new CvsPrinter(totalNumberOfEvents,participants );
            }
            case MARKDOWN -> {
                return new MarkdownPrinter(totalNumberOfEvents,participants);
            }
            default -> throw new IllegalArgumentException("Unknown printer mode: " + mode);

        }
    }

    public abstract void execute() throws IOException;

    protected String checkMark(Participant p) {
        StringBuilder line = new StringBuilder();
        for (int i = 1 ; i <= totalNumberOfEvents ; i++) {
            if(p.homework().containsKey(i) && p.homework().get(i)) {
                line.append("|:white_check_mark:");
            } else {
                line.append("|:x:");
            }
        }
        return line.toString();
    }
}
