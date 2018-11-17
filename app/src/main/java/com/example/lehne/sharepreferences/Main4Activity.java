package com.example.lehne.sharepreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    private Button kuldes2;
    private EditText ed4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        init();

        final SharedPreferences sh = getSharedPreferences("adatok", Context.MODE_PRIVATE);
        final String alapertelmezett_ertek = "Írd be a neved!";
        final String adat = sh.getString("adat", alapertelmezett_ertek);
        ed4.setText(adat);

        kuldes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String adat = ed4.getText().toString();
                SharedPreferences.Editor editor = sh.edit();
                editor.putString("adat", adat);
                editor.apply();


                if(adat.equals(alapertelmezett_ertek)){
                    Intent activity_1 = new Intent(Main4Activity.this, Main4Activity.class);
                    Toast.makeText(Main4Activity.this, "A név nem lehet üres!", Toast.LENGTH_SHORT).show();
                    startActivity(activity_1);
                }
                else if(adat.equals("")){
                    Intent activity_1 = new Intent(Main4Activity.this, Main4Activity.class);
                    Toast.makeText(Main4Activity.this, "A név nem lehet üres!", Toast.LENGTH_SHORT).show();
                    startActivity(activity_1);
                }
                else {
                    Intent activity = new Intent(Main4Activity.this, Main2Activity.class);
                    Toast.makeText(Main4Activity.this, "A neved mentve!", Toast.LENGTH_SHORT).show();
                    startActivity(activity);
                }
                finish();

            }
        });

    }
    public void init() {
        kuldes2 = (Button) findViewById(R.id.kuldes2);
        ed4 = (EditText) findViewById(R.id.ed4);
    }

}
