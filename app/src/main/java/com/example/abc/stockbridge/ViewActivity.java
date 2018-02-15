package com.example.abc.stockbridge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity implements ActionBar.TabListener,ActionBar.OnNavigationListener {

    ViewPager viewPager;
    TagPageAdapter adapter;
    Toolbar toolbar;
    ActionBar actionBar,mactionbar;
    Button button;
    Bundle bundle;
    private ArrayList<SpinnerNavItem> navSpinner;
    // Navigation adapter
    private TitleNavigationAdapter adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        bundle=getIntent().getExtras();

        adapter = new TagPageAdapter(getSupportFragmentManager());
        actionBar=getSupportActionBar();
        mactionbar=getSupportActionBar();
        viewPager=(ViewPager)findViewById(R.id.pager);

       // actionbar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        navSpinner = new ArrayList<SpinnerNavItem>();

        navSpinner.add(new SpinnerNavItem("Bitcoin", R.drawable.bitcoin1));
        navSpinner.add(new SpinnerNavItem("Ripple", R.drawable.ripple));
        navSpinner.add(new SpinnerNavItem("Etherum", R.drawable.ethereum));
        navSpinner.add(new SpinnerNavItem("Litecoin", R.drawable.litecoin));


        adapter1 = new TitleNavigationAdapter(getApplicationContext(), navSpinner);
       // actionbar.setListNavigationCallbacks(adapter1,this);
        actionBar.setListNavigationCallbacks(adapter1,this);

        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFilterPopup(v);
            }
        });*/



       // viewPager.setAdapter(adapter);
        viewPager.setAdapter(adapter);
        actionBar.setHomeButtonEnabled(true);
      actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        actionBar.addTab(actionBar.newTab().setText("What is?").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Chart").setTabListener(this));
actionBar.addTab(actionBar.newTab().setText("Details").setTabListener(this));
actionBar.addTab(actionBar.newTab().setText("Exchanges").setTabListener(this));


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.setting_menu, menu);
        return true;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {



    }

    public boolean onOptionItemsSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.alert:
                Toast.makeText(getApplicationContext(),"Alert button is clicked",Toast.LENGTH_SHORT).show();
                return  true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }



    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        return false;
    }
}