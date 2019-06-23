package com.loader.pro.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isConnectedOrConnecting();
        }
        return false;
    }

    public static String formateDate(String dateString) {
        String pattern = "dd-mm-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            Date date = simpleDateFormat.parse(dateString);
            return date.toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}

