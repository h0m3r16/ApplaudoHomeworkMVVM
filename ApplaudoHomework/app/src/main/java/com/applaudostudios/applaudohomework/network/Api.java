package com.applaudostudios.applaudohomework.network;

import com.applaudostudios.applaudohomework.model.Team;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface Api {
    String URL = "http://applaudostudios.com";

    @GET("/external/applaudo_homework.json")
    Call<List<Team>> getAllTeams();

    class Factory {
        public static Api create() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Api.URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            return retrofit.create(Api.class);
        }
    }
}
