package com.loader.loader3;

import android.util.LruCache;

/**
 *
 */

public class MemoryCache implements CacheManager {


    private static final int MAX_CACHE_SIZE = 16 * 1024 * 1024;
    private LruCache<String, CacheFile> cache;// to store downloaded info in cache to  reuse
    private int capacity;

    public MemoryCache(int capacity) {
        this.capacity = calculateCacheSize(capacity);
        reset();
    }

    /**
     * @param percentageOfMemoryForCache
     * @return cacheSize
     */
    public int calculateCacheSize(int percentageOfMemoryForCache) {
        Runtime runtime = Runtime.getRuntime();
        int calculatedSize = (int) (runtime.maxMemory() * percentageOfMemoryForCache / 100);
        int cacheSize = Math.min(calculatedSize, MAX_CACHE_SIZE);
        return cacheSize;
    }

    /**
     * clear cache  if its not empty otherwise initializing with allotted percentage of memory
     */
    private void reset() {
        if (cache != null) {
            cache.evictAll();
        } else {
            cache = new LruCache<>(capacity);
        }
    }

    /**
     * @param url
     * @param type
     * @return Cache File : Checking whether a url is already in cache if already there return the CacheFile from cache
     */
    @Override
    public CacheFile get(String url, int type) {
        if (cache.get(url) != null && cache.get(url).getType() == type) {
            return cache.get(url);
        }
        return null;

    }

    /**
     * @param url
     * @param type
     * @param data
     * Writes  the data if its not in the cache
     */
    @Override
    public void put(String url, int type, byte[] data) {
        if (cache.get(url) != null)
            if (cache.get(url).equals(url))
                if ((cache != null) && (cache.get(url).getType() == type)) {
                    return;
                }
        cache.put(url, new CacheFile(data, type));
    }
}
