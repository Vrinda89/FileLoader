package com.loader.loader3;

public class DownloadHelper implements GetCache {

    private StreamManager sm;
    private BytesCallback callback;


    DownloadHelper(StreamManager sm, BytesCallback callback) {
        this.sm = sm;
        this.callback = callback;
    }

    @Override
    public boolean fetchByte(String url) {
        Logger.d("Downloading ...");
        AsyncDownloader downloader = new AsyncDownloader(sm, callback, url);
        downloader.execute();
        return false;
    }
}
