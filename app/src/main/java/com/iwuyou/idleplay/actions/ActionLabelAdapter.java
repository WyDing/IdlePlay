package com.iwuyou.idleplay.actions;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.iwuyou.idleplay.R;
import com.iwuyou.idleplay.mode.ActionLabel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by duanding on 16/11/26.
 */

public class ActionLabelAdapter extends RecyclerView.Adapter<ActionLabelAdapter.ViewHolder> {
    private Context context;
    private List<ActionLabel> actionLabels;


    public ActionLabelAdapter(Context context, List<ActionLabel> actionLabels) {
        this.context = context;
        this.actionLabels = actionLabels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_action_form_view, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != onItemClickListener) {
                    onItemClickListener.onItemClick(holder.itemView, position, actionLabels.get(position));
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (null != onItemClickListener) {
                    onItemClickListener.onItemLongClick(holder.itemView, position, actionLabels.get(position));
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return null == actionLabels ? 0 : actionLabels.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_ic)
        ImageView imageIc;
        @BindView(R.id.image_name)
        TextView imageName;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    private OnItemClickListener<ActionLabel> onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener<ActionLabel> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    // 点击事件接口
    public interface OnItemClickListener<T> {
        void onItemClick(View view, int position, T model);

        void onItemLongClick(View view, int position, T model);
    }

}
