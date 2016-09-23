package com.applaudostudios.applaudohomework.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Team implements Parcelable {

    @SerializedName("id")
    private Integer mId;
    @SerializedName("team_name")
    private String mTeamName;
    @SerializedName("since")
    private String mSince;
    @SerializedName("coach")
    private String mCoach;
    @SerializedName("team_nickname")
    private String mTeamNickname;
    @SerializedName("stadium")
    private String mStadium;
    @SerializedName("img_logo")
    private String mImgLogo;
    @SerializedName("img_stadium")
    private String mImgStadium;
    @SerializedName("latitude")
    private String mLatitude;
    @SerializedName("longitude")
    private String mLongitude;
    @SerializedName("website")
    private String mWebsite;
    @SerializedName("tickets_url")
    private String mTicketsUrl;
    @SerializedName("address")
    private String mAddress;
    @SerializedName("phone_number")
    private String mPhoneNumber;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("video_url")
    private String mVideoUrl;
    @SerializedName("schedule_games")
    private List<ScheduleGame> mScheduleGames = new ArrayList<ScheduleGame>();

    public Team() {
    }

    protected Team(Parcel in) {
        this.mId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.mTeamName = in.readString();
        this.mSince = in.readString();
        this.mCoach = in.readString();
        this.mTeamNickname = in.readString();
        this.mStadium = in.readString();
        this.mImgLogo = in.readString();
        this.mImgStadium = in.readString();
        this.mLatitude = in.readString();
        this.mLongitude = in.readString();
        this.mWebsite = in.readString();
        this.mTicketsUrl = in.readString();
        this.mAddress = in.readString();
        this.mPhoneNumber = in.readString();
        this.mDescription = in.readString();
        this.mVideoUrl = in.readString();
        this.mScheduleGames = in.createTypedArrayList(ScheduleGame.CREATOR);
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getCoach() {
        return mCoach;
    }

    public void setCoach(String coach) {
        mCoach = coach;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public String getImgLogo() {
        return mImgLogo;
    }

    public void setImgLogo(String imgLogo) {
        mImgLogo = imgLogo;
    }

    public String getImgStadium() {
        return mImgStadium;
    }

    public void setImgStadium(String imgStadium) {
        mImgStadium = imgStadium;
    }

    public String getLatitude() {
        return mLatitude;
    }

    public void setLatitude(String latitude) {
        mLatitude = latitude;
    }

    public String getLongitude() {
        return mLongitude;
    }

    public void setLongitude(String longitude) {
        mLongitude = longitude;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public List<ScheduleGame> getScheduleGames() {
        return mScheduleGames;
    }

    public void setScheduleGames(List<ScheduleGame> scheduleGames) {
        mScheduleGames = scheduleGames;
    }

    public String getSince() {
        return mSince;
    }

    public void setSince(String since) {
        mSince = since;
    }

    public String getStadium() {
        return mStadium;
    }

    public void setStadium(String stadium) {
        mStadium = stadium;
    }

    public String getTeamName() {
        return mTeamName;
    }

    public void setTeamName(String teamName) {
        mTeamName = teamName;
    }

    public String getTeamNickname() {
        return mTeamNickname;
    }

    public void setTeamNickname(String teamNickname) {
        mTeamNickname = teamNickname;
    }

    public String getTicketsUrl() {
        return mTicketsUrl;
    }

    public void setTicketsUrl(String ticketsUrl) {
        mTicketsUrl = ticketsUrl;
    }

    public String getVideoUrl() {
        return mVideoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        mVideoUrl = videoUrl;
    }

    public String getWebsite() {
        return mWebsite;
    }

    public void setWebsite(String website) {
        mWebsite = website;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.mId);
        dest.writeString(this.mTeamName);
        dest.writeString(this.mSince);
        dest.writeString(this.mCoach);
        dest.writeString(this.mTeamNickname);
        dest.writeString(this.mStadium);
        dest.writeString(this.mImgLogo);
        dest.writeString(this.mImgStadium);
        dest.writeString(this.mLatitude);
        dest.writeString(this.mLongitude);
        dest.writeString(this.mWebsite);
        dest.writeString(this.mTicketsUrl);
        dest.writeString(this.mAddress);
        dest.writeString(this.mPhoneNumber);
        dest.writeString(this.mDescription);
        dest.writeString(this.mVideoUrl);
        dest.writeTypedList(mScheduleGames);
    }

    public static final Creator<Team> CREATOR = new Creator<Team>() {
        public Team createFromParcel(Parcel source) {
            return new Team(source);
        }

        public Team[] newArray(int size) {
            return new Team[size];
        }
    };
}
