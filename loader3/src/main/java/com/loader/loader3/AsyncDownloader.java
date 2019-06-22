package com.loader.loader3;

import android.os.AsyncTask;

import java.io.FileNotFoundException;

/**
 *
 *  AsyncTask used to download files
 *  Input :- url:String
 *  OutPut :- byte[]
 *
 */

public class AsyncDownloader extends AsyncTask<Void, Void, byte[]> {


    private final String url;

    private StreamManager sm;
    private BytesCallback callback;

    AsyncDownloader(StreamManager sm, BytesCallback callback, String url) {
        this.sm = sm;
        this.callback = callback;
        this.url = url;

    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        callback.onProgress();
    }

    @Override
    protected byte[] doInBackground(Void... voids) {
        try {
            return sm.retrieveInputStream(url);
        } catch (FileNotFoundException e) {
            callback.onFailed(MLoaderConstants.FILE_NOT_FOUND);
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(byte[] is) {
        super.onPostExecute(is);
        callback.onComplete(is, 0, this.url);
    }
}

