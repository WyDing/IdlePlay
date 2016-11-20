package com.iwuyou.libmine.view.pullrefreshandloadview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 *
 */
public class PullableScrollView extends ScrollView implements Pullable {

	private boolean triggerAble = true;

	public PullableScrollView(Context context)
	{
		super(context);
	}

	public PullableScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public PullableScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public boolean canPullDown() {
		if (getScrollY() == 0 && triggerAble)
			return true;
		else
			return false;
	}

	@Override
	public boolean canPullUp() {
		if ((getScrollY() >= (getChildAt(0).getHeight() - getMeasuredHeight())) && triggerAble)
			return true;
		else
			return false;
	}

	public void setTriggerAble(boolean triggerAble) {
		this.triggerAble = triggerAble;
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		return triggerAble && super.onInterceptTouchEvent(ev);
	}
}
