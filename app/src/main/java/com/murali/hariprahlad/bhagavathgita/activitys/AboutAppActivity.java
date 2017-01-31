package com.murali.hariprahlad.bhagavathgita.activitys;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.murali.hariprahlad.bhagavathgita.R;


public class AboutAppActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);
        toolbar = (Toolbar)findViewById(R.id.aboutapptoolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("ABOUT APPLICATION");
        toolbar.setTitleTextColor(Color.YELLOW);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initCollapsingToolbar();
    }

    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar_app);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout)findViewById(R.id.viewapp);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                toolbar.setTitle("");
                this.finish();
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}