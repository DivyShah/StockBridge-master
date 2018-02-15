package com.example.abc.stockbridge;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abc.stockbridge.data.ZebpayAPI;
import com.example.abc.stockbridge.network.Client;
import com.example.abc.stockbridge.network.ServiceGenrator;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ExchangeFragment extends Fragment {

    TextView title,buy,sell;
    Client client;
    private OnFragmentInteractionListener mListener;
    Bundle bundle;

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
        if(bundle.get("one")!=null)
        {
            String s = Utils.getAPI(Utils.bitcoin);
            client= ServiceGenrator.createService(Client.class,s);
            //callzebpay(client);
        }
        else if(bundle.get("two")!=null)
        {
            title.setText("hello");
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

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
    /*private void callzebpay(Client client)
    {
        Call<List<ZebpayAPI>> zebpayAPICall= client.getbitcoinzebpay();
        zebpayAPICall.enqueue(new Callback<List<ZebpayAPI>>() {
            @Override
            public void onResponse(Call<List<ZebpayAPI>> call, Response<List<ZebpayAPI>>  response) {
                Float buybtc = response.body().get(0).getBuy();
                Float sellbtc= response.body().get(0).getSell();
                buy.setText(buybtc.toString());
                sell.setText(sellbtc.toString());
            }

            @Override
            public void onFailure(Call<List<ZebpayAPI>>  call, Throwable t) {
                Log.e("helo","hi",t);

            }
        });
    }*/




    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
