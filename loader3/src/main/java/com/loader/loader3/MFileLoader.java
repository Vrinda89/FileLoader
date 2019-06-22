package com.loader.loader3;

import android.widget.ImageView;

public class MFileLoader {

    private static MFileLoader mFileLoader;

    public static MFileLoader getInstance() {
        if (mFileLoader == null) {
            mFileLoader = new MFileLoader();
        }
        return mFileLoader;
    }

    /**
     *
     * @param url
     * @param listener
     */
    public void loadJson(String url, final JsonResponseListener listener) {
        if (!MUtil.isValidURL(url)) {
            if (listener != null) {
                listener.onResponse(new MLoaderResponse(MLoaderStatus.FAILED,MLoaderConstants.INVALID_URL));
            }
            return;
        }
        JsonLoader.getInstance().loadJson(url, new JsonResponseCallback() {
            @Override
            public void onResponse(MLoaderResponse mLoaderResponse) {
                listener.onResponse(mLoaderResponse);
            }
        });

    }


    /**
     *
     * @param url
     * @param imageView
     * @param listener
     */

    public void loadImage(String url, ImageView imageView, final ImageResponseListener listener) {
        if (!MUtil.isValidURL(url)) {
            if (listener != null) {
                listener.onResponse(new MLoaderResponse(MLoaderStatus.FAILED,
                        MLoaderConstants.INVALID_URL));
            }
            return;
        }
        ImageLoader.getInstance().loadImage(url, imageView, new LoaderListener() {
            @Override
            public void onResponse(MLoaderResponse response) {
                switch (response.getStatus()) {
                    case SUCCESS:
                        listener.onResponse(response);
                }
            }
        });

    }

    /**
     *
     * @param url
     * @param imageView
     */

    public void loadImage(String url, ImageView imageView) {
        if (!MUtil.isValidURL(url)) {
            return;
        }
        ImageLoader.getInstance().loadImage(url, imageView);
    }



}
