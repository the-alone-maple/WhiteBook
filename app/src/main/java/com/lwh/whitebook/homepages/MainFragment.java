package com.lwh.whitebook.homepages;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.lwh.whitebook.R;
import com.lwh.whitebook.about.DouBanMommentFragment;
import com.lwh.whitebook.about.GuoKeFragment;
import com.lwh.whitebook.about.ZhiHuDailyFragment;
import com.lwh.whitebook.adapter.MainPagerAdapter;
import com.lwh.whitebook.presenter.DouBanMommentPresenter;
import com.lwh.whitebook.presenter.GuoKePresenter;
import com.lwh.whitebook.presenter.ZhiHuDailyPresenter;

import java.util.Random;

/**
 * Created by Administrator on 2017/2/23.
 * Main Fragment
 */

public class MainFragment extends Fragment {

    private TabLayout tablayout;
    private ViewPager viewPager;
    private FloatingActionButton floatingBtn;

    private MainPagerAdapter adapter;

    //fragment
    private ZhiHuDailyFragment zhiHuDailyFragment;
    private DouBanMommentFragment douBanMommentFragment;
    private GuoKeFragment guoKeFragment;

    //presenter
    private ZhiHuDailyPresenter zhiHuDailyPresenter;
    private GuoKePresenter guoKePresenter;
    private DouBanMommentPresenter douBanMommentPresenter;


    public static MainFragment newInstanc() {
        MainFragment mainFragment = new MainFragment();
        return mainFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            FragmentManager manager = getChildFragmentManager();
            zhiHuDailyFragment = (ZhiHuDailyFragment) manager.getFragment(savedInstanceState, "ZhiHuFragment");
            guoKeFragment = (GuoKeFragment) manager.getFragment(savedInstanceState, "GuoKeFragment");
            douBanMommentFragment = (DouBanMommentFragment) manager.getFragment(savedInstanceState, "DouBanFragment");
        } else {
            zhiHuDailyFragment = ZhiHuDailyFragment.getInstance();
            guoKeFragment = GuoKeFragment.getInstance();
            douBanMommentFragment = DouBanMommentFragment.getInstance();
        }

        zhiHuDailyPresenter = new ZhiHuDailyPresenter(getActivity(), zhiHuDailyFragment);
        douBanMommentPresenter = new DouBanMommentPresenter(getActivity(), douBanMommentFragment);
        guoKePresenter = new GuoKePresenter(getActivity(), guoKeFragment);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.frag_main, null);

        initViews(contentView);

        setHasOptionsMenu(true);


        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 1) {
                    floatingBtn.hide();
                } else {
                    floatingBtn.show();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        return contentView;
    }

    /**
     * initial all views
     *
     * @param contentView
     */
    private void initViews(View contentView) {

        tablayout = (TabLayout) contentView.findViewById(R.id.tab_layout);

        viewPager = (ViewPager) contentView.findViewById(R.id.view_pager);
        adapter = new MainPagerAdapter(getChildFragmentManager()
                , getActivity()
                , zhiHuDailyFragment
                , douBanMommentFragment
                , guoKeFragment);

        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
        tablayout.setupWithViewPager(viewPager);

        floatingBtn = (FloatingActionButton) contentView.findViewById(R.id.floating_btn);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main, menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_feel_lucky:
                feelLucky();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * random to selected fragment
     */
    private void feelLucky() {
        Random random = new Random(3);
        int luckyNum = random.nextInt();

        switch (luckyNum) {
            case 0:
                zhiHuDailyPresenter.feelLucky();
                break;

            case 1:
                douBanMommentPresenter.feelLucky();
                break;

            case 2:
                guoKePresenter.feelLucky();
                break;
        }
    }
}
