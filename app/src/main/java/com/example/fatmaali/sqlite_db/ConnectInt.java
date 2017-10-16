package com.example.fatmaali.sqlite_db;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ConnectInt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_int);
        Button connect = (Button)findViewById(R.id.btn_coonectInt);
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkInternetConnection chInt = new checkInternetConnection(ConnectInt.this);
                Boolean cic = chInt.isConnectionToInternet();
                if(! cic){
                    Toast.makeText(getApplicationContext(),"NO INTERT",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
