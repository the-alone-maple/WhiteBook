package com.lwh.whitebook;

import android.view.View;

/**
 * Created by Administrator on 2017/2/16.
 * basic view
 */

public interface BaseView<T> {

    /**
     * set presenter for this view
     * @param presenter
     */
    void setPresenter(T presenter);

    /**
     * init View
     */
    void initView(View view);
}
