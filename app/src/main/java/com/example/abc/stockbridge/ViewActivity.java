package com.example.abc.stockbridge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;

import static android.support.v7.app.ActionBar.NAVIGATION_MODE_LIST;

public class ViewActivity extends AppCompatActivity implements ActionBar.OnNavigationListener,AdapterView.OnItemSelectedListener {

    ViewPager viewPager;
    TagPageAdapter adapter;
    Toolbar toolbar;
    ActionBar actionBar,mactionbar;
    Button button;
    Bundle bundle;
    private ArrayList<SpinnerNavItem> navSpinner;
    // Navigation adapter
    private TitleNavigationAdapter adapter1;
    TabLayout tabLayout;
    Spinner spinner;
    String[] country = { "Bitcoin", "Ripple", "Etherum", "Litecoin", "BBitcoin Cash"  };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        bundle=getIntent().getExtras();

        adapter = new TagPageAdapter(getSupportFragmentManager());
        actionBar=getSupportActionBar();
        mactionbar=getSupportActionBar();
        viewPager=(ViewPager)findViewById(R.id.pager);

       // spinner=(Spinner)findViewById(R.id.spinner);
       // spinner.setOnItemSelectedListener(this);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                actionBar=getSupportActionBar();
                actionBar.setSelectedNavigationItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
       // spinner.setAdapter(aa);

        viewPager.setAdapter(adapter);

        // actionbar.setDisplayShowTitleEnabled(true);
       /* actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        navSpinner = new ArrayList<SpinnerNavItem>();

        navSpinner.add(new SpinnerNavItem("Bitcoin", R.drawable.bitcoin1));
        navSpinner.add(new SpinnerNavItem("Ripple", R.drawable.ripple));
        navSpinner.add(new SpinnerNavItem("Etherum", R.drawable.ethereum));
        navSpinner.add(new SpinnerNavItem("Litecoin", R.drawable.litecoin));


        adapter1 = new TitleNavigationAdapter(getApplicationContext(), navSpinner);
        actionBar.setListNavigationCallbacks(adapter1,this);*/
      //  actionBar.setListNavigationCallbacks(adapter1,this);







       // viewPager.setAdapter(adapter);
       // viewPager.setAdapter(adapter);
        actionBar.setHomeButtonEnabled(true);

      actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);



ActionBar.TabListener tabListener =new ActionBar.TabListener() {
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




};


        actionBar.addTab(actionBar.newTab().setText("What is?").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Chart").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Details").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Exchanges").setTabListener(tabListener));




        ActionBar.OnNavigationListener navigationListener = new ActionBar.OnNavigationListener() {
            @Override
            public boolean onNavigationItemSelected(int itemPosition, long itemId) {
                Toast.makeText(getBaseContext(), "You selected : " + country[itemPosition]  , Toast.LENGTH_SHORT).show();
                return false;

            }
        };


//        getActionBar().setListNavigationCallbacks(aa, (android.app.ActionBar.OnNavigationListener) navigationListener);
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(getApplicationContext(),country[position] ,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}