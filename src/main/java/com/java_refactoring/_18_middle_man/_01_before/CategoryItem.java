package com.java_refactoring._18_middle_man._01_before;

import java.util.List;

public class CategoryItem {

    private Integer id;

    private String title;

    private List<String> tags;

    public CategoryItem(Integer id, String title, List<String> tags) {
        this.id = id;
        this.title = title;
        this.tags = tags;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean hasTag(String tag) {
        return this.tags.contains(tag);
    }
}
