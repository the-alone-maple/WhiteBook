package com.lwh.whitebook.interfaze;

import com.android.volley.VolleyError;

/**
 * Created by Administrator on 2017/2/17.
 */

public interface OnStringListener {

    /**
     * when success use this.
     * @param success
     */
    void onSuccess(String success);


    /**
     * when occur error
     * @param error
     */
    void onError(VolleyError error);

}
