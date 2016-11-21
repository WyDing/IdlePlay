package com.iwuyou.idleplay.actions;

import android.os.Bundle;
import android.view.View;

import com.iwuyou.idleplay.R;
import com.iwuyou.idleplay.base.BaseFragment;

/**
 * Created by duanding on 16/11/21.
 */

public class ActionsFragment extends BaseFragment{

    private static final String ARG_POSITION = "position";

    @Override
    public int initContentViewID() {
        return R.layout.fragment_actions;
    }

    @Override
    public void init(View view) {
    }

    public static ActionsFragment newInstance(int position) {
        ActionsFragment f = new ActionsFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }
}
