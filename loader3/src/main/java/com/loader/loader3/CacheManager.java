package com.loader.loader3;

public interface CacheManager {

   CacheFile get(String url, int type);

    void put(String url, int type,byte[] data);
}
