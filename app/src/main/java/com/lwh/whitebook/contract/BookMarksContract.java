package com.lwh.whitebook.contract;

import com.lwh.whitebook.BasePresenter;
import com.lwh.whitebook.BaseView;
import com.lwh.whitebook.beans.ZhiHuDailyNews;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/2/23.
 */

public interface BookMarksContract {

    interface View extends BaseView<presenter>
    {
        void showError();

        void startLoading();

        void stopLoading();

        void showResults(ArrayList<ZhiHuDailyNews.Question> results);

        void  showPikerDataDialog();

    }


    interface presenter extends BasePresenter
    {
        void  doPosts(long date,boolean clearing);

        void refresh();

        void loadMore(long date);

        void startReading(int position);

        void feelLucky();
    }
}
