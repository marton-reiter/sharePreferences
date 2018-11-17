package com.example.lehne.sharepreferences;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button kuldes;
    private TextView tv1;
    private EditText ed1;

    String adat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        final SharedPreferences sh = getSharedPreferences("adatok", Context.MODE_PRIVATE);
        final String alapertelmezett_ertek = "A neved";
        adat = sh.getString("adat", alapertelmezett_ertek);

        ed1.setText(adat);

        new AlertDialog.Builder(MainActivity.this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Üdvözöllek újra " +adat)
                .setMessage("Folytatod ezen a néven vagy újat akarsz?")
                .setPositiveButton("Új játék.", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        adat=alapertelmezett_ertek;
                        ed1.setText(adat);
                    }
                })
                .setNegativeButton("Folytatom.", null)
                .show();

        kuldes.setOnClickListener(new View.OnClickListener() {
          @Override
            public void onClick(View view) {

                String adat = ed1.getText().toString();
                SharedPreferences.Editor editor = sh.edit();
                editor.putString("adat", adat);
                editor.apply();

                if(adat.equals(alapertelmezett_ertek)){
                    Intent activity_1 = new Intent(MainActivity.this, MainActivity.class);
                    Toast.makeText(MainActivity.this, "A név nem lehet üres!", Toast.LENGTH_SHORT).show();
                    startActivity(activity_1);
                }
                else if(adat.equals("")){
                  Intent activity_1 = new Intent(MainActivity.this, MainActivity.class);
                  Toast.makeText(MainActivity.this, "A név nem lehet üres!", Toast.LENGTH_SHORT).show();
                  startActivity(activity_1);
                }
                else {
                    Intent activity_2 = new Intent(MainActivity.this, Main2Activity.class);
                    Toast.makeText(MainActivity.this, "A neved mentve!", Toast.LENGTH_SHORT).show();
                    startActivity(activity_2);
                }
                finish();


            }
        });


    }


    public void init() {
        kuldes = (Button) findViewById(R.id.kuldes);
        tv1 = (TextView) findViewById(R.id.tv1);
        ed1 = (EditText) findViewById(R.id.ed1);


    }
}