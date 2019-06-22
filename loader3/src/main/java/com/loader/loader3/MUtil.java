package com.loader.loader3;

import android.text.TextUtils;
import android.util.Patterns;

public class MUtil {

    /**
     * @param url
     * @return true if url is a valid one otherwise false.
     */
    public static boolean isValidURL(String url) {
        return (!TextUtils.isEmpty(url) && Patterns.WEB_URL.matcher(url).matches());
    }
}
