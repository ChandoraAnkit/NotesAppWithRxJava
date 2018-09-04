package com.chandora.androidy.notesappwithrxjava.network;

import com.chandora.androidy.notesappwithrxjava.network.model.Note;
import com.chandora.androidy.notesappwithrxjava.network.model.User;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("notes/user/register")
    Single<User> register(@Field("api_key") String deviceId);

    @FormUrlEncoded
    @POST("notes/new")
    Single<Note> createNote(@Field("note") String note);


}
