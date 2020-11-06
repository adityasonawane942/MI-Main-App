package com.example.miapp.Ham_menu.FAQs;

import android.view.View;
import android.widget.TextView;

import com.example.miapp.R;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class AnswerViewHolder extends ChildViewHolder {
    private TextView mtextView;

    public AnswerViewHolder(View itemView) {
        super(itemView);
        mtextView = itemView.findViewById(R.id.textView);
    }

    public void bind(Answer answer){

        mtextView.setText(answer.name);
    }

}
