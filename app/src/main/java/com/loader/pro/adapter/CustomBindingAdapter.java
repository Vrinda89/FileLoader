package com.loader.pro.adapter;

import android.content.Context;
import android.text.TextUtils;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.BindingAdapter;

import com.loader.loader3.MFileLoader;
import com.loader.pro.R;
import com.loader.pro.utils.Utils;

/**
 * Author : Vrinda
 * Date : 23/6/19
 * Email : vrindavenugopal999@gmail.com
 */
public class CustomBindingAdapter {

    /**
     * Loads image in ImageView with the created library using data binding
     * @param imageView
     * @param url
     */
    @BindingAdapter("image")
    public static void setImageUrl(AppCompatImageView imageView, String url) {
        if (TextUtils.isEmpty(url)) {
            imageView.setImageResource(R.drawable.ic_placeholder);
        } else {
            MFileLoader.getInstance().loadImage(url, imageView);
        }
    }

    /**
     * set text with count of likes appended with "Likes"
     * @param textView
     * @param likes
     */
    @BindingAdapter("likes")
    public static void setLikes(AppCompatTextView textView, int likes) {
        Context context = textView.getContext();
        textView.setText(new StringBuilder().append(likes).append(" ").append(context.getResources().getString(R.string.str_likes)).toString());
    }

  /**
     * format input date string into dd-mm-yyyy and set to the text view
     * @param textView
     * @param date
     */
    @BindingAdapter("f_date")
    public static void setDate(AppCompatTextView textView, String  date) {
        textView.setText(Utils.formateDate(date));
    }

}
