package com.iwuyou.idleplay.actions;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.iwuyou.idleplay.R;
import com.iwuyou.idleplay.mode.Action;
import com.iwuyou.idleplay.view.swipe.BaseRecyclerViewAdapter;
import com.iwuyou.idleplay.view.swipe.BaseViewHolder;

import java.util.List;

import static com.iwuyou.idleplay.mode.Action.BRIEF;
import static com.iwuyou.idleplay.mode.Action.FORM;
import static com.iwuyou.idleplay.mode.Action.SORT;

/**
 * Created by duanding on 16/11/23.
 */

public class ActionsAdapter extends BaseRecyclerViewAdapter<Action> {

    public ActionsAdapter(Context context, List<Action> data) {
        super(context, data);
    }

    @Override
    protected void showViewHolder(BaseViewHolder holder, int position) {

    }

    @Override
    protected int setContentView(int viewType) {

//        switch (viewType){
//            case BRIEF:
//                return R.layout.item_action_brief;
//            case SORT:
//                return R.layout.item_action_sort;
//            case FORM:
//                return R.layout.item_action_form;
//        }
        return R.layout.item_action_brief;
    }


}
