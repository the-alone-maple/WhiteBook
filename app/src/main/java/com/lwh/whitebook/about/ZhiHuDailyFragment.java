package com.lwh.whitebook.about;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jaydenxiao.common.commonwidget.LoadingDialog;
import com.lwh.whitebook.R;
import com.lwh.whitebook.adapter.ZhiHuDailyNewsAdapter;
import com.lwh.whitebook.beans.ZhiHuDailyNews;
import com.lwh.whitebook.contract.ZhiHuDailyContract;
import com.lwh.whitebook.costomview.MyItemDecoration;
import com.lwh.whitebook.interfaze.OnRecyclerItemClickListener;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Administrator on 2017/2/16.
 * ZhiHuDaily fragment
 */

public class ZhiHuDailyFragment extends Fragment implements ZhiHuDailyContract.View, SwipeRefreshLayout.OnRefreshListener {
    private RecyclerView iRecyclerView;
    private SwipeRefreshLayout refreshLayout;

    private FloatingActionButton fab;
    private Toolbar toolbar;


    private ZhiHuDailyNewsAdapter adapter;
    private ZhiHuDailyContract.presenter presenter;

    private int mYear = Calendar.getInstance().get(Calendar.YEAR);
    private int mMonth = Calendar.getInstance().get(Calendar.MONTH);
    private int mDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

    /**
     * to provide a ZhiHuDailyFragment instance
     *
     * @return
     */
    public static ZhiHuDailyFragment getInstance() {
        return new ZhiHuDailyFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_list, container, false);

        initView(view);

        presenter.start();

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void initView(View view) {
        iRecyclerView = (RecyclerView) view.findViewById(R.id.irecycle_list);
        iRecyclerView.setHasFixedSize(true);
        iRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        iRecyclerView.addItemDecoration(new MyItemDecoration(getActivity(),LinearLayoutManager.VERTICAL));

        iRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            boolean isScrollToBottom = false;
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    LinearLayoutManager lManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                    int allItemCount = lManager.getItemCount();
                    int lastItemPos = lManager.findLastCompletelyVisibleItemPosition();

                    if (lastItemPos == (allItemCount -1)&& isScrollToBottom){
                        Calendar c = Calendar.getInstance();
                        c.set(mYear,mMonth,--mDay);
                        presenter.loadMore(c.getTimeInMillis());
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                isScrollToBottom
                        = dy>0;

                if (dy > 0)
                {
                    fab.hide();
                }else{
                    fab.show();
                }
            }
        });

        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh);

        fab = (FloatingActionButton) getActivity().findViewById(R.id.floating_btn);
        toolbar = (Toolbar) getActivity().findViewById(R.id.main_toolbar);


        refreshLayout.setOnRefreshListener(this);
    }



    @Override
    public void startLoading() {
        refreshLayout.setRefreshing(true);
    }

    @Override
    public void stopLoading() {
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void showResult(ArrayList<ZhiHuDailyNews.Question> list) {
        if (adapter == null) {
            adapter = new ZhiHuDailyNewsAdapter(getActivity(),list);

            adapter.setOnReCyclerItemClickListener(new OnRecyclerItemClickListener() {
                @Override
                public void onRecycleItemClick(View view, int pos) {
                    presenter.startReading(pos);
                }
            });

            iRecyclerView.setAdapter(adapter);
        }else {
            adapter.notifyDataSetChanged();
        }


    }

    @Override
    public void showDataPikerDialog() {
        DatePickerDialog datePicker = DatePickerDialog
                .newInstance(
                        new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

            }
        }
                        ,mYear
                        ,mMonth
                        ,mDay);
    }


    @Override
    public void onRefresh() {
        presenter.refresh();
    }


    @Override
    public void setPresenter(ZhiHuDailyContract.presenter presenter) {
        if (presenter != null)
        {
            this.presenter = presenter;
        }
    }

    @Override
    public void showError(String error) {
        LoadingDialog.showDialogForLoading(getActivity(), error, true);
    }
}
