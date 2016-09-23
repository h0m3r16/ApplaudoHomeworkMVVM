package com.applaudostudios.applaudohomework.ui.viewmodel;

import android.net.Uri;

import com.applaudostudios.applaudohomework.model.Team;
import com.google.android.gms.maps.model.LatLng;

public class TeamDetailViewModel extends TeamItemViewModel {

    public TeamDetailViewModel(Team team) {
        super(team, null);
    }

    public Uri getVideoPath() {
        return Uri.parse(mTeam.getVideoUrl());
    }

    public LatLng getLatLng() {
        return new LatLng(Double.valueOf(mTeam.getLatitude()), Double.valueOf(mTeam.getLongitude()));
    }
}
