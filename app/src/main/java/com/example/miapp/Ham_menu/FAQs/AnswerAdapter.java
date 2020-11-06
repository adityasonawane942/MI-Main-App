package com.example.miapp.Ham_menu.FAQs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.miapp.R;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;


import java.util.List;

public class AnswerAdapter extends ExpandableRecyclerViewAdapter<QuestionViewHolder,AnswerViewHolder> {
    public AnswerAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public QuestionViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.faq_question, parent, false);
        return new QuestionViewHolder(v);
    }

    @Override
    public AnswerViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.faq_answer, parent, false);
        return new AnswerViewHolder(v);
    }

    @Override
    public void onBindChildViewHolder(AnswerViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
    final Answer answer=(Answer) group.getItems().get(childIndex);
    holder.bind(answer);
    }



    @Override
    public void onBindGroupViewHolder(QuestionViewHolder holder, int flatPosition, ExpandableGroup group) {

    final Question question=(Question) group;
    holder.bind(question);
    }

}