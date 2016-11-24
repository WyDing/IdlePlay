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
        mAdapter = new ActionsAdapter(activity, mActions);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(activity));
        mRecyclerView.setAdapter(mAdapter);
        mActions.add(new Action("性价比专线-四明山大竹海-徒步浙东小九寨2日游>门票全含，宿五星，性价比爆棚",
                "周一", "七里庄地铁站", null, 30.5,
                "http://m.tuniucdn.com/filebroker/cdn/prd/ed/2e/ed2e4825aeeced53d28266b2c8bc1b4b_w450_h300_c1_t0_w500_h280_c1_t0.jpg",
                Action.BRIEF));

        mActions.add(new Action("宿希尔顿大酒店，含156元双份自助早，赠送价值1588元年夜饭", "周二到周三", "国贸地铁站F口", null,
                200, "http://m.tuniucdn.com/fb2/t1/G2/M00/07/E7/Cii-TFgsHSGIG5MWAAiS7RergWcAAEdQwKoow4ACJMF906_w450_h300_c1_t0_w500_h280_c1_t0.jpg"
                , Action.BRIEF));
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
