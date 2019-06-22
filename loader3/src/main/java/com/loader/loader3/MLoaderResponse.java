package com.loader.loader3;

public class MLoaderResponse {

    private String jsonResponse;
    private byte[] imageResponse;
    private  MLoaderStatus status;
    private String errorMessage;

    public MLoaderResponse(String jsonResponse, byte[] imageResponse, MLoaderStatus status, String errorMessage) {
        this.jsonResponse = jsonResponse;
        this.imageResponse = imageResponse;
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public MLoaderResponse(MLoaderStatus status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public MLoaderResponse(String jsonResponse, MLoaderStatus status, String errorMessage) {
        this.jsonResponse = jsonResponse;
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public MLoaderResponse(MLoaderStatus status) {
        this.status = status;
    }

    public String getJsonResponse() {
        return jsonResponse;
    }

    public byte[] getImageResponse() {
        return imageResponse;
    }

    public MLoaderStatus getStatus() {
        return status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
