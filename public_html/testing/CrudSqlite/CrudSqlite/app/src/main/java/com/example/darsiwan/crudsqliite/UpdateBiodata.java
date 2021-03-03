package com.example.darsiwan.crudsqliite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateBiodata extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2, ton3;
    EditText text1, text2, text3, text4, text5;
    EditText text6, text7, text8, text9, text10;
    EditText text11, text12, text13, text14, text15;
    EditText text16, text17, text18, text19, text20, text21, text22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_inv);

        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.editText1);
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editText3);
        text4 = (EditText) findViewById(R.id.editText4);
        text5 = (EditText) findViewById(R.id.editText5);
        text6 = (EditText) findViewById(R.id.editText6);
        text7 = (EditText) findViewById(R.id.editText7);
        text8 = (EditText) findViewById(R.id.editText8);
        text9 = (EditText) findViewById(R.id.editText9);
        text10 = (EditText) findViewById(R.id.editText10);

        text11 = (EditText) findViewById(R.id.editText11);
        text12 = (EditText) findViewById(R.id.editText12);
        text13 = (EditText) findViewById(R.id.editText13);
        text14 = (EditText) findViewById(R.id.editText14);
        text15 = (EditText) findViewById(R.id.editText15);
        text16 = (EditText) findViewById(R.id.editText16);
        text17 = (EditText) findViewById(R.id.editText17);
        text18 = (EditText) findViewById(R.id.editText18);
        text19 = (EditText) findViewById(R.id.editText19);
        text20 = (EditText) findViewById(R.id.editText20);
        text21 = (EditText) findViewById(R.id.editText21);
        text22 = (EditText) findViewById(R.id.editText22);


        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM datainv WHERE TAG_NUMBER = '" +
                getIntent().getStringExtra("tn") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(1).toString());
            text1.setEnabled(false);
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
            text21.setText(cursor.getString(21).toString());
            text22.setText(cursor.getString(22).toString());
        }
        ton1 = (Button) findViewById(R.id.button1);
        ton2 = (Button) findViewById(R.id.button2);
        // daftarkan even onClick pada btnSimpan
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update datainv set NIK='"+
                        text2.getText().toString() +"', NAMA='" +
                        text3.getText().toString()+"', ID_LOKASI='"+
                        text4.getText().toString() +"', LOKASI='" +
                        text5.getText().toString() +"', ITEM_CODE='" +
                        text6.getText().toString() +"', ID_SUBLOKASI='" +
                        text7.getText().toString() +"', SUBLOKASI='" +
                        text8.getText().toString() +"', P_PROCESSOR='" +
                        text9.getText().toString() +"', P_MEMORY='" +
                        text10.getText().toString() +"', P_HARDISK='" +
                        text11.getText().toString() +"', P_OS='" +
                        text12.getText().toString() +"', P_DISPLAY='" +
                        text13.getText().toString() +"', P_DISPLAY_TIPE='" +
                        text14.getText().toString() +"', P_KM='" +
                        text15.getText().toString() +"', ID_POSISI='" +
                        text16.getText().toString() +"', POSISI='" +
                        text17.getText().toString() +"', P_DESC='" +
                        text18.getText().toString() +"', P_IPADDR='" +
                        text19.getText().toString() +"', P_WIFIADDR='" +
                        text20.getText().toString() +"', P_GAD1ADDR='" +
                        text21.getText().toString() +"', P_GAD2ADDR='" +
                        text22.getText().toString() + "' where TAG_NUMBER='" +
                        text1.getText().toString()+"'");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
//                MainActivity.ma.RefreshList();
//                finish();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                //intent.putExtra("tn", rawResult.getText());
               // MainActivity.ma.RefreshList();
                startActivity(intent);
                finish();
            }
        });
        ton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }



}