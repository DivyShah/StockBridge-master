package com.example.abc.stockbridge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.abc.stockbridge.data.ZebpayAPI;
import com.example.abc.stockbridge.network.Client;
import com.example.abc.stockbridge.network.ServiceGenrator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class All_Exchange_Activity extends AppCompatActivity {

    Bundle bundle;
    TextView buy,sell;
    Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all__exchange_);
        bundle=getIntent().getExtras();
        buy=(TextView)findViewById(R.id.buy_zebpay);
        sell=(TextView)findViewById(R.id.sell_zebpay);
        if(bundle.get("zebpay")!=null)
        {
            String s= Utils.getAPI(Utils.bitcoin);
            client=ServiceGenrator.createService(Client.class,s);
            callzebpay(client);
        }
        else
        {

        }



    }

    private void callzebpay(Client client)
    {
        Call<ZebpayAPI> zebpayAPICall=client.getBitcoin();
        zebpayAPICall.enqueue(new Callback<ZebpayAPI>() {
            @Override
            public void onResponse(Call<ZebpayAPI> call, Response<ZebpayAPI> response) {
                Float zebpay_buy=response.body().getBuy();
                Float zebpay_sell= response.body().getSell();
                buy.setText("Buy Price"+zebpay_buy.toString()+"\n");
                sell.setText("\n"+"Sell Price"+zebpay_sell.toString());

            }

            @Override
            public void onFailure(Call<ZebpayAPI> call, Throwable t) {

            }
        });
    }




}
