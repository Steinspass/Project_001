package com.appy.ndpsh.project_001.Activities;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

import com.appy.ndpsh.project_001.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //setToolbar();
        setTabLayout();

    }

    private void setTabLayout(){
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_title_first)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_title_second)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_title_third)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_title_quarter)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_title_five)));
    }




}
