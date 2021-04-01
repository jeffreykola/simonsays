package com.example.simonsays

import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.Drawable


/**
 * Provides a callback when a non-looping [AnimationDrawable] completes its animation sequence. More precisely,
 * [.onAnimationComplete] is triggered when [View.invalidateDrawable] has been called on the
 * last frame.
 *
 * @author Benedict Lau
 */
abstract class AnimationDrawableCallback(animationDrawable: AnimationDrawable, callback: Drawable.Callback?) : Drawable.Callback {
    /**
     * The last frame of [Drawable] in the [AnimationDrawable].
     */
    private val mLastFrame: Drawable?

    /**
     * The client's [Callback] implementation. All calls are proxied to this wrapped [Callback]
     * implementation after intercepting the events we need.
     */
    private val mWrappedCallback: Drawable.Callback?

    /**
     * Flag to ensure that [.onAnimationComplete] is called only once, since
     * [.invalidateDrawable] may be called multiple times.
     */
    private var mIsCallbackTriggered = false
    override fun invalidateDrawable(who: Drawable) {
        if (mWrappedCallback != null) {
            mWrappedCallback.invalidateDrawable(who)
        }
        if (!mIsCallbackTriggered && mLastFrame != null && mLastFrame == who.current) {
            mIsCallbackTriggered = true
            onAnimationComplete()
        }
    }

    override fun scheduleDrawable(who: Drawable, what: Runnable, `when`: Long) {
        if (mWrappedCallback != null) {
            mWrappedCallback.scheduleDrawable(who, what, `when`)
        }
    }

    override fun unscheduleDrawable(who: Drawable, what: Runnable) {
        if (mWrappedCallback != null) {
            mWrappedCallback.unscheduleDrawable(who, what)
        }
    }
    //
    // Public methods.
    //
    /**
     * Callback triggered when [View.invalidateDrawable] has been called on the last frame, which marks
     * the end of a non-looping animation sequence.
     */
    abstract fun onAnimationComplete()

    /**
     *
     * @param animationDrawable
     * the [AnimationDrawable].
     * @param callback
     * the client's [Callback] implementation. This is usually the [View] the has the
     * [AnimationDrawable] as background.
     */
    init {
        mLastFrame = animationDrawable.getFrame(animationDrawable.numberOfFrames - 1)
        mWrappedCallback = callback
    }
}