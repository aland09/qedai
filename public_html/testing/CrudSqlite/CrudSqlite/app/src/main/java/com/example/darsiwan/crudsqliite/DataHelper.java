package com.example.darsiwan.crudsqliite;




import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "datainventori.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql = "create table datainv(SEQNO integer primary key AUTOINCREMENT, TAG_NUMBER text null, NIK integer null, NAMA text null, ID_LOKASI text null, LOKASI text null, ITEM_CODE text null, ID_SUBLOKASI text null, SUBLOKASI text null, P_PROCESSOR text null, P_MEMORY text null, P_HARDISK text null, P_OS text null, P_DISPLAY text null, P_DISPLAY_TIPE text null, P_KM text null, ID_POSISI text null, " +
                "POSISI text null, " +
                "P_DESC text null," +
                "P_IPADDR text null," +
                "P_WIFIADDR text null," +
                "P_GAD1ADDR text null," +
                "P_GAD2ADDR text null" +
                ");";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
//        sql = "INSERT INTO biodata (no, nama, tgl, jk, alamat) VALUES ('1', 'Darsiwan', '1996-07-12', 'Laki-laki','Indramayu');";
//        db.execSQL(sql);

      // sql = "INSERT INTO datainv(TAG_NUMBER, NIK, NAMA, ID_LOKASI, LOKASI, ITEM_CODE, ID_SUBLOKASI, SUBLOKASI, P_PROCESSOR, P_MEMORY, P_HARDISK, P_OS, P_DISPLAY, P_DISPLAY_TIPE, P_KM, ID_POSISI, POSISI, P_DESC, P_IPADDR, P_WIFIADDR, P_GAD1ADDR, P_GAD2ADDR) VALUES ('WS-000001','12367','Muhammad Mubarak','C1.001','Gedung Baru','109-10904002','C1.001.002','Lantai 1','Intel Core i3-2120 CPU 3.30 GHz','4096','250','Microsoft Windows 7 Professional','Samsung /SyncMaster','E19200','Logitech/Logitech','C1.001.002.009','IT Department','','131.107.101.153','','131.107.11.150','131.107.11.125');";
       // sql = "INSERT INTO datainv(TAG_NUMBER, NIK, NAMA, ID_LOKASI) VALUES ('WS-000001','12367','Muhammad Mubarak','C1.001');";
       // db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }

}