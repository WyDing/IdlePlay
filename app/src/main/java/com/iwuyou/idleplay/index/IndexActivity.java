package com.iwuyou.idleplay.index;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.iwuyou.idleplay.R;
import com.iwuyou.idleplay.actions.ActionSquareFragment;
import com.iwuyou.idleplay.actionshow.ActionShowFragment;
import com.iwuyou.idleplay.base.BaseActivity;
import com.iwuyou.idleplay.favorite.FavoriteFragment;
import com.iwuyou.idleplay.user.UserCenterFragment;
import com.iwuyou.idleplay.view.FragmentTabHost;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by duanding on 16/11/20.
 */

public class IndexActivity extends BaseActivity {

//    @BindView(android.R.id.tabhost)
    FragmentTabHost mTabHost;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        initTabHost();
    }

    private void initTabHost() {
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        mTabHost.addTab(R.string.tab_title_fund, R.drawable.tab_fund_selector, ActionSquareFragment.class);
        mTabHost.addTab(R.string.tab_title_show, R.drawable.tab_show_selector, ActionShowFragment.class);
        mTabHost.addTab(R.string.tab_title_favorite, R.drawable.tab_favorite_selector, FavoriteFragment.class);
        mTabHost.addTab(R.string.tab_mine, R.drawable.tab_me_selector, UserCenterFragment.class);
        mTabHost.getTabWidget().setDividerDrawable(android.R.color.transparent);
    }
}
