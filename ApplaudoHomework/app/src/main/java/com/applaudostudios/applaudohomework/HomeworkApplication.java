package com.applaudostudios.applaudohomework;

import android.app.Application;

import com.applaudostudios.applaudohomework.network.Api;

public class HomeworkApplication extends Application {

    private static HomeworkApplication sHomeworkApplication;
    private Api mApi;

    public static HomeworkApplication get() {
        return sHomeworkApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sHomeworkApplication = this;

        mApi = Api.Factory.create();
    }

    public Api getApi() {
        return mApi;
    }
}
