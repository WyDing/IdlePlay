package com.iwuyou.idleplay.actions;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.iwuyou.idleplay.R;
import com.iwuyou.idleplay.mode.Action;
import com.iwuyou.idleplay.utils.ImageLoader;
import com.iwuyou.idleplay.view.swipe.BaseRecyclerViewAdapter;
import com.iwuyou.idleplay.view.swipe.BaseViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    public BaseViewHolder onCompatCreateViewHolder(View realContentView, int viewType) {
        switch (viewType) {
            case BRIEF:
                return new ViewHolderBrief(realContentView);
            case SORT:
                return new ViewHolderSort(realContentView);
//            case FORM:
//                return R.layout.item_action_form;
        }
        return new ViewHolderBrief(realContentView);
    }

    @Override
    protected void showViewHolder(BaseViewHolder holder, int position) {

        switch (getItemViewType(position)) {
            case BRIEF:
                ViewHolderBrief viewHolderBrief = (ViewHolderBrief) holder;
                Action action = getItemData(position);
                viewHolderBrief.textName.setText(action.getName());
                viewHolderBrief.textAddress.setText(action.getAddress());
                viewHolderBrief.textMoney.setText("" + action.getMoney());
                viewHolderBrief.textStartLabel.setText(action.getStartLabel());
                ImageLoader.loadImage(viewHolderBrief.imgDetail, action.getImageDetailUrl());
                break;
            case SORT:
                break;
            case FORM:
                break;
        }

    }

    @Override
    protected int setContentView(int viewType) {
        switch (viewType) {
            case BRIEF:
                return R.layout.item_action_brief;
            case SORT:
                return R.layout.item_action_sort;
            case FORM:
                return R.layout.item_action_form;
        }

        return R.layout.item_action_brief;
    }


    @Override
    public int getItemViewType(int position) {
        return getItemData(position).getType();
    }

    static class ViewHolderBrief extends BaseViewHolder {
        @BindView(R.id.img_detail)
        ImageView imgDetail;
        @BindView(R.id.text_name)
        TextView textName;
        @BindView(R.id.text_address)
        TextView textAddress;
        @BindView(R.id.text_start_label)
        TextView textStartLabel;
        @BindView(R.id.text_money)
        TextView textMoney;

        ViewHolderBrief(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    static class ViewHolderSort extends BaseViewHolder{
        @BindView(R.id.img_arrow)
        ImageView imgArrow;
        @BindView(R.id.text_sort)
        TextView textSort;

        ViewHolderSort(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
