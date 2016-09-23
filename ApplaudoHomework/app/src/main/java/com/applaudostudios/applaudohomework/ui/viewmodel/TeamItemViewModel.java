package com.applaudostudios.applaudohomework.ui.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.applaudostudios.applaudohomework.model.Team;
import com.bumptech.glide.Glide;

public class TeamItemViewModel extends BaseObservable {

    protected Team mTeam;
    private ListViewModelListener<Team> mListener;

    public TeamItemViewModel(Team team, ListViewModelListener<Team> listener) {
        mTeam = team;
        mListener = listener;
    }

    @Bindable
    public String getLogoImageUrl() {
        return mTeam.getImgLogo();
    }

    @BindingAdapter("logoImage")
    public static void setLogoImage(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context).load(url).into(imageView);
    }

    @Bindable
    public String getTitle() {
        return mTeam.getTeamName();
    }

    @Bindable
    public String getDescription() {
        return mTeam.getDescription();
    }

    public void onTeamClick(View view) {
        mListener.onItemSelected(mTeam);
    }
}
