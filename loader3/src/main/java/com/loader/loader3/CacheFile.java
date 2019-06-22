package com.loader.loader3;

public class CacheFile {

    private byte[] mfile;
    private int type;

    public CacheFile(byte[] mfile, int type) {
        this.mfile = mfile;
        this.type = type;
    }

    public byte[] getfile() {
        return mfile;
    }


    public int getType() {
        return type;
    }


}
