package com.lwh.whitebook.utils;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2017/2/16.
 */

public class VolleySingleton {

    private static VolleySingleton volleySingleton;

    private RequestQueue requestQueue;

    /**
     *
     * @param ctx
     */
    private VolleySingleton(Context ctx) {
        requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());

    }

    public  static  synchronized VolleySingleton getVolleySingleton(Context context)
    {
        if (volleySingleton == null){
            volleySingleton = new VolleySingleton(context);
        }

        return volleySingleton;
    }


    /**
     * return requestQueue
     * @return
     */
    public RequestQueue getRequestQueue()
    {
        return this.requestQueue;
    }


    /**
     * add to requestQueue
     * @param req
     * @param <T>
     */
    public <T> void addToRequestQueue(Request<T> req)
    {
        getRequestQueue().add(req);
    }



}
