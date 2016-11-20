package com.iwuyou.idleplay.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by duanding on 16/11/20.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }


    protected void showLodingDialog(){

    }

    protected void hideLodingDialog(){

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
