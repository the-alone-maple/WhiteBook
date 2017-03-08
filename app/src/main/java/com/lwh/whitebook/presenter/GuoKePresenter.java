package com.lwh.whitebook.presenter;

import android.content.Context;

import com.lwh.whitebook.contract.GuoKeContract;

/**
 * Created by Administrator on 2017/3/3.
 */

public class GuoKePresenter implements GuoKeContract.presenter {
    private Context ctx;
    private GuoKeContract.View view;


    public  GuoKePresenter(Context ctx,GuoKeContract.View view)
    {
        this.view = view;
        this.ctx = ctx;
    }

    @Override
    public void doPosts(long date, boolean clearing) {
        view.startLoading();


        view.stopLoading();
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
