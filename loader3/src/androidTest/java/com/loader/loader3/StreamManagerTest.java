package com.loader.loader3;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class StreamManagerTest {

    @Test
    public void retrieve_input_stream_for_empty_url() {
        String EMPTY_URL = "";
        StreamManager streamManager = new StreamManager();
        try {
            streamManager.retrieveInputStream(EMPTY_URL);
        } catch (Exception e) {
            Assert.assertTrue(e instanceof FileNotFoundException);
        }
    }

    @Test
    public void retrieve_input_stream_for_valid_json_url() {
        String VALID_JSON_URL = "http://pastebin.com/raw/wgkJgazE";
        StreamManager streamManager = new StreamManager();
        try {
            byte[] bytes = streamManager.retrieveInputStream(VALID_JSON_URL);
            Assert.assertTrue(bytes != null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void retrieve_input_stream_for_invalid_url() {
        String VALID_JSON_URL = "hgshagshagshasg";
        StreamManager streamManager = new StreamManager();
        try {
            byte[] bytes = streamManager.retrieveInputStream(VALID_JSON_URL);
            Assert.assertTrue(bytes == null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}