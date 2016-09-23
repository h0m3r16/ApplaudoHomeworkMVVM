package com.applaudostudios.applaudohomework.ui.viewmodel;

import android.databinding.ObservableInt;
import android.view.View;

import com.applaudostudios.applaudohomework.HomeworkApplication;
import com.applaudostudios.applaudohomework.model.Team;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamListViewModel {

    public ObservableInt progressVisibility = new ObservableInt(View.INVISIBLE);

    private ListViewModelListener<Team> mListener;

    public TeamListViewModel(ListViewModelListener<Team> listener) {
        mListener = listener;
    }

    public void loadData() {
        progressVisibility.set(View.VISIBLE);
        Call<List<Team>> call = HomeworkApplication.get().getApi().getAllTeams();
        call.enqueue(new Callback<List<Team>>() {
            @Override
            public void onResponse(Call<List<Team>> call, Response<List<Team>> response) {
                mListener.onDataLoaded(response.body());
                progressVisibility.set(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<List<Team>> call, Throwable t) {

            }
        });
    }
}
