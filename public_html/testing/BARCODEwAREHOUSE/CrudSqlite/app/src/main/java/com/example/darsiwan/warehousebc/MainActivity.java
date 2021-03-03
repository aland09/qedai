package com.example.darsiwan.warehousebc;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    String[] daftar, idnya;
    ListView ListView01;
    Menu menu;
    protected Cursor cursor;
    DataHelper dbcenter;
    public static MainActivity ma;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn=(Button)findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent inte = new Intent(MainActivity.this, BuatBiodata.class);
                startActivity(inte);
            }
        });

//        getJSON("http://test.qedai.id/getdata.php");

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new JsonTask().execute("http://test.qedai.id/getdata.php");
//            }
//        });

        ma = this;
        dbcenter = new DataHelper(this);
        RefreshList();
    }

    public void RefreshList(){
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM datapbr",null);
        daftar = new String[cursor.getCount()];
        idnya = new String[cursor.getCount()];
        cursor.moveToFirst();
//        Toast.makeText(getApplicationContext(), daftar.toString(), Toast.LENGTH_LONG).show();


        for (int cc=0; cc < cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(3).toString()+"\n"+cursor.getString(20).toString()+"\n"+cursor.getString(2).toString();
            idnya[cc] = cursor.getString(2).toString();
        }
        ListView01 = (ListView)findViewById(R.id.listView1);
        ListView01.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        ListView01.setSelected(true);
        ListView01.setOnItemClickListener(new OnItemClickListener() {


            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = daftar[arg2]; //.getItemAtPosition(arg2).toString();
                final String selection2 = idnya[arg2]; //.getItemAtPosition(arg2).toString();
//                Toast.makeText(getApplicationContext(), idnya[arg2], Toast.LENGTH_LONG).show();
//                Toast.makeText(getApplicationContext(), idnya[arg2], Toast.LENGTH_LONG).show();
                final CharSequence[] dialogitem = {"Lihat Data", "Update Data", "Hapus Data"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch(item){
                            case 0 :
                                Intent i = new Intent(getApplicationContext(), LihatBiodata.class);
                                i.putExtra("nama", selection2);
                                startActivity(i);
                                break;
                            case 1 :
                                Intent in = new Intent(getApplicationContext(), UpdateBiodata.class);
                                in.putExtra("nama", selection);
                                startActivity(in);
                                break;
                            case 2 :
                                SQLiteDatabase db = dbcenter.getWritableDatabase();
                                db.execSQL("delete from biodata where nama = '"+selection+"'");
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }});
        ((ArrayAdapter)ListView01.getAdapter()).notifyDataSetInvalidated();
    }



//    @SuppressLint("StaticFieldLeak")
//    private class JsonTask extends AsyncTask<String, String, String> {
//
//        protected void onPreExecute() {
//            super.onPreExecute();
//
//            pd = new ProgressDialog(MainActivity.this);
//            pd.setMessage("Please wait");
//            pd.setCancelable(false);
//            pd.show();
//        }
//
//        protected String doInBackground(String... params) {
//
//
//            HttpURLConnection connection;
//            connection = null;
//            BufferedReader reader = null;
//
//            try {
//                URL url = new URL(params[0]);
//                connection = (HttpURLConnection) url.openConnection();
//                connection.connect();
//
//
//                InputStream stream = connection.getInputStream();
//
//                reader = new BufferedReader(new InputStreamReader(stream));
//
//                StringBuffer buffer = new StringBuffer();
//                String line = "";
//
//                while ((line = reader.readLine()) != null) {
//                    buffer.append(line+"\n");
//                    Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)
//
//                }
//
//                return buffer.toString();
//
//
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if (connection != null) {
//                    connection.disconnect();
//                }
//                try {
//                    if (reader != null) {
//                        reader.close();
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//            super.onPostExecute(result);
//            if (pd.isShowing()){
//                pd.dismiss();
//            }
////            txtJson.setText(result);
//            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
//        }
//    }






//    //this method is actually fetching the json string
//    private void getJSON(final String urlWebService) {
//        /*
//         * As fetching the json string is a network operation
//         * And we cannot perform a network operation in main thread
//         * so we need an AsyncTask
//         * The constrains defined here are
//         * Void -> We are not passing anything
//         * Void -> Nothing at progress update as well
//         * String -> After completion it should return a string and it will be the json string
//         * */
//        class GetJSON extends AsyncTask<Void, Void, String> {
//
//            //this method will be called before execution
//            //you can display a progress bar or something
//            //so that user can understand that he should wait
//            //as network operation may take some time
//            @Override
//            protected void onPreExecute() {
//                super.onPreExecute();
//            }
//
//            //this method will be called after execution
//            //so here we are displaying a toast with the json string
//            @Override
//            protected void onPostExecute(String s) {
//                super.onPostExecute(s);
//                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
//            }
//
//            //in this method we are fetching the json string
//            @Override
//            protected String doInBackground(Void... voids) {
//
//
//
//                try {
//                    //creating a URL
//                    URL url = new URL(urlWebService);
//
//                    //Opening the URL using HttpURLConnection
//                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
//
//                    //StringBuilder object to read the string from the service
//                    StringBuilder sb = new StringBuilder();
//
//                    //We will use a buffered reader to read the string from service
//                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
//
//                    //A simple string to read values from each line
//                    String json;
//
//                    //reading until we don't find null
//                    while ((json = bufferedReader.readLine()) != null) {
//
//                        //appending it to string builder
//                        sb.append(json + "\n");
//                    }
//
//                    //finally returning the read string
//                    return sb.toString().trim();
//                } catch (Exception e) {
//                    return null;
//                }
//
//            }
//        }
//
//        //creating asynctask object and executing it
//        GetJSON getJSON = new GetJSON();
//        getJSON.execute();
//    }


}