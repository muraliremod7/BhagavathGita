package com.murali.hariprahlad.bhagavathgita.activitys;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import com.murali.hariprahlad.bhagavathgita.R;
import com.murali.hariprahlad.bhagavathgita.fragments.ChatingFragment;
import com.murali.hariprahlad.bhagavathgita.fragments.LearningGitaFragment;
import com.murali.hariprahlad.bhagavathgita.fragments.TodaysLearningFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String[] FRAGMENT_NAME = {"CHANTING", "LEARNING GEETA", "TODAYS LEARNING"};
    private Menu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.YELLOW);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ChatingFragment(), FRAGMENT_NAME[0]);
        adapter.addFragment(new LearningGitaFragment(), FRAGMENT_NAME[1]);
        adapter.addFragment(new TodaysLearningFragment(), FRAGMENT_NAME[2]);
        viewPager.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Drawable drawable = item.getIcon();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
        FragmentTransaction mFragmentTransaction;
        FragmentManager mFragmentManager;
        mFragmentManager = getSupportFragmentManager();
        switch (item.getItemId()){
            case R.id.foudation:
                Intent intentfoundation = new Intent(HomeActivity.this,AboutFoundationActivity.class);
                startActivity(intentfoundation);
                return true;
            case R.id.bhagavathgeeta:
                Intent intentbha = new Intent(HomeActivity.this,AboutBhagavadgitaActivity.class);
                startActivity(intentbha);
                return true;
            case R.id.gitajayanthi:
                Intent intentgita = new Intent(HomeActivity.this,GitaJayanthiCelActivity.class);
                startActivity(intentgita);
                return true;
            case R.id.donate:
                Intent intentdonate = new Intent(HomeActivity.this,DonateActivity.class);
                startActivity(intentdonate);
                return true;
            case R.id.gallery:
                Intent intentgallery = new Intent(HomeActivity.this,GalleryActivity.class);
                startActivity(intentgallery);
                return true;
            case R.id.sponsers:
                Intent intentsponsers = new Intent(HomeActivity.this,AboutSponsersActivity.class);
                startActivity(intentsponsers);
                return true;
            case R.id.aboutapp:
                Intent intentapp = new Intent(HomeActivity.this,AboutAppActivity.class);
                startActivity(intentapp);
                return true;
            default:

        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByBackKey();

            //moveTaskToBack(false);

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void exitByBackKey() {

        AlertDialog alertbox = new AlertDialog.Builder(this,R.style.MyAlertDialogStyle)
                .setMessage("Do you want to exit application?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {
                        finish();
                        //close();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface dialog, int arg1) {
                        dialog.dismiss();
                    }
                })
                .show();

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        //Set the tab icon from selected array
        //tab.setIcon(SELECTED_ICON[tab.getPosition()]);
        toolbar.setTitle(FRAGMENT_NAME[tab.getPosition()]);
        toolbar.setTitleTextColor(Color.YELLOW);
        //When Tab is clicked this line set the viewpager to corresponding fragment
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        // Set icon from unselected tab array
        //tab.setIcon(UNSELECTED_ICON[tab.getPosition()]);
        toolbar.setTitleTextColor(Color.WHITE);
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        //tab.setIcon(SELECTED_ICON[tab.getPosition()]);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
