package com.iwuyou.idleplay.actions;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iwuyou.idleplay.R;
import com.iwuyou.idleplay.base.BaseFragment;
import com.iwuyou.idleplay.mode.Action;
import com.iwuyou.idleplay.view.swipe.RichRecyclerView;
import com.iwuyou.libmine.view.pullrefreshandloadview.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by duanding on 16/11/21.
 */

public class ActionsFragment extends BaseFragment {

    private static final String ARG_POSITION = "position";
    @BindView(R.id.recycler_view)
    RichRecyclerView mRecyclerView;
    @BindView(R.id.view_pull_layout)
    PullToRefreshLayout mViewPullLayout;

    private List<Action> mActions;

    private ActionsAdapter mAdapter;

    private Activity activity;

    @Override
    public int initContentViewID() {
        return R.layout.fragment_actions;
    }

    @Override
    public void init(View view) {
        activity = getActivity();
        mActions = new ArrayList<>();
        mAdapter = new ActionsAdapter(activity,mActions);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(activity));
        mRecyclerView.setAdapter(mAdapter);
        mActions.add(new Action());
        mActions.add(new Action());
        mAdapter.notifyDataSetChanged();
    }

    public static ActionsFragment newInstance(int position) {
        ActionsFragment f = new ActionsFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }
}
