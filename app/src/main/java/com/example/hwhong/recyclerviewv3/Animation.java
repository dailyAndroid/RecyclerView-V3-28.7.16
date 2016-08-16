package com.example.hwhong.recyclerviewv3;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;

/**
 * Created by hwhong on 7/28/16.
 */
public class Animation {

    public static void animate(RecyclerView.ViewHolder holder, boolean down) {
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator animator = ObjectAnimator.ofFloat(holder.itemView,
                "translationY", down == true ? 200 : -200, 0);

        animator.setDuration(1000);
        set.playTogether(animator);
        set.start();
    }
}
