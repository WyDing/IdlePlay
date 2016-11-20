package com.iwuyou.idleplay.view.swipe;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by duanding on 16/10/26.
 */

public class SwipeMenuAdapter<VH extends RecyclerView.ViewHolder> extends com.libswipeview.swipe.SwipeMenuAdapter<VH>{

    @Override
    public View onCreateContentView(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public VH onCompatCreateViewHolder(View realContentView, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
