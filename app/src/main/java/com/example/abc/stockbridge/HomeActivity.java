package com.example.abc.stockbridge;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abc.stockbridge.data.Latest;
import com.example.abc.stockbridge.data.LatestCrypto;
import com.example.abc.stockbridge.network.Client;
import com.example.abc.stockbridge.network.ServiceGenrator;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity{
    TextView latest_price, crypto, commodity, news, mutual_fund, subdata;
    TextView bitcoin, ethereum, ripple, litecoin,bitcoin_cash1;
    TextView news1;
    TextView mutal_fund_sub;
    TextView commdity_detail;
    Client client;
    String[] crptocurrency = {"Bitcoin", "Ethereum", "Ripple"};
    LinearLayout news_expan, mutual_fund_expan, commodity_linearlayout;
    RelativeLayout expandaable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mutal_fund_sub = (TextView) findViewById(R.id.mutual_fund_detail);
        commdity_detail = (TextView) findViewById(R.id.commodity_details);
        latest_price = (TextView) findViewById(R.id.latest_price);
        crypto = (TextView) findViewById(R.id.crypto);
        commodity = (TextView) findViewById(R.id.commodity);
        expandaable = (RelativeLayout) findViewById(R.id.expandable);
        news_expan = (LinearLayout) findViewById(R.id.news_expan);
        mutual_fund_expan = (LinearLayout) findViewById(R.id.mutualfund_expan);
        commodity_linearlayout = (LinearLayout) findViewById(R.id.commodity_linearlayout);
        news = (TextView) findViewById(R.id.news);
        mutual_fund = (TextView) findViewById(R.id.mutual_fund);
        bitcoin = (TextView) findViewById(R.id.bitcoin);
        bitcoin_cash1=(TextView)findViewById(R.id.bitcoin_cash);
        ethereum = (TextView) findViewById(R.id.ethereum);
        ripple = (TextView) findViewById(R.id.ripple);
        litecoin = (TextView) findViewById(R.id.litecoin);
        news1 = (TextView) findViewById(R.id.news1);
        String s = Utils.getAPI(Utils.latest_price);
        client = ServiceGenrator.createService(Client.class, s);
        calllatestprice(client);


        bitcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = Utils.getAPI(Utils.bitcoin);
                client = ServiceGenrator.createService(Client.class, s);
                callBitcoin(client);

            }
        });
        ripple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = Utils.getAPI(Utils.ripple);
                client = ServiceGenrator.createService(Client.class, s);
                callRipple(client);
            }
        });

        ethereum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = Utils.getAPI(Utils.ethereum);
                client = ServiceGenrator.createService(Client.class, s);
                callEthereum(client);
            }
        });
        litecoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = Utils.getAPI(Utils.litecoin);
                client = ServiceGenrator.createService(Client.class, s);
                callLitecoin(client);

            }
        });
        bitcoin_cash1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = Utils.getAPI(Utils.one_day_bitcoin_cash);
                client= ServiceGenrator.createService(Client.class,s);
                callBitcoin_cash(client);
            }
        });
//        expandaable.setVisibility(View.GONE);
        crypto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandaable.getVisibility() == View.GONE) {

                    expandaable.setVisibility(View.VISIBLE);

                } else {
                    expandaable.setVisibility(View.GONE);


                }
            }
        });
        commodity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (commodity_linearlayout.getVisibility() == View.GONE) {
                    commodity_linearlayout.setVisibility(View.VISIBLE);
                } else {
                    commodity_linearlayout.setVisibility(View.GONE);
                }

            }
        });

        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (news_expan.getVisibility() == View.GONE) {
                    news_expan.setVisibility(View.VISIBLE);
                } else {
                    news_expan.setVisibility(View.GONE);
                }

            }
        });
        mutual_fund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mutual_fund_expan.getVisibility() == View.GONE) {
                    mutual_fund_expan.setVisibility(View.VISIBLE);
                } else {
                    mutual_fund_expan.setVisibility(View.GONE);
                }
            }
        });

    }


    private void callBitcoin(Client client) {
        Intent intent = new Intent(HomeActivity.this, ViewActivity.class);
        String TAG = "one";
        intent.putExtra("one", TAG);
        startActivity(intent);
    }

    private void callLitecoin(Client client) {
        Intent intent = new Intent(HomeActivity.this, ViewActivity.class);
        String TAG = "four";
        intent.putExtra("four", TAG);
        startActivity(intent);

    }

    private String calllatestprice(Client client) {

        final Call<List<LatestCrypto>> listCall = client.getlatestprice();
        listCall.enqueue(new Callback<List<LatestCrypto>>() {
            @Override
            public void onResponse(Call<List<LatestCrypto>> call, Response<List<LatestCrypto>> response) {
                Float bitcoin1 = response.body().get(0).getPriceUsd();
                Float etherum = response.body().get(1).getPriceUsd();
                Float ethereum_perchange = Float.valueOf(response.body().get(1).getPercentChange24h());
                Float ripple1 = response.body().get(2).getPriceUsd();
                Float ripple_perchane = Float.valueOf(response.body().get(2).getPercentChange24h());
                Float bitcoin_perchange = Float.valueOf(response.body().get(0).getPercentChange24h());
                Float litecoin1 = response.body().get(4).getPriceUsd();
                Float litecoin_percentagechange = Float.valueOf(response.body().get(4).getPercentChange24h());
                Float bitcoin_cash=response.body().get(3).getPriceUsd();
                Float bitcoin_percentage_change= Float.valueOf(response.body().get(3).getPercentChange24h());

                //ripple.setText("Ripple"+"\n"+ripple1.toString());

                final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                final int flag = Spannable.SPAN_EXCLUSIVE_EXCLUSIVE;
                if (bitcoin1 != null) {
                    if (bitcoin_perchange > 0) {
                        SpannableString spannableString = new SpannableString("Bitcoin(BTC)" + "\n" + "$" + bitcoin1.toString() + "\n" + "24H:");
                        spannableString.setSpan(new ForegroundColorSpan(Color.BLACK), 0, spannableString.length(), 0);
                        ;
                        spannableStringBuilder.append(spannableString);
                        SpannableString spannableString1 = new SpannableString( bitcoin_perchange.toString()+"%");
                        spannableString1.setSpan(new ForegroundColorSpan(Color.GREEN), 0, spannableString1.length(), 0);
                        ;
                        spannableStringBuilder.append(spannableString1);
                        bitcoin.setText(spannableStringBuilder);

                    } else {
                        SpannableString spannableString = new SpannableString("Bitcoin(BTC)" + "\n" + "$" + bitcoin1.toString() + "\n" + "24H:");
                        spannableString.setSpan(new ForegroundColorSpan(Color.BLACK), 0, spannableString.length(), 0);
                        ;
                        spannableStringBuilder.append(spannableString);
                        SpannableString spannableString1 = new SpannableString(bitcoin_perchange.toString()+"%");
                        spannableString1.setSpan(new ForegroundColorSpan(Color.RED), 0, spannableString1.length(), 0);
                        ;
                        spannableStringBuilder.append(spannableString1);
                        bitcoin.setText(spannableStringBuilder);


                    }
                }
                if (etherum != null)


                {
                    final SpannableStringBuilder spannableStringBuildereth = new SpannableStringBuilder();
                    if (ethereum_perchange > 0) {
                        SpannableString spannableStringeth = new SpannableString("Ethereum(ETH)" + "\n" + "$" + etherum.toString() + "\n" + "24H:");
                        spannableStringeth.setSpan(new ForegroundColorSpan(Color.BLACK), 0, spannableStringeth.length(), 0);
                        ;
                        spannableStringBuildereth.append(spannableStringeth);
                        SpannableString spannableStringeth1 = new SpannableString(  ethereum_perchange.toString()+"%");
                        spannableStringeth1.setSpan(new ForegroundColorSpan(Color.GREEN), 0, spannableStringeth1.length(), 0);
                        ;
                        spannableStringBuildereth.append(spannableStringeth1);
                        ethereum.setText(spannableStringBuildereth);
                    } else {
                        SpannableString spannableStringeth = new SpannableString("Ethereum(ETH)" + "\n" + "$" + etherum.toString() + "\n" + "24H:");
                        spannableStringeth.setSpan(new ForegroundColorSpan(Color.BLACK), 0, spannableStringeth.length(), 0);
                        ;
                        spannableStringBuildereth.append(spannableStringeth);
                        SpannableString spannableStringeth1 = new SpannableString(ethereum_perchange.toString()+"%");
                        spannableStringeth1.setSpan(new ForegroundColorSpan(Color.RED), 0, spannableStringeth1.length(), 0);
                        ;
                        spannableStringBuildereth.append(spannableStringeth1);
                        ethereum.setText(spannableStringBuildereth);
                    }
                }
                if (ripple1 != null) {
                    SpannableStringBuilder spannableStringBuilderripple = new SpannableStringBuilder();
                    if (ripple_perchane > 0) {
                        SpannableString spannableStringripple = new SpannableString("Ripple(XRP)" + "\n" + "$" + ripple1.toString() + "\n" + "24H:");
                        spannableStringripple.setSpan(new ForegroundColorSpan(Color.BLACK), 0, spannableStringripple.length(), 0);
                        ;
                        spannableStringBuilderripple.append(spannableStringripple);
                        SpannableString spannableStringripple1 = new SpannableString( ripple_perchane.toString()+"%");
                        spannableStringripple1.setSpan(new ForegroundColorSpan(Color.GREEN), 0, spannableStringripple1.length(), 0);
                        ;
                        spannableStringBuilderripple.append(spannableStringripple1);
                        ripple.setText(spannableStringBuilderripple);

                    } else {
                        SpannableString spannableStringripple = new SpannableString("Ripple(XRP)" + "\n" + "$" + ripple1.toString() + "\n" + "24H:");
                        spannableStringripple.setSpan(new ForegroundColorSpan(Color.BLACK), 0, spannableStringripple.length(), 0);
                        ;
                        spannableStringBuilderripple.append(spannableStringripple);
                        SpannableString spannableStringripple1 = new SpannableString( ripple_perchane.toString()+"%");
                        spannableStringripple1.setSpan(new ForegroundColorSpan(Color.RED), 0, spannableStringripple1.length(), 0);
                        ;
                        spannableStringBuilderripple.append(spannableStringripple1);
                        ripple.setText(spannableStringBuilderripple);
                    }
                }
                if (litecoin1 != null) {

                    SpannableStringBuilder spannableStringBuilderlitecoin = new SpannableStringBuilder();
                    if (litecoin_percentagechange > 0) {
                        SpannableString spannableStringlitecoin = new SpannableString("Litecoin(LTC)" + "\n" + "$" + litecoin1.toString() + "\n" + "24H:");
                        spannableStringlitecoin.setSpan(new ForegroundColorSpan(Color.BLACK), 0, spannableStringlitecoin.length(), 0);
                        ;
                        spannableStringBuilderlitecoin.append(spannableStringlitecoin);
                        SpannableString spannableStringlitecoin1 = new SpannableString( litecoin_percentagechange.toString()+"%");
                        spannableStringlitecoin1.setSpan(new ForegroundColorSpan(Color.GREEN), 0, spannableStringlitecoin1.length(), 0);
                        ;
                        spannableStringBuilderlitecoin.append(spannableStringlitecoin1);
                        litecoin.setText(spannableStringBuilderlitecoin);

                    }
                    else {
                        SpannableString spannableStringlitecoin= new SpannableString("Litecoin(LTC)"+"\n"+"$"+litecoin1.toString()+"\n"+"24H:");
                        spannableStringlitecoin.setSpan(new ForegroundColorSpan(Color.BLACK),0,spannableStringlitecoin.length(),0);;
                        spannableStringBuilderlitecoin.append(spannableStringlitecoin);
                        SpannableString spannableStringlitecoin1= new SpannableString(litecoin_percentagechange.toString()+"%");
                        spannableStringlitecoin1.setSpan(new ForegroundColorSpan(Color.RED),0,spannableStringlitecoin1.length(),0);;
                        spannableStringBuilderlitecoin.append(spannableStringlitecoin1);
                        litecoin.setText(spannableStringBuilderlitecoin);
                    }
                }

                if (bitcoin_cash != null) {
                    SpannableStringBuilder spannableStringBuilderripple = new SpannableStringBuilder();
                    if (bitcoin_percentage_change > 0) {
                        SpannableString spannableStringripple = new SpannableString("Bitcoin Cash(BCH)" + "\n" + "$" + bitcoin_cash.toString() + "\n" + "24H:");
                        spannableStringripple.setSpan(new ForegroundColorSpan(Color.BLACK), 0, spannableStringripple.length(), 0);
                        ;
                        spannableStringBuilderripple.append(spannableStringripple);
                        SpannableString spannableStringripple1 = new SpannableString( bitcoin_percentage_change.toString()+"%");
                        spannableStringripple1.setSpan(new ForegroundColorSpan(Color.GREEN), 0, spannableStringripple1.length(), 0);
                        ;
                        spannableStringBuilderripple.append(spannableStringripple1);
                        bitcoin_cash1.setText(spannableStringBuilderripple);

                    } else {
                        SpannableString spannableStringripple = new SpannableString("Bitcoin Cash(BCH)" + "\n" + "$" + bitcoin_cash.toString() + "\n" + "24H:");
                        spannableStringripple.setSpan(new ForegroundColorSpan(Color.BLACK), 0, spannableStringripple.length(), 0);
                        ;
                        spannableStringBuilderripple.append(spannableStringripple);
                        SpannableString spannableStringripple1 = new SpannableString( bitcoin_percentage_change.toString()+"%");
                        spannableStringripple1.setSpan(new ForegroundColorSpan(Color.RED), 0, spannableStringripple1.length(), 0);
                        ;
                        spannableStringBuilderripple.append(spannableStringripple1);
                        bitcoin_cash1.setText(spannableStringBuilderripple);
                    }
                }


                //Toast.makeText(getApplicationContext(), bitcoin.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<LatestCrypto>> call, Throwable t) {

            }
        });
        return null;
    }

    private void callRipple(Client client) {
        Intent intent = new Intent(getApplicationContext(), ViewActivity.class);
        String TAG = "Hi";
        intent.putExtra("two", TAG);
        startActivity(intent);

    }

    private void callEthereum(Client client) {
        Intent intent = new Intent(HomeActivity.this, ViewActivity.class);
        String TAG = "three";
        intent.putExtra("three", TAG);
        startActivity(intent);
    }

    private void callBitcoin_cash(Client client)
    {
        Intent intent = new Intent(getApplicationContext(),ViewActivity.class);

        String TAG = "five";
        intent.putExtra("five",TAG);
        startActivity(intent);

    }

    public void toggle_contents(View view) {
        subdata.setVisibility(subdata.isShown()
                ? View.GONE : View.VISIBLE);
    }
}
