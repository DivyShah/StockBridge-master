package com.example.abc.stockbridge;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.HashMap;

public class CommmoditiesActivity extends AppCompatActivity {
    TextView source_code;
    TextView source_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commmodities);
        source_code=(TextView)findViewById(R.id.tv_sourcecode);
        source_item=(TextView)findViewById(R.id.tv_sourceitem);

        Intent intent=getIntent();
        HashMap<String,String> hashMap= (HashMap<String, String>) intent.getExtras().get("hashmap");










    }
}
