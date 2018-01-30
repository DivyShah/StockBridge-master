package com.example.abc.stockbridge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivty extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth firebaseAuth;
    private TextView showmessage;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_activty);

        firebaseAuth=FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()== null)
        {
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }
        FirebaseUser user=firebaseAuth.getCurrentUser();
        showmessage=(TextView)findViewById(R.id.textviewout);
        logout=(Button)findViewById(R.id.buttonlogout);
        logout.setOnClickListener(this);
        showmessage.setText("Welcome "+user.getEmail());

    }

    @Override
    public void onClick(View v) {
        if(v==logout)
        {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }

    }
}
