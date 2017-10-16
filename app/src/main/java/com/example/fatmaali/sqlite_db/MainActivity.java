package com.example.fatmaali.sqlite_db;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DB_sqlite db = new DB_sqlite(this);
    EditText name, email, id;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.edtxt_name);
        email = (EditText) findViewById(R.id.edtxt_email);
        id = (EditText) findViewById(R.id.edtxt_id);
        listView = (ListView) findViewById(R.id.listview_sqliteDB);
    }

    public void btn_add(View view) {
        String Name = name.getText().toString();
        String Email = email.getText().toString();
        Boolean result = db.insertData(Name, Email);
        if (result == true) {
//            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Integer.parseInt(Name+Email));
//            listView.setAdapter(arrayAdapter);
            Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_LONG).show();
            name.setText("");
            email.setText("");
            showData();
        } else {
            Toast.makeText(getApplicationContext(), "NO", Toast.LENGTH_LONG).show();
        }
    }

    public void showData() {
        ArrayList<String> List = db.getAllResult();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, List);
        listView.setAdapter(arrayAdapter);
    }

    public void btn_update(View view) {
        String Name = name.getText().toString();
        String Email = email.getText().toString();
        String ID = id.getText().toString();
        Boolean result = db.upData(ID, Name, Email);
        if (result == true) {
            Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_LONG).show();
            name.setText("");
            email.setText("");
            id.setText("");
            showData();
        } else {
            Toast.makeText(getApplicationContext(), "NO", Toast.LENGTH_LONG).show();
        }
    }

    public void btn_delete(View view) {
        String ID = id.getText().toString();
        Integer result = db.delete(ID);
        if(result>0){
            Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_LONG).show();
            showData();
        } else {
            Toast.makeText(getApplicationContext(), "NO", Toast.LENGTH_LONG).show();
        }

    }
}
