package com.lwh.whitebook.about;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lwh.whitebook.beans.ZhiHuDailyNews;
import com.lwh.whitebook.contract.GuoKeContract;
import com.lwh.whitebook.contract.ZhiHuDailyContract;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/2/16.
 * ZhiHuDaily fragment
 */

public class GuoKeFragment extends Fragment implements GuoKeContract.View{

    /**
     * To provide a ZhiHuDailyFragment instance
     * @return
     */
    public  static GuoKeFragment getInstance()
    {
        return new GuoKeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public void initView(View view) {

    }

    @Override
    public void setPresenter(GuoKeContract.presenter presenter) {

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
    public void showResult(ArrayList<ZhiHuDailyNews.Question> list) {

    }

    @Override
    public void showDataPikerDialog() {

    }



}
