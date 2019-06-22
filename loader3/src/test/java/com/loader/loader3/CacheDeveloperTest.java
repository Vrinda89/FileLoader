package com.loader.loader3;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.mockito.Mockito.mock;

public class CacheDeveloperTest {


    @Test
    public void fetchByte() {
        String VALID_JSON_URL = "http://pastebin.com/raw/wgkJgazE";
        StreamManager streamManager = new StreamManager();
        byte[] bytes = new byte[16384];
        try {
            bytes = streamManager.retrieveInputStream(VALID_JSON_URL);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        CacheManager cacheManager = new MemoryCache(15);
        BytesCallback bytesCallback = mock(BytesCallback.class);
        CacheDeveloper cacheDeveloper = new CacheDeveloper(cacheManager,bytesCallback);
        cacheDeveloper.put(VALID_JSON_URL,0,bytes);
        Assert.assertTrue(cacheManager.get(VALID_JSON_URL,0)!=null);


    }
}