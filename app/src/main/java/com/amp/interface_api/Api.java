package com.amp.interface_api;


import com.amp.Screens.SplashActivity;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface Api {
    String token = SplashActivity.sharedPreferences.getString("data", "");


    @FormUrlEncoded
    @POST("api/Login/Login")
    Call<ResponseBody> Login(@Field("Username") String Username,
                             @Field("Password") String Password);


    @GET("api/Fabric/AllColorMaster")
    Call<ResponseBody> FebColor(@Header("Authorization") String tokon);

    @GET("api/Fabric/AllVender")
    Call<ResponseBody> Vendorlist(@Header("Authorization") String tokon);


    @FormUrlEncoded
    @POST("api/Fabric/AddUpdateFabric")
    Call<ResponseBody> Addfebricdata(@Header("Authorization") String tokon, @Field("VenderID") int VenderID,
                                     @Field("Color") int Color,
                                     @Field("imagePath[]") List<String> imagePath,
                                     @Field("Quantity") String Quantity,
                                     @Field("BillNo") int BillNo,
                                     @Field("TakaBalesNo") String TakaBalesNo,
                                     @Field("Status") int Status);

    @GET("api/Fabric/AllFabricList")
    Call<ResponseBody> AllFabricList(@Header("Authorization") String tokon);


    @FormUrlEncoded
    @POST("api/Fabric/DeleteFabric")
    Call<ResponseBody> Delfeb(@Header("Authorization") String tokon,
                              @Field("InFabricID") int InFabricID);


    @FormUrlEncoded
    @POST("api/SKUCutting/GetSKUCuttingProcessDetailV2")
    Call<ResponseBody> Getskudata(@Header("Authorization") String tokon,
                                  @Field("SKUCuttingID") int SKUCuttingID);

    @POST("api/SKUCutting/UpdateProcessQty")
    Call<JsonObject> UpdateSkuData(@Header("Authorization") String tokon,@Body JsonObject body);


    @FormUrlEncoded
    @POST("api/SKUCutting/GetProcessList")
    Call<ResponseBody> GetProcessList(@Header("Authorization") String tokon,
                                     @Field("SKUCuttingID") int SKUCuttingID);


    @POST("api/Login/GetUserDetails/")
    Call<ResponseBody> GetUserDetails(
            @Header("Authorization") String tokon,
            @Query(value = "username") String username);

}

