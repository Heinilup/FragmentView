package com.ikabi.fragmentview;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ikabi.fragmentview.fragment.ContactsFragment;
import com.ikabi.fragmentview.fragment.SessionFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2015-09-01 0001.
 */
public class MainActivity extends ActionBarActivity {


    @InjectView(R.id.main_tv_title)
    TextView mTvTitle;
    @InjectView(R.id.main_viewpager)
    ViewPager mViewpager;
    @InjectView(R.id.main_bottom)
    LinearLayout mBottom;

    private List<Fragment> mFragments = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ButterKnife.inject(this);
        initData();
    }

    private void initData() {
        //viewPapger----View --- pagerAdapter
        //viewPapger----fragment---FragmentPagerAdapter---fragment数量比较少
        //viewPapger----fragment---FragmentStatePagerAdapter

        //添加fragment 到集合中
        mFragments.add(new SessionFragment());
        mFragments.add(new ContactsFragment());
        mViewpager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }


    class MyPagerAdapter extends FragmentPagerAdapter{

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

}
