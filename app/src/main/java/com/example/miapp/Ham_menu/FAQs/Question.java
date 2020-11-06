package com.example.miapp.Ham_menu.FAQs;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class Question extends ExpandableGroup<Answer> {
    public Question(String title, List items) {
        super(title, items);
    }
}
