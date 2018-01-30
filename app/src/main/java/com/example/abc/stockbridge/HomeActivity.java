package com.example.abc.stockbridge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abc.stockbridge.data.Latest;
import com.example.abc.stockbridge.data.LatestCrypto;
import com.example.abc.stockbridge.network.Client;
import com.example.abc.stockbridge.network.ServiceGenrator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    TextView latest_price,crypto,commodity,news,mutual_fund,subdata;
    Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        latest_price=(TextView)findViewById(R.id.latest_price);
        crypto=(TextView)findViewById(R.id.crypto);
        commodity=(TextView)findViewById(R.id.commodity);
        news=(TextView)findViewById(R.id.news);
        mutual_fund=(TextView)findViewById(R.id.mutual_fund);
        subdata=(TextView)findViewById(R.id.sub_data);
        String s = Utils.getAPI(Utils.latest_price);
        client=ServiceGenrator.createService(Client.class,s);
        calllatestprice(client);

        subdata.setVisibility(View.GONE);

    }

    private Float calllatestprice(Client client)
    {
        final Call<Latest> latestCryptoCall= client.getlatestprice();
        latestCryptoCall.enqueue(new Callback<Latest>() {
            @Override
            public void onResponse(Call<Latest> call, Response<Latest> response) {
                String bitcoin= response.body().getLatestCryptos().get(0).getId();
              news.setText(bitcoin);
               Toast.makeText(getApplicationContext(),bitcoin.toString(),Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<Latest> call, Throwable t) {
                Log.d("hello","hi",t);

            }
        });
        return null;
    }

    public void toggle_contents(View view) {
        subdata.setVisibility(subdata.isShown()
        ? View.GONE:View.VISIBLE);
    }
}
