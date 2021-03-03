package com.example.darsiwan.crudsqliite;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LihatBiodata extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton2, ton1;
    TextView text1, text2, text3, text4, text5,
    text6,
    text7 ,
    text8 ,
    text9 ,
    text10 ,

    text11 ,
    text12 ,
    text13 ,
    text14 ,
    text15 ,
    text16 ,
    text17 ,
    text18 ,
    text19 ,
    text20 ,

    text21 ,
    text22 ,
    text23 ;

    String datatag="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_inventory);

        dbHelper = new DataHelper(this);
        text1 = (TextView) findViewById(R.id.textView30);
        text2 = (TextView) findViewById(R.id.textView33);
        text3 = (TextView) findViewById(R.id.textView34);
        text4 = (TextView) findViewById(R.id.textView35);
        text5 = (TextView) findViewById(R.id.textView55);
        text6 = (TextView) findViewById(R.id.textView56);
        text7 = (TextView) findViewById(R.id.textView57);
        text8 = (TextView) findViewById(R.id.textView58);
        text9 = (TextView) findViewById(R.id.textView59);
        text10 = (TextView) findViewById(R.id.textView60);

        text11 = (TextView) findViewById(R.id.textView61);
        text12 = (TextView) findViewById(R.id.textView62);
        text13 = (TextView) findViewById(R.id.textView63);
        text14 = (TextView) findViewById(R.id.textView64);
        text15 = (TextView) findViewById(R.id.textView65);
        text16 = (TextView) findViewById(R.id.textView66);
        text17 = (TextView) findViewById(R.id.textView67);
        text18 = (TextView) findViewById(R.id.textView68);
        text19 = (TextView) findViewById(R.id.textView69);
        text20 = (TextView) findViewById(R.id.textView70);

        text21 = (TextView) findViewById(R.id.textView71);
        text22 = (TextView) findViewById(R.id.textView72);
        text23 = (TextView) findViewById(R.id.textView73);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM datainv WHERE TAG_NUMBER = '" +
                getIntent().getStringExtra("tn") + "'",null);
        Toast.makeText(getApplicationContext(), "Code " + getIntent().getStringExtra("tn"), Toast.LENGTH_LONG).show();
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
            text6.setText(cursor.getString(5).toString());
            text7.setText(cursor.getString(6).toString());
            text8.setText(cursor.getString(7).toString());
            text9.setText(cursor.getString(8).toString());
            text10.setText(cursor.getString(9).toString());

            text11.setText(cursor.getString(10).toString());
            text12.setText(cursor.getString(11).toString());
            text13.setText(cursor.getString(12).toString());
            text14.setText(cursor.getString(13).toString());
            text15.setText(cursor.getString(14).toString());
            text16.setText(cursor.getString(15).toString());
            text17.setText(cursor.getString(16).toString());
            text18.setText(cursor.getString(17).toString());
            text19.setText(cursor.getString(18).toString());
            text20.setText(cursor.getString(19).toString());
            text21.setText(cursor.getString(20).toString());
            text22.setText(cursor.getString(21).toString());
            text23.setText(cursor.getString(22).toString());

            datatag=cursor.getString(1).toString();
        }


        ton1 = (Button) findViewById(R.id.button4);
        ton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                Intent in = new Intent(getApplicationContext(), UpdateBiodata.class);
                in.putExtra("tn", datatag);
                startActivity(in);
            }
        });
        ton2 = (Button) findViewById(R.id.button3);
        ton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                //intent.putExtra("tn", rawResult.getText());
                startActivity(intent);
                finish();
            }
        });
    }



}