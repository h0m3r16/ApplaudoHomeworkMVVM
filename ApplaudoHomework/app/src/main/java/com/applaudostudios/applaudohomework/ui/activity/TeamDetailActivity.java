package com.applaudostudios.applaudohomework.ui.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.applaudostudios.applaudohomework.R;
import com.applaudostudios.applaudohomework.databinding.ActivityTeamDetailBinding;
import com.applaudostudios.applaudohomework.model.Team;
import com.applaudostudios.applaudohomework.ui.fragment.TeamDetailFragment;

public class TeamDetailActivity extends AppCompatActivity {

    private ActivityTeamDetailBinding mActivityTeamDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityTeamDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_team_detail);
        setSupportActionBar(mActivityTeamDetailBinding.toolbarContainer.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            Team team = getIntent().getParcelableExtra(TeamDetailFragment.ARG_ITEM_TEAM);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.team_detail_container, TeamDetailFragment.getInstance(team))
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            navigateUpTo(new Intent(this, TeamListActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
