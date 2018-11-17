package com.example.lehne.sharepreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    private Button vissza;
    private TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        init();

        final SharedPreferences sh = getSharedPreferences("adatok", Context.MODE_PRIVATE);
        final String alapertelmezett_ertek = "Írd be a neved!";
        final String adat = sh.getString("adat", alapertelmezett_ertek);


        vissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activity = new Intent(Main3Activity.this, Main2Activity.class);
                startActivity(activity);

                finish();

            }
        });
    }

    public void init() {
        vissza = (Button) findViewById(R.id.vissza);
        tv3 = (TextView) findViewById(R.id.tv3);
    }
}
