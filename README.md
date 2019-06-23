# MediaLoader

## Project pre requisites
   - Android Studio
   - Android Sdk
   
## Project Dependencies
    - Dagger
    - Android Architecture component
    
## About 
    
    - This project is developed in MVVM Architecture. 
    - Used the loader3 library for download image, Json file
    - Dagger is used for dependency injection so that depended object is ready during the runtime of the application.
    - Network calls are done using AsyncTask.
    - Datas are populated in UI using databinding method.
    - Clear text traffic is enabled for the api url since it is http url. And from Android Oreo OS doesn't allow the url request without https.
    
### Library

     Image loading library that will be used to asynchronously download the images.The library will also be useful for all other parts of the app where asynchronous remote image loading is required. 
     Library is created for multi type file download .Currentl it can be used for download image and Json data from a url and the library returns a byte[] of respone in callback.
     
#### Image Loader
       
       Image loader can be implemented in two way.
       
       1 . Without Status Callback
            
             MFileLoader.getInstance().loadImage(inputUrl, imageView);
             
       2 . With Status Callback   
       
            MFileLoader.getInstance().loadImage(inputUrl, imageView, new ImageResponseListener() {
                            @Override
                            public void onResponse(MLoaderResponse mLoaderResponse) {
                                switch (mLoaderResponse.getStatus()){
                                    case SUCCESS://Loading success
                                        break;
                                    case LOADING://Loading 
                                        break;
                                    case FAILED://Loading failed
                                        break;
                                    case CANCELLED://Loading cancelled
                                        break;
                                }
                            }
                        });
          
#### Json Loader
       
       Json loader can be implemented as below.
                
         MFileLoader.getInstance().loadJson(url, new JsonResponseListener() {
                   @Override
                   public void onResponse(MLoaderResponse mLoaderResponse) {
       
                       switch (mLoaderResponse.getStatus()){
                           case SUCCESS://Loading success
                               Gson gson = new Gson();
                               ProfileResponse.Profile[] profileResponse = gson.fromJson(mLoaderResponse.getJsonResponse(), ProfileResponse.Profile[].class);
                               response.setValue(profileResponse);
                               break;
                           case LOADING://show Loading 
                               break;
                           case FAILED://erro loading, can dismiss loading
                               break;
                           case CANCELLED://Loading cancelled
                               break;
                       }
                       
                   }
               });