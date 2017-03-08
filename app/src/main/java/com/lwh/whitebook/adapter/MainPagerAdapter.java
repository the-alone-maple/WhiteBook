package com.lwh.whitebook.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lwh.whitebook.R;
import com.lwh.whitebook.about.DouBanMommentFragment;
import com.lwh.whitebook.about.GuoKeFragment;
import com.lwh.whitebook.about.ZhiHuDailyFragment;
import com.lwh.whitebook.presenter.DouBanMommentPresenter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/3/3.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {
    private Context ctx;
    private List<Fragment>  frags;

    private List<String> titles;

    private ZhiHuDailyFragment zhiHuDailyFragment;

    private DouBanMommentFragment douBanMommentFragment;

    private GuoKeFragment guoKeFragment;

    /**
     *
     * @param fm
     * @param ctx
     * @param zhiHuDailyFragment
     * @param douBanMommentFragment
     * @param guoKeFragment
     */
    public MainPagerAdapter(FragmentManager fm
            ,Context ctx
            ,ZhiHuDailyFragment zhiHuDailyFragment
            ,DouBanMommentFragment douBanMommentFragment
            ,GuoKeFragment guoKeFragment) {
        super(fm);
        titles = Arrays.asList(new String[]{ctx.getResources().getString(R.string.zhi_hu_daily)
                , ctx.getResources().getString(R.string.dou_ban_momment)
                ,ctx.getResources().getString(R.string.guo_ke)});

        this.ctx = ctx;
        this.zhiHuDailyFragment = zhiHuDailyFragment;
        this.douBanMommentFragment = douBanMommentFragment;
        this.guoKeFragment = guoKeFragment;
    }



    @Override
    public Fragment getItem(int position) {
        if (position == 1)
            return douBanMommentFragment;
        else if (position == 2)
            return guoKeFragment;

        return zhiHuDailyFragment;
    }

    @Override
    public int getCount() {
        return titles.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
