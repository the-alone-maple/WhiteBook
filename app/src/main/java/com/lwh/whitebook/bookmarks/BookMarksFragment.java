package com.lwh.whitebook.bookmarks;

import android.support.v4.app.Fragment;
import android.view.View;

import com.lwh.whitebook.beans.ZhiHuDailyNews;
import com.lwh.whitebook.contract.BookMarksContract;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/2/23.
 */

public class BookMarksFragment extends Fragment implements BookMarksContract.View{

    public static BookMarksFragment newInstanc()
    {
        BookMarksFragment bookMarksFragment = new BookMarksFragment();


        return bookMarksFragment;
    }

    @Override
    public void showError() {

    }

    @Override
    public void startLoading() {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showResults(ArrayList<ZhiHuDailyNews.Question> results) {

    }

    @Override
    public void showPikerDataDialog() {

    }

    @Override
    public void setPresenter(BookMarksContract.presenter presenter) {

    }

    @Override
    public void initView(View view) {

    }
}
