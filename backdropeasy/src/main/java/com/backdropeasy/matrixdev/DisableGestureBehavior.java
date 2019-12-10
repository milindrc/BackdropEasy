package com.backdropeasy.matrixdev;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;


public class DisableGestureBehavior<T extends View> extends BottomSheetBehavior<T> {

    Context context;
    AttributeSet attributeSet;

    public DisableGestureBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        this.attributeSet = attributeSet;
    }

    public DisableGestureBehavior() {
        super();
    }

    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, T child, MotionEvent event) {
        return false;
    }

    @Override
    public boolean onTouchEvent(CoordinatorLayout parent, T child, MotionEvent event) {
        return false;
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return false;
    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
    }

    @Override
    public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T child, @NonNull View target, int type) {

    }

    @Override
    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T child, @NonNull View target, float velocityX, float velocityY, boolean consumed) {
        return false;
    }
}
