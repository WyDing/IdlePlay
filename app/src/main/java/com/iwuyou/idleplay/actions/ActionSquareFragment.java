package com.iwuyou.idleplay.actions;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iwuyou.idleplay.R;
import com.iwuyou.idleplay.base.BaseFragment;
import com.iwuyou.idleplay.view.CategoryTabStrip;
import com.iwuyou.libmine.utils.UITools;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by duanding on 16/11/20.
 */

public class ActionSquareFragment extends BaseFragment {
    @BindView(R.id.category_strip)
    CategoryTabStrip mCategoryStrip;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    private PagerAdapter mAdapter;
    private List<Pair<String, Integer>> mActionLabels;

    @Override
    public int initContentViewID() {
        return R.layout.fragment_action_square;
    }

    @Override
    public void init(View view) {
        mActionLabels = new ArrayList<>();
        mAdapter = new PagerAdapter(getChildFragmentManager(), mActionLabels);
        String[] actionStrs = getResources().getStringArray(R.array.actions_labels);
        for (int i = 0; i < actionStrs.length; i++) {
            Pair<String, Integer> pair = new Pair<>(actionStrs[i], i);
            mActionLabels.add(pair);
        }
        mAdapter.notifyDataSetChanged();
        mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
        mCategoryStrip = (CategoryTabStrip) view.findViewById(R.id.category_strip);
        mViewPager.setAdapter(mAdapter);
        mCategoryStrip.setViewPager(mViewPager);
    }


}
