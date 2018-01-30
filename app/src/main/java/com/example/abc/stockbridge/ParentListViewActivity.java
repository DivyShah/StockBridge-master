package com.example.abc.stockbridge;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.support.design.widget.NavigationView;
import android.widget.TextView;

import com.example.abc.stockbridge.network.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParentListViewActivity extends AppCompatActivity {

    TextView latest_price;
    ExpandableListAdapter listAdapter;
    private DrawerLayout mDrawerLayout;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    static Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_list_view);
        
        final ActionBar ab = getSupportActionBar();
        /* to set the menu icon image*/
        ab.setHomeAsUpIndicator(android.R.drawable.ic_menu_add);
        ab.setDisplayHomeAsUpEnabled(true);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);


        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }


        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
              /*  Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();*/
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
               /* Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();*/

            }
        });


        expListView.setOnChildClickListener(new OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                String data = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
                if (data.equals(Utils.bitcoin)) {
                   callBitcoin(client);
                }
                if (data.equals(Utils.ethereum)) {

                    callEthereum(client);


                }
                if (data.equals(Utils.ripple)) {

                    callRipple(client);
                }

                return false;
            }
        });

    }



    private void callBitcoin(Client client) {
        Intent intent = new Intent(ParentListViewActivity.this, ExploreActivity.class);
        String TAG="one";
        intent.putExtra("one", TAG);
        startActivity(intent);
    }

    private void callEthereum(Client client) {
        Intent intent = new Intent(ParentListViewActivity.this, ExploreActivity.class);
        String TAG="three";
        intent.putExtra("three", TAG);
        startActivity(intent);
    }

    private void callRipple(Client client) {
        Intent intent = new Intent(getApplicationContext(), ExploreActivity.class);
        String TAG = "Hi";
        intent.putExtra("two", TAG);
        startActivity(intent);

    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<>();

        // Adding child data
        listDataHeader.add("Currency");
        listDataHeader.add("Commodities");
        listDataHeader.add("CryptoCurrency");

        // Adding child data
        List<String> currency = new ArrayList<>();
        currency.add(Utils.indian);
        currency.add(Utils.yen);
        currency.add(Utils.dollor);


        List<String> commodites = new ArrayList<>();
        commodites.add(Utils.gold);
        commodites.add(Utils.silver);
        commodites.add(Utils.platinum);
        commodites.add(Utils.aluminimu);

        List<String> crypto = new ArrayList<>();
        crypto.add(Utils.bitcoin);
        crypto.add(Utils.ripple);
        crypto.add(Utils.ethereum);


        listDataChild.put(listDataHeader.get(0), currency); // Header, Child data
        listDataChild.put(listDataHeader.get(1), commodites);
        listDataChild.put(listDataHeader.get(2), crypto);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        //revision: this don't works, use setOnChildClickListener() and setOnGroupClickListener() above instead
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }


}
