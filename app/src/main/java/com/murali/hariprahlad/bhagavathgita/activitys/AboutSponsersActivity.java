package com.murali.hariprahlad.bhagavathgita.activitys;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.murali.hariprahlad.bhagavathgita.R;
import com.murali.hariprahlad.bhagavathgita.adapters.DataAdapter;

import java.util.ArrayList;
import java.util.Arrays;


public class AboutSponsersActivity extends AppCompatActivity {
    private ArrayList<String> main_Name;
    private ArrayList<String> sponser_Name;
    private Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_sponsers);
        toolbar = (Toolbar)findViewById(R.id.sponserstoolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("ABOUT SPONSERS");
        toolbar.setTitleTextColor(Color.YELLOW);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initViews();
    }
    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        String[] arrayname = getResources().getStringArray(R.array.mainnames);
        main_Name = new ArrayList<>(Arrays.asList(arrayname));
        String[] arraysponsernames = getResources().getStringArray(R.array.sponsernames);
        sponser_Name = new ArrayList<>(Arrays.asList(arraysponsernames));
        RecyclerView.Adapter adapter = new DataAdapter(main_Name,sponser_Name);
        recyclerView.setAdapter(adapter);

//        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
//            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
//
//                @Override public boolean onSingleTapUp(MotionEvent e) {
//                    return true;
//                }
//
//            });
//            @Override
//            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
//
//                View child = rv.findChildViewUnder(e.getX(), e.getY());
//                if(child != null && gestureDetector.onTouchEvent(e)) {
//                    int position = rv.getChildAdapterPosition(child);
//                    Toast.makeText(getApplicationContext(), main_Name.get(position), Toast.LENGTH_SHORT).show();
//                }
//
//                return false;
//            }
//
//            @Override
//            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
//
//            }
//
//            @Override
//            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//
//            }
//        });
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