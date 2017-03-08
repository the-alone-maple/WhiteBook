package com.lwh.whitebook.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.sax.RootElement;

/**
 * Created by Administrator on 2017/2/17.
 *  get netWork state info
 */

public class NetWorkStateUtil {

    /**
     *
     * @param ctx
     * @return
     */
    public static boolean isNetWorkAvalueable(Context ctx)
    {
        if (ctx!= null)
        {
            ConnectivityManager connectivityManager
                    = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = connectivityManager.getActiveNetworkInfo();
            if (info != null){
                return info.isAvailable();
            }
        }
        return false;
    }


    /**
     *
     * @param ctx
     * @return
     */
    public static boolean isWifiAvalueable(Context ctx)
    {
        if (ctx!= null)
        {
            ConnectivityManager connectivityManager
                    = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = connectivityManager.getActiveNetworkInfo();
            if (info != null){
               if (info.getType()==ConnectivityManager.TYPE_WIFI){
                   return true;
               }
            }
        }
        return false;
    }


    /**
     *
     * @param ctx
     * @return
     */
    public static boolean isMobileAvalueable(Context ctx)
    {
        if (ctx!= null)
        {
            ConnectivityManager connectivityManager
                    = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = connectivityManager.getActiveNetworkInfo();
            if (info != null){
                if (info.getType() == ConnectivityManager.TYPE_MOBILE){
                    return true;
                }
            }
        }
        return false;
    }



}
