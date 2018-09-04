package com.chandora.androidy.notesappwithrxjava.network.model;

import com.google.gson.annotations.SerializedName;

public class User extends BaseResponse {

    @SerializedName("api_key")
    String apiKey;

    public String getApiKey(){

        return apiKey;
    }
}
