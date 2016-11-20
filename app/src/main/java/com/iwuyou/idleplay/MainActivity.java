package com.iwuyou.idleplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.iwuyou.idleplay.base.BaseActivity;
import com.iwuyou.idleplay.index.IndexActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, IndexActivity.class);
        startActivity(intent);
    }


}
