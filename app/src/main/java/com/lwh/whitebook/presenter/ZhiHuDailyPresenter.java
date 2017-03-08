package com.lwh.whitebook.presenter;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.lwh.whitebook.api.Api;
import com.lwh.whitebook.beans.ZhiHuDailyNews;
import com.lwh.whitebook.contract.ZhiHuDailyContract;
import com.lwh.whitebook.db.DatabaseHelper;
import com.lwh.whitebook.interfaze.OnStringListener;
import com.lwh.whitebook.model.StringModelImpl;
import com.lwh.whitebook.utils.DateFormatUtil;
import com.lwh.whitebook.utils.NetWorkStateUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Administrator on 2017/2/16.
 */

public class ZhiHuDailyPresenter implements ZhiHuDailyContract.presenter {
    private ZhiHuDailyContract.View view;
    private Context ctx;
    private ArrayList<ZhiHuDailyNews.Question> questions ;

    private StringModelImpl model;
    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    private DateFormatUtil dateFormatUtil = new DateFormatUtil();
    private Gson gson = new Gson();

    public ZhiHuDailyPresenter(Context ctx,ZhiHuDailyContract.View view)
    {
        this.ctx = ctx;
        this.view = view;
        this.model = new StringModelImpl(ctx);
        this.view.setPresenter(this);
        questions = new ArrayList<ZhiHuDailyNews.Question>();
        dbHelper = new DatabaseHelper(ctx,"History.db",null,5);
        db = dbHelper.getWritableDatabase();
    }

    @Override
    public void start() {
        //load data
       doPosts(Calendar.getInstance().getTimeInMillis(),true);
    }

    @Override
    public void doPosts(long date, final boolean clearing) {
        if (clearing)
            view.startLoading();

        if (NetWorkStateUtil.isNetWorkAvalueable(ctx))
        {
            model.loadUrl(Api.ZHIHU_HISTORY + dateFormatUtil.ZhihuDailyDateFormat(date), new OnStringListener() {
                @Override
                public void onSuccess(String success) {

                    try {
                        ZhiHuDailyNews result = gson.fromJson(success,ZhiHuDailyNews.class);
                        ContentValues values = new ContentValues();

                        if (clearing)
                            questions.clear();

                        for (ZhiHuDailyNews.Question item : result.getStories())
                        {
                            questions.add(item);
                        }
                        //show results in view
                        view.showResult(questions);
                    }catch (JsonSyntaxException e)
                    {
                        view.showError(e.getMessage());
                    }
                    view.stopLoading();
                }

                @Override
                public void onError(VolleyError error) {
                    view.stopLoading();
                    view.showError(error.getMessage());
                }
            });
        }
    }

    @Override
    public void refresh() {
        doPosts(Calendar.getInstance().getTimeInMillis(),true);
    }

    @Override
    public void loadMore(long date) {
        doPosts(date,false);
    }

    @Override
    public void startReading(int position) {

    }

    @Override
    public void feelLucky() {

    }


}
