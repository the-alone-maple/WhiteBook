package com.lwh.whitebook.about;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aspsine.irecyclerview.IRecyclerView;
import com.lwh.whitebook.R;
import com.lwh.whitebook.beans.ZhiHuDailyNews;
import com.lwh.whitebook.contract.DouBanMommentContrat;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/2/16.
 * ZhiHuDaily fragment
 */

public class DouBanMommentFragment extends Fragment implements DouBanMommentContrat.View, SwipeRefreshLayout.OnRefreshListener {
    private RecyclerView iRecyclerView;

    private SwipeRefreshLayout refreshLayout;

    /**
     * to provide a ZhiHuDailyFragment instance
     * @return
     */
    public  static DouBanMommentFragment getInstance()
    {
        return new DouBanMommentFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view  =  inflater.inflate(R.layout.frag_list,container,false);

        iRecyclerView = (RecyclerView) view.findViewById(R.id.irecycle_list);

        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh);

        refreshLayout.setOnRefreshListener(this);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public void initView(View view) {

    }

    @Override
    public void setPresenter(DouBanMommentContrat.presenter presenter) {

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




    @Override
    public void onRefresh() {

    }
}
