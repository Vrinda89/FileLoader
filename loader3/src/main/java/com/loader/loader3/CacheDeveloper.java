package com.loader.loader3;

public class CacheDeveloper implements GetCache, PutCache {
    private final CacheManager memoryCacheManager;
    private final BytesCallback callback;

    public CacheDeveloper(CacheManager memoryCacheManager, BytesCallback callback) {
        this.memoryCacheManager = memoryCacheManager;
        this.callback = callback;
    }


    @Override
    public boolean fetchByte(String url) {
            CacheFile cacheFile = memoryCacheManager.get(url, 0);
            if (cacheFile != null) {
                Logger.d("Returning from from Cache");
                callback.onComplete(cacheFile.getfile(), cacheFile.getType(), url);
                return true;
            }

        return false;

    }

    @Override
    public void put(String url, int type, byte[] data) {
        Logger.d("Saving to cache..");
        if (memoryCacheManager != null) {
            memoryCacheManager.put(url, type, data);
        }
    }
}
