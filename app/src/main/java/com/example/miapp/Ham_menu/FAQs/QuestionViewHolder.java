package com.example.miapp.Ham_menu.FAQs;

import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.miapp.R;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import static android.view.animation.Animation.RELATIVE_TO_SELF;


public class QuestionViewHolder extends GroupViewHolder {
    private TextView mtextView;
    private ImageView arrow;

    public QuestionViewHolder(View itemView) {
        super(itemView);
        mtextView=itemView.findViewById(R.id.textView);
        arrow=itemView.findViewById(R.id.arrow);
    }

    public void bind(Question question)
    {

        mtextView.setText((question.getTitle()));
    }

    @Override
    public void expand() {
        animateExpand();
    }

    @Override
    public void collapse() {
        animateCollapse();
    }

    private void animateExpand() {
        RotateAnimation rotate =
                new RotateAnimation(360, 180, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrow.setAnimation(rotate);
    }

    private void animateCollapse() {
        RotateAnimation rotate =
                new RotateAnimation(180, 360, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrow.setAnimation(rotate);
    }
}
