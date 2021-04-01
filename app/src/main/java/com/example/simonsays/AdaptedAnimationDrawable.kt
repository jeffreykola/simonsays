package com.example.simonsays

import android.graphics.drawable.AnimationDrawable

class AnimationDrawable2(): AnimationDrawable() {

    interface IAnimationFinishListener {
        fun onAnimationFinished();
    }

    private var finished: Boolean = false;
    private lateinit var animationFinishListener: IAnimationFinishListener;

    public fun getAnimationFinishListener(): IAnimationFinishListener {
        return animationFinishListener;
    }

    fun setAnimationFinishListener(animationFinishListener: IAnimationFinishListener) {
        this.animationFinishListener = animationFinishListener;
    }


    override fun selectDrawable(index: Int): Boolean {
        //return super.selectDrawable(index)
        var ret: Boolean = super.selectDrawable(index);

        if ((index != 0) && (index == getNumberOfFrames() - 1)) {
            if (!this.finished) {
                this.finished = true;
                if (animationFinishListener != null) animationFinishListener.onAnimationFinished();
            }
        }

        return ret;
    }
}