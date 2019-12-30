package com.sred.eatright.searchFood;



import searchWithBarcode.BarcodeResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface Api {
    String BASE_URL = "https://api.edamam.com/api/food-database/";

    @GET//("food-database/parser?ingr=red%20apple&app_id=129fed80&app_key=bbd2848b3ab260bdc3d6e2776aca2f6")

    public Call<Example> getFood(@Url String url);

    @GET("parser")
    Call<Example> getFood1(@Query("ingr") String foodName,
                           @Query("app_id") String appId,
                           @Query("app_key") String appKey
    );

    //get Request for barcode
    @GET("parser")
    Call<BarcodeResult> getFoodBarcode(@Query("upc") String barCode,
                                       @Query("app_id") String appId,
                                       @Query("app_key") String appKey);
            //'https://api.edamam.com/api/food-database/parser?ingr=red%20apple&app_id={app_id}&app_key={your app_key}'
}
