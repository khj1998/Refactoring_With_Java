package com.java_refactoring._13_loops._02_replace_loop_with_pipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * refactoring smell : 루프 사용 의도를 잘 드러내도록 명시적인 파이프라인으로 표현한다.
 */
public class Author {

    private String company;

    private String twitterHandle;

    public Author(String company, String twitterHandle) {
        this.company = company;
        this.twitterHandle = twitterHandle;
    }

    static public List<String> TwitterHandles(List<Author> authors, String company) {

        return authors.stream().filter(author -> author.company.equals(company))
                .map(author ->  author.twitterHandle)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

}
