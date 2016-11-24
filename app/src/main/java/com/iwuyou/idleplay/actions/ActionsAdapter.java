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

/**
 * Created by duanding on 16/11/23.
 */

public class ActionsAdapter extends BaseRecyclerViewAdapter<Action> {

    public ActionsAdapter(Context context, List<Action> data) {
        super(context, data);
    }

    @Override
    public BaseViewHolder onCompatCreateViewHolder(View realContentView, int viewType) {
        return new ViewHolder(realContentView);
    }

    @Override
    protected void showViewHolder(BaseViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Action action = getItemData(position);
        viewHolder.textName.setText(action.getName());
        viewHolder.textAddress.setText(action.getAddress());
        viewHolder.textMoney.setText("" + action.getMoney());
        viewHolder.textStartLabel.setText(action.getStartLabel());
        ImageLoader.loadImage(viewHolder.imgDetail, action.getImageDetailUrl());
    }

    @Override
    protected int setContentView(int viewType) {


        return R.layout.item_action_brief;
    }


    static class ViewHolder extends BaseViewHolder {
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

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
