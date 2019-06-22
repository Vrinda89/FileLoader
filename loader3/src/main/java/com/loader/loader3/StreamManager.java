package com.loader.loader3;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;



class StreamManager {


    private static final int CONNECTION_TIMEOUT_MILLIS = 10000;
    private static final int READ_TIMEOUT_MILLIS = 10000;

    /**
     * Fetching Data from input URL
     * @param url
     * @return byte[]
     * @throws FileNotFoundException
     */
    byte[] retrieveInputStream(String url) throws FileNotFoundException {
        HttpURLConnection conn;
        try {
            conn = openConnection(url);
            conn.setConnectTimeout(CONNECTION_TIMEOUT_MILLIS);
            conn.setReadTimeout(READ_TIMEOUT_MILLIS);
            InputStream is = conn.getInputStream();

            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            int nRead;
            byte[] data = new byte[16384];

            while ((nRead = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            is.close();
            return buffer.toByteArray();
        } catch (FileNotFoundException fnfe) {
            throw fnfe;
        } catch (Throwable ex) {
            return null;
        }
    }


    private HttpURLConnection openConnection(String url) throws IOException {
        return (HttpURLConnection) new URL(url).openConnection();
    }
}
