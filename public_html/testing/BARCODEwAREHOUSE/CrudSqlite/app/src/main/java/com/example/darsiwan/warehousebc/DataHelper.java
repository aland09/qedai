package com.example.darsiwan.warehousebc;




import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Datawh3.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

//        String sql = "create table biodata(no integer primary key, nama text null, tgl text null, jk text null, alamat text null);";

        String sql = "create table datapbr(id integer primary key AUTOINCREMENT, QTY_ROLL text null, DOCNO text null, PURPOSE text null, PRODTYPE text null" +
                ", TYPE text null, THICK text null, WIDTH_JUMBO text null, NOLOT text null, TS text null, PROD_LINE text null, JUMBO_ID text null, KTF text null, BB_WEIGTH_ACT text null, BB_LENGTH text null" +
                ", PROD_DATE DATE , RCV_WEIGHT text null, RCV_LENGTH text null, CLASS text null, SO_REQUEST text null, DIVISI text null);";



        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
//        sql = "INSERT INTO biodata (no, nama, tgl, jk, alamat) VALUES ('1', 'Darsiwan', '1996-07-12', 'Laki-laki','Indramayu');";
//        db.execSQL(sql);

        sql = "INSERT INTO datapbr(QTY_ROLL, DOCNO, PURPOSE, PRODTYPE, TYPE, THICK, WIDTH_JUMBO, NOLOT, TS, PROD_LINE, JUMBO_ID, KTF, BB_WEIGTH_ACT, BB_LENGTH, PROD_DATE, RCV_WEIGHT, RCV_LENGTH, CLASS, SO_REQUEST, DIVISI) " +
                "VALUES ('1','0028045020109357','RESLIT','PC', '30','PC','30','450','4031','A2003119','Line 2 - 5','8','106204','0','0','9/20/2020','73.71,''6000','FG','A2014432','OPP');";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }

}