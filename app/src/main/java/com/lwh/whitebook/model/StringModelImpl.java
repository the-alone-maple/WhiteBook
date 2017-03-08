package com.lwh.whitebook.model;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.lwh.whitebook.interfaze.OnStringListener;
import com.lwh.whitebook.utils.VolleySingleton;

/**
 * Created by Administrator on 2017/2/17.
 */

public class StringModelImpl {
    private Context ctx;

    public StringModelImpl(Context ctx) {
        this.ctx = ctx;
    }

    /**
     * load url
     * @param url
     * @param listener
     */
    public void loadUrl(String url, final OnStringListener listener)
    {
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                listener.onSuccess(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                listener.onError(volleyError);
            }
        });
        //add to request queue
        VolleySingleton.getVolleySingleton(ctx).addToRequestQueue(stringRequest);
    }
}
