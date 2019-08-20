package com.apkglobal.realmdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    EditText etname, etmobile;
    Button btnsave, btnview;
Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsave = findViewById(R.id.btnsave);
        btnview = findViewById(R.id.btnfetch);
        etmobile = findViewById(R.id.etmobile);
        etname = findViewById(R.id.etname);
        //to install realm in Activity
        Realm.init(this);
        //pass of instance funtion of realm objects
        realm=Realm.getDefaultInstance();



        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RealmResults<Data> realmResults=realm.where(Data.class).findAll();
                for (Data data:  realmResults)
                {
                    Toast.makeText(MainActivity.this,
                            data.getName()+"\n"+data.getMobile(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //to insert the data
                realm.beginTransaction();
                Data data=realm.createObject(Data.class);
                data.setName(etname.getText().toString());
                data.setMobile(etmobile.getText().toString());
                realm.commitTransaction();
            }
        });

    }
}
