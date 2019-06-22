package com.loader.loader3;

public interface BytesCallback {

    void onProgress();

    void onFailed(String error);

    void onCancelled();

    void onComplete(byte[] is, int type, String url);
}
