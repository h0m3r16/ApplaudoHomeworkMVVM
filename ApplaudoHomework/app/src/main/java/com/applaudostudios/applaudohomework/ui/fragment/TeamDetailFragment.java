package com.applaudostudios.applaudohomework.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.applaudostudios.applaudohomework.R;
import com.applaudostudios.applaudohomework.databinding.FragmentTeamDetailBinding;
import com.applaudostudios.applaudohomework.model.Team;
import com.applaudostudios.applaudohomework.ui.viewmodel.TeamDetailViewModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class TeamDetailFragment extends Fragment {

    public static final String ARG_ITEM_TEAM = "item_team";

    private Team mTeam;
    private TeamDetailViewModel mTeamDetailViewModel;
    private FragmentTeamDetailBinding mFragmentTeamDetailBinding;
    private SupportMapFragment mSupportMapFragment;

    public TeamDetailFragment() {
    }

    public static TeamDetailFragment getInstance(Team team) {
        Bundle arguments = new Bundle();
        arguments.putParcelable(TeamDetailFragment.ARG_ITEM_TEAM, team);

        TeamDetailFragment teamDetailFragment = new TeamDetailFragment();
        teamDetailFragment.setArguments(arguments);

        return teamDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_TEAM)) {
            mTeam = getArguments().getParcelable(ARG_ITEM_TEAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mFragmentTeamDetailBinding  = DataBindingUtil.inflate(inflater, R.layout.fragment_team_detail, container, false);

        mTeamDetailViewModel = new TeamDetailViewModel(mTeam);
        mFragmentTeamDetailBinding.setViewModel(mTeamDetailViewModel);

        mSupportMapFragment = new SupportMapFragment();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.team_detail_map, mSupportMapFragment).commit();

        return mFragmentTeamDetailBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mFragmentTeamDetailBinding.teamDetailVideoView.setVideoURI(mTeamDetailViewModel.getVideoPath());
        mFragmentTeamDetailBinding.teamDetailVideoView.start();

        mSupportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                LatLng latLng = mTeamDetailViewModel.getLatLng();
                googleMap.addMarker(new MarkerOptions().position(latLng));
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            }
        });
    }
}
