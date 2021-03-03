package com.example.darsiwan.warehousebc;


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
    Button ton2;
    TextView text1, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12, text13, text14, text15, text16, text17, text18, text19, text20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_biodata);

        dbHelper = new DataHelper(this);
        text1 = (TextView) findViewById(R.id.textView1);
        text2 = (TextView) findViewById(R.id.textView2);
        text3 = (TextView) findViewById(R.id.textView3);
        text4 = (TextView) findViewById(R.id.textView4);
        text5 = (TextView) findViewById(R.id.textView5);
        text6 = (TextView) findViewById(R.id.textView6);
        text7 = (TextView) findViewById(R.id.textView7);
        text8 = (TextView) findViewById(R.id.textView8);
        text9 = (TextView) findViewById(R.id.textView9);
        text10 = (TextView) findViewById(R.id.textView10);
        text11 = (TextView) findViewById(R.id.textView11);
        text12 = (TextView) findViewById(R.id.textView12);
        text13 = (TextView) findViewById(R.id.textView13);
        text14 = (TextView) findViewById(R.id.textView14);
        text15 = (TextView) findViewById(R.id.textView15);
        text16 = (TextView) findViewById(R.id.textView16);
        text17 = (TextView) findViewById(R.id.textView17);
        text18 = (TextView) findViewById(R.id.textView18);
        text19 = (TextView) findViewById(R.id.textView19);
        text20 = (TextView) findViewById(R.id.textView20);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM datapbr WHERE DOCNO = '" +
                getIntent().getStringExtra("nama") + "'",null);
        cursor.moveToFirst();

        Toast.makeText(getApplicationContext(), getIntent().getStringExtra("nama") , Toast.LENGTH_LONG).show();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(1).toString());
            text2.setText(cursor.getString(2).toString());
            text3.setText(cursor.getString(3).toString());
            text4.setText(cursor.getString(4).toString());
            text5.setText(cursor.getString(5).toString());
            text6.setText(cursor.getString(6).toString());
            text7.setText(cursor.getString(7).toString());
            text8.setText(cursor.getString(8).toString());
            text9.setText(cursor.getString(9).toString());
            text10.setText(cursor.getString(10).toString());
            text11.setText(cursor.getString(11).toString());
            text12.setText(cursor.getString(12).toString());
            text13.setText(cursor.getString(13).toString());
            text14.setText(cursor.getString(14).toString());
            text15.setText(cursor.getString(15).toString());
            text16.setText(cursor.getString(16).toString());
            text17.setText(cursor.getString(17).toString());
            text18.setText(cursor.getString(18).toString());
            text19.setText(cursor.getString(19).toString());
            text20.setText(cursor.getString(20).toString());
        }
        ton2 = (Button) findViewById(R.id.button1);
        ton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }



}