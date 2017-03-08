package com.lwh.whitebook.presenter;

import android.content.Context;
import com.lwh.whitebook.contract.BookMarksContract;

/**
 * Created by Administrator on 2017/2/23.
 */

public class BookMarksPresenter implements BookMarksContract.presenter {

    private Context ctx;

    private BookMarksContract.View view;

    public BookMarksPresenter(Context ctx,BookMarksContract.View view)
    {
        this.ctx = ctx;
        this.view = view;
    }

    @Override
    public void start() {

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
}
