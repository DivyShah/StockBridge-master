package com.example.abc.stockbridge;

import android.content.Intent;
import android.graphics.Color;
import android.opengl.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abc.stockbridge.data.CryptoCurrency;
import com.example.abc.stockbridge.network.Client;
import com.example.abc.stockbridge.network.ServiceGenrator;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExploreActivity extends AppCompatActivity {

    LineChart mChart;
    private List<List<Float>> marketCap;
    List<Float> array = new ArrayList<>();
    List<Float> array_value = new ArrayList<>();
    TextView buy, sell, marketprice, abtzebpay, tv_one_hour,below_price;
    TextView one_hour, one_day, one_month, one_year, one_week,six_month,three_month;
    TextView small_tag;

    TextView display_coin,display_difference;
    Button allexchanges;
    String url = "";
    String zebpayurl = "https://chart.zebpay.com/";
    String etherumurl = "https://coingetprice.com/currencies/bitcoin/#charts";
    String zebpay = "https://en.wikipedia.org/wiki/Zebpay";
    int data = 0;
    private List<List<Float>> getprice;
    private String TAG = MainActivity.class.getName();
    Client client;
    WebView webView;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);
        bundle=getIntent().getExtras();
        buy = (TextView) findViewById(R.id.buybtc);

        //small_tag=(TextView)findViewById(R.id.small_tag);
        display_coin=(TextView)findViewById(R.id.display_coin);
        display_difference=(TextView)findViewById(R.id.dispaly_difference);
        one_hour = (TextView) findViewById(R.id.one_hour);
        one_day = (TextView) findViewById(R.id.one_day);
        one_week = (TextView) findViewById(R.id.one_week);
        one_month = (TextView) findViewById(R.id.one_month);
        six_month=(TextView)findViewById(R.id.six_month);
        three_month=(TextView)findViewById(R.id.three_month);
        one_year = (TextView) findViewById(R.id.one_year);
        mChart=(LineChart)findViewById(R.id.linechart);
        below_price=(TextView)findViewById(R.id.below_price);

        allexchanges=(Button)findViewById(R.id.all_exchanges);
        allexchanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // showFilterPopup(v);
            }
        });
        one_week.setClickable(true);
        one_hour.setClickable(true);
        one_day.setClickable(true);
        one_year.setClickable(true);

        //buy.setText(String.valueOf(getprice.get(getprice.size()-1).get(1)));
        //String url= (String) bundle.get("two");
//        buy.setTextColor(Color.parseColor("#FFFFFF"));


        if(bundle.get("one")!=null)
        {
            String btc="BTC/USD Price";
            display_coin.setText(btc);
            String s= Utils.getAPI(Utils.one_day_bitcoin);
            client = ServiceGenrator.createService(Client.class, s);
            String hello=callonedayprice(client,"one_hour");
            callgraph(client,"one_hour");
            buy.setText(hello);




        }
        else if(bundle.get("two")!=null)
        {
            display_coin.setText("XRP/USD Price");
            String s =Utils.getAPI(Utils.one_day_ripple);
            client=ServiceGenrator.createService(Client.class,s);
            String hello=callonedayprice(client,"one_hour");
            buy.setText(hello);
            callgraph(client,"one_hour");
        }
        else if(bundle.get("three")!=null)
        {
            display_coin.setText("ETH/USD Price");
            String s =Utils.getAPI(Utils.one_day_etherum);
            client=ServiceGenrator.createService(Client.class,s);
            String hello=callonedayprice(client,"one_hour");
            buy.setText(hello);
            callgraph(client,"one_hour");
        }
        else if(bundle.get("four")!=null)
        {
            display_coin.setText("LTC/USD Price");
            String s =Utils.getAPI(Utils.one_day_litecoin);
            client=ServiceGenrator.createService(Client.class,s);
            String hello=callonedayprice(client,"one_hour");
            buy.setText(hello);
            callgraph(client,"one_hour");
        }
        else if(bundle.get("five")!=null)
        {
            display_coin.setText("BCH/USD price");
            String s =Utils.getAPI(Utils.one_day_bitcoin_cash);
            client=ServiceGenrator.createService(Client.class,s);
            String hello=callonedayprice(client,"one_hour");
            buy.setText(hello);
            callgraph(client,"one_hour");
        }

        one_hour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(bundle.get("three")!=null) {
                    String s = Utils.getAPI(Utils.one_day_etherum);
                    client = ServiceGenrator.createService(Client.class, s);
                    callonedayprice(client, "one_hour");
                    callgraph(client,"one_hour");
                }

                else  if(bundle.get("one")!=null)
                {
                    String s= Utils.getAPI(Utils.one_day_bitcoin);
                    client= ServiceGenrator.createService(Client.class,s);
                    callonedayprice(client,"one_hour");
                    callgraph(client, "one_hour");
                }

                else  if(bundle.get("two")!=null)
                {
                    String s= Utils.getAPI(Utils.one_day_ripple);
                    client= ServiceGenrator.createService(Client.class,s);
                    callonedayprice(client,"one_hour");
                    callgraph(client,"one_hour");
                }
                else  if(bundle.get("four")!=null)
                {
                    String s= Utils.getAPI(Utils.one_day_litecoin);
                    client= ServiceGenrator.createService(Client.class,s);
                    callonedayprice(client,"one_hour");
                    callgraph(client,"one_hour");
                }
                else  if(bundle.get("five")!=null)
                {
                    String s= Utils.getAPI(Utils.one_day_bitcoin_cash);
                    client= ServiceGenrator.createService(Client.class,s);
                    callonedayprice(client,"one_hour");
                    callgraph(client,"one_hour");
                }





            }
        });

        one_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(bundle.get("two")!=null)
                {
                    String s= Utils.getAPI(Utils.one_day_ripple);
                    client=ServiceGenrator.createService(Client.class,s);
                    callonedayprice(client,"one_day");
                    callgraph(client,"one_day");

                }
                else  if(bundle.get("one")!=null)
                {
                    String s= Utils.getAPI(Utils.one_day_bitcoin);
                    client= ServiceGenrator.createService(Client.class,s);
                    callonedayprice(client,"one_day");
                    callgraph(client,"one_day");
                }

                else  if(bundle.get("three")!=null)
                {
                    String s = Utils.getAPI(Utils.one_day_etherum);
                    client = ServiceGenrator.createService(Client.class, s);
                    callonedayprice(client, "one_day");
                    callgraph(client, "one_day");
                }
                else  if(bundle.get("four")!=null)
                {
                    String s = Utils.getAPI(Utils.one_day_litecoin);
                    client = ServiceGenrator.createService(Client.class, s);
                    callonedayprice(client, "one_day");
                    callgraph(client, "one_day");
                }

                else  if(bundle.get("five")!=null)
                {
                    String s = Utils.getAPI(Utils.one_day_bitcoin_cash);
                    client = ServiceGenrator.createService(Client.class, s);
                    callonedayprice(client, "one_day");
                    callgraph(client, "one_day");
                }


            }
        });
        one_week.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(bundle.get("two")!=null)
                {
                    String s = Utils.getAPI(Utils.seven_day_ripple);
                    client = ServiceGenrator.createService(Client.class, s);
                    callonedayprice(client, "one_week");
                    callgraph(client, "one_week");
                }
                else  if(bundle.get("one")!=null)
                {
                    String s= Utils.getAPI(Utils.seven_day_bitcoin);
                    client= ServiceGenrator.createService(Client.class,s);
                    callonedayprice(client,"one_week");
                    callgraph(client, "one_week");
                }

                else  if(bundle.get("three")!=null)
                {
                    String s = Utils.getAPI(Utils.seven_day_ethereum);
                    client = ServiceGenrator.createService(Client.class, s);
                    callonedayprice(client, "one_week");
                    callgraph(client, "one_week");

                }
                else  if(bundle.get("four")!=null)
                {
                    String s = Utils.getAPI(Utils.seven_day_litecoin);
                    client = ServiceGenrator.createService(Client.class, s);
                    callonedayprice(client, "one_week");
                    callgraph(client, "one_week");

                }
                else  if(bundle.get("five")!=null)
                {
                    String s = Utils.getAPI(Utils.seven_day_bitcoin_cash);
                    client = ServiceGenrator.createService(Client.class, s);
                    callonedayprice(client, "one_week");
                    callgraph(client, "one_week");

                }


            }
        });
        one_month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(bundle.get("two")!=null)
                {
                    String s = Utils.getAPI(Utils.one_month_ripple);
                    client = ServiceGenrator.createService(Client.class, s);
                    callonedayprice(client, "one_month");
                    callgraph(client,"one_month");
                }else  if(bundle.get("one")!=null)
                {
                    String s= Utils.getAPI(Utils.one_month_bitcoin);
                    client= ServiceGenrator.createService(Client.class,s);
                    callonedayprice(client,"one_month");
                    callgraph(client,"one_month");
                }

                else  if(bundle.get("three")!=null)
                {
                    String s = Utils.getAPI(Utils.one_month_etherum);
                    client = ServiceGenrator.createService(Client.class, s);
                    callonedayprice(client, "one_month");
                    callgraph(client,"one_month");
                }
                else  if(bundle.get("four")!=null)
                {
                    String s = Utils.getAPI(Utils.one_month_litecoin);
                    client = ServiceGenrator.createService(Client.class, s);
                    callonedayprice(client, "one_month");
                    callgraph(client,"one_month");
                }

                else  if(bundle.get("five")!=null)
                {
                    String s = Utils.getAPI(Utils.one_month_bitcoin_cash);
                    client = ServiceGenrator.createService(Client.class, s);
                    callonedayprice(client, "one_month");
                    callgraph(client,"one_month");
                }



            }
        });

        three_month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(bundle.get("two")!=null)
                {
                    String s = Utils.getAPI(Utils.three_month_ripple);
                    client = ServiceGenrator.createService(Client.class, s);
                    callonedayprice(client, "three_month");
                    callgraph(client, "three_month");
                }
                else  if(bundle.get("one")!=null)
                {
                    String s= Utils.getAPI(Utils.three_month_bitcoin);
                    client= ServiceGenrator.createService(Client.class,s);
                    callonedayprice(client,"three_month");
                    callgraph(client, "three_month");
                }

                else  if(bundle.get("three")!=null)
                {
                    String s = Utils.getAPI(Utils.threemonthethereum);
                    client = ServiceGenrator.createService(Client.class, s);
                    callonedayprice(client, "three_month");
                    callgraph(client, "three_month");
                }
                else  if(bundle.get("four")!=null)
                {
                    String s = Utils.getAPI(Utils.three_montyh_litecoin);
                    client = ServiceGenrator.createService(Client.class, s);
                    callonedayprice(client, "three_month");
                    callgraph(client, "three_month");
                }

                else  if(bundle.get("five")!=null)
                {
                    String s = Utils.getAPI(Utils.three_montyh_bitcoin_cash);
                    client = ServiceGenrator.createService(Client.class, s);
                    callonedayprice(client, "three_month");
                    callgraph(client, "three_month");
                }


            }
        });
        six_month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(bundle.get("two")!=null)
                {
                    String s = Utils.getAPI(Utils.six_month_ripple);
                    client = ServiceGenrator.createService(Client.class, s);
                    callonedayprice(client, "six_month");
                    callgraph(client,"six_month");
                }
                else  if(bundle.get("one")!=null)
                {
                    String s= Utils.getAPI(Utils.six_month_bitcoin);
                    client= ServiceGenrator.createService(Client.class,s);
                    callonedayprice(client,"six_month");
                    callgraph(client,"six_month");
                }

                else  if(bundle.get("three")!=null)
                {
                    String s = Utils.getAPI(Utils.sixmonthethereum);
                    client = ServiceGenrator.createService(Client.class, s);
                    callonedayprice(client, "six_month");
                    callgraph(client,"six_month");
                }
                else  if(bundle.get("four")!=null)
                {
                    String s = Utils.getAPI(Utils.six_month_litecoin);
                    client = ServiceGenrator.createService(Client.class, s);
                    callonedayprice(client, "six_month");
                    callgraph(client,"six_month");
                }

                else  if(bundle.get("five")!=null)
                {
                    String s = Utils.getAPI(Utils.six_month_bitcoin_cash);
                    client = ServiceGenrator.createService(Client.class, s);
                    callonedayprice(client, "six_month");
                    callgraph(client,"six_month");
                }


            }
        });
        one_year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(bundle.get("two")!=null)
                {
                    String s = Utils.getAPI(Utils.one_year_ripple);
                    client = ServiceGenrator.createService(Client.class, s);
                    callonedayprice(client, "one_year");
                    callgraph(client,"one_year");
                }
                else  if(bundle.get("two")!=null)
                {
                    String s= Utils.getAPI(Utils.one_year_bitcoin);
                    client= ServiceGenrator.createService(Client.class,s);
                    callonedayprice(client,"one_year");
                    callgraph(client,"one_year");
                }

                else  if(bundle.get("three")!=null)
                {
                    String s = Utils.getAPI(Utils.one_yearethereum);
                    client = ServiceGenrator.createService(Client.class, s);
                    callonedayprice(client, "one_year");
                    callgraph(client,"one_year");
                }

                else  if(bundle.get("four")!=null)
                {
                    String s = Utils.getAPI(Utils.one_year_litecoin);
                    client = ServiceGenrator.createService(Client.class, s);
                    callonedayprice(client, "one_year");
                    callgraph(client,"one_year");
                }
                else  if(bundle.get("five")!=null)
                {
                    String s = Utils.getAPI(Utils.one_year_bitcoin_cash);
                    client = ServiceGenrator.createService(Client.class, s);
                    callonedayprice(client, "one_year");
                    callgraph(client,"one_year");
                }

            }
        });

    }

    private String callonedayprice(Client client, final String whichType) {
        Call<CryptoCurrency> cryptoCurrencyCall = null;
        if (whichType.equals("one_hour")) {
            if (bundle.get("three") != null) {

                cryptoCurrencyCall = client.getonedayETH();
            } else if (bundle.get("two") != null) {
                cryptoCurrencyCall = client.getonedayXRP();
            } else if (bundle.get("one") != null) {
                cryptoCurrencyCall = client.getGetonedayBTC();
            }
            else if (bundle.get("five") != null) {
                cryptoCurrencyCall = client.getonedayBCH();
            }

        }

        else if (whichType.equals("one_day")) {
            cryptoCurrencyCall = client.getonedayETH();
            if (bundle.get("two") != null) {
                cryptoCurrencyCall = client.getonedayXRP();
            } else if (bundle.get("three") != null) {
                cryptoCurrencyCall = client.getonedayETH();
            } else if (bundle.get("one") != null) {
                cryptoCurrencyCall = client.getGetonedayBTC();
            }
            else if (bundle.get("five") != null) {
                cryptoCurrencyCall = client.getonedayBCH();
            }

        }

        else if (whichType.equals("one_week")) {
            if (bundle.get("two") != null) {

                cryptoCurrencyCall = client.getsevendayXRP();
            } else if (bundle.get("three") != null) {

                cryptoCurrencyCall = client.getsevendayETH();
            } else if (bundle.get("one") != null) {
                cryptoCurrencyCall = client.getsevendayBTC();
            }
            else if (bundle.get("five") != null) {
                cryptoCurrencyCall = client.getsevendayBCH();
            }

        }

        else if (whichType.equals("one_month")) {

            if (bundle.get("two") != null) {
                cryptoCurrencyCall = client.getonemonthXRP();
            } else if (bundle.get("three") != null) {
                cryptoCurrencyCall = client.getonemonthETH();
            } else if (bundle.get("one") != null) {
                cryptoCurrencyCall = client.getonemonthBCT();
            }
            else if (bundle.get("five") != null) {
                cryptoCurrencyCall = client.getonemonthBCH();
            }

        }

        else if (whichType.equals("three_month")) {


            if (bundle.get("two") != null) {
                cryptoCurrencyCall = client.getthreemonthXRP();
            } else if (bundle.get("three") != null) {
                cryptoCurrencyCall = client.getThreemonthsETH();

            } else if (bundle.get("one") != null) {
                cryptoCurrencyCall = client.getthreemonthBTC();
            }
            else if (bundle.get("five") != null) {
                cryptoCurrencyCall = client.getthreemonthBCH();
            }


        }

        else if (whichType.equals("six_month")) {


            if (bundle.get("two") != null) {
                cryptoCurrencyCall = client.getsixmonthXRP();
            } else if (bundle.get("three") != null) {
                cryptoCurrencyCall = client.getsixmonthETH();
            } else if (bundle.get("one") != null) {
                cryptoCurrencyCall = client.getsixmonthBTC();
            }

            else if (bundle.get("five") != null) {
                cryptoCurrencyCall = client.getsixmonthBCH();
            }

        }

        else if (whichType.equals("one_year")) {


            if (bundle.get("two") != null) {
                cryptoCurrencyCall = client.getoneyearXRP();
            } else if (bundle.get("three") != null) {
                cryptoCurrencyCall = client.getoneyearETH();
            } else if (bundle.get("one") != null) {
                cryptoCurrencyCall = client.getoneyearBTC();
            }

            else if (bundle.get("five") != null) {
                cryptoCurrencyCall = client.getoneyearBCH();
            }

        }

        cryptoCurrencyCall.enqueue(new Callback<CryptoCurrency>() {
            @Override
            public void onResponse(Call<CryptoCurrency> call, Response<CryptoCurrency> response) {
                getprice = response.body().getPrice();

                List<Float> array = new ArrayList<>();

                if (getprice.size() != 0) {

                    if (whichType.equals("one_hour")) {
                        array.add(dateformat(getprice.get(getprice.size() - 1).get(0)));
                        array.add(dateformat(getprice.get(getprice.size() - 4).get(0)));
                        array.add(dateformat(getprice.get(getprice.size() - 7).get(0)));

                        List<Float> array_value = new ArrayList<>();


                        buy.setText("$" + String.valueOf(getprice.get(getprice.size() - 1).get(1)));
                        below_price.setText(RateDifferenceoneHour().toString());
                        display_difference.setText("since an hour ago");
                        array_value.add(getprice.get(getprice.size() - 7).get(1));


                    } else if (whichType.equals("one_day")) {
                        buy.setText("$" + String.valueOf(getprice.get(getprice.size() - 1).get(1)));
                        below_price.setText(RateDifferenceoneday().toString());
                        display_difference.setText("since yesterday");
                    } else if (whichType.equals("one_week")) {
                        buy.setText("$" + String.valueOf(getprice.get(0).get(1)));
                        below_price.setText(RateDiffernce().toString());
                        display_difference.setText("since last week");
                    } else if (whichType.equals("one_month")) {
                        buy.setText("$" + String.valueOf(getprice.get(0).get(1)));
                        below_price.setText(RateDiffernce().toString());
                        display_difference.setText("since last month");

                    } else if (whichType.equals("three_month")) {
                        buy.setText("$" + String.valueOf(getprice.get(0).get(1)));
                        below_price.setText(RateDiffernce().toString());
                        display_difference.setText("since 3 months");
                    } else if (whichType.equals("six_month")) {
                        buy.setText("$" + String.valueOf(getprice.get(0).get(1)));
                        below_price.setText(RateDiffernce().toString());
                        display_difference.setText("since 6 months");
                    } else if (whichType.equals("one_year")) {
                        buy.setText("$" + String.valueOf(getprice.get(0).get(1)));
                        below_price.setText(RateDiffernce().toString());
                        display_difference.setText("since 1 year");

                    }


                }

            }


            public Float RateDifferenceoneday() {
                Float difference_oneday = getprice.get(getprice.size() - 1).get(1) - getprice.get(0).get(1);
                if (difference_oneday > 0) {
                    below_price.setText(difference_oneday.toString());
                    below_price.setTextColor(Color.GREEN);
                } else {
                    below_price.setText(difference_oneday.toString());
                    below_price.setTextColor(Color.RED);
                }
                return difference_oneday;
            }

            public Float RateDiffernce() {
                Float difference_oneweek = getprice.get(getprice.size() - 1).get(1) - getprice.get(0).get(1);
                if (difference_oneweek > 0) {
                    below_price.setText(difference_oneweek.toString());
                    below_price.setTextColor(Color.GREEN);
                } else {
                    below_price.setText(difference_oneweek.toString());
                    below_price.setTextColor(Color.RED);
                }
                return difference_oneweek;
            }

            public Float RateDifferenceoneHour() {
                Float difference_onehour = getprice.get(getprice.size() - 1).get(1) - getprice.get(getprice.size() - 2).get(1);
                if (difference_onehour > 0) {
                    below_price.setText(difference_onehour.toString());
                    below_price.setTextColor(Color.GREEN);
                } else {
                    below_price.setText(difference_onehour.toString());
                    below_price.setTextColor(Color.RED);
                }
                return difference_onehour;
            }

            public Float dateformat(Float getprice_time) {
                SimpleDateFormat formatter = new SimpleDateFormat("HH.mm");
                Float formattedDate = Float.valueOf((formatter.format(getprice_time)));
                // formattedDate=(formatter.format(getprice.get(getprice.size())));


                return formattedDate;
            }


            @Override
            public void onFailure(Call<CryptoCurrency> call, Throwable t) {

                Log.d("ERROR ", "", t);
            }
        });
        return whichType;

    }



    private String callgraph(Client client,final String whichType)
    {Call<CryptoCurrency> cryptoCurrencyCall=null;



        if (whichType.equals("one_hour")) {
            if(bundle.get("three")!=null) {

                cryptoCurrencyCall = client.getonedayETH();
            }
            else  if(bundle.get("two")!=null)
            {
                cryptoCurrencyCall=client.getonedayXRP();
            }
            else  if(bundle.get("one")!=null)
            {
                cryptoCurrencyCall=client.getGetonedayBTC();
            }
            else  if(bundle.get("four")!=null)
            {
                cryptoCurrencyCall=client.getonedayLTC();
            }
            else  if(bundle.get("five")!=null)
            {
                cryptoCurrencyCall=client.getonedayBCH();
            }


        }

        else if (whichType.equals("one_day")) {
            cryptoCurrencyCall = client.getonedayETH();
            if(bundle.get("two")!=null)
            {
                cryptoCurrencyCall=client.getonedayXRP();
            }
            else  if(bundle.get("three")!=null)
            {
                cryptoCurrencyCall = client.getonedayETH();
            }
            else  if(bundle.get("one")!=null)
            {
                cryptoCurrencyCall=client.getGetonedayBTC();
            }
            else  if(bundle.get("four")!=null)
            {
                cryptoCurrencyCall=client.getonedayLTC();
            }
            else  if(bundle.get("five")!=null)
            {
                cryptoCurrencyCall=client.getonedayBCH();
            }

        }

        else if (whichType.equals("one_week")) {
            if(bundle.get("two")!=null)
            {

                cryptoCurrencyCall=client.getsevendayXRP();
            }
            else  if(bundle.get("three")!=null)
            {

                cryptoCurrencyCall = client.getsevendayETH();
            }
            else  if(bundle.get("one")!=null)
            {
                cryptoCurrencyCall=client.getsevendayBTC();
            }
            else  if(bundle.get("four")!=null)
            {
                cryptoCurrencyCall=client.getsevendayLTC();
            }
            else  if(bundle.get("five")!=null)
            {
                cryptoCurrencyCall=client.getsevendayBCH();
            }

        }

        else if(whichType.equals("one_month"))
        {

            if(bundle.get("two")!=null)
            {
                cryptoCurrencyCall=client.getonemonthXRP();
            }
            else  if(bundle.get("three")!=null)
            {
                cryptoCurrencyCall=client.getonemonthETH();
            }
            else  if(bundle.get("one")!=null)
            {
                cryptoCurrencyCall=client.getonemonthBCT();
            }
            else  if(bundle.get("four")!=null)
            {
                cryptoCurrencyCall=client.getonemonthLCT();
            }
            else  if(bundle.get("five")!=null)
            {
                cryptoCurrencyCall=client.getonemonthBCH();
            }

        }
        else if(whichType.equals("three_month"))
        {


            if(bundle.get("two")!=null)
            {
                cryptoCurrencyCall = client.getthreemonthXRP();
            }
            else  if(bundle.get("three")!=null)
            {cryptoCurrencyCall = client.getThreemonthsETH();

            }
            else  if(bundle.get("one")!=null)
            {
                cryptoCurrencyCall=client.getthreemonthBTC();
            }
            else  if(bundle.get("four")!=null)
            {
                cryptoCurrencyCall=client.getthreemonthLTC();
            }
            else  if(bundle.get("five")!=null)
            {
                cryptoCurrencyCall=client.getthreemonthBCH();
            }

        }
        else if(whichType.equals("six_month"))
        {


            if(bundle.get("two")!=null)
            {
                cryptoCurrencyCall = client.getsixmonthXRP();
            }
            else  if(bundle.get("three")!=null)
            {
                cryptoCurrencyCall = client.getsixmonthETH();
            }
            else  if(bundle.get("one")!=null)
            {
                cryptoCurrencyCall=client.getsixmonthBTC();
            }
            else  if(bundle.get("four")!=null)
            {
                cryptoCurrencyCall=client.getsixmonthLTC();
            }
            else  if(bundle.get("four")!=null)
            {
                cryptoCurrencyCall=client.getsixmonthBCH();
            }

        }
        else if(whichType.equals("one_year"))
        {


            if(bundle.get("two")!=null)
            {
                cryptoCurrencyCall = client.getoneyearXRP();
            }
            else  if(bundle.get("three")!=null)
            {
                cryptoCurrencyCall = client.getoneyearETH();
            }
            else  if(bundle.get("one")!=null)
            {
                cryptoCurrencyCall=client.getoneyearBTC();
            }
            else  if(bundle.get("four")!=null)
            {
                cryptoCurrencyCall=client.getoneyearLTC();
            }
            else  if(bundle.get("five")!=null)
            {
                cryptoCurrencyCall=client.getoneyearBCH();
            }

        }

        cryptoCurrencyCall.enqueue(new Callback<CryptoCurrency>() {
            @Override
            public void onResponse(Call<CryptoCurrency> call, Response<CryptoCurrency> response) {
                List<Entry> entries = new ArrayList<>();
                marketCap=response.body().getPrice();
                if(response.isSuccessful()) {
                    if (whichType.equals("one_hour")) {
                        if (marketCap == null) {
                            Toast.makeText(ExploreActivity.this, "MarketCap is null from response", Toast.LENGTH_SHORT).show();

                        } else {
                            setXAxisValues();
                            setYAxisValues();
                            setData();
                        }
                    }
                    else if(whichType.equals("one_day"))
                    {
                        if (marketCap == null) {
                            Toast.makeText(ExploreActivity.this, "MarketCap is null from response", Toast.LENGTH_SHORT).show();

                        } else {
                            setXAxisValues();
                            setYAxisValues();
                            setData();
                        }
                    }
                    else if(whichType.equals("one_week"))
                    {
                        if (marketCap == null) {
                            Toast.makeText(ExploreActivity.this, "MarketCap is null from response", Toast.LENGTH_SHORT).show();

                        } else {
                            setXAxisValues();
                            setYAxisValues();
                            setData();
                        }
                    }
                    else if(whichType.equals("one_month"))
                    {
                        if (marketCap == null) {
                            Toast.makeText(ExploreActivity.this, "MarketCap is null from response", Toast.LENGTH_SHORT).show();

                        } else {
                            setXAxisValues();
                            setYAxisValues();
                            setData();
                        }
                    }
                    else if(whichType.equals("three_month"))
                    {
                        if (marketCap == null) {
                            Toast.makeText(ExploreActivity.this, "MarketCap is null from response", Toast.LENGTH_SHORT).show();

                        } else {
                            setXAxisValues();
                            setYAxisValues();
                            setData();
                        }
                    }
                    else if(whichType.equals("six_month"))
                    {
                        if (marketCap == null) {
                            Toast.makeText(ExploreActivity.this, "MarketCap is null from response", Toast.LENGTH_SHORT).show();

                        } else {
                            setXAxisValues();
                            setYAxisValues();
                            setData();
                        }
                    }
                    else if(whichType.equals("one_year"))
                    {
                        if (marketCap == null) {
                            Toast.makeText(ExploreActivity.this, "MarketCap is null from response", Toast.LENGTH_SHORT).show();

                        } else {
                            setXAxisValues();
                            setYAxisValues();
                            setData();
                        }
                    }
                }
            }
            private ArrayList<String> setXAxisValues(){
                ArrayList<String> array = new ArrayList<>();

                array.add(String.valueOf(dateformat(marketCap.get(marketCap.size() - 1).get(0))));
                array.add(String.valueOf(dateformat(marketCap.get(marketCap.size() - 4).get(0))));
                array.add(String.valueOf(dateformat(marketCap.get(marketCap.size() - 7).get(0))));
                array.add(String.valueOf(dateformat(marketCap.get(marketCap.size()-15).get(0))));




                return array;
            }
            private ArrayList<Entry> setYAxisValues(){
                ArrayList<Entry> yVals = new ArrayList<Entry>();

                /*List<Float> array_value = new ArrayList<>();
                array_value.add(marketCap.get(marketCap.size() - 1).get(1));
                array_value.add(marketCap.get(marketCap.size() - 4).get(1));
                array_value.add(marketCap.get(marketCap.size() - 7).get(1));*/


                yVals.add(new Entry(marketCap.get(marketCap.size() - 1).get(1),0));
                //  yVals.add(new Entry(marketCap.get(marketCap.size() - 4).get(1),1));
                yVals.add(new Entry(marketCap.get(marketCap.size() - 7).get(1), 2));
                yVals.add(new Entry(marketCap.get(marketCap.size() - 7).get(1), 3));
              /*  yVals.add(new Entry(100, 3));
                yVals.add(new Entry(180.9f, 4));*/

                return yVals;
            }
            public void setData() {
                ArrayList<String> xVals = setXAxisValues();

                ArrayList<Entry> yVals = setYAxisValues();

                LineDataSet set1;

                // create a dataset and give it a type
                set1 = new LineDataSet(yVals, "DataSet 1");
                //set1.setFillAlpha(110);

                // set1.setFillColor(Color.RED);

                // set the line to be drawn like this "- - - - - -"
                // set1.enableDashedLine(10f, 5f, 0f);
                // set1.enableDashedHighlightLine(10f, 5f, 0f);
                set1.setColor(Color.BLACK);
                set1.setCircleColor(Color.BLACK);
                set1.setLineWidth(1f);
                set1.setCircleRadius(3f);
                set1.setDrawCircleHole(false);
                set1.setValueTextSize(9f);
                set1.setDrawFilled(true);

                ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
                dataSets.add(set1); // add the datasets

                // create a data object with the datasets
                LineData data = new LineData(set1);


                // set data
                mChart.setData(data);
                Legend l = mChart.getLegend();
                l.setForm(Legend.LegendForm.LINE);
                mChart.invalidate();

            }


            public Float dateformat(Float marketcap_time)
            {
                SimpleDateFormat formatter = new SimpleDateFormat("HH.mm");
                Float formattedDate = Float.valueOf((formatter.format(marketcap_time)));
                // formattedDate=(formatter.format(marketCap.get(marketCap.size())));




                return formattedDate;
            }

            @Override
            public void onFailure(Call<CryptoCurrency> call, Throwable t) {

            }
        });
        return whichType;
    }
   /* private void showFilterPopup(View view)
    {
        final PopupMenu popupMenu=new PopupMenu(this,view);
        popupMenu.inflate(R.menu.exchanges);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId())
                {

                    case R.id.zebpay:
                        int TAGZEBPAY=54;
                        if(bundle.get("one")!=null )
                        {
                            popupMenu.getMenu().findItem(R.id.zebpay).setVisible(true);
                          Intent intent = new Intent(getApplication(),ExhchangeFragment.class);

                            intent.putExtra("zebpay",TAGZEBPAY);
                            startActivity(intent);
                           // Toast.makeText(getApplicationContext(),"hello zebpay",Toast.LENGTH_SHORT).show();
                            return true;
                        }
                        else {
                                popupMenu.getMenu().findItem(R.id.zebpay).setVisible(false);
                        }




                    case R.id.coin_secure:
                        if(bundle.get("one")!=null || bundle.get("two")!=null)
                        {
                            Toast.makeText(getApplicationContext(),"hello coinsecure",Toast.LENGTH_SHORT).show();
                            return true;
                        }
                        else {
                            item.setVisible(false);
                        }


                    case R.id.unocoin:
                        Intent intent1= new Intent(getApplicationContext(),ExhchangeFragment.class);
                        String TAGUnocoin="Unocoin";
                        intent1.putExtra("unocoin",TAGUnocoin);
                        startActivity(intent1);
                        return true;

                    default:
                        return false;
                }
            }
        });
        popupMenu.show();

    }
*/
    public void exchange()
    {
        if(bundle.get("one")!=null)
        {

        }
    }

}
