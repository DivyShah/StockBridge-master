package com.example.abc.stockbridge;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button buttonRegister;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignin;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth=FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()!=null)
        {
            finish();
            startActivity(new Intent(getApplicationContext(),ParentListViewActivity.class));
        }
        progressDialog= new ProgressDialog(this);
        buttonRegister=(Button)findViewById(R.id.buttonRegister);
        editTextEmail=(EditText)findViewById(R.id.editTextEmail);
        editTextPassword=(EditText)findViewById(R.id.editTextPassword);
        textViewSignin=(TextView)findViewById(R.id.textViewSignin);

        buttonRegister.setOnClickListener( this);
        // buttonRegister.setOnClickListener((View.OnClickListener) this);
        textViewSignin.setOnClickListener( this);

    }


    private void registerUser()
    {
        String email=editTextEmail.getText().toString().trim();
        String password=editTextPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email))
        {
            //email is empty
            Toast.makeText(this,"Please enter email",Toast.LENGTH_SHORT).show();
            //stopping further execution of function
            return;
        }
        if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this,"Please enter a password",Toast.LENGTH_SHORT).show();
            return;
        }
        //check for validation
        progressDialog.setMessage("Registering a user...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            finish();
                            startActivity(new Intent(getApplicationContext(),ParentListViewActivity.class));

                          //  progressDialog.dismiss();
                            //user is successfully registerd and logged in
                            //we can start a profile actiivity
                           // Toast.makeText(MainActivity.this,"Registerd Successfully",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            progressDialog.dismiss();
                            task.getException();
                            Log.e("error :  ",task.getException().toString());
                            Toast.makeText(MainActivity.this,"Failed to registered...PLease Try again",Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {

        if(view == buttonRegister)
        {
            registerUser();
        }
        if(view == textViewSignin)
        {
            startActivity(new Intent(this,LoginActivity.class));
        }



    }
}
