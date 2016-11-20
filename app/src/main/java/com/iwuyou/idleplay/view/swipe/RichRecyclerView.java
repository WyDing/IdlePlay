package com.iwuyou.idleplay.view.swipe;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;

import com.iwuyou.libmine.view.pullrefreshandloadview.Pullable;
import com.libswipeview.swipe.SwipeMenuRecyclerView;

/**
 * Created by duanding on 16/10/26.
 */

public class RichRecyclerView extends SwipeMenuRecyclerView implements Pullable {
    public RichRecyclerView(Context context) {
        super(context);
    }

    public RichRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RichRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean canPullDown() {
        Adapter adapter =  getAdapter();

        if(adapter==null || adapter.getItemCount() == 0){
            return true;
        }
        LinearLayoutManager lm= (LinearLayoutManager) getLayoutManager();
        if (lm.findFirstCompletelyVisibleItemPosition() == 0)
        {
            // 滑到ListView的顶部了
            return true;
        }
        return false;
    }

    @Override
    public boolean canPullUp() {

        LinearLayoutManager lm = (LinearLayoutManager) getLayoutManager();
        if(null == lm){
            return false;
        }
        if(lm.findLastCompletelyVisibleItemPosition()==getAdapter().getItemCount() - 1)
            return true;
        return false;
    }
}
