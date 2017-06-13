package com.example.liuwangping.time_network;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.liuwangping.time_network.adapter.MyFragmentPagerAdapter;
import com.example.liuwangping.time_network.buyticket.BuyFragment;
import com.example.liuwangping.time_network.home.HomeFragment;
import com.example.liuwangping.time_network.livetelecast.LiveTelecastFragment;
import com.example.liuwangping.time_network.marker.MarkerFragment;
import com.example.liuwangping.time_network.me.MeFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.activity_main_viewpager)
    ViewPager activityMainViewpager;
    @Bind(R.id.activity_main_home)
    RadioButton activityMainHome;
    @Bind(R.id.activity_main_shop)
    RadioButton activityMainShop;
    @Bind(R.id.activity_main_marker)
    RadioButton activityMainMarker;
    @Bind(R.id.activity_main_live_telecast)
    RadioButton activityMainLiveTelecast;
    @Bind(R.id.activity_main_me)
    RadioButton activityMainMe;
    @Bind(R.id.activity_main_radiogroup)
    RadioGroup activityMainRadiogroup;
    @Bind(R.id.activity_main)
    LinearLayout activityMain;
    private ArrayList<Fragment> mList=new ArrayList<Fragment>();
    private MyFragmentPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        HomeFragment homeFragment=new HomeFragment();
        BuyFragment shopFragment=new BuyFragment();
        MarkerFragment markerFragment=new MarkerFragment();
        LiveTelecastFragment telecastFragment=new LiveTelecastFragment();
        MeFragment meFragment=new MeFragment();
        mList.add(homeFragment);
        mList.add(shopFragment);
        mList.add(markerFragment);
        mList.add(telecastFragment);
        mList.add(meFragment);
        adapter=new MyFragmentPagerAdapter(getSupportFragmentManager(),mList);
        activityMainViewpager.setAdapter(adapter);
        activityMainViewpager.setOffscreenPageLimit(5);
        activityMainViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0){
                    activityMainHome.setChecked(true);
                }else if( position==1)
                {
                    activityMainShop.setChecked(true);
                }else if(position==2){

                    activityMainMarker.setChecked(true);
                }else if (position==3){
                    activityMainLiveTelecast.setChecked(true);
                }else if (position==4){
                    activityMainMe.setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick({R.id.activity_main_home, R.id.activity_main_shop, R.id.activity_main_marker, R.id.activity_main_live_telecast, R.id.activity_main_me})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_main_home:
                activityMainViewpager.setCurrentItem(0);
                break;
            case R.id.activity_main_shop:
                activityMainViewpager.setCurrentItem(1);
                break;
            case R.id.activity_main_marker:
                activityMainViewpager.setCurrentItem(2);
                break;
            case R.id.activity_main_live_telecast:
                activityMainViewpager.setCurrentItem(3);
                break;
            case R.id.activity_main_me:
                activityMainViewpager.setCurrentItem(4);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
