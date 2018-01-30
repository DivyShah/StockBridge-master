package com.example.abc.stockbridge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.abc.stockbridge.data.ZebpayAPI;
import com.example.abc.stockbridge.data.CoinSecure;
import com.example.abc.stockbridge.data.Unocoin;
import com.example.abc.stockbridge.network.Client;
import com.example.abc.stockbridge.network.ServiceGenrator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.abc.stockbridge.ParentListViewActivity.client;

public class ExapandActivity extends Activity {
    String[] crypto ={ "Zebpay", "Unocoin","Coinsecure"};
    TextView market_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exapand);
        final Bundle bundle= getIntent().getExtras();
       // market_price=(TextView)findViewById(R.id.tx);
        String url="https://chart.zebpay.com/";
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.list_item,R.id.lblListItem,crypto);


        final ListView lv = (ListView)findViewById(R.id.listview);
        lv.setAdapter(adapter);

        /*final LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) lv.getLayoutParams();
        params.gravity= Gravity.CENTER_VERTICAL;
        lv.setLayoutParams(params);*/
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                /*int hello = (int) lv.getItemIdAtPosition(position);
                Intent intent= new Intent(getApplicationContext(),ExploreActivity.class);
                intent.putExtra("position",hello);
                startActivity(intent);*/

                if(position==0)
                {
                    String s =  Utils.getAPI(Utils.bitcoin);
                    client = ServiceGenrator.createService(Client.class,s);
                    callBitcoin(client);




                }
                if(position==1)
                {
                    String s = Utils.getAPI(Utils.unocoin);
                    client=ServiceGenrator.createService(Client.class,s);
                    callUnocoin(client);
                }
                if(position==2)
                {
                   // Log.e("hello","hi");
                    String s= Utils.getAPI(Utils.coinsecure);
                    client=ServiceGenrator.createService(Client.class,s);
                    callCoinSecure(client);
                }


            }
});



    }

    private void callBitcoin(Client client) {
        Call<ZebpayAPI> bitcoin = client.getBitcoin();
        bitcoin.enqueue(new Callback<ZebpayAPI>() {
            @Override
            public void onResponse(Call<ZebpayAPI> call, Response<ZebpayAPI> response) {
                Float buy = response.body().getBuy();
                Float sell = response.body().getSell();
                Float marketprice =response.body().getMarket();
                String currency = response.body().getCurrency();



                Intent intent = new Intent(getApplicationContext(),ExploreActivity.class);
                intent.putExtra("onclick",Utils.bitcoin);
                intent.putExtra("buy",buy);
                intent.putExtra("sell",sell);
                intent.putExtra("market_price",marketprice);

                startActivity(intent);

                /*String toast = "Buy --> "+buy+" Sell --> "+sell+" Currency --> "+currency;
                Toast.makeText(ParentListViewActivity.this,toast,Toast.LENGTH_SHORT).show();*/
            }

            @Override
            public void onFailure(Call<ZebpayAPI> call, Throwable t) {

            }
        });
    }
    private void callUnocoin(Client client)
    {
        Call<Unocoin> unocoinCall=client.getUncoin();
        unocoinCall.enqueue(new Callback<Unocoin>() {
            @Override
            public void onResponse(Call<Unocoin> call, Response<Unocoin> response) {
                Float buy = response.body().getBuy();
                Float sell= response.body().getSell();
                Log.e("response","response");
                Intent intent = new Intent(getApplicationContext(),ExploreActivity.class);
                intent.putExtra("buy",buy);
                intent.putExtra("sell",sell);
                startActivity(intent);



            }

            @Override
            public void onFailure(Call<Unocoin> call, Throwable t) {
                Log.e("message","sd",t);

            }
        });
    }

    private void callCoinSecure(Client client)
    {
        Call<CoinSecure> messageCall= client.getCoinsecure();
        messageCall.enqueue(new Callback<CoinSecure>() {
            @Override
            public void onResponse(Call<CoinSecure> call, Response<CoinSecure> response) {


                Float buy= response.body().getMessage().getAsk();
                Float sell = response.body().getMessage().getBid();
                Intent intent = new Intent(getApplicationContext(),ExploreActivity.class);
                intent.putExtra("buy",buy);
                intent.putExtra("sell",sell);
                startActivity(intent);


            }

            @Override
            public void onFailure(Call<CoinSecure> call, Throwable t) {
                Log.d("hello","hi",t);

            }
        });
    }


}
