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


public class DonateActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        toolbar = (Toolbar)findViewById(R.id.donatetoolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("ABOUT DONATE");
        toolbar.setTitleTextColor(Color.YELLOW);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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