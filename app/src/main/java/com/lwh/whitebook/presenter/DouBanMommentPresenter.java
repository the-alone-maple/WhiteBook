package com.lwh.whitebook.presenter;

import android.content.Context;

import com.lwh.whitebook.about.DouBanMommentFragment;
import com.lwh.whitebook.contract.DouBanMommentContrat;

/**
 * Created by Administrator on 2017/3/2.
 */

public class DouBanMommentPresenter implements DouBanMommentContrat.presenter {
    private Context ctx;
    private DouBanMommentContrat.View view;

    /**
     * the presenter constructor with two params
     * @param ctx Context
     */
    public DouBanMommentPresenter(Context ctx,DouBanMommentContrat.View view)
    {
        this.ctx = ctx;
        this.view = view;
    }

    @Override
    public void doPosts(long date, boolean clearing) {

    }

    @Override
    public void refresh() {

    }

    @Override
    public void loadMore(long date) {

    }

    @Override
    public void startReading(int position) {

    }

    @Override
    public void feelLucky() {

    }

    @Override
    public void start() {

    }
}
