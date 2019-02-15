package com.example.challengeproblems;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spanned nameText =  Html.fromHtml("<b>Proyecto hecho por</b>: <br >Ana Sollano <br> Daniel Medina <br> Bruno Schalch");
        names = (TextView) findViewById(R.id.names);
        names.setText(nameText);

    }

    public void goToMaps(View view){
        Intent intent = new Intent(this, HospitalActivity.class);
        startActivity(intent);
    }
}
