package com.loader.loader3;


/**
 * Callback to write downloaded byte[] and data type and url in LruCache
 */

public interface PutCache {

    void put(String url, int type,byte[] data);

}
