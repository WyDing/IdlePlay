package com.iwuyou.idleplay.view.swipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.libswipeview.swipe.SwipeMenuAdapter;

import java.util.List;


/**
 * Created by duanding on 16/10/27.
 */

public abstract class BaseRecyclerViewAdapter<T> extends SwipeMenuAdapter<BaseViewHolder> {
    protected Context mContext;
    private List<T> mData;
    private OnItemClickListener<T> mOnItemClickListener;

    public BaseRecyclerViewAdapter(Context context, List<T> data) {
        this.mContext = context;
        this.mData = data;
    }

    @Override
    public View onCreateContentView(ViewGroup parent, int viewType) {
        return LayoutInflater.from(mContext).inflate(setContentView(viewType),null);
    }

    @Override
    public BaseViewHolder onCompatCreateViewHolder(View realContentView, int viewType) {
        return new BaseViewHolder(realContentView);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

    }

    @Override
    public void onCompatBindViewHolder(BaseViewHolder holder, final int position, List<Object> payloads) {
        showViewHolder(holder,position);
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(null != mOnItemClickListener){
                    mOnItemClickListener.onItemLongClick(v,position,mData.get(position));
                }
                return true;
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(null != mOnItemClickListener){
                    mOnItemClickListener.onItemClick(v,position,mData.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return null == mData ? 0 : mData.size();
    }

    public void addData(T t) {
        mData.add(t);
        notifyDataSetChanged();
    }

    public void addData(List<T> ts) {
        for (int i = 0; i < ts.size(); i++) {
            mData.add(ts.get(i));
        }
        notifyDataSetChanged();
    }

    public T getItemData(int position){
        return null == mData ? null : mData.get(position);
    }

    public void remove(int i){
        mData.remove(i);
        notifyItemRemoved(i);
    };

    public List<T> getDatas(){
        return mData;
    }


    // 点击事件接口
    public interface OnItemClickListener<T> {
        void onItemClick(View view, int position, T model);

        void onItemLongClick(View view, int position, T model);
    }

    public void setOnItemClickListener(OnItemClickListener<T> listener) {
        this.mOnItemClickListener = listener;
    }

    /**
     * 数据与itemview绑定
     * @param holder
     * @param position
     */
    protected abstract void showViewHolder(BaseViewHolder holder, int position);

    /**
     * 通过viewtype返回对应的layout资源
     * @param viewType
     * @return
     */
    protected abstract int setContentView(int viewType);

}
