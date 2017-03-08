package com.lwh.whitebook.contract;

import com.lwh.whitebook.BasePresenter;
import com.lwh.whitebook.BaseView;
import com.lwh.whitebook.beans.ZhiHuDailyNews;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/2/16.
 *  ZhiHu contract to manage presenter and view
 */

public interface ZhiHuDailyContract {


    interface View extends BaseView<presenter>{
        //show the error message
        void showError(String error);

        //show the start loading message
        void startLoading();

        //show stop loading message
        void stopLoading();

        //show the result and display result in the view
        void showResult(ArrayList<ZhiHuDailyNews.Question> list);

        //show the data piker dialog
        void showDataPikerDialog();


    }

    interface presenter extends BasePresenter{
        //get data
        void  doPosts(long date,boolean clearing);

        //refresh view
        void  refresh();

        //load more data
        void loadMore(long date);

        //to go to the details view
        void startReading(int position);

        //just look
        void feelLucky();

    }
}
