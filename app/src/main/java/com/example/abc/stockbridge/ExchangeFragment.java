package com.example.abc.stockbridge;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abc.stockbridge.data.BTCXIndia;
import com.example.abc.stockbridge.data.Buyu.BuyUCoin;
import com.example.abc.stockbridge.data.Buyu.BuyUcoinDatum;
import com.example.abc.stockbridge.data.CoinSecure;
import com.example.abc.stockbridge.data.ETHXINDIA;
import com.example.abc.stockbridge.data.Koinex.Koinex;
import com.example.abc.stockbridge.data.Message;
import com.example.abc.stockbridge.data.Unocoin;
import com.example.abc.stockbridge.data.ZebpayAPI;
import com.example.abc.stockbridge.network.Client;
import com.example.abc.stockbridge.network.ServiceGenrator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ExchangeFragment extends Fragment {

    TextView title,buy,sell,volume;
    TextView buyUcoin_title,buyUcoin_buy,buyUcoin_sell1,buyUcoin_volume;
    TextView third_title,third_buy,third_sell1,third_volume;
    TextView Fourth_title,Fourth_buy,Fourth_sell1,Fourth_volume;
    Client client;
    private OnFragmentInteractionListener mListener;
    Bundle bundle;
    List<BuyUCoin> buyUCoins;
    public ExchangeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExchangeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExchangeFragment newInstance(String param1, String param2) {
        ExchangeFragment fragment = new ExchangeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle=getActivity().getIntent().getExtras();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_exchange,container,false);
        title=(TextView)view.findViewById(R.id.zebpay_title1);
        buy=(TextView)view.findViewById(R.id.buy);
        sell=(TextView)view.findViewById(R.id.sell);
        volume=(TextView)view.findViewById(R.id.volume1);
        buyUcoin_buy=(TextView)view.findViewById(R.id.buyUcoin_buy);
        buyUcoin_sell1=(TextView)view.findViewById(R.id.buyUcoin_sell);
        buyUcoin_volume=(TextView)view.findViewById(R.id.buyUcoin_volume1);
        buyUcoin_title=(TextView)view.findViewById(R.id.buyUcoin_title1);
        third_buy=(TextView)view.findViewById(R.id.unocoin_buy);
        third_sell1=(TextView)view.findViewById(R.id.unocoin_sell);
        third_volume=(TextView)view.findViewById(R.id.unocoin_volume1);
        third_title=(TextView)view.findViewById(R.id.unocoin_title1);
        Fourth_buy=(TextView)view.findViewById(R.id.Fourth_buy);
        Fourth_sell1=(TextView)view.findViewById(R.id.Fourth_sell);
        Fourth_volume=(TextView)view.findViewById(R.id.Fourth_volume1);
        Fourth_title=(TextView)view.findViewById(R.id.Fourth_title1);

        if(bundle.get("one")!=null)
        {



            callzebpay(client);
            callBuyUCoin(client);
           // callUnocoin(client);
            callCoinsecure(client);
            callKoinex(client);
        }

        else if(bundle.get("two")!=null)
        {

            callzebpay(client);
            callBuyUCoin(client);
            callKoinex(client);
           // callBTCXindia(client);


        }
        else if(bundle.get("three")!=null)
        {

            callBuyUCoin(client);
            callKoinex(client);
            callethxindia(client);

        }
        else if(bundle.get("four")!=null)
        {
            callKoinex(client);

            callzebpay(client);
            callBuyUCoin(client);
        }
        else if(bundle.get("five")!=null)
        {
            String s = Utils.getAPI(Utils.zebpay_cash);
            client=ServiceGenrator.createService(Client.class,s);
            callzebpay(client);
            callBuyUCoin(client);
            callKoinex(client);
        }

        /*title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = Utils.getAPI(Utils.zebpay_bitcoin);
                client=ServiceGenrator.createService(Client.class,s);
                callzebpay(client);
            }
        });
*/
        return view;
    }

    private void callBTCXindia(Client client) {
        String s = Utils.getAPI(Utils.btcxindia_ripple);
        client= ServiceGenrator.createService(Client.class,s);
        Call<BTCXIndia> btcxIndiaCall = client.getbtcXindia_ripple();
        btcxIndiaCall.enqueue(new Callback<BTCXIndia>() {
            @Override
            public void onResponse(Call<BTCXIndia> call, Response<BTCXIndia> response) {
               Double buy = response.body().getBid();
                Long sell= response.body().getAsk();
                Float volume= Float.valueOf(response.body().getCurrentVolume());
                Fourth_buy.setText("Buy:"+buy);
                Fourth_sell1.setText("Sell:"+sell);
                Fourth_volume.setText("Vol:"+volume);
                Fourth_title.setText("BTCXIndia");


            }

            @Override
            public void onFailure(Call<BTCXIndia> call, Throwable t) {

                Log.e("Hello",t.getMessage().toString());
            }
        });
    }

    private void callethxindia(Client client) {
        String s = Utils.getAPI(Utils.ethexindia);
        client= ServiceGenrator.createService(Client.class,s);
        Call<ETHXINDIA> ethxindiaCall = client.getethxindia();
        ethxindiaCall.enqueue(new Callback<ETHXINDIA>() {
            @Override
            public void onResponse(Call<ETHXINDIA> call, Response<ETHXINDIA> response) {
                Float buy= Float.valueOf(response.body().getBid());
                Float sell= Float.valueOf(response.body().getAsk());
                Float volume= Float.valueOf(response.body().getTotalVolume24h());
                Fourth_buy.setText("Buy:"+buy);
                Fourth_sell1.setText("Sell"+sell);
                Fourth_volume.setText("Vol:"+volume);
                Fourth_title.setText("ETHXIndia");

            }

            @Override
            public void onFailure(Call<ETHXINDIA> call, Throwable t) {
                Log.e("Hello",t.getMessage().toString());

            }
        });
    }

    private void callKoinex(Client client) {

        String s = Utils.getAPI(Utils.koinex_bitcoin);
        client = ServiceGenrator.createService(Client.class,s);
        Call<Koinex> call= client.getcoinex();
        call.enqueue(new Callback<Koinex>() {
            @Override
            public void onResponse(Call<Koinex> call, Response<Koinex> response) {
                if(bundle.get("one")!=null)
                {
                    Float price= Float.valueOf(response.body().getStats().getBTC().getHighestBid());
                    Float lowestbid= Float.valueOf(response.body().getStats().getBTC().getLowestAsk());
                    Float volume= Float.valueOf(response.body().getStats().getBTC().getVol24hrs());

                    third_buy.setText("Lowest Bid:"+lowestbid);
                    third_title.setText("Koinex");
                    third_sell1.setText("Highest Bid:"+price);
                    third_volume.setText("Vol:"+volume);
                }
                else  if(bundle.get("two")!=null)
                {
                    Float price= Float.valueOf(response.body().getStats().getXRP().getHighestBid());
                    Float lowestbid= Float.valueOf(response.body().getStats().getXRP().getLowestAsk());
                    Float volume= Float.valueOf(response.body().getStats().getXRP().getVol24hrs());

                    third_buy.setText("Lowest Bid:"+lowestbid);
                    third_title.setText("Koinex");
                    third_sell1.setText("Highest Bid:"+price);
                    third_volume.setText("Vol:"+volume);
                }
                else  if(bundle.get("three")!=null)
                {
                    Float price= Float.valueOf(response.body().getStats().getETH().getHighestBid());
                    Float lowestbid= Float.valueOf(response.body().getStats().getETH().getLowestAsk());
                    Float volume= Float.valueOf(response.body().getStats().getETH().getVol24hrs());

                    third_buy.setText("Lowest Bid:"+lowestbid);
                    third_title.setText("Koinex");
                    third_sell1.setText("Highest Bid:"+price);
                    third_volume.setText("Vol:"+volume);
                }
                else  if(bundle.get("four")!=null)
                {
                    Float price= Float.valueOf(response.body().getStats().getLTC().getHighestBid());
                    Float lowestbid= Float.valueOf(response.body().getStats().getLTC().getLowestAsk());
                    Float volume= Float.valueOf(response.body().getStats().getLTC().getVol24hrs());

                    third_buy.setText("Lowest Bid:"+lowestbid);
                    third_title.setText("Koinex");
                    third_sell1.setText("Highest Bid:"+price);
                    third_volume.setText("Vol:"+volume);
                }
                else  if(bundle.get("five")!=null)
                {
                    Float price= Float.valueOf(response.body().getStats().getBCH().getHighestBid());
                    Float lowestbid= Float.valueOf(response.body().getStats().getBCH().getLowestAsk());
                    Float volume= Float.valueOf(response.body().getStats().getBCH().getVol24hrs());

                    third_buy.setText("Lowest Bid:"+lowestbid);
                    third_title.setText("Koinex");
                    third_sell1.setText("Highest Bid:"+price);
                    third_volume.setText("Vol:"+volume);
                }



            }

            @Override
            public void onFailure(Call<Koinex> call, Throwable t) {

                Log.e("Hello",t.getMessage().toString());
            }
        });
    }


    private void callBuyUCoin(Client client) {
        Call<BuyUCoin> call=null;
        if(bundle.get("one")!=null)
        {
            String s = Utils.getAPI(Utils.buyucoin_bitcoin);
            client= ServiceGenrator.createService(Client.class,s);
            call= client.getBuyUCOin_bitcoin();
        }
        else if(bundle.get("two")!=null)
        {
            String s =Utils.getAPI(Utils.buyucoin_ripple);
            client= ServiceGenrator.createService(Client.class,s);
            call= client.getBuyUCOin_ripple();
        }
        else  if(bundle.get("three")!=null)
        {
            String s = Utils.getAPI(Utils.buyucoin_etherum);
            client=ServiceGenrator.createService(Client.class,s);
            call= client.getBuyUCOin_ethereum();
        }
        else  if(bundle.get("four")!=null)
        {
            String s = Utils.getAPI(Utils.buyucoin_litecoin);
            client= ServiceGenrator.createService(Client.class,s);
            call= client.getBuyUCOin_litecoin();
        }
        else  if(bundle.get("five")!=null)
        {
            String s = Utils.getAPI(Utils.buyucoin_bitcoincash);
            client= ServiceGenrator.createService(Client.class,s);
            call= client.getBuyUCOin_bitcoincash();
        }



        call.enqueue(new Callback<BuyUCoin>() {
            @Override
            public void onResponse(Call<BuyUCoin> call, Response<BuyUCoin> response) {
                if(bundle.get("one")!=null)
                {
                    Float buy = Float.valueOf(response.body().getBuyUcoinData().get(0).getBtcBuyPrice());
                    Float sell = Float.valueOf(response.body().getBuyUcoinData().get(0).getBtcSellPrice());
                    Float buy_volume= Float.valueOf(response.body().getBuyUcoinData().get(0).getBtcBuyVol());
                    Float sell_volume= Float.valueOf(response.body().getBuyUcoinData().get(0).getBtcSellVol());
                    buyUcoin_volume.setText("Buy Vol:"+buy_volume+"\n"+"Sell Vol:"+sell_volume.toString());
                    buyUcoin_title.setText("BuyUCoin");

                    buyUcoin_sell1.setText("Sell"+sell.toString());
                    buyUcoin_buy.setText("Buy"+buy.toString());
                }
                else  if(bundle.get("three")!=null)
                {
                    Float buy = Float.valueOf(response.body().getBuyUcoinData().get(0).getEthBuyPrice());
                    Float sell = Float.valueOf(response.body().getBuyUcoinData().get(0).getEthSellPrice());
                    Float buy_volume= Float.valueOf(response.body().getBuyUcoinData().get(0).getEthBuyVol());
                    Float sell_volume= Float.valueOf(response.body().getBuyUcoinData().get(0).getEthSellVol());
                    buyUcoin_volume.setText("Buy Vol:"+buy_volume+"\n"+"Sell Vol:"+sell_volume.toString());
                    buyUcoin_title.setText("BuyUCoin");

                    buyUcoin_sell1.setText("Sell"+sell.toString());
                    buyUcoin_buy.setText("Buy"+buy.toString());

                }
                else  if(bundle.get("four")!=null)
                {
                    Float buy = Float.valueOf(response.body().getBuyUcoinData().get(0).getLtcBuyPrice());
                    Float sell = Float.valueOf(response.body().getBuyUcoinData().get(0).getLtcSellPrice());
                    Float buy_volume= Float.valueOf(response.body().getBuyUcoinData().get(0).getLtcBuyVol());
                    Float sell_volume= Float.valueOf(response.body().getBuyUcoinData().get(0).getLtcSellVol());
                    buyUcoin_volume.setText("Buy Vol:"+buy_volume+"\n"+"Sell Vol:"+sell_volume.toString());
                    buyUcoin_title.setText("BuyUCoin");

                    buyUcoin_sell1.setText("Sell"+sell.toString());
                    buyUcoin_buy.setText("Buy"+buy.toString());

                }
                else  if(bundle.get("two")!=null)
                {
                    Float buy = Float.valueOf(response.body().getBuyUcoinData().get(0).getXrpBuyPrice());
                    Float sell = Float.valueOf(response.body().getBuyUcoinData().get(0).getXrpSellPrice());
                    Float buy_volume= Float.valueOf(response.body().getBuyUcoinData().get(0).getXrpBuyVol());
                    Float sell_volume= Float.valueOf(response.body().getBuyUcoinData().get(0).getXrpSellVol());
                    buyUcoin_volume.setText("Buy Vol:"+buy_volume+"\n"+"Sell Vol:"+sell_volume.toString());
                    buyUcoin_title.setText("BuyUCoin");

                    buyUcoin_sell1.setText("Sell"+sell.toString());
                    buyUcoin_buy.setText("Buy"+buy.toString());

                }
                else if(bundle.get("five")!=null)
                {
                    buyUcoin_buy.setText("Soory something went worng");
                }




            }

            @Override
            public void onFailure(Call<BuyUCoin> call, Throwable t) {
                Log.e("hwll",t.getMessage().toString());

            }
        });
    }

    private void callCoinsecure(Client client) {
        String s = Utils.getAPI(Utils.coinsecure);
        client=ServiceGenrator.createService(Client.class,s);
        Call<CoinSecure> coinSecureCall = client.getCoinsecure();
        coinSecureCall.enqueue(new Callback<CoinSecure>() {
            @Override
            public void onResponse(Call<CoinSecure> call, Response<CoinSecure> response) {
                Float buy = response.body().getMessage().getBid();
                Float sell= response.body().getMessage().getAsk();
                Fourth_title.setText("Coinsecure");

                Fourth_sell1.setText("Sell"+sell.toString());
                Fourth_buy.setText("Buy"+buy.toString());

            }

            @Override
            public void onFailure(Call<CoinSecure> call, Throwable t) {
                Log.e("hello",t.getMessage().toString());


            }
        });
    }

    /*private void callUnocoin(Client client) {

        String s = Utils.getAPI(Utils.unocoin);
        client = ServiceGenrator.createService(Client.class,s);

        Call<Unocoin> unocoinCall= client.getUNcoin();
        unocoinCall.enqueue(new Callback<Unocoin>() {
            @Override
            public void onResponse(Call<Unocoin> call, Response<Unocoin> response) {
                Float sell= response.body().getSell();
                Float buy= response.body().getBuy();
                unocoin_title.setText("Unocoin");
                unocoin_buy.setText("Buy:"+buy);
                unocoin_sell1.setText("Sell"+sell.toString());
            }

            @Override
            public void onFailure(Call<Unocoin> call, Throwable t) {

            }
        });
    }*/



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
    private void callzebpay(Client client)
    {
        Call<ZebpayAPI> zebpayAPICall=null;
        if(bundle.get("one")!=null)
        {
            String s = Utils.getAPI(Utils.zebpay_bitcoin);
            client= ServiceGenrator.createService(Client.class,s);
            zebpayAPICall= client.getBitcoin();
        }
        else if (bundle.get("two")!=null){
            String s = Utils.getAPI(Utils.zebpay_ripple);
            client=ServiceGenrator.createService(Client.class,s);
            zebpayAPICall=client.getzebpayripple();

        }
        else if(bundle.get("three")!=null)
        {String s = Utils.getAPI(Utils.zebpay_etherum);
            client=ServiceGenrator.createService(Client.class,s);
            zebpayAPICall=client.getzebpayripple();

        }
        else  if(bundle.get("four")!=null)
        {
            String s = Utils.getAPI(Utils.zebpay_litecoin);
            client=ServiceGenrator.createService(Client.class,s);
            zebpayAPICall=client.getzebpayLitecoin();
        }
        else if(bundle.get("five")!=null)
        {
            String s = Utils.getAPI(Utils.zebpay_cash);
            client=ServiceGenrator.createService(Client.class,s);
            zebpayAPICall=client.getzebpaybitcoin_cash();
        }

        zebpayAPICall.enqueue(new Callback<ZebpayAPI>() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            @Override
            public void onResponse(Call<ZebpayAPI> call, Response<ZebpayAPI>  response) {
                if(bundle.get("one")!=null)
                {
                    Float buybtc = response.body().getBuy();
                    Float sellbtc= response.body().getSell();
                    Float volume1=response.body().getVolume();


                    String result=("Zebpay"+ volume1.toString());

                    title.setText("Zebpay");
                    volume.setText("Vol:"+volume1);
                    buy.setText("Buy"+buybtc.toString());
                    sell.setText("Sell"+sellbtc.toString());
                }
                else if(bundle.get("two")!=null)
                {
                    Float buybtc = response.body().getBuy();
                    Float sellbtc= response.body().getSell();
                    Float volume1=response.body().getVolume();


                    String result=("Zebpay"+ volume1.toString());

                    title.setText("Zebpay");
                    volume.setText("Vol:"+volume1);
                    buy.setText("Buy"+buybtc.toString());
                    sell.setText("Sell"+sellbtc.toString());
                }
                else if(bundle.get("three")!=null)
                {
                    buy.setText("Sorry price is not available");
                }
                else  if(bundle.get("four")!=null)
                {
                    Float buybtc = response.body().getBuy();
                    Float sellbtc= response.body().getSell();
                    Float volume1=response.body().getVolume();


                    String result=("Zebpay"+ volume1.toString());

                    title.setText("Zebpay");
                    volume.setText("Vol:"+volume1);
                    buy.setText("Buy"+buybtc.toString());
                    sell.setText("Sell"+sellbtc.toString());
                }
                else  if(bundle.get("five")!=null)
                {
                    Float buybtc = response.body().getBuy();
                    Float sellbtc= response.body().getSell();
                    Float volume1=response.body().getVolume();


                    String result=("Zebpay"+ volume1.toString());

                    title.setText("Zebpay");
                    volume.setText("Vol:"+volume1);
                    buy.setText("Buy"+buybtc.toString());
                    sell.setText("Sell"+sellbtc.toString());
                }

            }

            @Override
            public void onFailure(Call<ZebpayAPI>  call, Throwable t) {
                Log.e("helo","hi",t);

            }
        });
    }






    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
