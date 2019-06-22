package com.loader.loader3;

public class JsonLoader implements BytesCallback {

    private static JsonLoader jsonLoader;
    private DownloadHelper dh;

    private JsonResponseCallback callback;
    private CacheDeveloper cacheRetriever;

    private JsonLoader() {

    }

    public static JsonLoader getInstance() {
        if (jsonLoader == null) {
            jsonLoader = new JsonLoader();
            jsonLoader.init();
        }
        return jsonLoader;
    }

    private void init() {
        dh = new DownloadHelper(new StreamManager(), this);
        int PERCENTAGE_OF_MEMORY_FOR_CACHING = 15;
        cacheRetriever = new CacheDeveloper(new MemoryCache(PERCENTAGE_OF_MEMORY_FOR_CACHING), this);

    }

    @Override
    public void onProgress() {
        callback.onResponse(new MLoaderResponse(null,null,MLoaderStatus.SUCCESS,""));
    }

    @Override
    public void onFailed(String error) {
        callback.onResponse(new MLoaderResponse(MLoaderStatus.SUCCESS,error));
    }

    @Override
    public void onCancelled() {
        callback.onResponse(new MLoaderResponse(null,null,MLoaderStatus.SUCCESS,MLoaderConstants.CANCELLED));
    }

    @Override
    public void onComplete(byte[] is, int type, String url) {
        if (is != null) {
            String jsonString = new String(is);
            if (callback != null)
                cacheRetriever.put(url,type,is);
                callback.onResponse(new MLoaderResponse(jsonString,MLoaderStatus.SUCCESS,MLoaderConstants.CANCELLED));
        }
    }

    public <T> void loadJson(String url, JsonResponseCallback callback) {
        this.callback = callback;
        if (cacheRetriever.fetchByte(url)) {
            return ;
        }
        dh.fetchByte(url);
    }





}
