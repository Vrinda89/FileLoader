package com.loader.loader3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import androidx.annotation.CallSuper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ImageLoader implements BytesCallback {

    private static ImageLoader imageLoader;
    private static DownloadHelper dh;
    private HashMap<String, List<ImageView>> viewHandler = new HashMap();//To store data if url is repeated and not fetched at least one response for the same.
    private CacheDeveloper cacheRetriever;
    private LoaderListener loaderListener;

    private ImageLoader() {

    }

    public static ImageLoader getInstance() {
        if (imageLoader == null) {
            imageLoader = new ImageLoader();
            imageLoader.init();
        }
        return imageLoader;
    }

    private void init() {
        dh = new DownloadHelper(new StreamManager(), this);
        int PERCENTAGE_OF_MEMORY_FOR_CACHING = 15;
        cacheRetriever = new CacheDeveloper(new MemoryCache(PERCENTAGE_OF_MEMORY_FOR_CACHING), this);
    }


    /**
     * Load image from url to the given imageview
     *
     * @param url
     * @param view
     * @param listener
     * @return
     */
    public ImageLoader loadImage(String url, ImageView view, LoaderListener listener) {
        loaderListener = listener;
        String id = url;
        Logger.d("Creating id " + id);
        Logger.d("Url  " + url);
        updateViewHandler(view, id);
        if (cacheRetriever.fetchByte(url)) {
            return imageLoader;
        }
        dh.fetchByte(url);
        return imageLoader;
    }

    /**
     * Load image from url to the given imageview
     *
     * @param url
     * @param view
     * @return
     */
    public ImageLoader loadImage(String url, ImageView view) {
        String id = url;
        Logger.d("Creating id " + id);
        Logger.d("Url  " + url);
        updateViewHandler(view, id);
        if (cacheRetriever.fetchByte(url)) {
            return imageLoader;
        }
        dh.fetchByte(url);
        return imageLoader;
    }

    private void updateViewHandler(final ImageView view, String id) {
        List<ImageView> imageViews = new ArrayList<>();
        imageViews.add(view);
        List<ImageView> list = viewHandler.get(id);
        if (list != null) {
            imageViews.addAll(list);
        } else {

        }
        viewHandler.put(id, imageViews);
    }

    @Override
    public void onProgress() {
        if (loaderListener != null) {
            loaderListener.onResponse(new MLoaderResponse(MLoaderStatus.LOADING));
        }
    }

    @CallSuper
    @Override
    public void onFailed(String error) {
        if (loaderListener != null) {
            loaderListener.onResponse(new MLoaderResponse( MLoaderStatus.FAILED, error));
        }
    }

    @Override
    public void onCancelled() {
        if (loaderListener != null) {
            loaderListener.onResponse(new MLoaderResponse (MLoaderStatus.CANCELLED));
        }
    }

    @Override
    public void onComplete(byte[] is, int type, String url) {
        Logger.d("On Complete");
        if (is != null) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(is, 0, is.length);
            if (bitmap != null) {
                cacheRetriever.put(url, type, is);
                List<ImageView> viewList = viewHandler.get(url);
                if (viewList != null) {
                    for (ImageView imageView : viewList)
                        imageView.setImageBitmap(bitmap);
                    viewHandler.remove(url);
                }
                return;
            }
        }
         if(loaderListener != null) {
            loaderListener.onResponse(new MLoaderResponse(MLoaderStatus.FAILED, MLoaderConstants.INVALID_URL));
        }

    }


}
