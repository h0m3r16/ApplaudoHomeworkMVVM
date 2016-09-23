package com.applaudostudios.applaudohomework.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ScheduleGame implements Parcelable {

    @SerializedName("date")
    private String mDate;
    @SerializedName("stadium")
    private String mStadium;

    public ScheduleGame() {
    }

    protected ScheduleGame(Parcel in) {
        this.mDate = in.readString();
        this.mStadium = in.readString();
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getStadium() {
        return mStadium;
    }

    public void setStadium(String stadium) {
        mStadium = stadium;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mDate);
        dest.writeString(this.mStadium);
    }

    public static final Creator<ScheduleGame> CREATOR = new Creator<ScheduleGame>() {
        public ScheduleGame createFromParcel(Parcel source) {
            return new ScheduleGame(source);
        }

        public ScheduleGame[] newArray(int size) {
            return new ScheduleGame[size];
        }
    };
}
