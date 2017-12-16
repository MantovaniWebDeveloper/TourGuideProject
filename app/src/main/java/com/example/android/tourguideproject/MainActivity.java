package com.example.android.tourguideproject;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.view_pager) ViewPager viewPager;
    @BindView(R.id.sliding_tabs) TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //using butterKnife to bind View
        ButterKnife.bind(this);
        //creating Adapter
        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager(), this);
        //setting adapter to ViewPager
        viewPager.setAdapter(tabAdapter);
        //let the ViewPager populate the tab layout
        tabLayout.setupWithViewPager(viewPager);
    }
}
