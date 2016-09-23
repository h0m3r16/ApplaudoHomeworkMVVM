package com.applaudostudios.applaudohomework.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.applaudostudios.applaudohomework.R;
import com.applaudostudios.applaudohomework.databinding.ItemTeamListBinding;
import com.applaudostudios.applaudohomework.model.Team;
import com.applaudostudios.applaudohomework.ui.viewmodel.ListViewModelListener;
import com.applaudostudios.applaudohomework.ui.viewmodel.TeamItemViewModel;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {
    private List<Team> mData;
    private ListViewModelListener<Team> mListener;

    public TeamAdapter(List<Team> data, ListViewModelListener<Team> listener) {
        mData = data;
        mListener = listener;
    }

    @Override
    public TeamAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Team team = mData.get(position);
        holder.mItemTeamListBinding.setViewModel(new TeamItemViewModel(team, mListener));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ItemTeamListBinding mItemTeamListBinding;

        public ViewHolder(View view) {
            super(view);
            mItemTeamListBinding = DataBindingUtil.bind(view);
        }
    }
}
