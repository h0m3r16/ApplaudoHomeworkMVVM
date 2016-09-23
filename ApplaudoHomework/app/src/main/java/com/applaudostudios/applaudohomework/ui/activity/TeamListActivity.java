package com.applaudostudios.applaudohomework.ui.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.applaudostudios.applaudohomework.R;
import com.applaudostudios.applaudohomework.adapter.TeamAdapter;
import com.applaudostudios.applaudohomework.databinding.ActivityTeamListBinding;
import com.applaudostudios.applaudohomework.model.Team;
import com.applaudostudios.applaudohomework.ui.fragment.TeamDetailFragment;
import com.applaudostudios.applaudohomework.ui.viewmodel.ListViewModelListener;
import com.applaudostudios.applaudohomework.ui.viewmodel.TeamListViewModel;

import java.util.List;

public class TeamListActivity extends AppCompatActivity implements ListViewModelListener<Team> {

    private boolean mTwoPane;
    private ActivityTeamListBinding mTeamListBinding;
    private TeamListViewModel mTeamListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTeamListBinding = DataBindingUtil.setContentView(this, R.layout.activity_team_list);
        mTeamListViewModel = new TeamListViewModel(this);
        mTeamListBinding.setViewModel(mTeamListViewModel);

        mTeamListViewModel.loadData();

        setSupportActionBar(mTeamListBinding.toolbarContainer.toolbar);
        mTeamListBinding.toolbarContainer.toolbar.setTitle(getTitle());

        if (findViewById(R.id.team_detail_container) != null) {
            mTwoPane = true;
        }
    }

    @Override
    public void onItemSelected(Team item) {
        if (mTwoPane) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.team_detail_container, TeamDetailFragment.getInstance(item))
                    .commit();
        } else {
            Intent intent = new Intent(this, TeamDetailActivity.class);
            intent.putExtra(TeamDetailFragment.ARG_ITEM_TEAM, item);

            startActivity(intent);
        }
    }

    @Override
    public void onDataLoaded(List<Team> items) {
        mTeamListBinding.teamListContent.teamList.setAdapter(new TeamAdapter(items, TeamListActivity.this));
    }
}
