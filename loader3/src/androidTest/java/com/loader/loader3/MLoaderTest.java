package com.loader.loader3;

import android.content.Context;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.test.InstrumentationRegistry;

import org.junit.Assert;
import org.junit.Test;

public class MLoaderTest {

    private Context appContext = InstrumentationRegistry.getTargetContext();

    @Test
    public void valid_status_and_error_for_empty_url() {
        MFileLoader mFileLoader = MFileLoader.getInstance();
        String EMPTY_URL = "";
        mFileLoader.loadImage(EMPTY_URL, new AppCompatImageView(appContext), new ImageResponseListener() {
            @Override
            public void onResponse(MLoaderResponse mLoaderResponse) {
                Assert.assertTrue(mLoaderResponse.getStatus().equals(MLoaderStatus.FAILED));
                Assert.assertTrue(mLoaderResponse.getErrorMessage().equals(MLoaderConstants.INVALID_URL));
            }
        });

    }


    @Test
    public void valid_status_and_error_for_invalid_url() {
        MFileLoader mFileLoader = MFileLoader.getInstance();
        String INVALID_URL = "http://www.africau.edu/images/default/sample.pdf";
        mFileLoader.loadImage(INVALID_URL, new AppCompatImageView(appContext), new ImageResponseListener() {
            @Override
            public void onResponse(MLoaderResponse mLoaderResponse) {
                Assert.assertTrue(mLoaderResponse.getStatus().equals(MLoaderStatus.FAILED));
                Assert.assertTrue(mLoaderResponse.getErrorMessage().equals(MLoaderConstants.INVALID_URL));
            }
        });

    }


    @Test
    public void valid_status_and_error_for_valid_url() {
        MFileLoader mFileLoader = MFileLoader.getInstance();
        String VALID_URL = " https://images.unsplash.com/profile-1459198013794-1b8e57737f57?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&fit=crop&h=64&w=64&s=a17ff0263815cc6b32d1966ad71db759";
        mFileLoader.loadImage(VALID_URL, new AppCompatImageView(appContext), new ImageResponseListener() {
            @Override
            public void onResponse(MLoaderResponse mLoaderResponse) {
                if (mLoaderResponse.getStatus() == MLoaderStatus.SUCCESS)
                    Assert.assertTrue(mLoaderResponse.getImageResponse() != null);
            }
        });

    }

    @Test
    public void valid_status_and_error_for_invalid_url_withpdf_in_loadimage() {
        MFileLoader mFileLoader = MFileLoader.getInstance();
        String INVALID_IMAGE_URL_WITH_PDF_LINK = "http://www.africau.edu/images/default/sample.pdf";
        mFileLoader.loadImage(INVALID_IMAGE_URL_WITH_PDF_LINK, new AppCompatImageView(appContext), new ImageResponseListener() {
            @Override
            public void onResponse(MLoaderResponse mLoaderResponse) {
                Assert.assertTrue(mLoaderResponse.getStatus().equals(MLoaderStatus.FAILED));
                Assert.assertTrue(mLoaderResponse.getErrorMessage().equals(MLoaderConstants.INVALID_URL));
            }
        });

    }




}