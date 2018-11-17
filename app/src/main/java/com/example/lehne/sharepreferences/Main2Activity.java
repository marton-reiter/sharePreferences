package com.example.lehne.sharepreferences;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private Button b1; Button b2; Button b3; Button b4;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();

        final SharedPreferences sh = getSharedPreferences("adatok", Context.MODE_PRIVATE);
        final String alapertelmezett_ertek = "Írd be a neved!";
        final String adat = sh.getString("adat", alapertelmezett_ertek);

        tv2.setText(adat);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activity_3 = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(activity_3);

                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activity_4 = new Intent(Main2Activity.this, Main4Activity.class);
                startActivity(activity_4);

                finish();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activity_22 = new Intent(Main2Activity.this, Main2Activity.class);
                startActivity(activity_22);
                Toast.makeText(Main2Activity.this, "A neved " + adat, Toast.LENGTH_SHORT).show();

                finish();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    new AlertDialog.Builder(Main2Activity.this)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setTitle("Biztos kilépsz?")
                            .setMessage("Biztos kilépsz a programból?")
                            .setPositiveButton("Kilépek.", new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            })
                            .setNegativeButton("Folytatom.", null)
                            .show();
                            }
        });

    }

    public void init() {
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        tv2 = (TextView) findViewById(R.id.tv2);
    }

}

